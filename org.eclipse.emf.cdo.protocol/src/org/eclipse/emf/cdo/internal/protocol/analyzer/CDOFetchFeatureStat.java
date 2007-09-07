/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.analyzer;

/**
 * @author Eike Stepper
 */
public class CDOFetchFeatureStat
{
  private CDOFetchRule fetchRule;

  private long timeBeforeUsed;

  private long latencyTime;

  public CDOFetchFeatureStat()
  {
  }

  public boolean isValid()
  {
    return fetchRule != null;
  }

  public long getTimeBeforeUsed()
  {
    return timeBeforeUsed;
  }

  public void setTimeBeforeUsed(long timeBeforeUsed)
  {
    this.timeBeforeUsed = timeBeforeUsed;
  }

  public long getLatencyTime()
  {
    return latencyTime;
  }

  public void setLatencyTime(long latencyTime)
  {
    this.latencyTime = latencyTime;
  }

  public CDOFetchRule getFetchRule()
  {
    return fetchRule;
  }

  public void setFetchRule(CDOFetchRule fetchRule)
  {
    this.fetchRule = fetchRule;
  }
}
