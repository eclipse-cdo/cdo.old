/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.CDOIDImpl;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOType;

import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public abstract class CDOTypeImpl implements CDOType
{
  private static List<CDOTypeImpl> index = new ArrayList();

  private static final byte BOOLEAN_DEFAULT_PRIMITIVE = 0;

  private static final char CHARACTER_DEFAULT_PRIMITIVE = 0;

  private static final short SHORT_DEFAULT_PRIMITIVE = 0;

  public static final Boolean BOOLEAN_DEFAULT = new Boolean(false);

  public static final Byte BYTE_DEFAULT = new Byte(BOOLEAN_DEFAULT_PRIMITIVE);

  public static final Character CHARACTER_DEFAULT = new Character(CHARACTER_DEFAULT_PRIMITIVE);

  public static final Double DOUBLE_DEFAULT = new Double(0.0);

  public static final Float FLOAT_DEFAULT = new Float(0.0);

  public static final Integer INTEGER_DEFAULT = new Integer(0);

  public static final Long LONG_DEFAULT = new Long(0L);

  public static final Short SHORT_DEFAULT = new Short(SHORT_DEFAULT_PRIMITIVE);

  public static final CDOTypeImpl BOOLEAN = new CDOTypeImpl("BOOLEAN", 22, false, BOOLEAN_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Boolean)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeBoolean((Boolean)(value == null ? getDefaultValue() : value));
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Boolean(in.readBoolean());
    }
  };

  public static final CDOTypeImpl BYTE = new CDOTypeImpl("BYTE", 24, false, BYTE_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Byte)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeByte((Byte)(value == null ? getDefaultValue() : value));
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Byte(in.readByte());
    }
  };

  public static final CDOTypeImpl CHAR = new CDOTypeImpl("CHAR", 27, false, CHARACTER_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Character)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeChar(((Character)(value == null ? getDefaultValue() : value)).charValue());
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Character(in.readChar());
    }
  };

  public static final CDOTypeImpl DOUBLE = new CDOTypeImpl("DOUBLE", 31, false, DOUBLE_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Double)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeDouble((Double)(value == null ? getDefaultValue() : value));
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Double(in.readDouble());
    }
  };

  public static final CDOTypeImpl FLOAT = new CDOTypeImpl("FLOAT", 37, false, FLOAT_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Float)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeFloat((Float)(value == null ? getDefaultValue() : value));
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Float(in.readFloat());
    }
  };

  public static final CDOTypeImpl INT = new CDOTypeImpl("INT", 39, false, INTEGER_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Integer)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeInt((Integer)(value == null ? getDefaultValue() : value));
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Integer(in.readInt());
    }
  };

  public static final CDOTypeImpl LONG = new CDOTypeImpl("LONG", 43, false, LONG_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Long)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeLong((Long)(value == null ? getDefaultValue() : value));
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Long(in.readLong());
    }
  };

  public static final CDOTypeImpl SHORT = new CDOTypeImpl("SHORT", 48, false, SHORT_DEFAULT)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value == null ? getDefaultValue() : (Short)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeShort((Short)(value == null ? getDefaultValue() : value));
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return new Short(in.readShort());
    }
  };

  public static final CDOTypeImpl OBJECT = new CDOTypeImpl("OBJECT", 10, true, CDOID.NULL)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      CDOIDImpl.write(out, (CDOID)value);
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return CDOIDImpl.read(in);
    }
  };

  public static final CDOTypeImpl BOOLEAN_OBJECT = new CDOTypeImpl("BOOLEAN_OBJECT", 23, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl BYTE_OBJECT = new CDOTypeImpl("BYTE_OBJECT", 26, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl CHARACTER_OBJECT = new CDOTypeImpl("CHARACTER_OBJECT", 28, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl DATE = new CDOTypeImpl("DATE", 29, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl DOUBLE_OBJECT = new CDOTypeImpl("DOUBLE_OBJECT", 32, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl FLOAT_OBJECT = new CDOTypeImpl("FLOAT_OBJECT", 38, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl INTEGER_OBJECT = new CDOTypeImpl("INTEGER_OBJECT", 40, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl LONG_OBJECT = new CDOTypeImpl("LONG_OBJECT", 44, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl SHORT_OBJECT = new CDOTypeImpl("SHORT_OBJECT", 49, true)
  {
    @Override
    public Object copyValue(Object value)
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      throw new UnsupportedOperationException("Not yet implemented");
    }
  };

  public static final CDOTypeImpl STRING = new CDOTypeImpl("STRING", 50, true)
  {
    @SuppressWarnings("cast")
    @Override
    public Object copyValue(Object value)
    {
      return (String)value;
    }

    @Override
    public void writeValue(ExtendedDataOutputStream out, Object value) throws IOException
    {
      out.writeString((String)value);
    }

    @Override
    public Object readValue(ExtendedDataInputStream in) throws IOException
    {
      return in.readString();
    }
  };

  private String name;

  private int typeID;

  private boolean canBeNull;

  private Object defaultValue;

  private CDOTypeImpl(String name, int typeID, boolean canBeNull, Object defaultValue)
  {
    this.name = name;
    this.typeID = typeID;
    this.canBeNull = canBeNull;
    this.defaultValue = defaultValue;
    setIndex();
  }

  private CDOTypeImpl(String name, int typeID, boolean canBeNull)
  {
    this(name, typeID, canBeNull, null);
  }

  public String getName()
  {
    return name;
  }

  public int getTypeID()
  {
    return typeID;
  }

  public boolean canBeNull()
  {
    return canBeNull;
  }

  public Object getDefaultValue()
  {
    return defaultValue;
  }

  @Override
  public String toString()
  {
    return name;
  }

  public abstract Object copyValue(Object value);

  public abstract void writeValue(ExtendedDataOutputStream out, Object value) throws IOException;

  public abstract Object readValue(ExtendedDataInputStream in) throws IOException;

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    out.writeByte(typeID);
  }

  public static CDOTypeImpl read(ExtendedDataInputStream in) throws IOException
  {
    byte typeID = in.readByte();
    return getType(typeID);
  }

  public static CDOTypeImpl getType(int typeID)
  {
    return index.get(typeID);
  }

  private void setIndex()
  {
    while (index.size() <= typeID)
    {
      index.add(null);
    }

    index.set(typeID, this);
  }
}
