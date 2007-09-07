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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.analyzer.IFetchRuleManager;

/**
 * @author Eike Stepper
 */
public class CDOFetchRuleManager implements IFetchRuleManager
{
  public CDOFetchRuleManager()
  {
  }

  public CDOID getContext()
  {
    return CDOFeatureAnalyzer.getCurrent().getContext();
  }

  public List<CDOFetchRule> getFetchRules(Collection<CDOID> ids)
  {
    return CDOFeatureAnalyzer.getCurrent().getFetchRules(ids);
  }
}
