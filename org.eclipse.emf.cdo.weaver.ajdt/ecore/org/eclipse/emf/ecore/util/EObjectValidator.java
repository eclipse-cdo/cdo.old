/**
 * <copyright>
 *
 * Copyright (c) 2004-2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ecore.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;


/**
 * A validity checker for basic EObject constraints.
 */
public class EObjectValidator implements EValidator
{
  public static final EObjectValidator INSTANCE = new EObjectValidator();

  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.emf.ecore";

  public static final int EOBJECT__EVERY_MULTIPCITY_CONFORMS = 1;
  public static final int EOBJECT__EVERY_DATA_VALUE_CONFORMS = 2;
  public static final int EOBJECT__EVERY_REFERENCE_IS_CONTAINED = 3;
  public static final int EOBJECT__EVERY_PROXY_RESOLVES = 4;
  public static final int DATA_VALUE__VALUE_IN_RANGE = 5;
  public static final int DATA_VALUE__LENGTH_IN_RANGE = 6;
  public static final int DATA_VALUE__TYPE_CORRECT = 7;
  public static final int DATA_VALUE__VALUE_IN_ENUMERATION = 8;
  public static final int DATA_VALUE__MATCHES_PATTERN = 9;
  public static final int DATA_VALUE__TOTAL_DIGITS_IN_RANGE = 10;
  public static final int DATA_VALUE__FRACTION_DIGITS_IN_RANGE = 11;
  public static final int EOBJECT__UNIQUE_ID = 12;
  public static final int EOBJECT__EVERY_KEY_UNIQUE = 13;
  public static final int EOBJECT__EVERY_MAP_ENTRY_UNIQUE = 14;
  
  static final int EOBJECT_DIAGNOSTIC_CODE_COUNT = EOBJECT__EVERY_MAP_ENTRY_UNIQUE;

  /**
   * @since 2.1.0
   */
  public static String getObjectLabel(EObject eObject, Map<Object, Object> context)
  {
    if (context != null)
    {
      SubstitutionLabelProvider substitutionlabelProvider = (SubstitutionLabelProvider)context.get(SubstitutionLabelProvider.class);
      if (substitutionlabelProvider != null)
      {
        return substitutionlabelProvider.getObjectLabel(eObject);
      }
    }
    return EcoreUtil.getIdentification(eObject);
  }

  /**
   * @since 2.1.0
   */
  public static String getFeatureLabel(EStructuralFeature eStructuralFeature, Map<Object, Object> context)
  {
    if (context != null)
    {
      SubstitutionLabelProvider substitutionlabelProvider = (SubstitutionLabelProvider)context.get(SubstitutionLabelProvider.class);
      if (substitutionlabelProvider != null)
      {
        return substitutionlabelProvider.getFeatureLabel(eStructuralFeature);
      }
    }
    return eStructuralFeature.getName();
  }

  /**
   * @since 2.1.0
   */
  public static String getValueLabel(EDataType eDataType, Object value, Map<Object, Object> context)
  {
    if (context != null)
    {
      SubstitutionLabelProvider substitutionlabelProvider = (SubstitutionLabelProvider)context.get(SubstitutionLabelProvider.class);
      if (substitutionlabelProvider != null)
      {
        return substitutionlabelProvider.getValueLabel(eDataType, value);
      }
    }
    return EcoreUtil.convertToString(eDataType, value);
  }

  public EObjectValidator()
  {
    super();
  }

  protected EPackage getEPackage()
  {
    return EcorePackage.eINSTANCE;
  }

  protected EValidator getRootEValidator(Map<Object, Object> context)
  {
    if (context != null)
    {
      EValidator result = (EValidator)context.get(EValidator.class);
      if (result != null)
      {
        return result;
      }
    }

    return Diagnostician.INSTANCE;
  }

  /**
   * Validates the object in the given context, optionally producing diagnostics.
   * @param diagnostics a place to accumulate diagnostics; if it's <code>null</code>, no diagnostics should be produced.
   * @param context a place to cache information, if it's <code>null</code>, no cache is supported.
   * @return whether the object is valid.
   */
  public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate(eObject.eClass(), eObject, diagnostics, context);
  }

  public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    if (eClass.eContainer() == getEPackage())
    {
      return validate(eClass.getClassifierID(), eObject, diagnostics, context);
    }
    else
    {
      List<EClass> eSuperTypes = eClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          validate_EveryDefaultConstraint(eObject, diagnostics, context) :
          validate(eSuperTypes.get(0), eObject, diagnostics, context);
    }
  }

  protected boolean validate(int classifierID, Object object, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return classifierID != EcorePackage.EOBJECT || validate_EveryDefaultConstraint((EObject)object, diagnostics, context);
  }

  public boolean validate_EveryDefaultConstraint(EObject object, DiagnosticChain theDiagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(object, theDiagnostics, context);
    if (result || theDiagnostics != null)
    {
      result &= validate_EveryProxyResolves(object, theDiagnostics, context);
    }
    if (result || theDiagnostics != null)
    {
      result &= validate_EveryReferenceIsContained(object, theDiagnostics, context);
    }
    if (result || theDiagnostics != null)
    {
      result &= validate_EveryDataValueConforms(object, theDiagnostics, context);
    }
    if (result || theDiagnostics != null)
    {
      result &= validate_UniqueID(object, theDiagnostics, context);
    }
    if (result || theDiagnostics != null)
    {
      result &= validate_EveryKeyUnique(object, theDiagnostics, context);
    }
    if (result || theDiagnostics != null)
    {
      result &= validate_EveryMapEntryUnique(object, theDiagnostics, context);
    }
    return result;
  }

  public boolean validate_EveryMultiplicityConforms(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    EClass eClass = eObject.eClass();
    for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
    {
      result &= validate_MultiplicityConforms(eObject, eClass.getEStructuralFeature(i), diagnostics, context);
      if (!result && diagnostics == null)
      {
        return false;
      }
    }
    return result;
  }
  
  protected boolean validate_MultiplicityConforms
    (EObject eObject, EStructuralFeature eStructuralFeature, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    if (eStructuralFeature.isMany())
    {
      int lowerBound = eStructuralFeature.getLowerBound();
      if (lowerBound > 0)
      {
        int size = ((List<?>)eObject.eGet(eStructuralFeature)).size();
        if (size < lowerBound)
        {
          result = false;
          if (diagnostics != null)
          {
            diagnostics.add
              (new BasicDiagnostic
                (Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 EOBJECT__EVERY_MULTIPCITY_CONFORMS,
                 getEcoreResourceLocator().getString
                   ("_UI_FeatureHasTooFewValues_diagnostic",
                    new Object []
                      {
                        getFeatureLabel(eStructuralFeature, context),
                        getObjectLabel(eObject, context),
                        new Integer(size),
                        new Integer(lowerBound)
                      }),
                 new Object [] { eObject, eStructuralFeature }));
          }
        }
        int upperBound = eStructuralFeature.getUpperBound();
        if (upperBound > 0 && size > upperBound)
        {
          result = false;
          if (diagnostics != null)
          {
            diagnostics.add
              (new BasicDiagnostic
                (Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 EOBJECT__EVERY_MULTIPCITY_CONFORMS,
                 getEcoreResourceLocator().getString
                   ("_UI_FeatureHasTooManyValues_diagnostic",
                    new Object []
                      {
                        getFeatureLabel(eStructuralFeature, context),
                        getObjectLabel(eObject, context),
                        new Integer(size),
                        new Integer(upperBound)
                      }),
                 new Object [] { eObject, eStructuralFeature }));
          }
        }
      }
      else
      {
        int upperBound = eStructuralFeature.getUpperBound();
        if (upperBound > 0)
        {
          int size = ((List<?>)eObject.eGet(eStructuralFeature)).size();
          if (size > upperBound)
          {
            result = false;
            if (diagnostics != null)
            {
              diagnostics.add
                (new BasicDiagnostic
                  (Diagnostic.ERROR,
                   DIAGNOSTIC_SOURCE,
                   EOBJECT__EVERY_MULTIPCITY_CONFORMS,
                   getEcoreResourceLocator().getString
                     ("_UI_FeatureHasTooManyValues_diagnostic",
                      new Object []
                        {
                          getFeatureLabel(eStructuralFeature, context),
                          getObjectLabel(eObject, context),
                          new Integer(size),
                          new Integer(upperBound)
                        }),
                   new Object [] { eObject, eStructuralFeature }));
            }
          }
        }
      }
    }
    else if (eStructuralFeature.isRequired())
    {
      if (eStructuralFeature.isUnsettable() ? !eObject.eIsSet(eStructuralFeature) : eObject.eGet(eStructuralFeature, false) == null)
      {
        result = false;
        if (diagnostics != null)
        {
          diagnostics.add
            (new BasicDiagnostic
              (Diagnostic.ERROR,
               DIAGNOSTIC_SOURCE,
               EOBJECT__EVERY_MULTIPCITY_CONFORMS,
               getEcoreResourceLocator().getString
                 ("_UI_RequiredFeatureMustBeSet_diagnostic",
                  new Object [] { getFeatureLabel(eStructuralFeature, context), getObjectLabel(eObject, context) }),
               new Object [] { eObject, eStructuralFeature }));
        }
      }
    }

    return result;
  }

  public boolean validate_EveryProxyResolves(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    for (EContentsEList.FeatureIterator<EObject> i = (EContentsEList.FeatureIterator<EObject>)eObject.eCrossReferences().iterator(); i.hasNext(); )
    {
      EObject eCrossReferenceObject = i.next();
      if (eCrossReferenceObject.eIsProxy())
      {
        result = false;
        if (diagnostics != null)
        {
          diagnostics.add
            (new BasicDiagnostic
              (Diagnostic.ERROR,
               DIAGNOSTIC_SOURCE,
               EOBJECT__EVERY_PROXY_RESOLVES,
               getEcoreResourceLocator().getString
                 ("_UI_UnresolvedProxy_diagnostic",
                  new Object []
                    {
                      getFeatureLabel(i.feature(), context),
                      getObjectLabel(eObject, context),
                      getObjectLabel(eCrossReferenceObject, context)
                    }),
               new Object [] { eObject, i.feature(), eCrossReferenceObject }));
        }
        else
        {
          break;
        }
      }
    }
    return result;
  }

  public boolean validate_EveryReferenceIsContained(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    if (eObject.eResource() != null)
    {
      for (EContentsEList.FeatureIterator<EObject> i = (EContentsEList.FeatureIterator<EObject>)eObject.eCrossReferences().iterator(); i.hasNext(); )
      {
        EObject eCrossReferenceObject = i.next();
        if (eCrossReferenceObject.eResource() == null && !eCrossReferenceObject.eIsProxy() && !i.feature().isTransient())
        {
          result = false;
          if (diagnostics != null)
          {
            diagnostics.add
              (new BasicDiagnostic
                (Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 EOBJECT__EVERY_REFERENCE_IS_CONTAINED,
                 getEcoreResourceLocator().getString
                   ("_UI_DanglingReference_diagnostic",
                    new Object []
                      {
                        getFeatureLabel(i.feature(), context),
                        getObjectLabel(eObject, context),
                        getObjectLabel(eCrossReferenceObject, context)
                      }),
                 new Object [] { eObject, i.feature(), eCrossReferenceObject }));
          }
          else
          {
            break;
          }
        }
      }
    }
    return result;
  }

  public boolean validate_EveryDataValueConforms(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    for (EAttribute eAttribute : eObject.eClass().getEAllAttributes())
    {
      result &= validate_DataValueConforms(eObject, eAttribute, diagnostics, context);
      if (!result && diagnostics == null)
      {
        return false;
      }
    }
    return result;
  }

  protected boolean validate_DataValueConforms
    (EObject eObject, EAttribute eAttribute, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    if (!eObject.eIsSet(eAttribute))
    {
      return true;
    }
    boolean result = true;
    EDataType eDataType = eAttribute.getEAttributeType();
    EValidator rootValidator = getRootEValidator(context);
    Object value = eObject.eGet(eAttribute);
    if (FeatureMapUtil.isFeatureMap(eAttribute))
    {
      @SuppressWarnings("unchecked") Collection<FeatureMap.Entry> featureMap = (Collection<FeatureMap.Entry>)value;
      EClass eClass = eObject.eClass();
      Map<EStructuralFeature, DiagnosticChain> entryFeatureToDiagnosticChainMap = null;
      for (Iterator<FeatureMap.Entry> i = featureMap.iterator(); i.hasNext() && (result || diagnostics != null); )
      {
        FeatureMap.Entry entry = i.next();
        EStructuralFeature entryFeature = entry.getEStructuralFeature();
        if (entryFeature instanceof EAttribute &&
              ExtendedMetaData.INSTANCE.getAffiliation(eClass, entryFeature) == eAttribute)
        {
          EDataType entryType = (EDataType)entryFeature.getEType();
          Object entryValue = entry.getValue();
          boolean entryIsValid = rootValidator.validate(entryType, entryValue, null, context);
          if (!entryIsValid)
          {
            result = false;
            if (diagnostics != null)
            {
              if (entryFeatureToDiagnosticChainMap == null)
              {
                entryFeatureToDiagnosticChainMap = new HashMap<EStructuralFeature, DiagnosticChain>();
              }
              DiagnosticChain entryFeatureDiagnostic = entryFeatureToDiagnosticChainMap.get(entryFeature);
              if (entryFeatureDiagnostic == null)
              {
                entryFeatureDiagnostic = createBadDataValueDiagnostic(eObject, (EAttribute)entryFeature, diagnostics, context);
                entryFeatureToDiagnosticChainMap.put(entryFeature, entryFeatureDiagnostic);
              }
              rootValidator.validate(entryType, entryValue, entryFeatureDiagnostic, context);
            }
          }
        }
      }
    }
    else if (eAttribute.isMany())
    {
      for (Iterator<?> i = ((List<?>)value).iterator(); i.hasNext() && result; )
      {
        result &= rootValidator.validate(eDataType, i.next(), null, context);
      }

      if (!result && diagnostics != null)
      {
        DiagnosticChain diagnostic = createBadDataValueDiagnostic(eObject, eAttribute, diagnostics, context);
        for (Iterator<?> i = ((List<?>)value).iterator(); i.hasNext(); )
        {
          rootValidator.validate(eDataType, i.next(), diagnostic, context);
        }
      }
    }
    else if (value != null)
    {
      result = rootValidator.validate(eDataType, value, null, context);
      if (!result && diagnostics != null)
      {
        DiagnosticChain diagnostic = createBadDataValueDiagnostic(eObject, eAttribute, diagnostics, context);
        rootValidator.validate(eDataType, value, diagnostic, context);
      }
    }

    return result;
  }

  protected DiagnosticChain createBadDataValueDiagnostic
    (EObject eObject, EAttribute eAttribute, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    BasicDiagnostic diagnostic =
      new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         EOBJECT__EVERY_DATA_VALUE_CONFORMS,
         getEcoreResourceLocator().getString
           ("_UI_BadDataValue_diagnostic",
            new Object []
              {
                getFeatureLabel(eAttribute, context),
                getObjectLabel(eObject, context)
              }),
         new Object [] { eObject, eAttribute });
    diagnostics.add(diagnostic);
    return diagnostic;
  }

  protected boolean validatePattern
    (EDataType eDataType, Object value, PatternMatcher [][] patterns, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    String literal = EcoreUtil.convertToString(eDataType, value);
    for (int i = 0; i < patterns.length; ++i)
    {
      PatternMatcher [] children = patterns[i];
      boolean matches = false;
      for (int j = 0; j < children.length; ++j)
      {
        if (children[j].matches(literal))
        {
          matches = true;
          break;
        }
      }
      if (!matches)
      {
        if (diagnostics != null)
        {
          reportDataValuePatternViolation(eDataType, value, children, diagnostics, context);
        }
        return false;
      }
    }
    return true;
  }

  public class DynamicEDataTypeValidator
  {
    protected List<Object> effectiveEnumeration;
    protected PatternMatcher [][] effectivePattern;
    protected int effectiveTotalDigits = -1;
    protected int effectiveFractionDigits = -1;
    protected int effectiveMinLength = -1;
    protected int effectiveMaxLength = -1;
    protected Object effectiveMin;
    protected boolean effectiveMinIsInclusive;
    protected int effectiveTotalDigitsMin = -1;
    protected Object effectiveMax;
    protected boolean effectiveMaxIsInclusive;
    protected int effectiveTotalDigitsMax = -1;
    protected EDataType itemType;
    protected List<EDataType> memberTypes;

    public DynamicEDataTypeValidator(EDataType eDataType)
    {
      ExtendedMetaData extendedMetaData = ExtendedMetaData.INSTANCE;
      Resource resource = eDataType.eResource();
      if (resource != null)
      {
        ResourceSet resourceSet = resource.getResourceSet();
        if (resourceSet != null)
        {
          extendedMetaData = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
        }
      }

      List<PatternMatcher[]> patterns = null;

      for (;;)
      {
        if (effectiveEnumeration == null)
        {
          List<String> enumeration = extendedMetaData.getEnumerationFacet(eDataType);
          if (!enumeration.isEmpty())
          {
            effectiveEnumeration = new ArrayList<Object>();
            for (String enumerator : enumeration)
            {
              effectiveEnumeration.add(EcoreUtil.createFromString(eDataType, enumerator));
            }
          }
        }

        List<String> pattern = extendedMetaData.getPatternFacet(eDataType);
        if (!pattern.isEmpty())
        {
          if (patterns == null)
          {
            patterns = new ArrayList<PatternMatcher[]>();
          }
          PatternMatcher [] children = new PatternMatcher [pattern.size()];
          patterns.add(children);
          for (ListIterator<String> i = pattern.listIterator(); i.hasNext(); )
          {
            PatternMatcher patternMatcher = XMLTypeUtil.createPatternMatcher(i.next());
            children[i.previousIndex()] = patternMatcher;
          }
        }

        if (effectiveTotalDigits == -1)
        {
          effectiveTotalDigits = extendedMetaData.getTotalDigitsFacet(eDataType);
        }
        if (effectiveFractionDigits == -1)
        {
          effectiveFractionDigits = extendedMetaData.getFractionDigitsFacet(eDataType);
        }
        if (effectiveMinLength == -1)
        {
          effectiveMinLength = extendedMetaData.getLengthFacet(eDataType);
          if (effectiveMinLength == -1)
          {
            effectiveMinLength = extendedMetaData.getMinLengthFacet(eDataType);
          }
        }
        if (effectiveMaxLength == -1)
        {
          effectiveMaxLength = extendedMetaData.getLengthFacet(eDataType);
          if (effectiveMaxLength == -1)
          {
            effectiveMaxLength = extendedMetaData.getMaxLengthFacet(eDataType);
          }
        }
        if (effectiveMin == null)
        {
          effectiveMin = extendedMetaData.getMinExclusiveFacet(eDataType);
          if (effectiveMin == null)
          {
            effectiveMin = extendedMetaData.getMinInclusiveFacet(eDataType);
            if (effectiveMin != null)
            {
              effectiveMin = EcoreUtil.createFromString(eDataType, (String)effectiveMin);
              effectiveMinIsInclusive = true;
            }
          }
          else
          {
            effectiveMin = EcoreUtil.createFromString(eDataType, (String)effectiveMin);
            effectiveMinIsInclusive = false;
          }
        }
        if (effectiveMax == null)
        {
          effectiveMax = extendedMetaData.getMaxExclusiveFacet(eDataType);
          if (effectiveMax == null)
          {
            effectiveMax = extendedMetaData.getMaxInclusiveFacet(eDataType);
            if (effectiveMax != null)
            {
              effectiveMax = EcoreUtil.createFromString(eDataType, (String)effectiveMax);
              effectiveMaxIsInclusive = true;
            }
          }
          else
          {
            effectiveMax = EcoreUtil.createFromString(eDataType, (String)effectiveMax);
            effectiveMaxIsInclusive = false;
          }
        }

        EDataType baseType = extendedMetaData.getBaseType(eDataType);
        if (baseType != null)
        {
          eDataType = baseType;
          continue;
        }
        else
        {
          itemType = extendedMetaData.getItemType(eDataType);
          memberTypes = extendedMetaData.getMemberTypes(eDataType);
          break;
        }
      }

      if (patterns != null)
      {
        effectivePattern = new PatternMatcher [patterns.size()][];
        patterns.toArray(effectivePattern);
      }

      if (effectiveTotalDigits != -1 && eDataType.getInstanceClassName() != "java.math.BigDecimal")
      {
        StringBuffer digits = new StringBuffer("1");
        for (int i = effectiveTotalDigits; i > 0; --i)
        {
          digits.append("0");
        }
        Object upperBound = EcoreUtil.createFromString(eDataType, digits.toString());
        Object lowerBound = EcoreUtil.createFromString(eDataType, "-" + digits.toString());

        @SuppressWarnings("unchecked") boolean lowerBounded = effectiveMin == null ||
              (effectiveMinIsInclusive ?
                 ((Comparable<Object>)effectiveMin).compareTo(lowerBound) <= 0:
                 ((Comparable<Object>)effectiveMin).compareTo(lowerBound) < 0);
        if (lowerBounded)
        {
          effectiveMinIsInclusive = false;
          effectiveMin = lowerBound;
          effectiveTotalDigitsMin = effectiveTotalDigits;
        }

        @SuppressWarnings("unchecked") boolean upperBounded = effectiveMax == null ||
              (effectiveMaxIsInclusive ?
                 ((Comparable<Object>)effectiveMax).compareTo(upperBound) >= 0:
                 ((Comparable<Object>)effectiveMax).compareTo(upperBound) > 0);
        if (upperBounded)
        {
          effectiveMaxIsInclusive = false;
          effectiveMax = upperBound;
          effectiveTotalDigitsMax = effectiveTotalDigits;
        }
        effectiveTotalDigits = -1;
      }

      if (effectiveFractionDigits != -1 && eDataType.getInstanceClassName() != "java.math.BigDecimal")
      {
        effectiveFractionDigits = -1;
      }
    }

    public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
      boolean result = true;
      if (effectiveEnumeration != null)
      {
        if (!effectiveEnumeration.contains(value))
        {
          if (diagnostics != null) reportEnumerationViolation(eDataType, value, effectiveEnumeration, diagnostics, context);
          result = false;
        }
      }

      if (effectivePattern != null)
      {
        result = validatePattern(eDataType, value, effectivePattern, diagnostics, context);
      }

      if (effectiveMin != null)
      {
        @SuppressWarnings("unchecked") Comparable<Object> comparableObject = (Comparable<Object>)effectiveMin;
        if (effectiveMinIsInclusive ?
              comparableObject.compareTo(value) > 0:
              comparableObject.compareTo(value) >= 0)
        {
          if (diagnostics != null)
          {
            if (effectiveTotalDigitsMin != -1)
            {
              reportTotalDigitsViolation(eDataType, value, effectiveTotalDigitsMin, diagnostics, context);
            }
            else
            {
              reportMinViolation(eDataType, value, effectiveMin, effectiveMinIsInclusive, diagnostics, context);
            }
          }
          result = false;
        }
      }

      if (effectiveMax != null)
      {
        @SuppressWarnings("unchecked") Comparable<Object> comparableObject = (Comparable<Object>)effectiveMax;
        if (effectiveMaxIsInclusive ?
              comparableObject.compareTo(value) < 0:
              comparableObject.compareTo(value) <= 0)
        {
          if (diagnostics != null)
          {
            if (effectiveTotalDigitsMax != -1)
            {
              reportTotalDigitsViolation(eDataType, value, effectiveTotalDigitsMax, diagnostics, context);
            }
            else
            {
              reportMaxViolation(eDataType, value, effectiveMax, effectiveMaxIsInclusive, diagnostics, context);
            }
          }
          result = false;
        }
      }

      if (effectiveMinLength != -1)
      {
        int length =
          value instanceof String ?
            ((String)value).length() :
             value instanceof Object[] ?
               ((Object[])value).length :
               ((Collection<?>)value).size();
        if (length < effectiveMinLength)
        {
          if (diagnostics != null) reportMinLengthViolation(eDataType, value, length, effectiveMinLength, diagnostics, context);
          result = false;
        }
      }

      if (effectiveMaxLength != -1)
      {
        int length =
          value instanceof String ?
            ((String)value).length() :
             value instanceof Object[] ?
               ((Object[])value).length :
               ((Collection<?>)value).size();
        if (length > effectiveMaxLength)
        {
          if (diagnostics != null) reportMaxLengthViolation(eDataType, value, length, effectiveMaxLength, diagnostics, context);
          result = false;
        }
      }

      if (effectiveTotalDigits != -1)
      {
        if (value instanceof BigDecimal && ((BigDecimal)value).unscaledValue().abs().toString().length() > effectiveTotalDigits)
        {
          if (diagnostics != null) reportTotalDigitsViolation(eDataType, value, effectiveTotalDigits, diagnostics, context);
          result = false;
        }
      }

      if (effectiveFractionDigits != -1)
      {
        if (value instanceof BigDecimal && ((BigDecimal)value).scale() > effectiveFractionDigits)
        {
          if (diagnostics != null) reportFractionDigitsViolation(eDataType, value, effectiveFractionDigits, diagnostics, context);
          result = false;
        }
      }

      if (itemType != null)
      {
        EValidator rootValidator = getRootEValidator(context);
        for (Iterator<?> i = ((List<?>)value).iterator(); i.hasNext() && (result || diagnostics != null); )
        {
          result &= rootValidator.validate(itemType, i.next(), diagnostics, context);
        }
        return result;
      }
      else if (!memberTypes.isEmpty())
      {
        EValidator rootValidator = getRootEValidator(context);
        
        for (EDataType memberType : memberTypes)
        {
          if (rootValidator.validate(memberType, value, null, context))
          {
            return true;
          }
        }
        for (EDataType memberType : memberTypes)
        {
          if (memberType.isInstance(value))
          {
            return rootValidator.validate(memberType, value, diagnostics, context);
          }
        }
        return false;
      }
      else
      {
        return result;
      }
    }
  }

  public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    if (!eDataType.isInstance(value))
    {
      if (value == null)
      {
        return true;
      }
      else
      {
        if (diagnostics != null) reportDataValueTypeViolation(eDataType, value, diagnostics, context);
        return false;
      }
    }

    if (eDataType.eContainer() == getEPackage())
    {
      return validate(eDataType.getClassifierID(), value, diagnostics, context);
    }
    else
    {
      return
        new DynamicEDataTypeValidator(eDataType)
        {
          // Ensure that the class loader for this class will be used downstream.
          //
        }.validate(eDataType, value, diagnostics, context);
    }
  }

  protected void reportMinViolation
    (EDataType eDataType, Object value, Object bound, boolean isInclusive, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__VALUE_IN_RANGE,
         getEcoreResourceLocator().getString
           (isInclusive ? "_UI_MinInclusiveConstraint_diagnostic" : "_UI_MinExclusiveConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                isInclusive ? ">=" : ">",
                getValueLabel(eDataType, bound, context)
              }),
         new Object [] { value, bound, isInclusive ? Boolean.TRUE : Boolean.FALSE }));
  }

  protected void reportMaxViolation
    (EDataType eDataType, Object value, Object bound, boolean isInclusive, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__VALUE_IN_RANGE,
         getEcoreResourceLocator().getString
           (isInclusive ? "_UI_MaxInclusiveConstraint_diagnostic" : "_UI_MaxExclusiveConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                "<",
                getValueLabel(eDataType, bound, context)
              }),
         new Object [] { value, bound, isInclusive ? Boolean.TRUE : Boolean.FALSE }));
  }

  protected void reportMinLengthViolation
    (EDataType eDataType, Object value, int length, int bound, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__LENGTH_IN_RANGE,
         getEcoreResourceLocator().getString
           ("_UI_MinLengthConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                Integer.toString(length),
                Integer.toString(bound)
              }),
         new Object [] { value, eDataType, new Integer(length), new Integer(bound) }));
  }

  protected void reportMaxLengthViolation
    (EDataType eDataType, Object value, int length, int bound, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__LENGTH_IN_RANGE,
         getEcoreResourceLocator().getString
           ("_UI_MaxLengthConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                Integer.toString(length),
                Integer.toString(bound)
              }),
         new Object [] { value, eDataType, new Integer(length), new Integer(bound) }));
  }

  protected void reportTotalDigitsViolation
    (EDataType eDataType, Object value, int totalDigits, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__TOTAL_DIGITS_IN_RANGE,
         getEcoreResourceLocator().getString
           ("_UI_TotalDigitsConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                new Integer(totalDigits)
              }),
         new Object [] { value, eDataType, new Integer(totalDigits) }));
  }

  protected void reportFractionDigitsViolation
    (EDataType eDataType, Object value, int fractionDigits, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__TOTAL_DIGITS_IN_RANGE,
         getEcoreResourceLocator().getString
           ("_UI_FractionDigitsConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                new Integer(fractionDigits)
              }),
         new Object [] { value, eDataType, new Integer(fractionDigits) }));
  }

  protected void reportEnumerationViolation
    (EDataType eDataType, Object value, Collection<?> values, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    String valueLiterals = "";
    Iterator<?> i = values.iterator();
    if (i.hasNext())
    {
      valueLiterals =
        getEcoreResourceLocator().getString("_UI_ListHead_composition", new Object [] { getValueLabel(eDataType, i.next(), context) });
      while (i.hasNext())
      {
        valueLiterals =
          getEcoreResourceLocator().getString
            ("_UI_ListTail_composition",
             new Object [] { valueLiterals, getValueLabel(eDataType, i.next(), context) });
      }
    }
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__VALUE_IN_ENUMERATION,
         getEcoreResourceLocator().getString
           ("_UI_EnumerationConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                valueLiterals
              }),
         new Object [] { value, eDataType, values }));
  }

  protected void reportDataValuePatternViolation
    (EDataType eDataType, Object value, PatternMatcher [] patterns, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    String patternLiterals = "";
    if (patterns.length > 0)
    {
      patternLiterals = getEcoreResourceLocator().getString("_UI_ListHead_composition", new Object [] { patterns[0] });
      for (int i = 1; i < patterns.length; ++i)
      {
        patternLiterals = getEcoreResourceLocator().getString("_UI_ListTail_composition", new Object [] { patternLiterals, patterns[i] });
      }
    }

    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__MATCHES_PATTERN,
         getEcoreResourceLocator().getString
           ("_UI_PatternConstraint_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                patternLiterals
              }),
         new Object [] { value, eDataType, patterns }));
  }

  protected void reportDataValueTypeViolation
    (EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    diagnostics.add
      (new BasicDiagnostic
        (Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         DATA_VALUE__TYPE_CORRECT,
         getEcoreResourceLocator().getString
           ("_UI_BadDataValueType_diagnostic",
            new Object []
              {
                getValueLabel(eDataType, value, context),
                value == null ? "<null>" : value.getClass().getName(),
                eDataType.getInstanceClass().getName()
              }),
         new Object [] { value, eDataType }));
  }

  protected static Collection<Object> wrapEnumerationValues(Object [] values)
  {
    return java.util.Arrays.asList(values);
  }
  
  /**
   * @since 2.2
   */
  public boolean validate_UniqueID(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    String id = EcoreUtil.getID(eObject);
    if (id != null)
    {
      Resource resource = eObject.eResource();
      if (resource != null)
      {
        EObject otherEObject = resource.getEObject(id);
        if (eObject != otherEObject && otherEObject != null)
        {
          // ...
          diagnostics.add
            (new BasicDiagnostic
              (Diagnostic.ERROR,
               DIAGNOSTIC_SOURCE,
               EOBJECT__UNIQUE_ID,
               getEcoreResourceLocator().getString
                 ("_UI_DuplicateID_diagnostic",
                  new Object []
                    {
                      id,
                      getObjectLabel(eObject, context),
                      getObjectLabel(otherEObject, context)
                    }),
               new Object [] { eObject, otherEObject, id }));
        }
      }
    }
    return result;
  }

  /**
   * @since 2.3
   * @param eObject
   * @param diagnostics
   * @param context
   * @return whether every key is unique.
   */
  public boolean validate_EveryKeyUnique(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    EClass eClass = eObject.eClass();
    for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (eStructuralFeature instanceof EReference)
      {
        EReference eReference = (EReference)eStructuralFeature;
        if (eReference.isMany() && !eReference.getEKeys().isEmpty())
        {
          result &= validate_KeyUnique(eObject, eReference, diagnostics, context);
          if (!result && diagnostics == null)
          {
            return false;
          }
        }
      }
    }
    return result;
  }
  
  /**
   * @since 2.3
   * @param eObject
   * @param eReference
   * @param diagnostics
   * @param context
   * @return whether every key is unique.
   */
  protected boolean validate_KeyUnique
    (EObject eObject, EReference eReference, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    Map<List<Object>, EObject> keys = new HashMap<List<Object>, EObject>();
    EAttribute [] eAttributes = (EAttribute[])((BasicEList<?>)eReference.getEKeys()).data();
    @SuppressWarnings("unchecked")
    List<EObject> values = (List<EObject>)eObject.eGet(eReference);
    for (EObject value : values)
    {
      ArrayList<Object> key = new ArrayList<Object>(); 
      for (int i = 0, size = eAttributes.length; i < size; ++i)
      {
        EAttribute eAttribute = eAttributes[i];
        if (eAttribute == null)
        {
          break;
        }
        else 
        {
          key.add(value.eGet(eAttribute));
        }
      }
      EObject otherValue = keys.put(key, value);
      if (otherValue != null)
      {
        result = false;
        if (diagnostics == null)
        {
          break;
        }
        else
        {
          String uriFragmentSegment = ((InternalEObject)eObject).eURIFragmentSegment(eReference, value);
          int index = uriFragmentSegment.indexOf('[', 0);
          if (index != -1)
          {
            uriFragmentSegment = uriFragmentSegment.substring(index);
          }
          diagnostics.add
            (new BasicDiagnostic
              (Diagnostic.ERROR,
               DIAGNOSTIC_SOURCE,
               EOBJECT__EVERY_KEY_UNIQUE,
               getEcoreResourceLocator().getString
                 ("_UI_DuplicateKey_diagnostic",
                  new Object []
                    {
                      getFeatureLabel(eReference, context),
                      uriFragmentSegment,
                      getObjectLabel(value, context),
                      getObjectLabel(otherValue, context)
                    }),
               new Object [] { eObject, eReference, value, otherValue }));
        }
      }
    }

    return result;
  }

  /**
   * @since 2.3
   * @param eObject
   * @param diagnostics
   * @param context
   * @return whether every map entry is unique.
   */
  public boolean validate_EveryMapEntryUnique(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    EClass eClass = eObject.eClass();
    for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (eStructuralFeature.getEType().getInstanceClassName() == "java.util.Map$Entry" && eStructuralFeature instanceof EReference)
      {
        EReference eReference = (EReference)eStructuralFeature;
        result &= validate_MapEntryUnique(eObject, eReference, diagnostics, context);
        if (!result && diagnostics == null)
        {
          return false;
        }
      }
    }
    return result;
  }

  /**
   * @since 2.3
   * @param eObject
   * @param eReference
   * @param diagnostics
   * @param context
   * @return whether every map entry is unique.
   */
  protected boolean validate_MapEntryUnique
    (EObject eObject, EReference eReference, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    Object value = eObject.eGet(eReference);
    if (value instanceof EMap)
    {
      EMap<?, ?> eMap = (EMap<?, ?>)value;
      for (int i = 0, size = eMap.size(); i < size; ++i)
      {
        Map.Entry<?, ?> entry = eMap.get(i);
        Object key = entry.getKey();
        int index =  eMap.indexOfKey(key);
        if (index != i)
        {
          result = false;
          if (diagnostics == null)
          {
            break;
          }
          else
          {
            diagnostics.add
              (new BasicDiagnostic
                (Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 EOBJECT__EVERY_MAP_ENTRY_UNIQUE,
                 getEcoreResourceLocator().getString
                   ("_UI_DuplicateMapEntry_diagnostic",
                    new Object []
                      {
                        getFeatureLabel(eReference, context),
                        i,
                        index
                      }),
                 new Object [] { eObject, eReference, entry, eMap.get(index) }));
          }
        }
      }
    }

    return result;
  }

  /**
   * @since 2.2
   */
  protected ResourceLocator getEcoreResourceLocator()
  {
    return EcorePlugin.INSTANCE;
  }
}
