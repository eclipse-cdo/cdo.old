/**
 * <copyright>
 *
 * Copyright (c) 2006-2007 IBM Corporation and others.
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

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!--
 * end-user-doc -->
 * 
 * @see org.eclipse.emf.ecore.EcorePackage
 * @generated
 */
public class EcoreValidator extends EObjectValidator
{
  /**
   * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static final EcoreValidator INSTANCE = new EcoreValidator();

  /**
   * A constant for the
   * {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
   * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes}
   * from this package. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated NOT
   */
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.emf.ecore.model";

  /**
   * A constant with a fixed name that can be used as the base value for
   * additional hand written constants. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * @see #validateEClass_AtMostOneID(EClass, DiagnosticChain, Map)
   */
  public static final int AT_MOST_ONE_ID = GENERATED_DIAGNOSTIC_CODE_COUNT + 1;

  /**
   * @see #validateEGenericType_ConsistentArguments(EGenericType,
   *      DiagnosticChain, Map)
   */
  public static final int CONSISTENT_ARGUMENTS_INCORRECT_NUMBER = 2;

  /**
   * @see #validateEGenericType_ConsistentArguments(EGenericType,
   *      DiagnosticChain, Map)
   */
  public static final int CONSISTENT_ARGUMENTS_INVALID_SUBSTITUTION = 3;

  /**
   * @see #validateEGenericType_ConsistentArguments(EGenericType,
   *      DiagnosticChain, Map)
   */
  public static final int CONSISTENT_ARGUMENTS_NONE = 4;

  /**
   * @see #validateEGenericType_ConsistentArguments(EGenericType,
   *      DiagnosticChain, Map)
   */
  public static final int CONSISTENT_ARGUMENTS_NONE_ALLOWED = 5;

  /**
   * @see #validateETypedElement_ConsistentBounds(ETypedElement,
   *      DiagnosticChain, Map)
   */
  public static final int CONSISTENT_BOUNDS = 6;

  /**
   * @see #validateEGenericType_ConsistentBounds(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_BOUNDS_NOT_ALLOWED = 7;

  /**
   * @see #validateEGenericType_ConsistentBounds(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_BOUNDS_NO_BOUNDS_WITH_TYPE_PARAMETER_OR_CLASSIFIER = 8;

  /**
   * @see #validateEGenericType_ConsistentBounds(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_BOUNDS_NO_LOWER_AND_UPPER = 9;

  /**
   * @see #validateEReference_ConsistentKeys(EReference, DiagnosticChain, Map)
   */
  public static final int CONSISTENT_KEYS = 10;

  /**
   * @see #validateEReference_ConsistentOpposite(EReference, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_OPPOSITE_BAD_TRANSIENT = 11;

  /**
   * @see #validateEReference_ConsistentOpposite(EReference, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_OPPOSITE_BOTH_CONTAINMENT = 12;

  /**
   * @see #validateEReference_ConsistentOpposite(EReference, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_OPPOSITE_NOT_FROM_TYPE = 13;

  /**
   * @see #validateEReference_ConsistentOpposite(EReference, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_OPPOSITE_NOT_MATCHING = 14;

  /**
   * @see #validateEClass_ConsistentSuperTypes(EClass, DiagnosticChain, Map)
   */
  public static final int CONSISTENT_SUPER_TYPES_CONFLICT = 15;

  /**
   * @see #validateEClass_ConsistentSuperTypes(EClass, DiagnosticChain, Map)
   */
  public static final int CONSISTENT_SUPER_TYPES_DUPLICATE = 16;

  /**
   * @see #validateEAttribute_ConsistentTransient(EAttribute, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TRANSIENT = 17;

  /**
   * @see #validateEGenericType_ConsistentType(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TYPE_CLASS_REQUIRED = 18;

  /**
   * @see #validateEGenericType_ConsistentType(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TYPE_CLASS_NOT_PERMITTED = 19;

  /**
   * @see #validateEGenericType_ConsistentType(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TYPE_DATA_TYPE_NOT_PERMITTED = 20;

  /**
   * @see #validateEGenericType_ConsistentType(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TYPE_NO_TYPE_PARAMETER_AND_CLASSIFIER = 21;

  /**
   * @see #validateEGenericType_ConsistentType(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TYPE_PRIMITIVE_TYPE_NOT_PERMITTED = 22;

  /**
   * @see #validateEGenericType_ConsistentType(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TYPE_TYPE_PARAMETER_NOT_IN_SCOPE = 23;

  /**
   * @see #validateEGenericType_ConsistentType(EGenericType, DiagnosticChain,
   *      Map)
   */
  public static final int CONSISTENT_TYPE_WILDCARD_NOT_PERMITTED = 24;

  /**
   * @see #validateEClass_InterfaceIsAbstract(EClass, DiagnosticChain, Map)
   */
  public static final int INTERFACE_IS_ABSTRACT = 25;

  /**
   * @see #validateEClass_NoCircularSuperTypes(EClass, DiagnosticChain, Map)
   */
  public static final int NO_CIRCULAR_SUPER_TYPES = 26;

  /**
   * @see #validateEOperation_NoRepeatingVoid(EOperation, DiagnosticChain, Map)
   */
  public static final int NO_REPEATING_VOID = 27;

  /**
   * @see #validateEReference_SingleContainer(EReference, DiagnosticChain, Map)
   */
  public static final int SINGLE_CONTAINER = 28;

  /**
   * @see #validateEPackage_UniqueClassifierNames(EPackage, DiagnosticChain,
   *      Map)
   */
  public static final int UNIQUE_CLASSIFIER_NAMES = 29;

  /**
   * @see #validateEEnum_UniqueEnumeratorNames(EEnum, DiagnosticChain, Map)
   */
  public static final int UNIQUE_ENUMERATOR_LITERALS = 30;

  /**
   * @see #validateEEnum_UniqueEnumeratorNames(EEnum, DiagnosticChain, Map)
   */
  public static final int UNIQUE_ENUMERATOR_NAMES = 31;

  /**
   * @see #validateEClass_UniqueFeatureNames(EClass, DiagnosticChain, Map)
   */
  public static final int UNIQUE_FEATURE_NAMES = 32;

  /**
   * @see #validateEPackage_UniqueNsURIs(EPackage, DiagnosticChain, Map)
   */
  public static final int UNIQUE_NS_URIS = 33;

  /**
   * @see #validateEClass_UniqueOperationSignatures(EClass, DiagnosticChain,
   *      Map)
   */
  public static final int UNIQUE_OPERATION_SIGNATURES = 34;

  /**
   * @see #validateEOperation_UniqueParameterNames(EOperation, DiagnosticChain,
   *      Map)
   */
  public static final int UNIQUE_PARAMETER_NAMES = 35;

  /**
   * @see #validateEPackage_UniqueSubpackageNames(EPackage, DiagnosticChain,
   *      Map)
   */
  public static final int UNIQUE_SUBPACKAGE_NAMES = 36;

  /**
   * @see #validateEOperation_UniqueParameterNames(EOperation, DiagnosticChain,
   *      Map)
   * @see #validateEClassifier_UniqueTypeParameterNames(EClassifier,
   *      DiagnosticChain, Map)
   */
  public static final int UNIQUE_TYPE_PARAMETER_NAMES = 37;

  /**
   * @see #validateEStructuralFeature_ValidDefaultValueLiteral(EStructuralFeature,
   *      DiagnosticChain, Map)
   */
  public static final int VALID_DEFAULT_VALUE_LITERAL = 38;

  /**
   * @see #validateETypedElement_ValidLowerBound(ETypedElement, DiagnosticChain,
   *      Map)
   */
  public static final int VALID_LOWER_BOUND = 39;

  /**
   * @see #validateETypedElement_ValidType(ETypedElement, DiagnosticChain, Map)
   */
  public static final int VALID_TYPE = 40;

  /**
   * @see #validateETypedElement_ValidUpperBound(ETypedElement, DiagnosticChain,
   *      Map)
   */
  public static final int VALID_UPPER_BOUND = 41;

  /**
   * @see #validateEClassifier_WellFormedInstanceTypeName(EClassifier,
   *      DiagnosticChain, Map)
   */
  public static final int WELL_FORMED_INSTANCE_TYPE_NAME = 42;

  /**
   * @see #validateEClass_WellFormedMapEntryClass(EClass, DiagnosticChain, Map)
   */
  public static final int WELL_FORMED_MAP_ENTRY_CLASS = 43;

  /**
   * @see #validateEClass_WellFormedMapEntryClass(EClass, DiagnosticChain, Map)
   */
  public static final int WELL_FORMED_NAME = 44;

  /**
   * @see #validateEPackage_WellFormedNsPrefix(EPackage, DiagnosticChain, Map)
   */
  public static final int WELL_FORMED_NS_PREFIX = 45;

  /**
   * @see #validateEPackage_WellFormedNsURI(EPackage, DiagnosticChain, Map)
   */
  public static final int WELL_FORMED_NS_URI = 46;

  /**
   * @see #validateEAnnotation_WellFormedSourceURI(EAnnotation, DiagnosticChain,
   *      Map)
   */
  public static final int WELL_FORMED_SOURCE_URI = 47;

  /**
   * A constant with a fixed name that can be used as the base value for
   * additional hand written constants in a derived class. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = WELL_FORMED_SOURCE_URI;

  /**
   * The cached base package validator. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  protected XMLTypeValidator xmlTypeValidator;

  /**
   * Creates an instance of the switch. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  public EcoreValidator()
  {
    super();
    xmlTypeValidator = XMLTypeValidator.INSTANCE;
  }

  /**
   * Returns the package of this validator switch. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EPackage getEPackage()
  {
    return EcorePackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the
   * model. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    switch (classifierID)
    {
    case EcorePackage.EATTRIBUTE:
      return validateEAttribute((EAttribute)value, diagnostics, context);
    case EcorePackage.EANNOTATION:
      return validateEAnnotation((EAnnotation)value, diagnostics, context);
    case EcorePackage.ECLASS:
      return validateEClass((EClass)value, diagnostics, context);
    case EcorePackage.ECLASSIFIER:
      return validateEClassifier((EClassifier)value, diagnostics, context);
    case EcorePackage.EDATA_TYPE:
      return validateEDataType((EDataType)value, diagnostics, context);
    case EcorePackage.EENUM:
      return validateEEnum((EEnum)value, diagnostics, context);
    case EcorePackage.EENUM_LITERAL:
      return validateEEnumLiteral((EEnumLiteral)value, diagnostics, context);
    case EcorePackage.EFACTORY:
      return validateEFactory((EFactory)value, diagnostics, context);
    case EcorePackage.EMODEL_ELEMENT:
      return validateEModelElement((EModelElement)value, diagnostics, context);
    case EcorePackage.ENAMED_ELEMENT:
      return validateENamedElement((ENamedElement)value, diagnostics, context);
    case EcorePackage.EOBJECT:
      return validateEObject((EObject)value, diagnostics, context);
    case EcorePackage.EOPERATION:
      return validateEOperation((EOperation)value, diagnostics, context);
    case EcorePackage.EPACKAGE:
      return validateEPackage((EPackage)value, diagnostics, context);
    case EcorePackage.EPARAMETER:
      return validateEParameter((EParameter)value, diagnostics, context);
    case EcorePackage.EREFERENCE:
      return validateEReference((EReference)value, diagnostics, context);
    case EcorePackage.ESTRUCTURAL_FEATURE:
      return validateEStructuralFeature((EStructuralFeature)value, diagnostics, context);
    case EcorePackage.ETYPED_ELEMENT:
      return validateETypedElement((ETypedElement)value, diagnostics, context);
    case EcorePackage.ESTRING_TO_STRING_MAP_ENTRY:
      return validateEStringToStringMapEntry((Map.Entry<?, ?>)value, diagnostics, context);
    case EcorePackage.EGENERIC_TYPE:
      return validateEGenericType((EGenericType)value, diagnostics, context);
    case EcorePackage.ETYPE_PARAMETER:
      return validateETypeParameter((ETypeParameter)value, diagnostics, context);
    case EcorePackage.EBIG_DECIMAL:
      return validateEBigDecimal((BigDecimal)value, diagnostics, context);
    case EcorePackage.EBIG_INTEGER:
      return validateEBigInteger((BigInteger)value, diagnostics, context);
    case EcorePackage.EBOOLEAN:
      return validateEBoolean(((Boolean)value).booleanValue(), diagnostics, context);
    case EcorePackage.EBOOLEAN_OBJECT:
      return validateEBooleanObject((Boolean)value, diagnostics, context);
    case EcorePackage.EBYTE:
      return validateEByte(((Byte)value).byteValue(), diagnostics, context);
    case EcorePackage.EBYTE_ARRAY:
      return validateEByteArray((byte[])value, diagnostics, context);
    case EcorePackage.EBYTE_OBJECT:
      return validateEByteObject((Byte)value, diagnostics, context);
    case EcorePackage.ECHAR:
      return validateEChar(((Character)value).charValue(), diagnostics, context);
    case EcorePackage.ECHARACTER_OBJECT:
      return validateECharacterObject((Character)value, diagnostics, context);
    case EcorePackage.EDATE:
      return validateEDate((Date)value, diagnostics, context);
    case EcorePackage.EDIAGNOSTIC_CHAIN:
      return validateEDiagnosticChain((DiagnosticChain)value, diagnostics, context);
    case EcorePackage.EDOUBLE:
      return validateEDouble(((Double)value).doubleValue(), diagnostics, context);
    case EcorePackage.EDOUBLE_OBJECT:
      return validateEDoubleObject((Double)value, diagnostics, context);
    case EcorePackage.EE_LIST:
      return validateEEList((EList<?>)value, diagnostics, context);
    case EcorePackage.EENUMERATOR:
      return validateEEnumerator((Enumerator)value, diagnostics, context);
    case EcorePackage.EFEATURE_MAP:
      return validateEFeatureMap((FeatureMap)value, diagnostics, context);
    case EcorePackage.EFEATURE_MAP_ENTRY:
      return validateEFeatureMapEntry((FeatureMap.Entry)value, diagnostics, context);
    case EcorePackage.EFLOAT:
      return validateEFloat(((Float)value).floatValue(), diagnostics, context);
    case EcorePackage.EFLOAT_OBJECT:
      return validateEFloatObject((Float)value, diagnostics, context);
    case EcorePackage.EINT:
      return validateEInt(((Integer)value).intValue(), diagnostics, context);
    case EcorePackage.EINTEGER_OBJECT:
      return validateEIntegerObject((Integer)value, diagnostics, context);
    case EcorePackage.EJAVA_CLASS:
      return validateEJavaClass((Class<?>)value, diagnostics, context);
    case EcorePackage.EJAVA_OBJECT:
      return validateEJavaObject(value, diagnostics, context);
    case EcorePackage.ELONG:
      return validateELong(((Long)value).longValue(), diagnostics, context);
    case EcorePackage.ELONG_OBJECT:
      return validateELongObject((Long)value, diagnostics, context);
    case EcorePackage.EMAP:
      return validateEMap((Map<?, ?>)value, diagnostics, context);
    case EcorePackage.ERESOURCE:
      return validateEResource((Resource)value, diagnostics, context);
    case EcorePackage.ERESOURCE_SET:
      return validateEResourceSet((ResourceSet)value, diagnostics, context);
    case EcorePackage.ESHORT:
      return validateEShort(((Short)value).shortValue(), diagnostics, context);
    case EcorePackage.ESHORT_OBJECT:
      return validateEShortObject((Short)value, diagnostics, context);
    case EcorePackage.ESTRING:
      return validateEString((String)value, diagnostics, context);
    case EcorePackage.ETREE_ITERATOR:
      return validateETreeIterator((TreeIterator<?>)value, diagnostics, context);
    default:
      return true;
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEAttribute(EAttribute eAttribute, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eAttribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eAttribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eAttribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eAttribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eAttribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eAttribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eAttribute, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eAttribute, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidLowerBound(eAttribute, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidUpperBound(eAttribute, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ConsistentBounds(eAttribute, diagnostics, context);
    if (result || diagnostics != null) result &= validateETypedElement_ValidType(eAttribute, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEStructuralFeature_ValidDefaultValueLiteral(eAttribute, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEAttribute_ConsistentTransient(eAttribute, diagnostics, context);
    return result;
  }

  /**
   * Validates the ConsistentTransient constraint of '<em>EAttribute</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEAttribute_ConsistentTransient(EAttribute eAttribute, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    EDataType eAttributeType = eAttribute.getEAttributeType();
    boolean result = isEffectivelyTransient(eAttribute) || eAttributeType == null || eAttributeType.isSerializable()
        || FeatureMapUtil.isFeatureMapEntry(eAttributeType);
    if (!result && diagnostics != null)
    {
      String attributeName = eAttribute.getName();
      if (eAttribute.getEContainingClass() != null)
      {
        attributeName = eAttribute.getEContainingClass().getName() + "." + attributeName;
      }
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_TRANSIENT,
          EcorePlugin.INSTANCE
              .getString("_UI_EAttributeConsistentTransient_diagnostic", new String[] { attributeName }),
          new Object[] { eAttribute }));
    }
    return result;
  }

  private static boolean isEffectivelyTransient(EStructuralFeature eStructuralFeature)
  {
    if (eStructuralFeature.isTransient())
    {
      EStructuralFeature group = ExtendedMetaData.INSTANCE.getGroup(eStructuralFeature);
      return group == null || isEffectivelyTransient(group);
    }
    else
    {
      return false;
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEAnnotation(EAnnotation eAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eAnnotation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eAnnotation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eAnnotation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eAnnotation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eAnnotation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eAnnotation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eAnnotation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEAnnotation_WellFormedSourceURI(eAnnotation, diagnostics, context);
    return result;
  }

  /**
   * Validates the WellFormedSourceURI constraint of '<em>EAnnotation</em>'.
   * <!-- begin-user-doc --> The source URI must either be either
   * <code>null</code> or {@link #isWellFormedURI(String) well formed}. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEAnnotation_WellFormedSourceURI(EAnnotation eAnnotation, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    String source = eAnnotation.getSource();
    boolean result = source == null || isWellFormedURI(source);
    if (!result && diagnostics != null)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_SOURCE_URI,
          EcorePlugin.INSTANCE.getString("_UI_EAnnotationSourceURINotWellFormed_diagnostic", new Object[] { source }),
          new Object[] { eAnnotation }));
    }
    return result;
  }

  /**
   * A well formed URI string must have a non-zero length, and must encode any
   * special characters such as the space character. As such, creating a
   * {@link URI#createURI(String, boolean) URI}, ignoring the properly encoded
   * characters, and converting that to a {@link URI#toString() string}, must
   * yield this URI string itself.
   * 
   * @param uri
   *          the URI string in question.
   * @return whether the URI is well formed.
   */
  protected static boolean isWellFormedURI(String uri)
  {
    try
    {
      return uri != null && uri.length() != 0 && uri.equals(URI.createURI(uri, true).toString());
    }
    catch (Throwable exception)
    {
      return false;
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEClass(EClass eClass, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateENamedElement_WellFormedName(eClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_WellFormedInstanceTypeName(eClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_UniqueTypeParameterNames(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateEClass_InterfaceIsAbstract(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateEClass_AtMostOneID(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateEClass_UniqueFeatureNames(eClass, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClass_UniqueOperationSignatures(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateEClass_NoCircularSuperTypes(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateEClass_WellFormedMapEntryClass(eClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateEClass_ConsistentSuperTypes(eClass, diagnostics, context);
    return result;
  }

  /**
   * Validates the InterfaceIsAbstract constraint of '<em>EClass</em>'. <!--
   * begin-user-doc --> A class that is an interface must be abstract. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClass_InterfaceIsAbstract(EClass eClass, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = !eClass.isInterface() || eClass.isAbstract();
    if (!result && diagnostics != null)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, INTERFACE_IS_ABSTRACT,
          EcorePlugin.INSTANCE.getString("_UI_EClassInterfaceNotAbstract_diagnostic"), new Object[] { eClass }));
    }
    return result;
  }

  /**
   * Validates the AtMostOneID constraint of '<em>EClass</em>'. <!--
   * begin-user-doc --> There can be at most one attribute that is an ID. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClass_AtMostOneID(EClass eClass, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = true;
    EAttribute eIDAttribute = eClass.getEIDAttribute();

    // A document root can have multiple ID attributes because there can be
    // multiple global element or attribute declarations of type ID
    // and these will be the ID in the complex types that reference them,
    // i.e., they aren't really the ID of the document root.
    //
    if (eIDAttribute != null && !"".equals(ExtendedMetaData.INSTANCE.getName(eClass)))
    {
      LOOP: for (EAttribute eAttribute : eClass.getEAllAttributes())
      {
        if (eAttribute.isID() && eIDAttribute != eAttribute)
        {
          result = false;
          if (diagnostics == null)
          {
            break;
          }
          else
          {
            // We do not want to diagnose any errors that have already been
            // diagnosed by a super type.
            // Although we ignore all the first super's features, there may be
            // mixin classes that still would result in duplicates.
            //
            for (EClass eSuperType : eClass.getESuperTypes())
            {
              EList<EStructuralFeature> eAllStructuralFeatures = eSuperType.getEAllStructuralFeatures();
              if (eAllStructuralFeatures.contains(eIDAttribute) && eAllStructuralFeatures.contains(eAttribute))
              {
                continue LOOP;
              }
            }
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, AT_MOST_ONE_ID,
                EcorePlugin.INSTANCE.getString("_UI_EClassAtMostOneID_diagnostic", new Object[] {
                    getFeatureLabel(eIDAttribute, context), getFeatureLabel(eAttribute, context) }), new Object[] {
                    eClass, eAttribute, eIDAttribute }));
          }
        }
      }
    }
    return result;
  }

  /**
   * Validates the UniqueFeatureNames constraint of '<em>EClass</em>'. <!--
   * begin-user-doc --> No two features may have matching names. Feature names
   * are matched ignoring their case and their underscore separators. It is an
   * error to have two features with names that are equal but only a warning to
   * have two features with names that match. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClass_UniqueFeatureNames(EClass eClass, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    int size = eClass.getFeatureCount();
    if (size > 0)
    {
      // For performance, skip matching all the features of the first super
      // type.
      //
      int start = 0;
      EList<EClass> eSuperTypes = eClass.getESuperTypes();
      if (!eSuperTypes.isEmpty())
      {
        start = eSuperTypes.get(0).getEAllStructuralFeatures().size();
      }

      // Build a list of the keys
      //
      ArrayList<String> keys = new ArrayList<String>();
      LOOP: for (int i = 0; i < size; ++i)
      {
        EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
        String name = eStructuralFeature.getName();
        if (name == null)
        {
          // Don't bother complaining about things with no name,
          // since there are constraints for that problem.
          //
          keys.add(null);
        }
        else
        {
          // Drop the _ separators and normalize the case.
          //
          String key = name.replace("_", "").toLowerCase();

          // Ignore features from the first super type.
          //
          if (i >= start)
          {
            int index = keys.indexOf(key);
            if (index != -1)
            {
              if (diagnostics == null)
              {
                return false;
              }
              else
              {
                result = false;

                EStructuralFeature otherEStructuralFeature = eClass.getEStructuralFeature(index);

                // We do not want to diagnose any errors that have already been
                // diagnosed by a super type.
                // Although we ignore all the first super's features, there may
                // be mixin classes that still would result in duplicates.
                //
                for (EClass eSuperType : eSuperTypes)
                {
                  EList<EStructuralFeature> eAllStructuralFeatures = eSuperType.getEAllStructuralFeatures();
                  if (eAllStructuralFeatures.contains(eStructuralFeature)
                      && eAllStructuralFeatures.contains(otherEStructuralFeature))
                  {
                    continue LOOP;
                  }
                }

                // Produce different levels of diagnostic depending whether the
                // names are exactly the same or only matching.
                //
                String otherName = otherEStructuralFeature.getName();
                diagnostics.add(new BasicDiagnostic(name.equals(otherName) ? Diagnostic.ERROR : Diagnostic.WARNING,
                    DIAGNOSTIC_SOURCE, UNIQUE_FEATURE_NAMES, name.equals(otherName) ? EcorePlugin.INSTANCE.getString(
                        "_UI_EClassUniqueEStructuralFeatureName_diagnostic", new Object[] { name })
                        : EcorePlugin.INSTANCE.getString("_UI_EClassDissimilarEStructuralFeatureName_diagnostic",
                            new Object[] { name, otherName }), new Object[] { eClass, eStructuralFeature,
                        otherEStructuralFeature }));
              }
            }
          }
          keys.add(key);
        }
      }
    }
    return result;
  }

  /**
   * Validates the UniqueOperationSignatures constraint of '<em>EClass</em>'.
   * <!-- begin-user-doc --> No two operations defined in the same class may
   * have matching signatures. The signature is determined by the name of the
   * operation and the types of its parameters. If the name is the same and the
   * types match, the signatures match. Types match if they are same classifier,
   * or both classifiers have instance class names that are the same. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClass_UniqueOperationSignatures(EClass eClass, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    EList<EOperation> eOperatons = eClass.getEOperations();
    if (!eOperatons.isEmpty())
    {
      for (EOperation eOperation : eOperatons)
      {
        String name = eOperation.getName();
        if (name != null)
        {
          EList<EParameter> eParameters = eOperation.getEParameters();
          int eParameterSize = eParameters.size();
          LOOP: for (EOperation otherEOperation : eOperatons)
          {
            // Match against every other operation but this one.
            //
            if (otherEOperation == eOperation)
            {
              break;
            }
            else
            {
              String otherName = otherEOperation.getName();
              if (name.equals(otherName))
              {
                EList<EParameter> otherEParmeters = otherEOperation.getEParameters();
                if (otherEParmeters.size() == eParameterSize)
                {
                  for (int i = 0; i < eParameterSize; ++i)
                  {
                    EParameter eParameter = eParameters.get(i);
                    EParameter otherEParameter = otherEParmeters.get(i);
                    EClassifier eType = eParameter.getEType();
                    EClassifier otherEType = otherEParameter.getEType();

                    // There is no match if the types are different
                    // and they don't each specify the same non-null instance
                    // class name.
                    //
                    if (eType != otherEType)
                    {
                      if (eType != null && otherEType != null)
                      {
                        String instanceClassName = eType.getInstanceClassName();
                        String otherInstanceClassName = otherEType.getInstanceClassName();
                        if (instanceClassName != otherInstanceClassName || instanceClassName == null
                            || eParameter.isMany() != otherEParameter.isMany())
                        {
                          continue LOOP;
                        }
                      }
                      else
                      {
                        continue LOOP;
                      }
                    }
                    else if (eParameter.isMany() != otherEParameter.isMany())
                    {
                      continue LOOP;
                    }
                  }
                  if (diagnostics == null)
                  {
                    return false;
                  }
                  else
                  {
                    result = false;

                    // We do not want to diagnose any error that have already
                    // been diagnosed by a super type.
                    //
                    for (EClass eSuperType : eClass.getEAllSuperTypes())
                    {
                      EList<EOperation> superTypeEAllOperations = eSuperType.getEAllOperations();
                      if (superTypeEAllOperations.contains(eOperation)
                          && superTypeEAllOperations.contains(otherEOperation))
                      {
                        continue LOOP;
                      }
                    }

                    diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                        UNIQUE_OPERATION_SIGNATURES, EcorePlugin.INSTANCE.getString(
                            "_UI_EClassUniqueEOperationSignatures_diagnostic", new Object[] {
                                getObjectLabel(eOperation, context), getObjectLabel(otherEOperation, context) }),
                        new Object[] { eClass, eOperation, otherEOperation }));
                  }
                }
              }
            }
          }
        }
      }
    }
    return result;
  }

  /**
   * There are other constraints we should check such as consistency of the
   * return type, correctness of the signature with respect to type
   * substitution, and so on... Validates the UniqueOperationSignatures
   * constraint of '<em>EClass</em>'. <!-- begin-user-doc --> No two
   * operation defined in the same class may have matching signatures. The
   * signature is determined by the name of the operation and the types of its
   * parameters. If the name is the same and the types match, the signatures
   * match. Types match if they are same classifier, of both classifiers have
   * instance class names that are the same. <!-- end-user-doc -->
   * 
   * @generated NOT YET
   */
  @SuppressWarnings("unused")
  private boolean validateEClass_UniqueOperationSignatures2(EClass eClass, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    EList<EOperation> eAllOperations = eClass.getEAllOperations();
    if (!eAllOperations.isEmpty())
    {
      // Iterate over all the operations but skip all the operations in the
      // first super.
      //
      List<EOperation> eOperations = eAllOperations;
      EList<EClass> eSuperTypes = eClass.getESuperTypes();
      if (!eSuperTypes.isEmpty())
      {
        eOperations = eAllOperations.subList(eSuperTypes.get(0).getEAllOperations().size(), eAllOperations.size());
      }
      for (EOperation eOperation : eOperations)
      {
        String name = eOperation.getName();
        if (name != null)
        {
          EList<EParameter> eParameters = eOperation.getEParameters();
          int eParameterSize = eParameters.size();
          LOOP: for (EOperation otherEOperation : eAllOperations)
          {
            // Match against every other operation but this one.
            //
            if (otherEOperation == eOperation)
            {
              break;
            }
            else
            {
              String otherName = otherEOperation.getName();
              if (name.equals(otherName))
              {
                EList<EParameter> otherEParmeters = otherEOperation.getEParameters();
                if (otherEParmeters.size() == eParameterSize)
                {
                  for (int i = 0; i < eParameterSize; ++i)
                  {
                    EParameter eParameter = eParameters.get(i);
                    EParameter otherEParameter = otherEParmeters.get(i);
                    EClassifier eType = eParameter.getEType();
                    EClassifier otherEType = otherEParameter.getEType();

                    // There is no match if the types are different
                    // and they don't each specify the same non-null instance
                    // class name.
                    //
                    if (eType != otherEType)
                    {
                      if (eType != null && otherEType != null)
                      {
                        String instanceClassName = eType.getInstanceClassName();
                        String otherInstanceClassName = otherEType.getInstanceClassName();
                        if (instanceClassName != otherInstanceClassName && instanceClassName != null
                            && otherInstanceClassName != null)
                        {
                          continue LOOP;
                        }
                      }
                    }
                  }
                  if (diagnostics == null)
                  {
                    return false;
                  }
                  else
                  {
                    result = false;

                    // We do not want to diagnose any error that have already
                    // been diagnosed by a super type.
                    //
                    for (EClass eSuperType : eClass.getEAllSuperTypes())
                    {
                      EList<EOperation> superTypeEAllOperations = eSuperType.getEAllOperations();
                      if (superTypeEAllOperations.contains(eOperation)
                          && superTypeEAllOperations.contains(otherEOperation))
                      {
                        continue LOOP;
                      }
                    }

                    diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                        UNIQUE_OPERATION_SIGNATURES, EcorePlugin.INSTANCE.getString(
                            "_UI_EClassUniqueEOperationSignatures_diagnostic", new Object[] {
                                getObjectLabel(eOperation, context), getObjectLabel(otherEOperation, context) }),
                        new Object[] { eClass, eOperation, otherEOperation }));
                  }
                }
              }
            }
          }
        }
      }
    }
    return result;
  }

  /**
   * Validates the NoCircularSuperTypes constraint of '<em>EClass</em>'.
   * <!-- begin-user-doc --> A super type must not appear in its own list of all
   * super types. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClass_NoCircularSuperTypes(EClass eClass, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = !eClass.getEAllSuperTypes().contains(eClass);
    if (!result && diagnostics != null)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, NO_CIRCULAR_SUPER_TYPES,
          EcorePlugin.INSTANCE.getString("_UI_EClassNoCircularSuperTypes_diagnostic"), new Object[] { eClass }));
    }
    return result;
  }

  /**
   * Validates the WellFormedMapEntryClass constraint of '<em>EClass</em>'.
   * <!-- begin-user-doc --> A map entry class must have features named 'key'
   * and 'value'. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClass_WellFormedMapEntryClass(EClass eClass, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    if (eClass.getInstanceClassName() == "java.util.Map$Entry")
    {
      EStructuralFeature keyFeature = eClass.getEStructuralFeature("key");
      if (keyFeature == null)
      {
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_MAP_ENTRY_CLASS,
              EcorePlugin.INSTANCE.getString("_UI_EClassNotWellFormedMapEntry_diagnostic", new Object[] { "key" }),
              new Object[] { eClass }));
        }
      }
      EStructuralFeature valueFeature = eClass.getEStructuralFeature("value");
      if (valueFeature == null)
      {
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_MAP_ENTRY_CLASS,
              EcorePlugin.INSTANCE.getString("_UI_EClassNotWellFormedMapEntry_diagnostic", new Object[] { "value" }),
              new Object[] { eClass }));
        }
      }
    }
    return result;
  }

  /**
   * Validates the ConsistentSuperTypes constraint of '<em>EClass</em>'.
   * <!-- begin-user-doc --> The same class must not occur more than once among
   * the generic super types nor among all the generic super types where
   * occurrences in the latter represent conflicting instantiations of the same
   * classifier. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClass_ConsistentSuperTypes(EClass eClass, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;

    // Maintain a list of classifiers for looking up conficts.
    //
    ArrayList<EClassifier> superTypes = new ArrayList<EClassifier>();

    // Look for duplicates among the generic super types.
    //
    EList<EGenericType> eGenericSuperTypes = eClass.getEGenericSuperTypes();
    for (EGenericType eGenericSuperType : eGenericSuperTypes)
    {
      // Ignore it if it isn't a class. Not being a class is diagnosed for the
      // generic type itself.
      //
      EClassifier eClassifier = eGenericSuperType.getEClassifier();
      if (eClassifier instanceof EClass)
      {
        int index = superTypes.indexOf(eClassifier);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_SUPER_TYPES_DUPLICATE,
                EcorePlugin.INSTANCE.getString("_UI_EClassNoDuplicateSuperTypes_diagnostic", new Object[] {
                    eGenericSuperTypes.indexOf(eGenericSuperType), index }), new Object[] { eClass, eGenericSuperType,
                    eGenericSuperTypes.get(index) }));
          }
        }
      }
      superTypes.add(eClassifier);
    }

    if (result)
    {
      superTypes.clear();
      EList<EGenericType> eAllGenericSuperTypes = eClass.getEAllGenericSuperTypes();
      for (EGenericType eGenericSuperType : eAllGenericSuperTypes)
      {
        EClassifier eClassifier = eGenericSuperType.getEClassifier();
        if (eClassifier instanceof EClass)
        {
          int index = superTypes.indexOf(eClassifier);
          if (index != -1)
          {
            if (diagnostics == null)
            {
              return false;
            }
            else
            {
              result = false;
              diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_SUPER_TYPES_CONFLICT,
                  EcorePlugin.INSTANCE.getString("_UI_EClassConsistentSuperTypes_diagnostic",
                      new Object[] { getObjectLabel(eClassifier, context) }), new Object[] { eClass, eGenericSuperType,
                      eAllGenericSuperTypes.get(index) }));
            }
          }
        }
        superTypes.add(eClassifier);
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEClassifier(EClassifier eClassifier, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eClassifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eClassifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eClassifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eClassifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eClassifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eClassifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eClassifier, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eClassifier, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_WellFormedInstanceTypeName(eClassifier, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_UniqueTypeParameterNames(eClassifier, diagnostics, context);
    return result;
  }

  /**
   * Validates the WellFormedInstanceTypeName constraint of '<em>EClassifier</em>'.
   * <!-- begin-user-doc --> The instance type name may be null only for a class
   * or an enum and must be
   * {@link EGenericTypeBuilder#parseInstanceTypeName(String) well formed} when
   * not null. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClassifier_WellFormedInstanceTypeName(EClassifier eClassifier, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    String instanceTypeName = eClassifier.getInstanceTypeName();
    Diagnostic typeBuilderDiagnostic = instanceTypeName == null ? null : EGenericTypeBuilder.INSTANCE
        .parseInstanceTypeName(instanceTypeName);
    String formattedName = null;
    boolean result = instanceTypeName != null ? typeBuilderDiagnostic.getSeverity() == Diagnostic.OK
        && instanceTypeName.equals(formattedName = EcoreUtil.toJavaInstanceTypeName((EGenericType)typeBuilderDiagnostic
            .getData().get(0))) : eClassifier instanceof EClass || eClassifier instanceof EEnum;
    if (!result && diagnostics != null)
    {
      BasicDiagnostic diagnosic = new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
          WELL_FORMED_INSTANCE_TYPE_NAME, EcorePlugin.INSTANCE.getString(
              "_UI_EClassifierInstanceTypeNameNotWellFormed_diagnostic", new Object[] { getValueLabel(
                  EcorePackage.Literals.ESTRING, instanceTypeName, context) }), new Object[] { eClassifier });
      if (typeBuilderDiagnostic != null)
      {
        if (!typeBuilderDiagnostic.getChildren().isEmpty())
        {
          diagnosic.addAll(typeBuilderDiagnostic);
        }
        else if (instanceTypeName != null && formattedName != null)
        {
          // The string must contain inappropriate whitespace, so find the index
          // for the first difference.
          //
          int i = 0;
          for (int length = Math.min(instanceTypeName.length(), formattedName.length()); i < length; i = Character
              .offsetByCodePoints(instanceTypeName, i, 1))
          {
            if (instanceTypeName.codePointAt(i) != formattedName.codePointAt(i))
            {
              break;
            }
          }

          diagnosic.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_INSTANCE_TYPE_NAME,
              EcorePlugin.INSTANCE.getString(
                  instanceTypeName.codePointAt(i) == ' ' ? "_UI_EClassifierInstanceTypeNameUnexpectedSpace_diagnostic"
                      : "_UI_EClassifierInstanceTypeNameExpectedSpace_diagnostic", new Object[] { i }),
              new Object[] { i }));
        }
      }
      diagnostics.add(diagnosic);
    }
    return result;
  }

  /**
   * Validates the UniqueTypeParameterNames constraint of '<em>EClassifier</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEClassifier_UniqueTypeParameterNames(EClassifier eClassifier, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    List<String> names = new ArrayList<String>();
    EList<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
    for (ETypeParameter eTypeParameter : eTypeParameters)
    {
      String name = eTypeParameter.getName();
      if (name != null)
      {
        int index = names.indexOf(name);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            ETypeParameter otherETypeParameter = eTypeParameters.get(index);
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_TYPE_PARAMETER_NAMES,
                EcorePlugin.INSTANCE.getString("_UI_UniqueTypeParameterNames_diagnostic", new Object[] { name }),
                new Object[] { eClassifier, eTypeParameter, otherETypeParameter }));
          }
        }
      }
      names.add(name);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEDataType(EDataType eDataType, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eDataType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eDataType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eDataType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eDataType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eDataType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eDataType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eDataType, diagnostics, context);
    if (result || diagnostics != null) result &= validateENamedElement_WellFormedName(eDataType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_WellFormedInstanceTypeName(eDataType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_UniqueTypeParameterNames(eDataType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEEnum(EEnum eEnum, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validateENamedElement_WellFormedName(eEnum, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_WellFormedInstanceTypeName(eEnum, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEClassifier_UniqueTypeParameterNames(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validateEEnum_UniqueEnumeratorNames(eEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validateEEnum_UniqueEnumeratorLiterals(eEnum, diagnostics, context);
    return result;
  }

  /**
   * Validates the UniqueEnumeratorNames constraint of '<em>EEnum</em>'.
   * <!-- begin-user-doc --> No two enum literals may have matching names.
   * Literal names are matched ignoring their case and their underscore
   * separators. It is an error to have two enum literals with names that are
   * equal but only a warning to have two enum literals with names that match.
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEEnum_UniqueEnumeratorNames(EEnum eEnum, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    List<String> names = new ArrayList<String>();
    EList<EEnumLiteral> eLiterals = eEnum.getELiterals();
    for (EEnumLiteral eEnumLiteral : eLiterals)
    {
      String name = eEnumLiteral.getName();
      if (name == null)
      {
        names.add(null);
      }
      else
      {
        String key = name.replace("_", "").toUpperCase();
        int index = names.indexOf(key);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            EEnumLiteral otherEEnumLiteral = eLiterals.get(index);
            String otherName = otherEEnumLiteral.getName();
            diagnostics.add(new BasicDiagnostic(name.equals(otherName) ? Diagnostic.ERROR : Diagnostic.WARNING,
                DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_NAMES, name.equals(otherName) ? EcorePlugin.INSTANCE.getString(
                    "_UI_EEnumUniqueEnumeratorNames_diagnostic", new Object[] { name }) : EcorePlugin.INSTANCE
                    .getString("_UI_EEnumDissimilarEnumeratorNames_diagnostic", new Object[] { name, otherName }),
                new Object[] { eEnum, eEnumLiteral, otherEEnumLiteral }));
          }
        }
        names.add(key);
      }
    }
    return result;
  }

  /**
   * Validates the UniqueEnumeratorLiterals constraint of '<em>EEnum</em>'.
   * <!-- begin-user-doc --> No two enum literals may have the same literal
   * value. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEEnum_UniqueEnumeratorLiterals(EEnum eEnum, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    List<String> literals = new ArrayList<String>();
    EList<EEnumLiteral> eLiterals = eEnum.getELiterals();
    for (EEnumLiteral eEnumLiteral : eLiterals)
    {
      String literal = eEnumLiteral.getLiteral();
      if (literal != null)
      {
        int index = literals.indexOf(literal);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            EEnumLiteral otherEEnumLiteral = eLiterals.get(index);
            // Don't complain about the literals if they are the same as the
            // names and the names collide.
            //
            String name = eEnumLiteral.getName();
            if (name == null || !name.equals(literal) || !name.equals(otherEEnumLiteral.getName()))
            {
              diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_ENUMERATOR_LITERALS,
                  EcorePlugin.INSTANCE.getString("_UI_EEnumUniqueEnumeratorLiterals_diagnostic",
                      new Object[] { literal }), new Object[] { eEnum, eEnumLiteral, otherEEnumLiteral }));
            }
          }
        }
      }
      literals.add(literal);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEEnumLiteral(EEnumLiteral eEnumLiteral, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eEnumLiteral, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(eEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eEnumLiteral, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eEnumLiteral, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEFactory(EFactory eFactory, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(eFactory, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEModelElement(EModelElement eModelElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(eModelElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateENamedElement(ENamedElement eNamedElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eNamedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eNamedElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(eNamedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eNamedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eNamedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eNamedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eNamedElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eNamedElement, diagnostics, context);
    return result;
  }

  /**
   * Validates the WellFormedName constraint of '<em>ENamed Element</em>'.
   * <!-- begin-user-doc --> The name must be a valid Java identifier. I.e., it
   * must start with a
   * {@link Character#isJavaIdentifierStart(int) Java identifier start character},
   * that is followed by zero or more
   * {@link Character#isJavaIdentifierPart(int) Java identifier part characters}.
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateENamedElement_WellFormedName(ENamedElement eNamedElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = false;
    String name = eNamedElement.getName();
    if (name != null)
    {
      int length = name.length();
      if (length > 0 && Character.isJavaIdentifierStart(name.codePointAt(0)))
      {
        result = true;
        for (int i = Character.offsetByCodePoints(name, 0, 1); i < length; i = Character.offsetByCodePoints(name, i, 1))
        {
          if (!Character.isJavaIdentifierPart(name.codePointAt(i)))
          {
            result = false;
            break;
          }
        }
      }
    }

    if (!result && diagnostics != null)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_NAME, EcorePlugin.INSTANCE
          .getString("_UI_ENamedElementNameNotWellFormed_diagnostic", new Object[] { getValueLabel(
              EcorePackage.Literals.ESTRING, name, context) }), new Object[] { eNamedElement }));
    }

    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEObject(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(eObject, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEOperation(EOperation eOperation, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eOperation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eOperation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidLowerBound(eOperation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidUpperBound(eOperation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ConsistentBounds(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validateETypedElement_ValidType(eOperation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEOperation_UniqueParameterNames(eOperation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEOperation_UniqueTypeParameterNames(eOperation, diagnostics, context);
    if (result || diagnostics != null) result &= validateEOperation_NoRepeatingVoid(eOperation, diagnostics, context);
    return result;
  }

  /**
   * Validates the UniqueParameterNames constraint of '<em>EOperation</em>'.
   * <!-- begin-user-doc --> No two parameters may have the same name. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEOperation_UniqueParameterNames(EOperation eOperation, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    List<String> names = new ArrayList<String>();
    EList<EParameter> eParameters = eOperation.getEParameters();
    for (EParameter eParameter : eParameters)
    {
      String name = eParameter.getName();
      if (name != null)
      {
        int index = names.indexOf(name);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            EParameter otherEParameter = eParameters.get(index);
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_PARAMETER_NAMES,
                EcorePlugin.INSTANCE.getString("_UI_EOperationUniqueParameterNames_diagnostic", new Object[] { name }),
                new Object[] { eOperation, eParameter, otherEParameter }));
          }
        }
      }
      names.add(name);
    }
    return result;
  }

  /**
   * Validates the UniqueTypeParameterNames constraint of '<em>EOperation</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEOperation_UniqueTypeParameterNames(EOperation eOperation, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    List<String> names = new ArrayList<String>();
    EList<ETypeParameter> eTypeParameters = eOperation.getETypeParameters();
    for (ETypeParameter eTypeParameter : eTypeParameters)
    {
      String name = eTypeParameter.getName();
      if (name != null)
      {
        int index = names.indexOf(name);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            ETypeParameter otherETypeParameter = eTypeParameters.get(index);
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_TYPE_PARAMETER_NAMES,
                EcorePlugin.INSTANCE.getString("_UI_UniqueTypeParameterNames_diagnostic", new Object[] { name }),
                new Object[] { eOperation, eTypeParameter, otherETypeParameter }));
          }
        }
      }
      names.add(name);
    }
    return result;
  }

  /**
   * Validates the NoRepeatingVoid constraint of '<em>EOperation</em>'. <!--
   * begin-user-doc --> An operation without a type, which represents void, must
   * have an upper bound of 1. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEOperation_NoRepeatingVoid(EOperation eOperation, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    int upperBound = eOperation.getUpperBound();
    boolean result = upperBound == 1 || eOperation.getEType() != null;
    if (!result && diagnostics != null)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, NO_REPEATING_VOID, EcorePlugin.INSTANCE
          .getString("_UI_EOperationNoRepeatingVoid_diagnostic", new Object[] { upperBound }),
          new Object[] { eOperation }));
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEPackage(EPackage ePackage, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validateENamedElement_WellFormedName(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validateEPackage_WellFormedNsURI(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validateEPackage_WellFormedNsPrefix(ePackage, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEPackage_UniqueSubpackageNames(ePackage, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEPackage_UniqueClassifierNames(ePackage, diagnostics, context);
    if (result || diagnostics != null) result &= validateEPackage_UniqueNsURIs(ePackage, diagnostics, context);
    return result;
  }

  /**
   * Validates the WellFormedNsURI constraint of '<em>EPackage</em>'. <!--
   * begin-user-doc --> The namespace URI must be
   * {@link #isWellFormedURI(String) well formed} and may not be
   * <code>null</code>. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEPackage_WellFormedNsURI(EPackage ePackage, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    String nsURI = ePackage.getNsURI();
    boolean result = isWellFormedURI(nsURI);
    if (!result && diagnostics != null)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_NS_URI, EcorePlugin.INSTANCE
          .getString("_UI_EPackageNsURINotWellFormed_diagnostic", new Object[] { nsURI }), new Object[] { ePackage }));
    }
    return result;
  }

  /**
   * Validates the WellFormedNsPrefix constraint of '<em>EPackage</em>'.
   * <!-- begin-user-doc --> The namespace prefix must be either
   * <code>null</code> or a
   * {@link XMLTypeValidator#validateNCName(String, DiagnosticChain, Map) valid NCName}
   * that does not start with the any case combination of the three letters <a
   * href="http://www.w3.org/TR/REC-xml-names/#xmlReserved">"xml"</a>. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEPackage_WellFormedNsPrefix(EPackage ePackage, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    String nsPrefix = ePackage.getNsPrefix();
    boolean result = "".equals(nsPrefix) || nsPrefix != null
        && XMLTypeValidator.INSTANCE.validateNCName(nsPrefix, null, context)
        && (!nsPrefix.toLowerCase().startsWith("xml") || XMLNamespacePackage.eNS_URI.equals(ePackage.getNsURI()));
    if (!result && diagnostics != null)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_NS_PREFIX,
          EcorePlugin.INSTANCE.getString("_UI_EPackageNsPrefixNotWellFormed_diagnostic", new Object[] { nsPrefix }),
          new Object[] { ePackage }));
    }
    return result;
  }

  /**
   * Validates the UniqueSubpackageNames constraint of '<em>EPackage</em>'.
   * <!-- begin-user-doc --> No two packages my have the same name. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEPackage_UniqueSubpackageNames(EPackage ePackage, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    List<String> names = new ArrayList<String>();
    EList<EPackage> eSubpackages = ePackage.getESubpackages();
    for (EPackage eSubpackage : eSubpackages)
    {
      String name = eSubpackage.getName();
      if (name != null)
      {
        int index = names.indexOf(name);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            EPackage otherESubpackage = eSubpackages.get(index);
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_SUBPACKAGE_NAMES,
                EcorePlugin.INSTANCE.getString("_UI_EPackageUniqueSubpackageNames_diagnostic", new Object[] { name }),
                new Object[] { ePackage, eSubpackage, otherESubpackage }));
          }
        }
      }
      names.add(name);
    }
    return result;
  }

  /**
   * Validates the UniqueClassifierNames constraint of '<em>EPackage</em>'.
   * <!-- begin-user-doc --> No two classifiers may have matching names.
   * Classifier names are matched ignoring their case and their underscore
   * separators. It is an error to have two classifier with names that are equal
   * but only a warning to have two classifiers with names that match. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEPackage_UniqueClassifierNames(EPackage ePackage, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    List<String> names = new ArrayList<String>();
    EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
    for (EClassifier eClassifier : eClassifiers)
    {
      String name = eClassifier.getName();
      if (name != null)
      {
        String key = name.replace("_", "").toUpperCase();
        int index = names.indexOf(key);
        if (index != -1)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            EClassifier otherEClassifier = eClassifiers.get(index);
            String otherName = otherEClassifier.getName();
            diagnostics.add(new BasicDiagnostic(name.equals(otherName) ? Diagnostic.ERROR : Diagnostic.WARNING,
                DIAGNOSTIC_SOURCE, UNIQUE_CLASSIFIER_NAMES, name.equals(otherName) ? EcorePlugin.INSTANCE.getString(
                    "_UI_EPackageUniqueClassifierNames_diagnostic", new Object[] { name }) : EcorePlugin.INSTANCE
                    .getString("_UI_EPackageDissimilarClassifierNames_diagnostic", new Object[] { name, otherName }),
                new Object[] { ePackage, eClassifier, otherEClassifier }));
          }
        }
        names.add(key);
      }
      else
      {
        names.add(null);
      }
    }
    return result;
  }

  /**
   * Validates the UniqueNsURIs constraint of '<em>EPackage</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEPackage_UniqueNsURIs(EPackage ePackage, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    String nsURI = ePackage.getNsURI();
    if (nsURI != null)
    {
      EPackage rootEPackage = ePackage;
      for (EPackage eSuperPackage = ePackage.getESuperPackage(); eSuperPackage != null; eSuperPackage = eSuperPackage
          .getESuperPackage())
      {
        rootEPackage = eSuperPackage;
      }

      UniqueEList<EPackage> ePackages = new UniqueEList.FastCompare<EPackage>();
      ePackages.add(rootEPackage);
      for (int i = 0; i < ePackages.size(); ++i)
      {
        ePackages.addAll(ePackages.get(i).getESubpackages());
      }
      ePackages.remove(ePackage);

      for (EPackage otherEPackage : ePackages)
      {
        if (nsURI.equals(otherEPackage.getNsURI()))
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, UNIQUE_NS_URIS,
                EcorePlugin.INSTANCE.getString("_UI_EPackageUniqueNsURIs_diagnostic", new Object[] { nsURI }),
                new Object[] { ePackage, otherEPackage }));
          }
        }
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEParameter(EParameter eParameter, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eParameter, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eParameter, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidLowerBound(eParameter, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidUpperBound(eParameter, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ConsistentBounds(eParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validateETypedElement_ValidType(eParameter, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEReference(EReference eReference, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eReference, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eReference, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidLowerBound(eReference, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidUpperBound(eReference, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ConsistentBounds(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validateETypedElement_ValidType(eReference, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEStructuralFeature_ValidDefaultValueLiteral(eReference, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEReference_ConsistentOpposite(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validateEReference_SingleContainer(eReference, diagnostics, context);
    if (result || diagnostics != null) result &= validateEReference_ConsistentKeys(eReference, diagnostics, context);
    return result;
  }

  /**
   * Validates the ConsistentOpposite constraint of '<em>EReference</em>'.
   * <!-- begin-user-doc --> An {@link EReference#getEOpposite() opposite} is
   * optional but if one exists, it must be a feature of this references's
   * {@link EReference#getEReferenceType() type}, it must have this reference
   * as its opposite, and, if this feature is
   * {@link EStructuralFeature#isTransient() transient}, then the opposite must
   * also be transient, must not
   * {@link EReference#isResolveProxies() resolve proxies}. or must be a
   * {@link EReference#isContainment() containment}, <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEReference_ConsistentOpposite(EReference eReference, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    EReference eOpposite = eReference.getEOpposite();
    if (eOpposite != null)
    {
      if (eReference.getEContainingClass() != null)
      {
        EReference oppositeEOpposite = eOpposite.getEOpposite();
        if (oppositeEOpposite != eReference)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_OPPOSITE_NOT_MATCHING,
                EcorePlugin.INSTANCE.getString("_UI_EReferenceOppositeOfOppositeInconsistent_diagnostic"),
                new Object[] { eReference, eOpposite, oppositeEOpposite }));
          }
        }
        EClassifier eType = eReference.getEType();
        if (eType != null)
        {
          EClass oppositeEContainingClass = eOpposite.getEContainingClass();
          if (oppositeEContainingClass != null && oppositeEContainingClass != eType)
          {
            if (diagnostics == null)
            {
              return false;
            }
            else
            {
              result = false;
              diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                  CONSISTENT_OPPOSITE_NOT_FROM_TYPE, EcorePlugin.INSTANCE
                      .getString("_UI_EReferenceOppositeNotFeatureOfType_diagnostic"), new Object[] { eReference,
                      eOpposite, eType }));
            }
          }
        }
      }
      if (result)
      {
        result = !isEffectivelyTransient(eReference) || isEffectivelyTransient(eOpposite)
            || !eOpposite.isResolveProxies() || eOpposite.isContainment();
        if (diagnostics != null && !result)
        {
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_OPPOSITE_BAD_TRANSIENT,
              EcorePlugin.INSTANCE.getString("_UI_EReferenceTransientOppositeNotTransient_diagnostic"), new Object[] {
                  eReference, eOpposite }));
        }
      }
      if (result)
      {
        result = !eReference.isContainment() || !eOpposite.isContainment();
        if (diagnostics != null && !result)
        {
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
              CONSISTENT_OPPOSITE_BOTH_CONTAINMENT, EcorePlugin.INSTANCE
                  .getString("_UI_EReferenceOppositeBothContainment_diagnostic"),
              new Object[] { eReference, eOpposite }));
        }
      }
    }
    return result;
  }

  /**
   * Validates the SingleContainer constraint of '<em>EReference</em>'. <!--
   * begin-user-doc --> A {@link EReference#isContainer() container} reference
   * must have a upper bound of 1. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEReference_SingleContainer(EReference eReference, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = !eReference.isContainer() || eReference.getUpperBound() == 1;
    if (diagnostics != null && !result)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, SINGLE_CONTAINER, EcorePlugin.INSTANCE
          .getString("_UI_EReferenceSingleContainer_diagnostic", new Object[] { eReference.getUpperBound() }),
          new Object[] { eReference }));
    }
    return result;
  }

  /**
   * Validates the ConsistentKeys constraint of '<em>EReference</em>'. <!--
   * begin-user-doc --> The {@link EReference#getEKeys() keys} of a reference
   * must be features of the reference's {@link ETypedElement#getEType()}. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEReference_ConsistentKeys(EReference eReference, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    EList<EAttribute> eKeys = eReference.getEKeys();
    if (!eKeys.isEmpty())
    {
      EClass eClass = eReference.getEReferenceType();
      if (eClass != null)
      {
        for (EAttribute eAttribute : eKeys)
        {
          if (eClass.getFeatureID(eAttribute) == -1)
          {
            if (diagnostics == null)
            {
              return false;
            }
            else
            {
              result = false;
              diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_KEYS,
                  EcorePlugin.INSTANCE.getString("_UI_EReferenceConsistentKeys_diagnostic",
                      new Object[] { getObjectLabel(eAttribute, context) }), new Object[] { eReference, eAttribute }));
            }
          }
        }
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEStructuralFeature(EStructuralFeature eStructuralFeature, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidLowerBound(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidUpperBound(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ConsistentBounds(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidType(eStructuralFeature, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEStructuralFeature_ValidDefaultValueLiteral(eStructuralFeature, diagnostics, context);
    return result;
  }

  /**
   * Validates the ValidDefaultValueLiteral constraint of '<em>EStructural Feature</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEStructuralFeature_ValidDefaultValueLiteral(EStructuralFeature eStructuralFeature,
      DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    String defaultValueLiteral = eStructuralFeature.getDefaultValueLiteral();
    Object defaultValue = null;
    EDataType eDataType = null;
    boolean result = true;
    if (defaultValueLiteral != null)
    {
      EClassifier eType = eStructuralFeature.getEType();
      if (eType instanceof EDataType)
      {
        eDataType = (EDataType)eType;
        defaultValue = eStructuralFeature.getDefaultValue();
        if (defaultValue == null)
        {
          // We need to be conservative and diagnose a problem only if we are
          // quite sure that type is built-in
          // and hence that the lack of a default value really represents a
          // problem with being unable to convert the literal to a value.
          // 
          result = !isBuiltinEDataType(eDataType);
        }
        else
        {
          result = getRootEValidator(context).validate(eDataType, defaultValue, null, context);
        }
      }
      else
      {
        result = false;
      }
    }
    if (diagnostics != null && !result)
    {
      BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, VALID_LOWER_BOUND,
          EcorePlugin.INSTANCE.getString("_UI_EStructuralFeatureValidDefaultValueLiteral_diagnostic",
              new Object[] { defaultValueLiteral }), new Object[] { eStructuralFeature });
      if (defaultValue != null)
      {
        getRootEValidator(context).validate(eDataType, defaultValue, diagnostic, context);
      }
      diagnostics.add(diagnostic);
    }
    return result;
  }

  protected boolean isBuiltinEDataType(EDataType eDataType)
  {
    EPackage ePackage = eDataType.getEPackage();
    if (ePackage == EcorePackage.eINSTANCE || ePackage == XMLTypePackage.eINSTANCE
        || ePackage == XMLNamespacePackage.eINSTANCE)
    {
      return true;
    }

    EDataType baseType = ExtendedMetaData.INSTANCE.getBaseType(eDataType);
    if (baseType != null)
    {
      return isBuiltinEDataType(baseType);
    }

    EDataType itemType = ExtendedMetaData.INSTANCE.getItemType(eDataType);
    if (itemType != null)
    {
      return isBuiltinEDataType(itemType);
    }

    List<EDataType> memberTypes = ExtendedMetaData.INSTANCE.getMemberTypes(eDataType);
    if (!memberTypes.isEmpty())
    {
      for (EDataType memberType : memberTypes)
      {
        if (!isBuiltinEDataType(memberType))
        {
          return false;
        }
      }
      return true;
    }

    return false;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateETypedElement(ETypedElement eTypedElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eTypedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eTypedElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(eTypedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eTypedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eTypedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eTypedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eTypedElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eTypedElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidLowerBound(eTypedElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ValidUpperBound(eTypedElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateETypedElement_ConsistentBounds(eTypedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateETypedElement_ValidType(eTypedElement, diagnostics, context);
    return result;
  }

  /**
   * Validates the ValidLowerBound constraint of '<em>ETyped Element</em>'.
   * <!-- begin-user-doc --> The
   * {@link ETypedElement#getLowerBound() lower bound} must be greater or equal
   * to 0 <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateETypedElement_ValidLowerBound(ETypedElement eTypedElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    int lowerBound = eTypedElement.getLowerBound();
    boolean result = lowerBound >= 0;
    if (diagnostics != null && !result)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, VALID_LOWER_BOUND, EcorePlugin.INSTANCE
          .getString("_UI_ETypedElementValidLowerBound_diagnostic", new Object[] { lowerBound }),
          new Object[] { eTypedElement }));
    }
    return result;
  }

  /**
   * Validates the ValidUpperBound constraint of '<em>ETyped Element</em>'.
   * <!-- begin-user-doc --> The
   * {@link ETypedElement#getUpperBound() upper bound} must be either
   * {@link ETypedElement#UNBOUNDED_MULTIPLICITY},
   * {@link ETypedElement#UNSPECIFIED_MULTIPLICITY}, or greater than 0. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateETypedElement_ValidUpperBound(ETypedElement eTypedElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    int upperBound = eTypedElement.getUpperBound();
    boolean result = upperBound > 0 || upperBound == ETypedElement.UNSPECIFIED_MULTIPLICITY
        || upperBound == ETypedElement.UNBOUNDED_MULTIPLICITY;
    if (diagnostics != null && !result)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, VALID_UPPER_BOUND, EcorePlugin.INSTANCE
          .getString("_UI_ETypedElementValidUpperBound_diagnostic", new Object[] { upperBound }),
          new Object[] { eTypedElement }));
    }
    return result;
  }

  /**
   * Validates the ConsistentBounds constraint of '<em>ETyped Element</em>'.
   * <!-- begin-user-doc --> The
   * {@link ETypedElement#getLowerBound() lower bound} must be less than or
   * equal to the {@link ETypedElement#getUpperBound() upper bound}, unless the
   * upper bound is one of the two special values
   * {@link ETypedElement#UNBOUNDED_MULTIPLICITY} or
   * {@link ETypedElement#UNSPECIFIED_MULTIPLICITY}. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateETypedElement_ConsistentBounds(ETypedElement eTypedElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    int lowerBound = eTypedElement.getLowerBound();
    int upperBound = eTypedElement.getUpperBound();
    boolean result = upperBound < 0 || lowerBound <= upperBound;
    if (diagnostics != null && !result)
    {
      diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_BOUNDS, EcorePlugin.INSTANCE
          .getString("_UI_ETypedElementConsistentBounds_diagnostic", new Object[] { lowerBound, upperBound }),
          new Object[] { eTypedElement }));
    }
    return result;
  }

  /**
   * Validates the ValidType constraint of '<em>ETyped Element</em>'. <!--
   * begin-user-doc --> The {@link ETypedElement#getEGenericType() type} may be
   * <code>null</code> only if this in an {@link EOperation operation}. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateETypedElement_ValidType(ETypedElement eTypedElement, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    EGenericType eGenericType = eTypedElement.getEGenericType();
    if (eGenericType == null && !(eTypedElement instanceof EOperation))
    {
      result = false;
      if (diagnostics != null)
      {
        diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, VALID_TYPE, EcorePlugin.INSTANCE
            .getString("_UI_ETypedElementNoType_diagnostic"), new Object[] { eTypedElement }));
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEStringToStringMapEntry(Map.Entry<?, ?> eStringToStringMapEntry, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint((EObject)eStringToStringMapEntry, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEGenericType(EGenericType eGenericType, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eGenericType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eGenericType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(eGenericType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eGenericType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eGenericType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eGenericType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eGenericType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEGenericType_ConsistentType(eGenericType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEGenericType_ConsistentBounds(eGenericType, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateEGenericType_ConsistentArguments(eGenericType, diagnostics, context);
    return result;
  }

  /**
   * Validates the ConsistentType constraint of '<em>EGeneric Type</em>'.
   * <!-- begin-user-doc --> A generic type must not reference both a
   * {@link EGenericType#getEClassifier() classifier} and a
   * {@link EGenericType#getETypeParameter() type parameter}. The referenced
   * type parameter must be in scope, i.e., its {@link EObject#eContainer()}
   * must be an {@link EcoreUtil#isAncestor(EObject, EObject)} of this generic
   * type. A generic type used as a
   * {@link EClass#getEGenericSuperTypes() generic super type} must have a
   * classifier that refers to a {@link EClass class}. A generic type used as a
   * {@link EGenericType#getETypeArguments() type argument} of a generic type
   * used as a generic super type must specify either a classifier or a type
   * parameter, i.e., it can't be a wildcard. A generic type may omit both the
   * classifier and the type argument to act as a wildcard only when used as a
   * type argument of some generic type, with the above exception. If present,
   * the classifier of generic type used as the
   * {@link ETypedElement#getEType() type} of an {@link EAttribute attribute}
   * must be a {@link EDataType data type}. If present, the classifier of
   * generic type used as the type of a {@link EReference reference} must be a
   * class. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEGenericType_ConsistentType(EGenericType eGenericType, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;

    ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
    EClassifier eClassifier = eGenericType.getEClassifier();
    if (eTypeParameter != null)
    {
      if (eClassifier != null)
      {
        // Can't have both a classifier and a type parameter.
        //
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics
              .add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                  CONSISTENT_TYPE_NO_TYPE_PARAMETER_AND_CLASSIFIER, EcorePlugin.INSTANCE
                      .getString("_UI_EGenericTypeNoTypeParameterAndClassifier_diagnostic"),
                  new Object[] { eGenericType }));
        }
      }

      // The referencing generic type must be contained to be in scope
      //
      EObject scope = eTypeParameter.eContainer();
      boolean inScope = EcoreUtil.isAncestor(scope, eGenericType);
      if (inScope)
      {
        // And even if it is contained, it must not be a forward reference.
        // eTypeParameterIndex == index is allowed when the type parameter is
        // the type argument of the bound, though
        //
        List<?> typeParameters = (List<?>)scope.eGet(eTypeParameter.eContainmentFeature());
        EObject usage = eGenericType;
        for (EObject container = usage.eContainer(); container != scope; container = container.eContainer())
        {
          usage = container;
        }
        int index = typeParameters.indexOf(usage);
        int eTypeParameterIndex = typeParameters.indexOf(eTypeParameter);
        inScope = index == -1
            || index > eTypeParameterIndex
            || (index == eTypeParameterIndex && eGenericType.eContainingFeature() == EcorePackage.Literals.EGENERIC_TYPE__ETYPE_ARGUMENTS);
      }

      if (!inScope)
      {
        // The type parameter must be in scope and must not be a forward
        // reference.
        //
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
              CONSISTENT_TYPE_TYPE_PARAMETER_NOT_IN_SCOPE, EcorePlugin.INSTANCE
                  .getString("_UI_EGenericTypeOutOfScopeTypeParameter_diagnostic"), new Object[] { eGenericType }));
        }
      }
    }

    EReference eContainmentFeature = eGenericType.eContainmentFeature();
    if (eContainmentFeature == EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES)
    {
      // When used as a generic super type, there must be a classifier that
      // refers to a class.
      //
      if (!(eGenericType.getEClassifier() instanceof EClass))
      {
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_TYPE_CLASS_REQUIRED,
              EcorePlugin.INSTANCE.getString("_UI_EGenericTypeNoClass_diagnostic"), new Object[] { eGenericType }));
        }
      }
    }
    else if (eContainmentFeature == EcorePackage.Literals.EGENERIC_TYPE__ETYPE_ARGUMENTS)
    {
      if (eGenericType.eContainer().eContainmentFeature() == EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES)
      {
        // The type arguments of a generic super type must not be a wildcard.
        //
        if (eClassifier == null && eTypeParameter == null)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            diagnostics
                .add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_TYPE_WILDCARD_NOT_PERMITTED,
                    EcorePlugin.INSTANCE.getString("_UI_EGenericTypeNoTypeParameterOrClassifier_diagnostic"),
                    new Object[] { eGenericType }));
          }
        }
      }
    }
    else if (eContainmentFeature != null)
    {
      // Wildcards are only allowed in type arguments.
      //
      if (eClassifier == null && eTypeParameter == null)
      {
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
              CONSISTENT_TYPE_WILDCARD_NOT_PERMITTED, EcorePlugin.INSTANCE
                  .getString("_UI_EGenericTypeNoTypeParameterOrClassifier_diagnostic"), new Object[] { eGenericType }));
        }
      }
      else if (eClassifier != null)
      {
        EObject eContainer = eGenericType.eContainer();
        if (eContainer instanceof EStructuralFeature)
        {
          if (eClassifier instanceof EClass)
          {
            if (eContainer instanceof EAttribute)
            {
              // The classifier of an attribute's generic type must be a data
              // type.
              //
              if (diagnostics == null)
              {
                return false;
              }
              else
              {
                result = false;
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                    CONSISTENT_TYPE_CLASS_NOT_PERMITTED, EcorePlugin.INSTANCE
                        .getString("_UI_EAttributeNoDataType_diagnostic"), new Object[] { eGenericType }));
              }
            }
          }
          else if (eClassifier instanceof EDataType)
          {
            if (eContainer instanceof EReference)
            {
              // The classifier of an references's generic type must be a class.
              //
              if (diagnostics == null)
              {
                return false;
              }
              else
              {
                result = false;
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                    CONSISTENT_TYPE_DATA_TYPE_NOT_PERMITTED, EcorePlugin.INSTANCE
                        .getString("_UI_EReferenceNoClass_diagnostic"), new Object[] { eGenericType }));
              }
            }
          }
        }
      }
    }

    if (eClassifier != null && eContainmentFeature != null
        && eContainmentFeature != EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE)
    {
      // A primitive type can only be used as the generic type of a typed
      // element.
      //
      String instanceClassName = eClassifier.getInstanceClassName();
      if (instanceClassName == "boolean" || instanceClassName == "byte" || instanceClassName == "char"
          || instanceClassName == "double" || instanceClassName == "float" || instanceClassName == "int"
          || instanceClassName == "long" || instanceClassName == "short")
      {
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
              CONSISTENT_TYPE_PRIMITIVE_TYPE_NOT_PERMITTED, EcorePlugin.INSTANCE.getString(
                  "_UI_EGenericTypeInvalidPrimitiveType_diagnostic", new Object[] { instanceClassName }),
              new Object[] { eGenericType }));
        }
      }
    }
    return result;
  }

  /**
   * Validates the ConsistentBounds constraint of '<em>EGeneric Type</em>'.
   * <!-- begin-user-doc --> A generic type may have bounds only when used as a
   * {@link EGenericType#getETypeArguments() type argument}. A generic type may
   * not have both a {@link EGenericType#getELowerBound() lower} and an
   * {@link EGenericType#getEUpperBound() upper bound}. A generic type may not
   * have bounds as well as a {@link EGenericType#getEClassifier() classifier}
   * or a {@link EGenericType#getETypeParameter() type parameter}. <!--
   * end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEGenericType_ConsistentBounds(EGenericType eGenericType, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;

    EGenericType eLowerBound = eGenericType.getELowerBound();
    EGenericType eUpperBound = eGenericType.getEUpperBound();
    if (eLowerBound != null || eUpperBound != null)
    {
      EStructuralFeature eContainmentFeature = eGenericType.eContainmentFeature();
      if (eContainmentFeature == EcorePackage.Literals.EGENERIC_TYPE__ETYPE_ARGUMENTS)
      {
        // Can't have both an upper and lower bound.
        //
        if (eLowerBound != null && eUpperBound != null)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                CONSISTENT_BOUNDS_NO_LOWER_AND_UPPER, EcorePlugin.INSTANCE
                    .getString("_UI_EGenericTypeNoUpperAndLowerBound_diagnostic"), new Object[] { eGenericType }));
          }
        }

        // Can't have a classifier or a type parameter as well as bounds.
        //
        if (eGenericType.getEClassifier() != null || eGenericType.getETypeParameter() != null)
        {
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                CONSISTENT_BOUNDS_NO_BOUNDS_WITH_TYPE_PARAMETER_OR_CLASSIFIER, EcorePlugin.INSTANCE
                    .getString("_UI_EGenericTypeNoTypeParameterOrClassifierAndBound_diagnostic"),
                new Object[] { eGenericType }));
          }
        }
      }
      else
      {
        // Can only have bounds when used as a type argument.
        //
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_BOUNDS_NOT_ALLOWED,
              EcorePlugin.INSTANCE.getString("_UI_EGenericTypeBoundsOnlyForTypeArgument_diagnostic"),
              new Object[] { eGenericType }));
        }
      }
    }
    return result;
  }

  /**
   * Validates the ConsistentArguments constraint of '<em>EGeneric Type</em>'.
   * <!-- begin-user-doc --> A generic type can have
   * {@link EGenericType#getETypeArguments() type arguments} only if it has a
   * {@link EGenericType#getEClassifier() classifier} that specifies
   * {@link EClassifier#getETypeParameters()}; the number of type arguments
   * must match the number of type parameters. It is only a warning for there to
   * be no arguments when there are parameters, but any other mismatch is an
   * error. <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean validateEGenericType_ConsistentArguments(EGenericType eGenericType, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = true;
    EClassifier eClassifier = eGenericType.getEClassifier();
    EList<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
    int eTypeArgumentSize = eTypeArguments.size();
    if (eClassifier == null)
    {
      if (eTypeArgumentSize != 0)
      {
        // Can't have type arguments unless there is a classifier
        //
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, CONSISTENT_ARGUMENTS_NONE_ALLOWED,
              EcorePlugin.INSTANCE.getString("_UI_EGenericTypeNoArguments_diagnostic"), new Object[] { eGenericType }));

        }
      }
    }
    else
    {
      EList<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
      int eTypeParameterSize = eTypeParameters.size();
      if (eTypeArgumentSize == 0)
      {
        if (eTypeParameterSize > 0)
        {
          // Have no arguments when they are allowed is only a warning.
          //
          if (diagnostics == null)
          {
            return false;
          }
          else
          {
            result = false;
            diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, CONSISTENT_ARGUMENTS_NONE,
                EcorePlugin.INSTANCE.getString("_UI_EGenericTypeArgumentsNeeded_diagnostic", new Object[] {
                    eClassifier.getName(), eTypeParameterSize }), new Object[] { eGenericType }));

          }
        }
      }
      else if (eTypeArgumentSize != eTypeParameters.size())
      {
        // Incorrect number of type arguments.
        //
        if (diagnostics == null)
        {
          return false;
        }
        else
        {
          result = false;
          diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
              CONSISTENT_ARGUMENTS_INCORRECT_NUMBER, EcorePlugin.INSTANCE.getString(
                  "_UI_EGenericTypeIncorrectArguments_diagnostic", new Object[] { eClassifier.getName(),
                      eTypeArgumentSize, eTypeParameterSize }), new Object[] { eGenericType }));

        }
      }
      else
      {
        Map<ETypeParameter, EGenericType> substitutions = new HashMap<ETypeParameter, EGenericType>();
        for (int i = 0; i < eTypeParameterSize; ++i)
        {
          ETypeParameter eTypeParameter = eTypeParameters.get(i);
          EGenericType eTypeArgument = eTypeArguments.get(i);
          if (isValidSubstitution(eTypeArgument, eTypeParameter, substitutions))
          {
            substitutions.put(eTypeParameter, eTypeArgument);
          }
          else
          {
            if (diagnostics == null)
            {
              return false;
            }
            else
            {
              result = false;
              diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
                  CONSISTENT_ARGUMENTS_INVALID_SUBSTITUTION, EcorePlugin.INSTANCE.getString(
                      "_UI_EGenericTypeArgumentInvalidSubstitution_diagnostic", new Object[] {
                          getObjectLabel(eTypeArgument, context), getObjectLabel(eTypeParameter, context) }),
                  new Object[] { eGenericType, eTypeArgument, eTypeParameter }));

            }
          }
        }
      }
    }
    return result;
  }

  /**
   * Returns whether the generic type argument is a valid substitution for the
   * type parameter. A generic type is a valid substitution if it is
   * {@link #isBounded(EGenericType, EGenericType, Map) bounded} by every
   * {@link ETypeParameter#getEBounds() bound} of the type parameter. It follows
   * that for a type parameter without bounds, every type argument is a valid
   * substitution.
   * 
   * @param eTypeArgument
   *          the generic type argument to consider.
   * @param eTypeParameter
   *          the type parameter in question.
   * @return whether the generic type argument is a valid substitution for the
   *         type parameter.
   */
  protected boolean isValidSubstitution(EGenericType eTypeArgument, ETypeParameter eTypeParameter,
      Map<ETypeParameter, EGenericType> substitutions)
  {
    EList<EGenericType> eBounds = eTypeParameter.getEBounds();
    if (!eBounds.isEmpty())
    {
      if (eTypeArgument.getEClassifier() == null && eTypeArgument.getETypeParameter() == null
          && eTypeArgument.getEUpperBound() == null && eTypeArgument.getELowerBound() == null)
      {
        return true;
      }
      for (EGenericType eBound : eBounds)
      {
        if (!isBounded(eTypeArgument, eBound, substitutions))
        {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns whether the first generic type is bounded by the second. If they
   * both reference a classifier, then the classifier of the first must be
   * bounded by the classifier of the second, and the type arguments must
   * {@link #matchingTypeArguments(EList, EList, Map) match}. A classifier is
   * bounded by another classifier, if they are the same classifier, if both are
   * classes and the first is a {@link EClass#isSuperTypeOf(EClass)} the second,
   * or if both have an non-null
   * {@link EClassifier#getInstanceClass() instance class} for which the first
   * is {@link Class#isAssignableFrom(Class) assignable from} the second, or,
   * failing all these, if they have non-null
   * {@link EClassifier#getInstanceTypeName()} that are equal. If the bound
   * references a classifier, and the generic type argument references a type
   * parameter, one of the {@link ETypeParameter#getEBounds() bounds} of that
   * type parameter must be bounded by bound. If the bound has a
   * {@link EGenericType#getELowerBound() lower bound}, the generic type
   * argument must be bounded by that lower bound. If the bound has an
   * {@link EGenericType#getEUpperBound() upper bound}, the generic type
   * argument must be bounded by that upper bound. If the bound references a
   * type parameter, the generic type argument must be bounded by every bound of
   * that type parameter. If the bound has a lower bound, the generic type
   * argument must be bounded by it. If the bound has an upper bound, the
   * generic type argument must be bound that upper bound. Failing all these
   * cases, the bound is a wildcard with no constraint, and the type argument is
   * bounded.
   * 
   * @param eGenericType
   *          the generic type in question.
   * @param eBound
   *          the bound it's being assessed against.
   * @param substitutions
   *          the map of substitutions that are in effect.
   * @return whether the first generic type is bounded by the second.
   */
  public static boolean isBounded(EGenericType eGenericType, EGenericType eBound,
      Map<? extends ETypeParameter, ? extends EGenericType> substitutions)
  {
    if (eGenericType == eBound)
    {
      return true;
    }

    // Check if the bound specifies a classifier...
    //
    EClassifier eBoundEClassifier = eBound.getEClassifier();
    if (eBoundEClassifier != null)
    {
      // If the type also specifies a classifier...
      //
      EClassifier eClassifier = eGenericType.getEClassifier();
      if (eClassifier != null)
      {
        // If the are the same then it is bounded properly...
        //
        if (eBoundEClassifier != eClassifier)
        {
          // We test their relationship either via them both being classes...
          //
          if (eBoundEClassifier instanceof EClass && eClassifier instanceof EClass)
          {
            if (!((EClass)eBoundEClassifier).isSuperTypeOf((EClass)eClassifier))
            {
              return false;
            }
          }
          else
          {
            // Or we test their relationship via their instance classes, if they
            // have them.
            //
            Class<?> eBoundClass = eBoundEClassifier.getInstanceClass();
            if (eBoundClass != null)
            {
              Class<?> eClassifierClass = eClassifier.getInstanceClass();
              if (eClassifierClass != null && !eBoundClass.isAssignableFrom(eClassifierClass))
              {
                return false;
              }
            }
          }
        }

        // If neither approach finds a contradiction, we must assume they are
        // okay and then check all the arguments.
        // TODO What about the fact that we should be matching its type argument
        // structure?
        //
        return matchingTypeArguments(eGenericType.getETypeArguments(), eBound.getETypeArguments(), substitutions);
      }
      else
      {
        ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
        if (eTypeParameter != null)
        {
          EGenericType substitution = substitutions.get(eTypeParameter);
          if (substitution != null)
          {
            return isBounded(substitution, eBound, substitutions);
          }
          else
          {
            // If there is a type parameter, one of its bounds must be bounded
            // by the bound.
            //
            boolean result = false;
            for (EGenericType eTypeParameterBound : eTypeParameter.getEBounds())
            {
              if (isBounded(eTypeParameterBound, eBound, substitutions))
              {
                result = true;
                break;
              }
            }
            return result;
          }
        }
        else
        {
          // If there is a upper bound, the bound must bound it.
          //
          EGenericType eUpperBound = eGenericType.getEUpperBound();
          if (eUpperBound != null)
          {
            return isBounded(eUpperBound, eBound, substitutions);
          }
          else
          {
            // Failing all those cases, there must be an lower bound that bounds
            // it.
            //
            EGenericType eLowerBound = eGenericType.getELowerBound();
            return eLowerBound != null && isBounded(eLowerBound, eBound, substitutions);
          }
        }
      }
    }
    else
    {
      ETypeParameter eBoundETypeParameter = eBound.getETypeParameter();
      if (eBoundETypeParameter != null)
      {
        ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
        if (eTypeParameter == eBoundETypeParameter)
        {
          return true;
        }
        else
        {
          EGenericType substitution = substitutions.get(eBoundETypeParameter);
          if (substitution != null)
          {
            return isBounded(eGenericType, substitution, substitutions);
          }
          else if (eTypeParameter != null)
          {
            substitution = substitutions.get(eTypeParameter);
            if (substitution != null)
            {
              return isBounded(substitution, eBound, substitutions);
            }
            else
            {
              boolean result = false;
              for (EGenericType eTypeParameterEBound : eTypeParameter.getEBounds())
              {
                if (!(result = isBounded(eTypeParameterEBound, eBound, substitutions)))
                {
                  for (EGenericType eBoundETypeParameterEBound : eBoundETypeParameter.getEBounds())
                  {
                    if (isBounded(eTypeParameterEBound, eBoundETypeParameterEBound, substitutions))
                    {
                      result = true;
                      break;
                    }
                  }
                }
                if (!result)
                {
                  return false;
                }
              }
              return result;
            }
          }
          else
          {
            if (eGenericType.getEUpperBound() != null)
            {
              return isBounded(eGenericType.getEUpperBound(), eBound, substitutions);
            }
            else
            {
              return false;
            }
          }
        }
      }
      else
      {
        // If the generic type is a wildcard, it can't be bounded by another
        // wildcard.
        //
        if (eGenericType.getETypeParameter() == null && eGenericType.getEClassifier() == null)
        {
          return false;
        }
        EGenericType eBoundEUpperBound = eBound.getEUpperBound();
        if (eBoundEUpperBound != null)
        {
          return isBounded(eGenericType, eBoundEUpperBound, substitutions);
        }
        else
        {
          EGenericType eBoundELowerBound = eBound.getELowerBound();
          if (eBoundELowerBound != null)
          {
            // If there is an lower bound, the type argument must bound it.
            //
            return isBounded(eBoundELowerBound, eGenericType, substitutions);
          }

          // The bound is a wildcard with no constraints.
          //
          return false;
        }
      }
    }
  }

  public static boolean matchingTypeArguments(EList<EGenericType> eTypeArguments1, EList<EGenericType> eTypeArguments2,
      Map<? extends ETypeParameter, ? extends EGenericType> substitutions)
  {
    int size = eTypeArguments1.size();
    if (size != eTypeArguments2.size())
    {
      return false;
    }
    else
    {
      for (int i = 0; i < size; ++i)
      {
        EGenericType eTypeArgument1 = eTypeArguments1.get(i);
        EGenericType eTypeArgument2 = eTypeArguments2.get(i);
        if (!isMatching(eTypeArgument1, eTypeArgument2, substitutions))
        {
          return false;
        }
      }
      return true;
    }
  }

  public static boolean isMatching(EGenericType eGenericType, EGenericType eBound,
      Map<? extends ETypeParameter, ? extends EGenericType> substitutions)
  {
    if (eGenericType == eBound)
    {
      return true;
    }

    // Check if the bound specifies a classifier...
    //
    EClassifier eBoundEClassifier = eBound.getEClassifier();
    if (eBoundEClassifier != null)
    {
      // If the type also specifies a classifier...
      //
      EClassifier eClassifier = eGenericType.getEClassifier();
      if (eClassifier != null)
      {
        // If they are the same classifier, they are of course equal.
        //
        if (eClassifier != eBoundEClassifier)
        {
          // Consider the instance type names they wrap
          // to see if they are non-null and equal.
          //
          String instanceTypeName1 = eClassifier.getInstanceTypeName();
          String instanceTypeName2 = eBoundEClassifier.getInstanceTypeName();

          // I.e., the classifiers are considered equal if they wrap the same
          // non-null type.
          //
          if (instanceTypeName1 == null || !instanceTypeName2.equals(instanceTypeName2))
          {
            return false;
          }
        }

        // TODO What about the instance type name and the fact that we should be
        // matching its type argument structure?
        // If they match so far, we must assume they are okay and then check all
        // the arguments.
        //
        return equalTypeArguments(eGenericType.getETypeArguments(), eBound.getETypeArguments(), substitutions);
      }
      else
      {
        return false;
      }
    }
    else
    {
      ETypeParameter eBoundETypeParameter = eBound.getETypeParameter();
      if (eBoundETypeParameter != null)
      {
        ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
        if (eTypeParameter == eBoundETypeParameter)
        {
          return true;
        }
        else
        {
          EGenericType substitution = substitutions.get(eTypeParameter);
          if (substitution != null)
          {
            return isMatching(substitution, eBound, substitutions);
          }
          else if ((substitution = substitutions.get(eBoundETypeParameter)) != null)
          {
            return isMatching(eGenericType, substitution, substitutions);
          }
          else
          {
            return false;
          }
        }
      }
      else
      {
        // If the generic type is a different wildcard, it doesn't match.
        //
        if (eGenericType.getEClassifier() == null && eGenericType.getETypeParameter() == null)
        {
          return isMatching(eGenericType.getELowerBound(), eBound.getELowerBound(), substitutions)
              && isMatching(eGenericType.getEUpperBound(), eBound.getEUpperBound(), substitutions);
        }
        else
        {
          EGenericType eBoundEUpperBound = eBound.getEUpperBound();
          if (eBoundEUpperBound != null)
          {
            return isBounded(eGenericType, eBoundEUpperBound, substitutions);
          }
          else
          {
            EGenericType eBoundELowerBound = eBound.getELowerBound();
            if (eBoundELowerBound != null)
            {
              // Reverse the test.
              //
              return isMatching(eBoundELowerBound, eGenericType, substitutions);
            }

            // The bound is a wildcard with no constraints.
            //
            return true;
          }
        }
      }
    }
  }

  public static boolean equalTypeArguments(EList<EGenericType> eTypeArguments1, EList<EGenericType> eTypeArguments2,
      Map<? extends ETypeParameter, ? extends EGenericType> substitutions)
  {
    int size = eTypeArguments1.size();
    if (size != eTypeArguments2.size())
    {
      return false;
    }
    else
    {
      for (int i = 0; i < size; ++i)
      {
        EGenericType eTypeArgument1 = eTypeArguments1.get(i);
        EGenericType eTypeArgument2 = eTypeArguments2.get(i);
        if (!equalTypeArguments(eTypeArgument1, eTypeArgument2, substitutions))
        {
          return false;
        }
      }
      return true;
    }
  }

  public static boolean equalTypeArguments(EGenericType eGenericType1, EGenericType eGenericType2,
      Map<? extends ETypeParameter, ? extends EGenericType> substitutions)
  {
    // If they are the same instance they are equal.
    //
    if (eGenericType1 == eGenericType2)
    {
      return true;
    }
    // If one is null (but the other is not) then they are not equal.
    //
    else if (eGenericType1 == null || eGenericType2 == null)
    {
      return false;
    }
    else
    {
      // Consider the classifiers in a special way
      // to take into account the fact they they often acts as wrappers for
      // instance type names
      // and that two classifiers that wrap the same instance type name should
      // be considered equal.
      //
      EClassifier eClassifier1 = eGenericType1.getEClassifier();
      EClassifier eClassifier2 = eGenericType2.getEClassifier();

      // If they are the same classifier, they are of course equal.
      //
      if (eClassifier1 != eClassifier2)
      {
        // If they both aren't null...
        //
        if (eClassifier1 != null && eClassifier2 != null)
        {
          // Consider the instance type names they wrap
          // to see if they are non-null and equal.
          //
          String instanceTypeName1 = eClassifier1.getInstanceTypeName();
          String instanceTypeName2 = eClassifier2.getInstanceTypeName();

          // I.e., the classifiers are considered equal if they wrap the same
          // non-null type.
          //
          if (instanceTypeName1 == null || !instanceTypeName2.equals(instanceTypeName2))
          {
            return false;
          }
        }
        // If one is null (but the other is not) then they can't be equal.
        //
        else if (eClassifier1 != null || eClassifier2 != null)
        {
          return false;
        }
      }

      ETypeParameter eTypeParameter1 = eGenericType1.getETypeParameter();
      EGenericType substitution = substitutions.get(eTypeParameter1);
      if (substitution != null)
      {
        return equalTypeArguments(substitution, eGenericType2, substitutions);
      }
      ETypeParameter eTypeParameter2 = eGenericType2.getETypeParameter();
      substitution = substitutions.get(eTypeParameter2);
      if (substitution != null)
      {
        return equalTypeArguments(eGenericType1, substitution, substitutions);
      }

      // The arguments, type parameters, lower bounds and upper bounds must be
      // equal type arguments.
      //
      return eTypeParameter1 == eTypeParameter2
          && equalTypeArguments(eGenericType1.getETypeArguments(), eGenericType2.getETypeArguments(), substitutions)
          && equalTypeArguments(eGenericType1.getELowerBound(), eGenericType2.getELowerBound(), substitutions)
          && equalTypeArguments(eGenericType1.getEUpperBound(), eGenericType2.getEUpperBound(), substitutions);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateETypeParameter(ETypeParameter eTypeParameter, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    boolean result = validate_EveryMultiplicityConforms(eTypeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eTypeParameter, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(eTypeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(eTypeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(eTypeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(eTypeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eTypeParameter, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateENamedElement_WellFormedName(eTypeParameter, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEBigDecimal(BigDecimal eBigDecimal, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEBigInteger(BigInteger eBigInteger, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEBoolean(boolean eBoolean, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEBooleanObject(Boolean eBooleanObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEByte(byte eByte, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEByteArray(byte[] eByteArray, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEByteObject(Byte eByteObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEChar(char eChar, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateECharacterObject(Character eCharacterObject, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEDate(Date eDate, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEDiagnosticChain(DiagnosticChain eDiagnosticChain, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEDouble(double eDouble, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEDoubleObject(Double eDoubleObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEEList(EList<?> eeList, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEEnumerator(Enumerator eEnumerator, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEFeatureMap(FeatureMap eFeatureMap, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEFeatureMapEntry(FeatureMap.Entry eFeatureMapEntry, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEFloat(float eFloat, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEFloatObject(Float eFloatObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEInt(int eInt, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEIntegerObject(Integer eIntegerObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEJavaClass(Class<?> eJavaClass, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEJavaObject(Object eJavaObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateELong(long eLong, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateELongObject(Long eLongObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEMap(Map<?, ?> eMap, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEResource(Resource eResource, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEResourceSet(ResourceSet eResourceSet, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEShort(short eShort, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEShortObject(Short eShortObject, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateEString(String eString, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean validateETreeIterator(TreeIterator<?> eTreeIterator, DiagnosticChain diagnostics,
      Map<Object, Object> context)
  {
    return true;
  }

  /**
   * A utility for parsing generic types and generic type parameters.
   * 
   * @since 2.3
   */
  public static class EGenericTypeBuilder
  {
    /**
     * A singleton instance of the generic type build.
     */
    public static final EGenericTypeBuilder INSTANCE = new EGenericTypeBuilder();

    /**
     * Parses an instance type name and returns a diagnostic representing the
     * result of the analysis. The {@link Diagnostic#getData() data} of the
     * diagnostic will contain as the first object, the resulting
     * {@link EGenericType generic type}.
     * 
     * @param instanceTypeName
     *          an instance type name.
     * @return the diagnostic result of the analysis.
     */
    public Diagnostic parseInstanceTypeName(final String instanceTypeName)
    {
      return new BasicDiagnostic()
      {
        {
          source = DIAGNOSTIC_SOURCE;
          code = WELL_FORMED_INSTANCE_TYPE_NAME;
          message = EcorePlugin.INSTANCE.getString("_UI_EClassifierInstanceTypeNameAnalysisResult_diagnostic",
              new Object[] { instanceTypeName });
          char[] instanceTypeNameCharacterArray = instanceTypeName.toCharArray();
          EGenericType eGenericType = handleInstanceTypeName(instanceTypeNameCharacterArray, 0,
              instanceTypeNameCharacterArray.length, this);
          data = dataAsList(new Object[] { eGenericType, instanceTypeName });
        }
      };
    }

    /**
     * Parses a list of type parameters and returns a diagnostic representing
     * the result of the analysis. The {@link Diagnostic#getData() data} of the
     * diagnostic will contain as the first object, the resulting list of
     * {@link ETypeParameter type parameters}.
     * 
     * @param typeParameterList
     *          a comma separated list of type parameters delimited by '&lt;'
     *          and '>'.
     * @return the diagnostic result of the analysis.
     */
    public Diagnostic parseTypeParameterList(final String typeParameterList)
    {
      return new BasicDiagnostic()
      {
        {
          source = DIAGNOSTIC_SOURCE;
          code = WELL_FORMED_INSTANCE_TYPE_NAME;
          message = EcorePlugin.INSTANCE.getString("_UI_EClassifierInstanceTypeNameAnalysisResult_diagnostic",
              new Object[] { typeParameterList });
          char[] instanceTypeNameCharacterArray = typeParameterList.toCharArray();
          List<ETypeParameter> eTypeParameters = handleTypeParameters(instanceTypeNameCharacterArray, 0,
              instanceTypeNameCharacterArray.length, this);
          data = dataAsList(new Object[] { eTypeParameters, typeParameterList });
        }
      };
    }

    /**
     * Parses a type parameter and returns a diagnostic representing the result
     * of the analysis. The {@link Diagnostic#getData() data} of the diagnostic
     * will contain as the first object, the resulting
     * {@link ETypeParameter type parameter}.
     * 
     * @param typeParameter
     *          comma separated list of type parameters delimited by '&lt;' and
     *          '>'.
     * @return the diagnostic result of the analysis.
     */
    public Diagnostic parseTypeParameter(final String typeParameter)
    {
      return new BasicDiagnostic()
      {
        {
          source = DIAGNOSTIC_SOURCE;
          code = WELL_FORMED_INSTANCE_TYPE_NAME;
          message = EcorePlugin.INSTANCE.getString("_UI_EClassifierInstanceTypeNameAnalysisResult_diagnostic",
              new Object[] { typeParameter });
          char[] instanceTypeNameCharacterArray = typeParameter.toCharArray();
          ETypeParameter eTypeParameter = handleTypeParameter(instanceTypeNameCharacterArray, 0,
              instanceTypeNameCharacterArray.length, this);
          data = dataAsList(new Object[] { eTypeParameter, typeParameter });
        }
      };
    }

    /**
     * Finds or creates an {@link EClassifier classifier} with the given
     * instance type name.
     * 
     * @param instanceTypeName
     *          the instance type name for which a classifier is needed.
     * @return a classifier with the instance type name.
     */
    protected EClassifier resolveEClassifier(String instanceTypeName)
    {
      EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
      eDataType.setInstanceTypeName(instanceTypeName);
      return eDataType;
    }

    /**
     * Creates a new diagnostic for a problem at the given index.
     * 
     * @param diagnostics
     *          the target for the new diagnostic.
     * @param message
     *          the text describing the problem.
     * @param index
     *          the index at which the problem occurred.
     */
    protected void report(DiagnosticChain diagnostics, String message, int index)
    {
      if (diagnostics != null)
      {
        diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, WELL_FORMED_INSTANCE_TYPE_NAME,
            message, new Object[] { index }));
      }
    }

    /**
     * A well formed instance type name must syntactically denote a valid Java
     * type name; names denoting keywords are considered well formed. It must
     * start with a qualified name consisting of one or more "." separated
     * identifiers, where each identifier must start with a
     * {@link Character#isJavaIdentifierStart(int) Java identifier start character},
     * that is followed by zero or more
     * {@link Character#isJavaIdentifierPart(int) Java identifier part characters}.
     * The methods {@link #isIdentifierStart(int)} and
     * {@link #isIdentifierPart(int)} are used so that this behavior can be
     * specialized. This qualified name may optionally be followed by zero or
     * more pairs of "[]" characters or by type arguments consisting of the pair
     * of "&lt;>" characters with embedded
     * {@link #handleTypeArguments(char[], int, int, DiagnosticChain) well formed type arguments}.
     * 
     * @param instanceTypeName
     *          the instance type name in question.
     * @param start
     *          the start of the characters under consideration.
     * @param end
     *          the end of the characters under consideration.
     * @param diagnostics
     *          the target in which to accumulate diagnostics.
     * @return the generic type representing the instance type name.
     */
    protected EGenericType handleInstanceTypeName(char[] instanceTypeName, int start, int end,
        DiagnosticChain diagnostics)
    {
      EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
      StringBuilder qualifiedName = new StringBuilder();
      int identifierStart = -1;
      int identifierLast = -1;
      int brackets = 0;
      List<EGenericType> typeArguments = null;
      LOOP: for (int i = start; i < end; i = Character.offsetByCodePoints(instanceTypeName, 0, instanceTypeName.length,
          i, 1))
      {
        int codePoint = Character.codePointAt(instanceTypeName, i);
        if (codePoint == '[')
        {
          if (identifierStart == -1
              && (qualifiedName.length() == 0 || qualifiedName.charAt(qualifiedName.length() - 1) == '.'))
          {
            report(diagnostics, EcorePlugin.INSTANCE.getString(
                "_UI_EClassifierInstanceTypeNameBracketWithoutPrecedingIdentifier_diagnostic", new Object[] { i }), i);
            return eGenericType;
          }
          else
          {
            for (int j = i + 1; j < end; j = Character.offsetByCodePoints(instanceTypeName, 0, instanceTypeName.length,
                j, 1))
            {
              codePoint = Character.codePointAt(instanceTypeName, j);
              if (codePoint == ']')
              {
                i = j;
                ++brackets;
                continue LOOP;
              }
              else if (!Character.isWhitespace(codePoint))
              {
                report(diagnostics, EcorePlugin.INSTANCE.getString(
                    "_UI_EClassifierInstanceTypeNameNoClosingBracket2_diagnostic", new Object[] { j,
                        new String(Character.toChars(codePoint)) }), j);
                return eGenericType;
              }
            }
            report(diagnostics, EcorePlugin.INSTANCE.getString(
                "_UI_EClassifierInstanceTypeNameNoClosingBracket_diagnostic", new Object[] { end }), end);
            return eGenericType;
          }
        }
        else if (brackets > 0)
        {
          if (!Character.isWhitespace(codePoint))
          {
            report(diagnostics, EcorePlugin.INSTANCE.getString(
                "_UI_EClassifierInstanceTypeNameBracketExpected_diagnostic", new Object[] { i,
                    new String(Character.toChars(codePoint)) }), i);
            return eGenericType;
          }
        }
        else if (codePoint == '.')
        {
          if (identifierStart == -1)
          {
            if (qualifiedName.length() == 0 || qualifiedName.charAt(qualifiedName.length() - 1) == '.')
            {
              report(diagnostics, EcorePlugin.INSTANCE.getString(
                  "_UI_EClassifierInstanceTypeNameDotWithoutPrecedingIdentifier_diagnostic", new Object[] { i }), i);
              return eGenericType;
            }
            else
            {
              qualifiedName.append('.');
            }
          }
          else
          {
            qualifiedName.append(instanceTypeName, identifierStart, identifierLast - identifierStart + 1);
            qualifiedName.append('.');
            identifierStart = -1;
            identifierLast = -1;
          }
        }
        else if (identifierStart != -1 ? isIdentifierPart(codePoint) : isIdentifierStart(codePoint))
        {
          if (identifierStart == -1)
          {
            if (qualifiedName.length() > 0 && qualifiedName.charAt(qualifiedName.length() - 1) != '.')
            {
              report(diagnostics, EcorePlugin.INSTANCE.getString(
                  "_UI_EClassifierInstanceTypeNameDotExpectedBeforeIdentifier_diagnostic", new Object[] { i }), i);
              return eGenericType;
            }
            identifierStart = i;
          }
          identifierLast = i;
        }
        else if (Character.isWhitespace(codePoint))
        {
          if (identifierStart == -1)
          {
            // Ignore leading whitespace
          }
          else if (qualifiedName.length() == 0 || qualifiedName.charAt(qualifiedName.length() - 1) == '.')
          {
            qualifiedName.append(instanceTypeName, identifierStart, identifierLast - identifierStart + 1);
            identifierStart = -1;
            identifierLast = -1;
          }
          else
          {
            // Ignore trailing whitespace
          }
        }
        else if (codePoint == '<')
        {
          if (identifierStart == -1
              && (qualifiedName.length() == 0 || qualifiedName.charAt(qualifiedName.length() - 1) == '.'))
          {
            report(diagnostics,
                EcorePlugin.INSTANCE.getString(
                    "_UI_EClassifierInstanceTypeNameAngleBracketWithoutPrecedingIdentifier_diagnostic",
                    new Object[] { i }), i);
            return eGenericType;
          }
          for (int j = end - 1; j > i; --j)
          {
            if (instanceTypeName[j] == '>')
            {
              typeArguments = handleTypeArguments(instanceTypeName, i + 1, j, diagnostics);
              i = j;
              continue LOOP;
            }
          }
          report(diagnostics, EcorePlugin.INSTANCE.getString(
              "_UI_EClassifierInstanceTypeNameUnterminatedAngleBracket_diagnostic", new Object[] { i }), i);
          return eGenericType;
        }
        else
        {
          report(diagnostics, EcorePlugin.INSTANCE.getString(
              "_UI_EClassifierInstanceTypeNameUnexpectedCharacter_diagnostic", new Object[] { i,
                  new String(Character.toChars(codePoint)) }), i);
          return eGenericType;
        }
      }

      if (identifierStart == -1
          && (qualifiedName.length() == 0 || qualifiedName.charAt(qualifiedName.length() - 1) == '.'))
      {
        report(diagnostics, EcorePlugin.INSTANCE.getString(
            "_UI_EClassifierInstanceTypeNameExpectingIdentifier_diagnostic", new Object[] { end }), end);
      }
      else
      {
        if (identifierStart != -1)
        {
          qualifiedName.append(instanceTypeName, identifierStart, identifierLast - identifierStart + 1);
        }
        while (brackets-- > 0)
        {
          qualifiedName.append("[]");
        }
        String qualifiedNameString = qualifiedName.toString();
        eGenericType.setEClassifier(resolveEClassifier(qualifiedNameString));
        if (typeArguments != null)
        {
          eGenericType.getETypeArguments().addAll(typeArguments);
        }
      }
      return eGenericType;
    }

    /**
     * Returns whether this code point is a valid start of an identifier.
     * 
     * @param codePoint
     *          the code point in question.
     * @return whether this code point is a valid start of an identifier.
     */
    protected boolean isIdentifierStart(int codePoint)
    {
      return Character.isJavaIdentifierStart(codePoint);
    }

    /**
     * Returns whether this code point is a valid part of an identifier, i.e.,
     * whether it's valid after the first character.
     * 
     * @param codePoint
     *          the code point in question.
     * @return whether this code point is a valid part of an identifier.
     */
    protected boolean isIdentifierPart(int codePoint)
    {
      return Character.isJavaIdentifierPart(codePoint);
    }

    /**
     * Well formed type arguments must syntactically denote a comma separated
     * sequence of
     * {@link #handleTypeArgument(char[], int, int, DiagnosticChain) well formed type arguments}.
     * Whitespace before or after arguments is ignored.
     * 
     * @param instanceTypeName
     *          the instance type name in question.
     * @param start
     *          the start of the characters under consideration.
     * @param end
     *          the end of the characters under consideration.
     * @param diagnostics
     *          the target in which to accumulate diagnostics.
     * @return a list of generic type representing the type arguments.
     */
    protected List<EGenericType> handleTypeArguments(char[] instanceTypeName, int start, int end,
        DiagnosticChain diagnostics)
    {
      List<EGenericType> result = new ArrayList<EGenericType>();
      int depth = 0;
      int typeArgumentStart = start;
      for (int i = start; i < end; i = Character.offsetByCodePoints(instanceTypeName, 0, instanceTypeName.length, i, 1))
      {
        int codePoint = Character.codePointAt(instanceTypeName, i);
        switch (codePoint)
        {
        case '<':
        {
          ++depth;
          break;
        }
        case '>':
        {
          --depth;
          break;
        }
        case ',':
        {
          if (depth == 0)
          {
            result.add(handleTypeArgument(instanceTypeName, typeArgumentStart, i, diagnostics));
            typeArgumentStart = i + 1;
          }
          break;
        }
        default:
        {
          if (typeArgumentStart == -1)
          {
            typeArgumentStart = i;
          }
          break;
        }
        }
      }
      result.add(handleTypeArgument(instanceTypeName, typeArgumentStart, end, diagnostics));
      return result;
    }

    /**
     * A well formed type argument must denote a valid Java type argument. It
     * may start with a "?" which may be optionally followed by the keyword
     * "extends" or "super" which in turn, when present, must be followed by a
     * {@link #handleInstanceTypeName(char[], int, int, DiagnosticChain) well formed type instance name}.
     * White space before the keyword is optional but at least one space
     * character is expected after the keyword. Otherwise, the whole string must
     * be a well formed instance type name.
     * 
     * @param instanceTypeName
     *          the instance type name in question.
     * @param start
     *          the start of the characters under consideration.
     * @param end
     *          the end of the characters under consideration.
     * @param diagnostics
     *          the target in which to accumulate diagnostics.
     * @return the generic type representing the type argument.
     */
    protected EGenericType handleTypeArgument(char[] instanceTypeName, int start, int end, DiagnosticChain diagnostics)
    {
      EGenericType eGenericType = null;
      int firstNonWhiteSpaceIndex = start;
      LOOP: for (int i = start; i < end; i = Character.offsetByCodePoints(instanceTypeName, 0, instanceTypeName.length,
          i, 1))
      {
        int codePoint = Character.codePointAt(instanceTypeName, i);
        switch (codePoint)
        {
        case '?':
        {
          if (eGenericType == null)
          {
            eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
            break;
          }
          else
          {
            report(diagnostics, EcorePlugin.INSTANCE.getString(
                "_UI_EClassifierInstanceTypeNameTooManyQuestionMarks_diagnostic", new Object[] { i }), i);
            break LOOP;
          }
        }
        case 'e':
        {
          if (eGenericType != null)
          {
            if (i + 7 < end && instanceTypeName[i + 1] == 'x' && instanceTypeName[i + 2] == 't'
                && instanceTypeName[i + 3] == 'e' && instanceTypeName[i + 4] == 'n' && instanceTypeName[i + 5] == 'd'
                && instanceTypeName[i + 6] == 's'
                && Character.isWhitespace(Character.codePointAt(instanceTypeName, i + 7)))
            {
              EGenericType eUpperBound = handleInstanceTypeName(instanceTypeName, Character.offsetByCodePoints(
                  instanceTypeName, 0, instanceTypeName.length, i + 6, 1), end, diagnostics);
              eGenericType.setEUpperBound(eUpperBound);
            }
            else
            {
              report(diagnostics, EcorePlugin.INSTANCE.getString(
                  "_UI_EClassifierInstanceTypeNameExpectingExtends_diagnostic", new Object[] { i }), i);
            }
          }
          else
          {
            eGenericType = handleInstanceTypeName(instanceTypeName, start, end, diagnostics);
          }
          break LOOP;
        }
        case 's':
        {
          if (eGenericType != null)
          {
            if (i + 5 < end && instanceTypeName[i + 1] == 'u' && instanceTypeName[i + 2] == 'p'
                && instanceTypeName[i + 3] == 'e' && instanceTypeName[i + 4] == 'r'
                && Character.isWhitespace(Character.codePointAt(instanceTypeName, i + 5)))
            {
              EGenericType eLowerBound = handleInstanceTypeName(instanceTypeName, Character.offsetByCodePoints(
                  instanceTypeName, 0, instanceTypeName.length, i + 4, 1), end, diagnostics);
              eGenericType.setELowerBound(eLowerBound);
            }
            else
            {
              report(diagnostics, EcorePlugin.INSTANCE.getString(
                  "_UI_EClassifierInstanceTypeNameExpectingSuper_diagnostic", new Object[] { i }), i);
            }
          }
          else
          {
            eGenericType = handleInstanceTypeName(instanceTypeName, start, end, diagnostics);
          }
          break LOOP;
        }
        default:
        {
          if (Character.isWhitespace(codePoint))
          {
            break;
          }
          else if (eGenericType != null)
          {
            report(diagnostics, EcorePlugin.INSTANCE.getString(
                "_UI_EClassifierInstanceTypeNameExpectingExtendsOrSuper_diagnostic", new Object[] { i }), i);
            break LOOP;
          }
          else
          {
            firstNonWhiteSpaceIndex = i;
            eGenericType = handleInstanceTypeName(instanceTypeName, i, end, diagnostics);
            break LOOP;
          }
        }
        }
      }
      if (eGenericType == null)
      {
        eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
        report(diagnostics,
            EcorePlugin.INSTANCE.getString("_UI_EClassifierInstanceTypeNameTypeArgumentExpected_diagnostic",
                new Object[] { firstNonWhiteSpaceIndex }), firstNonWhiteSpaceIndex);
      }
      return eGenericType;
    }

    /**
     * Well formed type parameters must syntactically denote a comma separated
     * sequence of
     * {@link #handleTypeParameter(char[], int, int, DiagnosticChain) well formed type parameters}
     * delimited by "&lt;>". Whitespace before or after parameters is ignored.
     * 
     * @param typeParameters
     *          the type parameters question.
     * @param start
     *          the start of the characters under consideration.
     * @param end
     *          the end of the characters under consideration.
     * @param diagnostics
     *          the target in which to accumulate diagnostics.
     * @return a list of type parameters.
     */
    protected List<ETypeParameter> handleTypeParameters(char[] typeParameters, int start, int end,
        DiagnosticChain diagnostics)
    {
      List<ETypeParameter> result = new ArrayList<ETypeParameter>();
      int depth = 0;
      int typeArgumentStart = -1;
      for (int i = start; i < end; i = Character.offsetByCodePoints(typeParameters, 0, typeParameters.length, i, 1))
      {
        int codePoint = Character.codePointAt(typeParameters, i);
        switch (codePoint)
        {
        case '<':
        {
          ++depth;
          break;
        }
        case '>':
        {
          if (--depth == 0)
          {
            result.add(handleTypeParameter(typeParameters, typeArgumentStart, i, diagnostics));
          }
          break;
        }
        case ',':
        {
          if (depth == 1)
          {
            result.add(handleTypeParameter(typeParameters, typeArgumentStart, i, diagnostics));
            typeArgumentStart = i + 1;
          }
          break;
        }
        default:
        {
          if (typeArgumentStart == -1)
          {
            typeArgumentStart = i;
          }
          break;
        }
        }
      }
      if (depth != 0)
      {
        report(diagnostics, EcorePlugin.INSTANCE.getString(
            "_UI_EClassifierInstanceTypeNameUnterminatedAngleBracket_diagnostic", new Object[] { start }), start);
      }
      return result;
    }

    /**
     * A well formed type parameter must denote a valid Java type parameter. It
     * must start with a well formed java identifier which may be optionally
     * followed by the keyword "extends" which in turn, when present, must be
     * followed by one or more '&amp;' separated
     * {@link #handleTypeArgument(char[], int, int, DiagnosticChain) well formed type arguments}
     * representing the bounds. White space before the keyword is optional but
     * at least one space character is expected after the keyword.
     * 
     * @param typeParameters
     *          the instance type name in question.
     * @param start
     *          the start of the characters under consideration.
     * @param end
     *          the end of the characters under consideration.
     * @param diagnostics
     *          the target in which to accumulate diagnostics.
     * @return the type parameter.
     */
    protected ETypeParameter handleTypeParameter(char[] typeParameters, int start, int end, DiagnosticChain diagnostics)
    {
      ETypeParameter eTypeParameter = EcoreFactory.eINSTANCE.createETypeParameter();
      int identifierStart = -1;
      int identifierLast = -1;
      boolean identifierDone = false;
      LOOP: for (int i = start; i < end; i = Character.offsetByCodePoints(typeParameters, 0, typeParameters.length, i,
          1))
      {
        int codePoint = Character.codePointAt(typeParameters, i);
        if (Character.isWhitespace(codePoint))
        {
          if (identifierStart != -1)
          {
            identifierDone = true;
          }
        }
        else if (identifierDone)
        {
          if (codePoint == 'e' && i + 7 < end && typeParameters[i + 1] == 'x' && typeParameters[i + 2] == 't'
              && typeParameters[i + 3] == 'e' && typeParameters[i + 4] == 'n' && typeParameters[i + 5] == 'd'
              && typeParameters[i + 6] == 's' && Character.isWhitespace(Character.codePointAt(typeParameters, i + 7)))
          {
            i += 7;
            int boundStart = i;
            while (i < end)
            {
              char character = typeParameters[i];
              if (character == '&')
              {
                EGenericType eBound = handleInstanceTypeName(typeParameters, boundStart, i, diagnostics);
                eTypeParameter.getEBounds().add(eBound);
                boundStart = i + 1;
              }
              ++i;
            }
            EGenericType eBound = handleInstanceTypeName(typeParameters, boundStart, i, diagnostics);
            eTypeParameter.getEBounds().add(eBound);
          }
          else
          {
            report(diagnostics, EcorePlugin.INSTANCE.getString(
                "_UI_EClassifierInstanceTypeNameExpectingExtends_diagnostic", new Object[] { i }), i);
          }
          break LOOP;
        }
        else if (identifierStart != -1 ? isIdentifierPart(codePoint) : isIdentifierStart(codePoint))
        {
          if (identifierStart == -1)
          {
            identifierStart = i;
          }
          identifierLast = i;
        }
        else
        {
          report(diagnostics, EcorePlugin.INSTANCE.getString(
              "_UI_EClassifierInstanceTypeNameUnexpectedCharacter_diagnostic", new Object[] { i,
                  new String(Character.toChars(codePoint)) }), i);
          break LOOP;
        }
      }

      if (identifierLast == -1)
      {
        report(diagnostics, EcorePlugin.INSTANCE.getString(
            "_UI_EClassifierInstanceTypeNameExpectingIdentifier_diagnostic", new Object[] { end }), end);
      }
      else
      {
        eTypeParameter.setName(new String(typeParameters, identifierStart, identifierLast - identifierStart + 1));
      }
      return eTypeParameter;
    }
  }

} // EcoreValidator
