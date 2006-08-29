/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.AlreadyRequestingException;
import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.ChannelCancelledException;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.IllegalEventException;
import org.eclipse.net4j.core.Indication;
import org.eclipse.net4j.core.IndicationWithResponse;
import org.eclipse.net4j.core.Multiplexer;
import org.eclipse.net4j.core.Protocol;
import org.eclipse.net4j.core.Request;
import org.eclipse.net4j.core.RequestWithConfirmation;
import org.eclipse.net4j.core.ResponseTimedOutException;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.Assert;
import org.eclipse.net4j.util.BitHelper;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.ThreadInterruptedException;
import org.eclipse.net4j.util.fsm.StateMachine;
import org.eclipse.net4j.util.thread.DeadlockDetector;

import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class ChannelImpl extends ServiceImpl implements Channel
{
  public static boolean TRACING = false;

  public static boolean TRACING_BUFFERS = false;

  public static boolean TRACING_STATES = false;

  public static int TRACE_MODE = BufferImpl.FLAT_MODE;

  public static final boolean DEBUG_MODE = !System.getProperty("java.vm.info", "").contains(
          "sharing");

  // TODO Beanify
  public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

  public static final String UTF_8 = "UTF-8";

  public static final String UTF_16 = "UTF-16";

  public static final String CHARSET = UTF_16;

  protected static final int CHANNEL_PAD = SERVICE_BITS;

  protected static final int COMM_STATE_BITS = 3;

  protected static final int COMM_STATE_PAD = CHANNEL_PAD;

  protected static final int COMM_STATE_MASK = BitHelper.getMask(COMM_STATE_BITS, COMM_STATE_PAD);

  protected static final int CHANNEL_BITS = COMM_STATE_PAD + COMM_STATE_BITS;

  public static final String[] STATE_NAMES = {"IDLE", "REQUESTING", "INDICATING", "INDIQUESTING",
          "RESPONDING", "CONFIRMING"};

  public static final String[] EVENT_NAMES = {"REQUEST_START", "REQUEST_END", "INDICATE_START",
          "INDICATION_END", "RESPOND_START", "RESPOND_END", "CONFIRM_START", "CONFIRM_END"};

  public static final ChannelStateMachine clientStateMachine = new ClientStateMachine();

  public static final ChannelStateMachine serverStateMachine = new ServerStateMachine();

  public static final long DEFAULT_RESPONSE_TIMEOUT_MILLIS = DEBUG_MODE ? Long.MAX_VALUE : 5000;

  public long responseTimeoutMillis = DEFAULT_RESPONSE_TIMEOUT_MILLIS;

  private Connector connector;

  private short channelIndex;

  private Multiplexer multiplexer;

  private Protocol protocol;

  private BufferImpl receiverBuffer;

  private BlockingQueue<BufferImpl> receiverQueue = new LinkedBlockingQueue();

  private Runnable receiverTask;

  private BufferImpl transmitterBuffer;

  private BlockingQueue<BufferImpl> transmitterQueue = new LinkedBlockingQueue();

  private Object protocolData;

  private Request currentRequest;

  private transient Object returnValue;

  private transient boolean responseReady;

  private transient Object responseMutex = new Object();

  private transient String cancelCode;

  public ChannelImpl()
  {
    setCommState(IDLE);
  }

  public int getCommState()
  {
    return (flags & COMM_STATE_MASK) >> COMM_STATE_PAD;
  }

  public void setCommState(int state)
  {
    flags &= ~COMM_STATE_MASK;
    flags |= (state << COMM_STATE_PAD) & COMM_STATE_MASK;
  }

  public void processCommEvent(int event)
  {
    int type = getConnector().getType();
    StateMachine stateMachine = (type == Connector.CLIENT ? clientStateMachine : serverStateMachine);

    try
    {
      stateMachine.process(this, event, null);
    }
    catch (Exception ex)
    {
      error("Error while processing CommEvent " + stateMachine.getEventName(event), ex);
    }
  }

  public boolean isTransmittingAllowed()
  {
    switch (getCommState())
    {
    case Channel.IDLE:
    case Channel.REQUESTING:
    case Channel.INDIQUESTING:
    case Channel.RESPONDING:
      return true;
    }

    return false;
  }

  public boolean isReceivingAllowed()
  {
    switch (getCommState())
    {
    case Channel.IDLE:
    case Channel.INDICATING:
    case Channel.INDIQUESTING:
    case Channel.CONFIRMING:
      return true;
    }

    return false;
  }

  public Object transmit(Request request)
  {
    assertActive();

    if (currentRequest != null)
    {
      // TODO Enqueue (server-initiated?) notifications
      if (getConnector().isClient())
      {
        throw new AlreadyRequestingException();
      }

      throw new UnsupportedOperationException();
    }

    currentRequest = request;
    responseReady = false;
    returnValue = null;

    request.setChannel(this);

    short signalId = request.getSignalId();
    if (TRACING && isDebugEnabled()) debug("Transmitting signal id");
    transmitShort(signalId);

    if (request.isDebugEnabled())
    {
      request.debug("");
      request.debug("---------------------------------------------------------------------");
      request.debug("Transmitting request " + request.getName());
    }

    synchronized (this)
    {
      processCommEvent(REQUEST_START);
      request.request();
      flush();
      processCommEvent(REQUEST_END);
    }

    if (request.hasResponse())
    {
      if (getConnector().isServer())
      {
        throw new ImplementationError(
                "Passive connectors must not transmit requests with confirmation");
      }

      long start = System.currentTimeMillis();
      while (!responseReady)
      {
        if (System.currentTimeMillis() - start > responseTimeoutMillis)
        {
          throw new ResponseTimedOutException();
        }

        synchronized (responseMutex)
        {
          DeadlockDetector.wait(responseMutex, responseTimeoutMillis);
        }
      }
    }

    currentRequest = null;
    Object tmp = returnValue;
    returnValue = null;

    if (tmp instanceof ResponseExceptionWrapper)
    {
      throw ((ResponseExceptionWrapper)tmp).getException();
    }

    return tmp;
  }

  public void flush()
  {
    if (TRACING && isDebugEnabled()) debug("Flushing");
    scheduleBuffer();
  }

  public Connector getConnector()
  {
    return connector;
  }

  public Protocol getProtocol()
  {
    return protocol;
  }

  /**
   * Called by the multiplexer when a new buffer is inserted into the transmitterQueue. If a buffer
   * is found in the queue, it is removed, given to the connector and finally returned to the
   * bufferPool.
   */
  public void handleTransmission()
  {
    assertActive();
    BufferImpl buffer = null;

    if (cancelCode != null)
    {
      while ((buffer = transmitterQueue.poll()) != null)
      {
        releaseBuffer(buffer);
      }

      throw new ChannelCancelledException("Channel canceled: " + cancelCode);
    }

    buffer = transmitterQueue.poll();
    if (buffer != null)
    {
      if (TRACING && isDebugEnabled())
      {
        debug("Transmitting data: " + buffer.toString(TRACE_MODE));
      }

      connector.transmit(channelIndex, buffer);
      releaseBuffer(buffer);
    }
  }

  public boolean receiveBoolean()
  {
    ensureReceiverBufferData(1);
    boolean value = receiverBuffer.get() == 0 ? false : true;
    if (TRACING && isDebugEnabled()) debug("Received boolean: " + value);
    return value;
  }

  public byte[] receiveBytes()
  {
    ensureReceiverBufferData(4);
    int len = receiverBuffer.getInt();
    if (len == -1)
    {
      if (TRACING && isDebugEnabled()) debug("Received Bytes: null");
      return null;
    }

    byte[] result = new byte[len];
    int offset = 0;
    int chunk = Math.min(len, receiverBuffer.remaining());
    if (chunk > 0)
    {
      receiverBuffer.get(result, offset, chunk);
      offset += chunk;
      len -= chunk;
    }

    while (len > 0)
    {
      releaseBuffer(receiverBuffer);
      ensureReceiverBuffer();

      chunk = Math.min(len, receiverBuffer.remaining());
      receiverBuffer.get(result, offset, chunk);
      offset += chunk;
      len -= chunk;
    }

    if (TRACING && isDebugEnabled()) debug("Received Bytes: " + result);
    return result;
  }

  public byte receiveByte()
  {
    ensureReceiverBufferData(1);
    byte value = receiverBuffer.get();
    if (TRACING && isDebugEnabled()) debug("Received byte: " + value);
    return value;
  }

  public char receiveChar()
  {
    ensureReceiverBufferData(2);
    char value = receiverBuffer.getChar();
    if (TRACING && isDebugEnabled()) debug("Received char: " + value);
    return value;
  }

  public double receiveDouble()
  {
    ensureReceiverBufferData(8);
    double value = receiverBuffer.getDouble();
    if (TRACING && isDebugEnabled()) debug("Received double: " + value);
    return value;
  }

  public float receiveFloat()
  {
    ensureReceiverBufferData(4);
    float value = receiverBuffer.getFloat();
    if (TRACING && isDebugEnabled()) debug("Received float: " + value);
    return value;
  }

  public int receiveInt()
  {
    ensureReceiverBufferData(4);
    int value = receiverBuffer.getInt();
    if (TRACING && isDebugEnabled()) debug("Received int: " + value);
    return value;
  }

  public long receiveLong()
  {
    ensureReceiverBufferData(8);
    long value = receiverBuffer.getLong();
    if (TRACING && isDebugEnabled()) debug("Received long: " + value);
    return value;
  }

  public Object receiveObject()
  {
    byte[] array = receiveBytes();
    InputStream buffer = new ByteArrayInputStream(array);

    try
    {
      ObjectInputStream stream = new ObjectInputStream(buffer);
      return stream.readObject();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      return null;
    }
  }

  public short receiveShort()
  {
    ensureReceiverBufferData(2);
    short value = receiverBuffer.getShort();
    if (TRACING && isDebugEnabled()) debug("Received short: " + value);
    return value;
  }

  public String receiveString()
  {
    byte[] array = receiveBytes();
    if (array == null)
    {
      return null;
    }

    String result = null;
    try
    {
      result = new String(array, CHARSET);
    }
    catch (UnsupportedEncodingException ex)
    {
      ex.printStackTrace();
    }

    return result;
  }

  public void setConnector(Connector connector)
  {
    doSet("connector", connector);
  }

  public void setChannelIndex(short channelIndex)
  {
    doSet("channelIndex", channelIndex);
  }

  public void setProtocol(Protocol protocol)
  {
    doSet("protocol", protocol);
  }

  public void transmitBoolean(boolean value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting boolean: " + value);
    ensureTransmitterBufferData(1);
    transmitterBuffer.put((byte)(value ? 1 : 0));
  }

  public void transmitBytes(byte[] value)
  {
    if (value == null)
    {
      if (TRACING && isDebugEnabled()) debug("Transmitting Bytes: null");
      ensureTransmitterBufferData(4);
      transmitterBuffer.putInt(-1);
    }
    else
    {
      if (TRACING && isDebugEnabled()) debug("Transmitting Bytes: " + value);
      int len = value.length;
      ensureTransmitterBufferData(4);
      transmitterBuffer.putInt(len);

      int offset = 0;
      int chunk = Math.min(len, transmitterBuffer.remaining());
      if (chunk > 0)
      {
        transmitterBuffer.put(value, offset, chunk);
        offset += chunk;
        len -= chunk;
      }

      while (len > 0)
      {
        scheduleBuffer();
        chunk = Math.min(len, transmitterBuffer.remaining());
        transmitterBuffer.put(value, offset, chunk);
        offset += chunk;
        len -= chunk;
      }
    }
  }

  public void transmitByte(byte value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting byte: " + value);
    ensureTransmitterBufferData(2);
    transmitterBuffer.put(value);
  }

  public void transmitChar(char value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting char: " + value);
    ensureTransmitterBufferData(2);
    transmitterBuffer.putChar(value);
  }

  public void transmitDouble(double value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting double: " + value);
    ensureTransmitterBufferData(8);
    transmitterBuffer.putDouble(value);
  }

  public void transmitFloat(float value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting float: " + value);
    ensureTransmitterBufferData(4);
    transmitterBuffer.putFloat(value);
  }

  public void transmitInt(int value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting int: " + value);
    ensureTransmitterBufferData(4);
    transmitterBuffer.putInt(value);
  }

  public void transmitLong(long value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting long: " + value);
    ensureTransmitterBufferData(8);
    transmitterBuffer.putLong(value);
  }

  public void transmitObject(Object value)
  {
    byte[] array = null;
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    try
    {
      ObjectOutputStream stream = new ObjectOutputStream(buffer);
      stream.writeObject(value);
      array = buffer.toByteArray();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }

    transmitBytes(array);
  }

  public void transmitShort(short value)
  {
    if (TRACING && isDebugEnabled()) debug("Transmitting short: " + value);
    ensureTransmitterBufferData(2);
    transmitterBuffer.putShort(value);
  }

  public void transmitString(String value)
  {
    byte[] array = null;
    if (value != null)
    {
      try
      {
        array = value.getBytes(CHARSET);
      }
      catch (UnsupportedEncodingException ex)
      {
        ex.printStackTrace();
      }
    }

    transmitBytes(array);
  }

  public short getChannelIndex()
  {
    return channelIndex;
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("multiplexer");

    if (connector != null)
    {
      newTransmitterBuffer();
    }
  }

  @Override
  protected void activate() throws Exception
  {
    super.activate();
    protocol.registerChannel(this);
  }

  @Override
  protected void deactivate() throws Exception
  {
    protocol.deregisterChannel(this);
    connector.removeChannel(this);
    super.deactivate();
  }

  /**
   * Called by the Connector on arrival of new buffers (in the context of a Selector.Controller
   * thread).
   */
  public void notifyData(BufferImpl data)
  {
    if (TRACING && isDebugEnabled()) debug("Received data: " + data.toString(TRACE_MODE));

    receiverQueue.add(data);

    if (receiverTask == null)
    {
      startSignalTask();
    }
  }

  protected void startSignalTask()
  {
    if (!receiverQueue.isEmpty())
    {
      try
      {
        if (TRACING && isDebugEnabled()) debug("Starting signal task");
        // System.out.println("Starting signal task");
        receiverTask = new SignalTask();
        EXECUTOR_SERVICE.execute(receiverTask);
      }
      catch (Exception ex)
      {
        error("Error while dispatching task " + receiverTask, ex);
      }
    }
  }

  protected void ensureTransmitterBufferData(int dataSize)
  {
    if (dataSize <= 0) throw new IllegalArgumentException("dataSize <= 0");
    if (TRACING_BUFFERS && isDebugEnabled())
      debug("Ensuring " + dataSize + " bytes in transmitterBuffer");

    if (transmitterBuffer.remaining() < dataSize) scheduleBuffer();
    if (TRACING_BUFFERS && isDebugEnabled())
      debug("Ensured transmitterBuffer " + transmitterBuffer);
  }

  /**
   * Called by the receiveXyz() methods to ensure that there is enough data available. This method
   * will block until both a receiverBuffer is available from the receiverQueue and the requested
   * number of bytes are available in that buffer.
   */
  protected void ensureReceiverBufferData(int dataSize)
  {
    if (dataSize <= 0) throw new IllegalArgumentException("dataSize <= 0");
    if (TRACING_BUFFERS && isDebugEnabled())
      debug("Ensuring " + dataSize + " bytes in receiverBuffer");

    if (receiverBuffer == null)
    {
      ensureReceiverBuffer();
    }
    else if (!receiverBuffer.hasRemaining())
    {
      releaseBuffer(receiverBuffer);
      ensureReceiverBuffer();
    }

    if (receiverBuffer.remaining() < dataSize)
    {
      throw new ImplementationError("receiverBuffer level too low: " + receiverBuffer.remaining()
              + " < " + dataSize);
    }

    if (TRACING_BUFFERS && isDebugEnabled()) debug("Ensured receiverBuffer " + receiverBuffer);
  }

  /**
   * Called by the thread of this Channel's client (current owner)
   */
  protected void ensureReceiverBuffer()
  {
    try
    {
      receiverBuffer = receiverQueue.take();
    }
    catch (InterruptedException ex)
    {
      throw new ThreadInterruptedException(ex);
    }
  }

  protected void scheduleBuffer()
  {
    if (transmitterBuffer.position() == 0)
    {
      return;
    }

    transmitterBuffer.flip();
    transmitterQueue.add(transmitterBuffer);
    multiplexer.schedule(this);
    newTransmitterBuffer();
  }

  protected void releaseBuffer(BufferImpl buffer)
  {
    getConnector().getBufferPool().releaseBuffer(buffer);
  }

  protected void newTransmitterBuffer()
  {
    transmitterBuffer = getConnector().getBufferPool().getBuffer();
    connector.adjustTransmitterBuffer(transmitterBuffer);
  }

  public Multiplexer getMultiplexer()
  {
    return multiplexer;
  }

  public void setMultiplexer(Multiplexer multiplexer)
  {
    doSet("multiplexer", multiplexer);
  }

  public Object getProtocolData()
  {
    return protocolData;
  }

  public void setProtocolData(Object data)
  {
    protocolData = data;
  }

  public Request getCurrentRequest()
  {
    return currentRequest;
  }

  public void cancel(String code)
  {
    cancelCode = code;
  }

  public boolean isCancelled()
  {
    return cancelCode != null;
  }

  public long getResponseTimeoutMillis()
  {
    return responseTimeoutMillis;
  }

  public void setResponseTimeoutMillis(long responseTimeoutMillis)
  {
    doSet("responseTimeoutMillis", DEBUG_MODE ? Long.MAX_VALUE : responseTimeoutMillis);
  }

  @Override
  protected void adjustPrototypeBeanName()
  {
    if (connector == null)
    {
      throw new ImplementationError("Called too early: connector == null");
    }

    String connectorName = connector.getBeanName();

    if (connectorName == null)
    {
      throw new ImplementationError("Called too early: connectorName == null");
    }

    setBeanName(connectorName + "-" + getBeanName() + "-" + channelIndex);
  }

  @Override
  protected String formatLogMessage(String message)
  {
    if (getCommState() == IDLE) return message;
    return "|   " + message;
  }

  private final class SignalTask implements Runnable
  {
    public void run()
    {
      processSignal();
      postProcessChannel();
    }

    private void processSignal()
    {
      if (TRACING && isDebugEnabled()) debug("Waiting for signal id");
      short signalId = receiveShort();
      Assert.isTrue(signalId != 0, "signalID == 0");

      if (signalId < 0)
      {
        // Signal is a Confirmation, use the original Request
        RequestWithConfirmation confirmation = (RequestWithConfirmation)getCurrentRequest();

        while (confirmation == null)
        {
          confirmation = (RequestWithConfirmation)getCurrentRequest();
          DeadlockDetector.sleep(5);
        }

        short requestId = confirmation.getSignalId();
        if (requestId != -signalId)
        {
          throw new ImplementationError("Mismatch between Request(" + requestId + ") and Response("
                  + (-signalId) + ")");
        }

        if (confirmation.isDebugEnabled())
        {
          confirmation.debug("");
          confirmation
                  .debug("---------------------------------------------------------------------");
          confirmation.debug("Receiving confirmation " + confirmation.getName());
        }

        try
        {
          synchronized (ChannelImpl.this)
          {
            try
            {
              processCommEvent(Channel.CONFIRM_START);
              returnValue = confirmation.confirm();
            }
            finally
            {
              processCommEvent(Channel.CONFIRM_END);
            }
          }
        }
        catch (RuntimeException ex)
        {
          returnValue = new ResponseExceptionWrapper(ex);
        }
        finally
        {
          synchronized (responseMutex)
          {
            responseReady = true;
            responseMutex.notifyAll();
          }
        }
      }
      else
      {
        // Signal is an incoming Indication, create it
        Protocol protocol = getProtocol();
        Indication indication = protocol.createIndication(signalId);
        indication.setChannel(ChannelImpl.this);

        if (indication.isDebugEnabled())
        {
          indication.debug("");
          indication.debug("---------------------------------------------------------------------");
          indication.debug("Receiving indication " + indication.getName());
        }

        synchronized (ChannelImpl.this)
        {
          processCommEvent(Channel.INDICATE_START);
          indication.indicate();
          processCommEvent(Channel.INDICATE_END);
        }

        if (indication.hasResponse())
        {
          IndicationWithResponse response = (IndicationWithResponse)indication;
          short responseId = (short)-signalId;
          if (TRACING && isDebugEnabled()) debug("Transmitting signal id");

          transmitShort(responseId);

          if (response.isDebugEnabled())
          {
            response.debug("");
            response.debug("---------------------------------------------------------------------");
            response.debug("Transmitting response " + response.getName());
          }

          synchronized (ChannelImpl.this)
          {
            processCommEvent(Channel.RESPOND_START);
            response.respond();
            flush();
            processCommEvent(Channel.RESPOND_END);
          }
        }
      }
    }

    private void postProcessChannel()
    {
      if (TRACING && isDebugEnabled()) debug("Finished signal task");
      // System.out.println("Finished signal task");
      receiverTask = null;
      startSignalTask();
    }
  }

  public static class ChannelStateMachine extends StateMachine<ChannelImpl>
  {
    private static final ITransition<ChannelImpl> DEFAULT_TRANSITION = new ITransition<ChannelImpl>()
    {
      public void process(ChannelImpl subject, int event, Object data) throws Exception
      {
        throw new IllegalEventException("Illegal event " + EVENT_NAMES[event] + " in state "
                + STATE_NAMES[subject.getCommState()] + " for channel " + subject);
      }
    };

    public ChannelStateMachine()
    {
      super(STATE_NAMES, EVENT_NAMES, DEFAULT_TRANSITION);
    }

    @Override
    protected int getState(ChannelImpl subject)
    {
      return subject.getCommState();
    }

    @Override
    protected void setState(ChannelImpl subject, int state)
    {
      if (TRACING_STATES && subject.isDebugEnabled())
      {
        subject.debug("Setting comm state: " + getStateName(state));
      }
      subject.setCommState(state);
    }
  }

  public static class ClientStateMachine extends ChannelStateMachine
  {
    private static final Logger logger = Logger.getLogger(ClientStateMachine.class.getName());

    public ClientStateMachine()
    {
      // IDLE
      handle(IDLE, REQUEST_START, REQUESTING);
      handle(IDLE, INDICATE_START, INDICATING);
      handle(IDLE, CONFIRM_START, CONFIRMING);

      // REQUESTING
      handle(REQUESTING, REQUEST_END, IDLE);
      handle(REQUESTING, INDICATE_START, INDIQUESTING);

      // INDICATING
      handle(INDICATING, INDICATE_END, IDLE);
      handle(INDICATING, REQUEST_START, INDIQUESTING);

      // INDIQUESTING
      handle(INDIQUESTING, REQUEST_END, INDICATING);
      handle(INDIQUESTING, INDICATE_END, REQUESTING);

      // CONFIRMING
      handle(CONFIRMING, CONFIRM_END, IDLE);
    }

    @Override
    protected Logger getLogger()
    {
      return logger;
    }
  }

  public static class ServerStateMachine extends ChannelStateMachine
  {
    private static final Logger logger = Logger.getLogger(ServerStateMachine.class.getName());

    public ServerStateMachine()
    {
      // IDLE
      handle(IDLE, REQUEST_START, REQUESTING);
      handle(IDLE, INDICATE_START, INDICATING);
      handle(IDLE, RESPOND_START, RESPONDING);

      // REQUESTING
      handle(REQUESTING, REQUEST_END, IDLE);
      handle(REQUESTING, INDICATE_START, INDIQUESTING);
      handle(REQUESTING, REQUEST_START, REQUESTING);

      // INDICATING
      handle(INDICATING, INDICATE_END, IDLE);
      handle(INDICATING, REQUEST_START, INDIQUESTING);

      // INDIQUESTING
      handle(INDIQUESTING, REQUEST_END, INDICATING);
      handle(INDIQUESTING, INDICATE_END, REQUESTING);
      handle(INDIQUESTING, REQUEST_START, INDIQUESTING);

      // RESPONDING
      handle(RESPONDING, RESPOND_END, IDLE);
    }

    @Override
    protected Logger getLogger()
    {
      return logger;
    }
  }
}
