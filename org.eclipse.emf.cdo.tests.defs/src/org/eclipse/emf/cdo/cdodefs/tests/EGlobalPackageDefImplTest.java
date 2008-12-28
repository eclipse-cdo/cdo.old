package org.eclipse.emf.cdo.cdodefs.tests;

import org.eclipse.emf.cdo.cdodefs.CDODefsFactory;
import org.eclipse.emf.cdo.cdodefs.EGlobalPackageDef;
import org.eclipse.emf.cdo.tests.AbstractCDOTest;

import org.eclipse.emf.ecore.EPackage;

public class EGlobalPackageDefImplTest extends AbstractCDOTest
{

  public void testEGlobalPackageDefReturnsPackage()
  {
    EPackage model1Package = getModel1Package();
    EPackage.Registry.INSTANCE.put(model1Package.getNsURI(), model1Package);

    EGlobalPackageDef packageDef = CDODefsFactory.eINSTANCE.createEGlobalPackageDef();
    packageDef.setNsURI(model1Package.getNsURI());

    EPackage ePackage = (EPackage) packageDef.getInstance();
  }

}
