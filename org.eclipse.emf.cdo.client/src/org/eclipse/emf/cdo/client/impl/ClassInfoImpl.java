/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.AttributeInfo;
import org.eclipse.emf.cdo.client.CDOPackage;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.mapping.AttributeMapping;
import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import java.util.ArrayList;
import java.util.Iterator;


public class ClassInfoImpl implements ClassInfo
{
  protected int cid;

  protected String fullName;

  protected EClass eClass;

  protected ClassMapping mapping;

  protected PackageInfo packageInfo;

  protected ClassInfo parent;

  protected boolean parentCached;

  protected AttributeInfo[] attributeInfos;

  protected EReference[] allReferences;

  public ClassInfoImpl(EClass eClass, PackageInfo packageInfo, ClassMapping mapping)
  {
    this.eClass = eClass;
    this.mapping = mapping;
    this.packageInfo = packageInfo;

    fullName = eClass.getEPackage().getName() + "." + eClass.getName();

    initAttributeInfos();
    initReferences();
  }

  public String toString()
  {
    return getFullName();
  }

  public String getName()
  {
    return eClass.getName();
  }

  public String getFullName()
  {
    return fullName;
  }

  public EClass getEClass()
  {
    return eClass;
  }

  public ClassMapping getMapping()
  {
    return mapping;
  }

  public ClassInfo getParent()
  {
    if (!parentCached)
    {
      parentCached = true;

      for (Iterator it = eClass.getEAllSuperTypes().iterator(); it.hasNext();)
      {
        EClass candidate = (EClass) it.next();
        if (candidate != null && !candidate.isInterface()
            && !candidate.equals(CDOPackage.eINSTANCE.getCdoPersistent()))
        {
          parent = packageInfo.getPackageManager().getClassInfo(candidate);
          break;
        }
      }
    }

    return parent;
  }

  public AttributeInfo[] getAttributeInfos()
  {
    return attributeInfos;
  }

  public EReference[] getAllReferences()
  {
    return allReferences;
  }

  //  public String toString()
  //  {
  //    if (inheritance == null) return eClass.getName();
  //    StringBuffer buffer = new StringBuffer(eClass.getName());
  //    for (int i = 0; i < inheritance.length; i++)
  //    {
  //      buffer.append(" -> " + inheritance[i].getName());
  //    }
  //    return buffer.toString();
  //  }
  //
  //  public void dump()
  //  {
  //    System.out.println(this);
  //    for (int i = 0; i < attributes.length; i++)
  //    {
  //      System.out.println((i < attributes.length - ownAttributesCount ? "  " : " *")
  //          + attributes[i].getName() + "(" + attributes[i].getFeatureID() + "): "
  //          + attributes[i].getEType().getName() + "      " + attributes[i]);
  //    }
  //
  //    for (int i = 0; i < allReferences.length; i++)
  //    {
  //      System.out.println("  " + allReferences[i].getName() + "(" + allReferences[i].getFeatureID()
  //          + "): " + allReferences[i].getEType().getName() + "      " + allReferences[i]);
  //    }
  //  }

  protected void initAttributeInfos()
  {
    ArrayList tmp = new ArrayList();

    for (Iterator it = eClass.getEAttributes().iterator(); it.hasNext();)
    {
      EAttribute eAttribute = (EAttribute) it.next();
      AttributeMapping attributeMapping = mapping.getAttributeMapping(eAttribute.getName());

      if (attributeMapping != null)
      {
        AttributeInfo attributeInfo = new AttributeInfoImpl(eAttribute, attributeMapping, this);
        tmp.add(attributeInfo);
      }
    }

    attributeInfos = (AttributeInfo[]) tmp.toArray(new AttributeInfo[tmp.size()]);
  }

  protected void initReferences()
  {
    ArrayList tmp = new ArrayList();

    for (Iterator it = eClass.getEAllReferences().iterator(); it.hasNext();)
    {
      EReference reference = (EReference) it.next();

      if (!reference.isTransient())
      {
        // TODO provide mapping info for references
        tmp.add(reference);
      }
    }

    allReferences = (EReference[]) tmp.toArray(new EReference[tmp.size()]);
  }

  public int getCID()
  {
    return cid;
  }

  public void setCID(int cid)
  {
    this.cid = cid;
    packageInfo.getPackageManager().initCID(this);
  }

  public AttributeInfo getAttributeInfo(EAttribute eAttribute)
  {
    for (int i = 0; i < attributeInfos.length; i++)
    {
      if (attributeInfos[i].getEAttribute() == eAttribute)
      {
        return attributeInfos[i];
      }
    }

    ClassInfo parentInfo = getParent();
    if (parentInfo != null)
    {
      return parentInfo.getAttributeInfo(eAttribute);
    }

    return null;
  }

  public AttributeInfo getAttributeInfo(int feature)
  {
    for (int i = 0; i < attributeInfos.length; i++)
    {
      if (attributeInfos[i].getEAttribute().getFeatureID() == feature)
      {
        return attributeInfos[i];
      }
    }

    ClassInfo parentInfo = getParent();
    if (parentInfo != null)
    {
      return parentInfo.getAttributeInfo(feature);
    }

    return null;
  }

  public PackageInfo getPackageInfo()
  {
    return packageInfo;
  }
}