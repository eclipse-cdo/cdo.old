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
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.analyzer.IFeatureAnalyzer;
import org.eclipse.emf.cdo.protocol.analyzer.IFetchRuleManager;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDOFeatureAnalyzer implements IFeatureAnalyzer, IFetchRuleManager
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG, CDOFeatureAnalyzer.class);

  private static final long ELAPSE_TIME = 400L;

  private static final ThreadLocal<CDOFeatureAnalyzer> threadLocal = new ThreadLocal<CDOFeatureAnalyzer>();

  private Map<CDOFeature, CDOFeatureRule> featureRules = new HashMap<CDOFeature, CDOFeatureRule>();

  private CDOFeatureRule lastFeatureRule;

  private long lastAccessTime;

  private boolean inUse;

  private CDORevision lastRevision;

  public CDOFeatureAnalyzer()
  {
  }

  public CDOFeatureRule getCurrentFeatureRule()
  {
    return lastFeatureRule;
  }

  public static CDOFeatureAnalyzer getCurrent()
  {
    return threadLocal.get();
  }

  public void preTraverseFeature(CDORevision revision, CDOFeature feature, int index)
  {
    CDOClass cdoClass = revision.getCDOClass();
    threadLocal.set(this);
    lastRevision = revision;

    if (TRACER.isEnabled())
    {
      TRACER.format("preTraverseFeature : {0}.{1}", cdoClass.getName(), feature.getName());
    }

    // Do not handle these cases
    long currentTime = System.currentTimeMillis();
    if (!feature.isReference() || feature.isContainment() || feature.isMany() && index != 0)
    {
      lastAccessTime = currentTime;
      return;
    }

    long elapseTimeBeforeLastRequest = currentTime - lastAccessTime;
    if (elapseTimeBeforeLastRequest > ELAPSE_TIME || lastFeatureRule == null)
    {
      CDOFeatureRule featureRule = getFeatureRule(cdoClass, feature);
      lastFeatureRule = featureRule;
    }

    CDOFetchFeatureStat stat = lastFeatureRule.getFeatureStat(feature);
    if (stat.getTimeBeforeUsed() != 0)
    {
      stat.setTimeBeforeUsed((stat.getTimeBeforeUsed() + elapseTimeBeforeLastRequest) / 2);
    }
    else
    {
      stat.setTimeBeforeUsed(elapseTimeBeforeLastRequest);
    }

    if (!stat.isValid() && stat.getTimeBeforeUsed() < CDOFeatureAnalyzer.ELAPSE_TIME)
    {
      CDOFetchRule fetchRule = lastFeatureRule.addFeatureRule(cdoClass, feature);
      stat.setFetchRule(fetchRule);
    }
    else if (stat.isValid() && stat.getTimeBeforeUsed() > CDOFeatureAnalyzer.ELAPSE_TIME)
    {
      // Unregister rules
      lastFeatureRule.removeFeatureRule(cdoClass, feature);
      stat.setFetchRule(null);
    }

    lastAccessTime = currentTime;
    inUse = true;
  }

  public void postTraverseFeature(CDORevision revision, CDOFeature feature, int index)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("postTraverseFeature : {0}.{1}", revision.getCDOClass(), feature.getName());
    }

    lastAccessTime = System.currentTimeMillis();
    inUse = false;
    threadLocal.set(null);
  }

  public CDOID getContext()
  {
    return lastRevision.getID();
  }

  public synchronized CDOFeatureRule getFeatureRule(CDOClass cdoClass, CDOFeature cdoFeature)
  {
    CDOFeatureRule featureRule = featureRules.get(cdoFeature);
    if (featureRule == null)
    {
      featureRule = new CDOFeatureRule(cdoClass, cdoFeature);
      featureRules.put(cdoFeature, featureRule);
    }

    return featureRule;
  }

  public List<CDOFetchRule> getFetchRules(Collection<CDOID> ids)
  {
    if (!inUse || lastFeatureRule == null)
    {
      return null;
    }

    List<CDOFetchRule> list = new ArrayList<CDOFetchRule>();
    for (Iterator<CDOFetchRule> it = lastFeatureRule.iterator(); it.hasNext();)
    {
      CDOFetchRule fetchRule = it.next();
      list.add(fetchRule);
    }

    return list;
  }
}
