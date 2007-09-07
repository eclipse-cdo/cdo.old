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

import org.eclipse.emf.cdo.internal.protocol.bundle.OM;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDOFeatureRule
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG, CDOFeatureRule.class);

  private CDOClass cdoClass;

  private CDOFeature cdoFeature;

  private Map<CDOFeature, CDOFetchFeatureStat> featureStats = new HashMap<CDOFeature, CDOFetchFeatureStat>();

  private Map<CDOClass, CDOFetchRule> fetchRules = new HashMap<CDOClass, CDOFetchRule>();

  public CDOFeatureRule(CDOClass cdoClass, CDOFeature cdoFeature)
  {
    this.cdoClass = cdoClass;
    this.cdoFeature = cdoFeature;
  }

  public CDOClass getCDOClass()
  {
    return cdoClass;
  }

  public CDOFeature getCDOFeature()
  {
    return cdoFeature;
  }

  public Iterator<CDOFetchRule> iterator()
  {
    return fetchRules.values().iterator();
  }

  public synchronized CDOFetchFeatureStat getFeatureStat(CDOFeature cdoFeature)
  {
    CDOFetchFeatureStat featureRule = featureStats.get(cdoFeature);
    if (featureRule == null)
    {
      featureRule = new CDOFetchFeatureStat();
      featureStats.put(cdoFeature, featureRule);
    }

    return featureRule;
  }

  public synchronized CDOFetchRule addFeatureRule(CDOClass cdoClass, CDOFeature cdoFeature)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Adding new fetch rule : {0}.{1} from root {2}.{3}", cdoClass.getName(), cdoFeature.getName(),
          this.cdoClass.getName(), this.cdoFeature.getName());
    }

    CDOFetchRule fetchRule = getFetchRule(cdoClass);
    fetchRule.addFeature(cdoFeature);
    return fetchRule;

  }

  public synchronized CDOFetchRule removeFeatureRule(CDOClass cdoClass, CDOFeature cdoFeature)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Adding new fetch rule : {0}.{1} from root {2}.{3}", cdoClass.getName(), cdoFeature.getName(),
          this.cdoClass.getName(), this.cdoFeature.getName());
    }

    CDOFetchRule fetchRule = getFetchRule(cdoClass);
    fetchRule.removeFeature(cdoFeature);
    if (fetchRule.isEmpty())
    {
      fetchRules.remove(cdoClass);
    }

    return fetchRule;
  }

  public synchronized CDOFetchRule getFetchRule(CDOClass cdoFeature)
  {
    CDOFetchRule featureRule = fetchRules.get(cdoFeature);
    if (featureRule == null)
    {
      featureRule = new CDOFetchRule(cdoFeature);
      fetchRules.put(cdoFeature, featureRule);
    }

    return featureRule;
  }
}
