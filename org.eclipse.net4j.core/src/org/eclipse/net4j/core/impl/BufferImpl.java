/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.StringHelper;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SocketChannel;


/**
 * TODO make interface
 */
public class BufferImpl
{
  public static final int HEX_MODE = 1;

  public static final int UTF8_MODE = 2;

  public static final int FLAT_MODE = 3;

  protected ByteBuffer byteBuffer;

  public BufferImpl(int size)
  {
    byteBuffer = ByteBuffer.allocateDirect(size);
  }

  public int capacity()
  {
    return byteBuffer.capacity();
  }

  public java.nio.Buffer clear()
  {
    return byteBuffer.clear();
  }

  public java.nio.Buffer flip()
  {
    return byteBuffer.flip();
  }

  public byte get()
  {
    return byteBuffer.get();
  }

  public ByteBuffer get(byte[] arg0)
  {
    return byteBuffer.get(arg0);
  }

  public ByteBuffer get(byte[] arg0, int arg1, int arg2)
  {
    return byteBuffer.get(arg0, arg1, arg2);
  }

  public char getChar()
  {
    return byteBuffer.getChar();
  }

  public double getDouble()
  {
    return byteBuffer.getDouble();
  }

  public float getFloat()
  {
    return byteBuffer.getFloat();
  }

  public int getInt()
  {
    return byteBuffer.getInt();
  }

  public long getLong()
  {
    return byteBuffer.getLong();
  }

  public short getShort()
  {
    return byteBuffer.getShort();
  }

  public boolean hasRemaining()
  {
    return byteBuffer.hasRemaining();
  }

  /**
   * @return
   */
  public int limit()
  {
    return byteBuffer.limit();
  }

  public void limit(int newLimit)
  {
    byteBuffer.limit(newLimit);
  }

  public java.nio.Buffer mark()
  {
    return byteBuffer.mark();
  }

  public int position()
  {
    return byteBuffer.position();
  }

  public void position(int newPosition)
  {
    byteBuffer.position(newPosition);
  }

  public ByteBuffer put(byte arg0)
  {
    return byteBuffer.put(arg0);
  }

  public ByteBuffer put(byte[] arg0)
  {
    return byteBuffer.put(arg0);
  }

  public ByteBuffer put(byte[] arg0, int arg1, int arg2)
  {
    return byteBuffer.put(arg0, arg1, arg2);
  }

  public ByteBuffer put(BufferImpl arg0)
  {
    return byteBuffer.put(arg0.getByteBuffer());
  }

  public ByteBuffer putChar(char arg0)
  {
    return byteBuffer.putChar(arg0);
  }

  public ByteBuffer putDouble(double arg0)
  {
    return byteBuffer.putDouble(arg0);
  }

  public ByteBuffer putFloat(float arg0)
  {
    return byteBuffer.putFloat(arg0);
  }

  public ByteBuffer putInt(int arg0)
  {
    return byteBuffer.putInt(arg0);
  }

  public ByteBuffer putLong(long arg0)
  {
    return byteBuffer.putLong(arg0);
  }

  public ByteBuffer putShort(short arg0)
  {
    return byteBuffer.putShort(arg0);
  }

  public int remaining()
  {
    return byteBuffer.remaining();
  }

  public java.nio.Buffer reset()
  {
    return byteBuffer.reset();
  }

  public java.nio.Buffer rewind()
  {
    return byteBuffer.rewind();
  }

  public String toString()
  {
    return byteBuffer.toString();
  }

  public String toString(int mode)
  {
    int position = byteBuffer.position();
    int limit = byteBuffer.limit();
    String result;

    switch (mode)
    {
    case HEX_MODE:
      result = StringHelper.toHexString(byteBuffer);
      break;

    case UTF8_MODE:
      result = StringHelper.toUTF8String(byteBuffer, false);
      break;

    case FLAT_MODE:
      result = StringHelper.toUTF8String(byteBuffer, false);
      break;

    default:
      throw new ImplementationError("invalid mode: " + mode);
    }

    byteBuffer.position(position);
    byteBuffer.limit(limit);
    return result;
  }

  public ByteBuffer getByteBuffer()
  {
    return byteBuffer;
  }

  public boolean readFrom(SocketChannel socketChannel) throws IOException
  {
    boolean ok = false;

    try
    {
      ok = socketChannel.read(byteBuffer) != -1;
    }
    catch (ClosedChannelException ex)
    {
    }

    return ok;
  }
}
