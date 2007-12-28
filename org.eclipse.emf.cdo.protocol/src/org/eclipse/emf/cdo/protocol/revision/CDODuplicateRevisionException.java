/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.protocol.revision;

import org.eclipse.emf.cdo.protocol.util.CDOException;

/**
 * @author Eike Stepper
 */
public class CDODuplicateRevisionException extends CDOException
{
  private static final long serialVersionUID = 1L;

  private CDORevision revision;

  public CDODuplicateRevisionException(CDORevision revision)
  {
    super(revision.toString());
    this.revision = revision;
  }

  public CDORevision getRevision()
  {
    return revision;
  }
}
