/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.dbgen.impl;


import org.eclipse.net4j.util.Argument;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.StringHelper;

import org.eclipse.emf.cdo.dbgen.Column;
import org.eclipse.emf.cdo.dbgen.ColumnType;
import org.eclipse.emf.cdo.dbgen.Database;
import org.eclipse.emf.cdo.dbgen.Index;
import org.eclipse.emf.cdo.dbgen.IndexType;
import org.eclipse.emf.cdo.dbgen.SQLDialect;
import org.eclipse.emf.cdo.dbgen.Table;
import org.eclipse.emf.cdo.dbgen.TableCreationException;
import org.eclipse.emf.cdo.dbgen.UnknownSQLTypeException;
import org.eclipse.emf.cdo.dbgen.internal.DBGenActivator;
import org.eclipse.emf.cdo.dbgen.internal.DBGenActivator.DialectElement;

import org.apache.log4j.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.MetaDataAccessException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


public class SQLDialectImpl implements SQLDialect
{
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(SQLDialectImpl.class);

  private DBGenActivator.DialectElement dialectElement;

  private String stringBIGINT = "BIGINT";

  private String stringBINARY = "BINARY";

  private String stringBIT = "BIT";

  private String stringBLOB = "LONG VARBINARY";

  private String stringBOOLEAN = "BIT";

  private String stringCHAR = "CHAR";

  private String stringCLOB = "LONG VARCHAR";

  private String stringDATE = "DATE";

  private String stringDECIMAL = "DECIMAL";

  private String stringDOUBLE = "DOUBLEPRECISION";

  private String stringFLOAT = "FLOAT";

  private String stringINTEGER = "INTEGER";

  private String stringLONGVARBINARY = "LONG VARBINARY";

  private String stringLONGVARCHAR = "LONG VARCHAR";

  private String stringNUMERIC = "NUMERIC";

  private String stringREAL = "REAL";

  private String stringSMALLINT = "SMALLINT";

  private String stringTIME = "TIME";

  private String stringTIMESTAMP = "TIMESTAMP";

  private String stringTINYINT = "TINYINT";

  private String stringVARBINARY = "VARBINARY";

  private String stringVARCHAR = "VARCHAR";

  public SQLDialectImpl(DialectElement dialectElement)
  {
    Argument.isNotNull(dialectElement);
    this.dialectElement = dialectElement;
    initTypeMappings();
  }

  public DBGenActivator.DialectElement getDialectElement()
  {
    return dialectElement;
  }

  public String toDBType(int sqlType)
  {
    switch (sqlType)
    {
      case ColumnType.BIGINT:
        return stringBIGINT;

      case ColumnType.BINARY:
        return stringBINARY;

      case ColumnType.BIT:
        return stringBIT;

      case ColumnType.BLOB:
        return stringBLOB;

      case ColumnType.BOOLEAN:
        return stringBOOLEAN;

      case ColumnType.CHAR:
        return stringCHAR;

      case ColumnType.CLOB:
        return stringCLOB;

      case ColumnType.DATE:
        return stringDATE;

      case ColumnType.DECIMAL:
        return stringDECIMAL;

      case ColumnType.DOUBLE:
        return stringDOUBLE;

      case ColumnType.FLOAT:
        return stringFLOAT;

      case ColumnType.INTEGER:
        return stringINTEGER;

      case ColumnType.LONGVARBINARY:
        return stringLONGVARBINARY;

      case ColumnType.LONGVARCHAR:
        return stringLONGVARCHAR;

      case ColumnType.NUMERIC:
        return stringNUMERIC;

      case ColumnType.REAL:
        return stringREAL;

      case ColumnType.SMALLINT:
        return stringSMALLINT;

      case ColumnType.TIME:
        return stringTIME;

      case ColumnType.TIMESTAMP:
        return stringTIMESTAMP;

      case ColumnType.TINYINT:
        return stringTINYINT;

      case ColumnType.VARBINARY:
        return stringVARBINARY;

      case ColumnType.VARCHAR:
        return stringVARCHAR;

      default:
        throw new UnknownSQLTypeException("Unkown SQL type " + sqlType);
    }
  }

  public void save(DataSource dataSource, Database database, boolean clean)
  {
    Map existingTables = getExistingTables(dataSource);

    for (Iterator tableIt = database.getTables().iterator(); tableIt.hasNext();)
    {
      Table table = (Table) tableIt.next();
      String key = table.getName().toUpperCase();
      boolean exists = (existingTables.get(key) != null);

      if (exists)
      {
        if (clean)
        {
          dropTable(dataSource, table);
          createTable(dataSource, table);
        }
      }
      else
      {
        createTable(dataSource, table);
      }
    }
  }

  protected String composeIndexCreationString(Index index)
  {
    Table table = index.getTable();
    String template;

    switch (index.getType().getValue())
    {
      case IndexType.NON_UNIQUE:
        template = dialectElement.getCreateIndexTemplate();
        break;
      case IndexType.UNIQUE:
        template = dialectElement.getCreateUniqueIndexTemplate();
        break;
      case IndexType.PRIMARY:
        template = dialectElement.getCreatePrimaryIndexTemplate();
        break;
      default:
        throw new ImplementationError("invalid index type: " + index.getType());
    }

    String[] args = { composeColumnsString(index), index.getName(), table.getName()};
    String result = StringHelper.replaceString(template, args);
    return result;
  }

  protected String composeTableCreationString(Table table)
  {
    Index pk = table.getPrimaryIndex();

    String template = pk == null ? dialectElement.getCreateTableTemplate() : dialectElement
        .getCreateTablePrimaryTemplate();
    String pkConstraint = pk == null ? null : composeColumnsString(pk);

    String[] args = { composeColumnsString(table, false), table.getName(), pkConstraint};
    String result = StringHelper.replaceString(template, args);
    return result;
  }

  protected String composeTableDropString(Table table)
  {
    String[] args = { table.getName()};
    String result = StringHelper.replaceString(dialectElement.getDropTableTemplate(), args);
    return result;
  }

  protected String composeColumnsString(Table table, boolean onlyNames)
  {
    if (onlyNames)
    {
      return composeColumnsString(table.getColumns());
    }

    StringBuffer buffer = new StringBuffer();
    boolean first = true;

    for (Iterator iter = table.getColumns().iterator(); iter.hasNext();)
    {
      Column column = (Column) iter.next();
      String type = composeTypeString(column);

      if (first)
      {
        first = false;
      }
      else
      {
        buffer.append(", ");
      }

      buffer.append(column.getName());
      buffer.append(" ");
      buffer.append(type);

      if (column.getLength() > 0)
      {
        buffer.append("(");
        buffer.append(column.getLength());
        buffer.append(")");
      }

      if (column.getConstraint() != null)
      {
        buffer.append(" " + column.getConstraint());
      }
    }

    return buffer.toString();
  }

  protected String composeColumnsString(Index index)
  {
    return composeColumnsString(index.getColumns());
  }

  protected String composeColumnsString(List columns)
  {
    Iterator iter = columns.iterator();
    StringBuffer result = new StringBuffer(((Column) iter.next()).getName());

    while (iter.hasNext())
    {
      result.append(", ");
      result.append(((Column) iter.next()).getName());
    }

    return result.toString();
  }

  protected String composeTypeString(Column column)
  {
    return toDBType(column.getType().getValue());
  }

  protected Map getExistingTables(DataSource dataSource)
  {
    final Map result = new HashMap();

    try
    {
      JdbcUtils.extractDatabaseMetaData(dataSource, new DatabaseMetaDataCallback()
      {
        public Object processMetaData(DatabaseMetaData dbmd) throws SQLException
        {
          ResultSet tables = dbmd.getTables(null, null, "%", new String[] { "TABLE"});
          while (tables.next())
          {
            String table = tables.getString(3);
            String key = table.toUpperCase();

            if (logger.isDebugEnabled()) logger.debug("Found existing table " + key);
            result.put(key, table);
          }
          return null;
        }
      });
    }
    catch (MetaDataAccessException ex)
    {
      logger.error("Error while retrieving JDBC metadata", ex);
    }

    return result;
  }

  /**
   * @param table
   */
  private void createTable(DataSource dataSource, Table table)
  {
    JdbcTemplate template = new JdbcTemplate(dataSource);
    String tableSQL = composeTableCreationString(table);
    if (logger.isDebugEnabled()) logger.debug(tableSQL);

    template.execute(tableSQL);

    for (Iterator indexIt = table.getIndices().iterator(); indexIt.hasNext();)
    {
      Index index = (Index) indexIt.next();

      if (index.getType().equals(IndexType.PRIMARY_LITERAL)) continue;

      if (index.getColumns().size() == 0)
      {
        throw new TableCreationException("Index " + index.getName() + " has no columns");
      }

      String indexSQL = composeIndexCreationString(index);
      if (indexSQL == null)
      {
        continue;
      }

      if (logger.isDebugEnabled()) logger.debug(indexSQL);
      template.execute(indexSQL);
    }
  }

  /**
   * @param table
   */
  private void dropTable(DataSource dataSource, Table table)
  {
    try
    {
      JdbcTemplate template = new JdbcTemplate(dataSource);
      String sql = composeTableDropString(table);
      template.execute(sql);
    }
    catch (Throwable t)
    {
      logger.warn("Error while dropping table " + table, t);
    }
  }

  private void initTypeMappings()
  {
    DBGenActivator.TypeMappingElement[] elements = dialectElement.getTypeMappings();
    for (int i = 0; i < elements.length; i++)
    {
      DBGenActivator.TypeMappingElement element = elements[i];
      if ("BIGINT".equals(element.getSqlType()))
      {
        stringBIGINT = element.getVendorString();
      }
      else if ("BINARY".equals(element.getSqlType()))
      {
        stringBINARY = element.getVendorString();
      }
      else if ("BIT".equals(element.getSqlType()))
      {
        stringBIT = element.getVendorString();
      }
      else if ("BLOB".equals(element.getSqlType()))
      {
        stringBLOB = element.getVendorString();
      }
      else if ("BOOLEAN".equals(element.getSqlType()))
      {
        stringBOOLEAN = element.getVendorString();
      }
      else if ("CHAR".equals(element.getSqlType()))
      {
        stringCHAR = element.getVendorString();
      }
      else if ("CLOB".equals(element.getSqlType()))
      {
        stringCLOB = element.getVendorString();
      }
      else if ("DATE".equals(element.getSqlType()))
      {
        stringDATE = element.getVendorString();
      }
      else if ("DECIMAL".equals(element.getSqlType()))
      {
        stringDECIMAL = element.getVendorString();
      }
      else if ("DOUBLE".equals(element.getSqlType()))
      {
        stringDOUBLE = element.getVendorString();
      }
      else if ("FLOAT".equals(element.getSqlType()))
      {
        stringFLOAT = element.getVendorString();
      }
      else if ("INTEGER".equals(element.getSqlType()))
      {
        stringINTEGER = element.getVendorString();
      }
      else if ("LONGVARBINARY".equals(element.getSqlType()))
      {
        stringLONGVARBINARY = element.getVendorString();
      }
      else if ("LONGVARCHAR".equals(element.getSqlType()))
      {
        stringLONGVARCHAR = element.getVendorString();
      }
      else if ("NUMERIC".equals(element.getSqlType()))
      {
        stringNUMERIC = element.getVendorString();
      }
      else if ("REAL".equals(element.getSqlType()))
      {
        stringREAL = element.getVendorString();
      }
      else if ("SMALLINT".equals(element.getSqlType()))
      {
        stringSMALLINT = element.getVendorString();
      }
      else if ("TIME".equals(element.getSqlType()))
      {
        stringTIME = element.getVendorString();
      }
      else if ("TIMESTAMP".equals(element.getSqlType()))
      {
        stringTIMESTAMP = element.getVendorString();
      }
      else if ("TINYINT".equals(element.getSqlType()))
      {
        stringTINYINT = element.getVendorString();
      }
      else if ("VARBINARY".equals(element.getSqlType()))
      {
        stringVARBINARY = element.getVendorString();
      }
      else if ("VARCHAR".equals(element.getSqlType()))
      {
        stringVARCHAR = element.getVendorString();
      }
    }
  }
}
