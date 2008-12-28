package org.eclipse.emf.cdo.cdodefs.tests;

import org.eclipse.emf.cdo.cdodefs.CDODefsFactory;
import org.eclipse.emf.cdo.cdodefs.CDOPackageRegistryDef;
import org.eclipse.emf.cdo.cdodefs.EGlobalPackageDef;
import org.eclipse.emf.cdo.cdodefs.EPackageDef;
import org.eclipse.emf.cdo.tests.AbstractCDOTest;
import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model2.Model2Package;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author André Dietisheim
 */
public class CDOPackageRegistryDefImplTest extends AbstractCDOTest
{

  public void testReturnsPackageInstances()
  {
    CDOPackageRegistryDef packageRegistryDef = CDODefsFactory.eINSTANCE.createCDOPackageRegistryDef();
    EList<EPackageDef> packages = packageRegistryDef.getPackages();
    Model1Package model1package = getModel1Package();
    packages.add(createEGlobalPackageDef(model1package));
    Model2Package model2Package = getModel2Package();
    packages.add(createEGlobalPackageDef(model2Package));

    EPackage.Registry packageRegistry = (EPackage.Registry)packageRegistryDef.getInstance();
    EPackage ePackage1 = packageRegistry.getEPackage(getModel1Package().getNsURI());
    assertTrue(ePackage1 instanceof Model1Package);
    EPackage ePackage2 = packageRegistry.getEPackage(getModel2Package().getNsURI());
    assertTrue(ePackage2 instanceof Model2Package);
  }

  private EGlobalPackageDef createEGlobalPackageDef(EPackage ePackage)
  {
    EGlobalPackageDef eGlobalPackageDef = CDODefsFactory.eINSTANCE.createEGlobalPackageDef();
    eGlobalPackageDef.setNsURI(ePackage.getNsURI());
    return eGlobalPackageDef;
  }

}
