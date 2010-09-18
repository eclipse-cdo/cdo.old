/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.net4j.tools.workingset.dsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslFactoryImpl extends EFactoryImpl implements DslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DslFactory init()
  {
    try
    {
      DslFactory theDslFactory = (DslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/net4j/tools/workingset"); 
      if (theDslFactory != null)
      {
        return theDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DslPackage.BOOLEAN_EXPRESSION: return createBooleanExpression();
      case DslPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case DslPackage.STRING_EXPRESSION: return createStringExpression();
      case DslPackage.STRING_LITERAL: return createStringLiteral();
      case DslPackage.PROPERTY_ACCESS: return createPropertyAccess();
      case DslPackage.OR_EXPRESSION: return createOrExpression();
      case DslPackage.XOR_EXPRESSION: return createXorExpression();
      case DslPackage.AND_EXPRESSION: return createAndExpression();
      case DslPackage.BOOLEAN_COMPARISON: return createBooleanComparison();
      case DslPackage.STRING_COMPARISON: return createStringComparison();
      case DslPackage.NOT_EXPRESSION: return createNotExpression();
      case DslPackage.IS_EXPRESSION: return createIsExpression();
      case DslPackage.HAS_EXPRESSION: return createHasExpression();
      case DslPackage.TEST_EXPRESSION: return createTestExpression();
      case DslPackage.CONCAT_EXPRESSION: return createConcatExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DslPackage.COMPARISON_OPERATOR:
        return createComparisonOperatorFromString(eDataType, initialValue);
      case DslPackage.STRING_OPERATOR:
        return createStringOperatorFromString(eDataType, initialValue);
      case DslPackage.TYPE:
        return createTypeFromString(eDataType, initialValue);
      case DslPackage.KIND:
        return createKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DslPackage.COMPARISON_OPERATOR:
        return convertComparisonOperatorToString(eDataType, instanceValue);
      case DslPackage.STRING_OPERATOR:
        return convertStringOperatorToString(eDataType, instanceValue);
      case DslPackage.TYPE:
        return convertTypeToString(eDataType, instanceValue);
      case DslPackage.KIND:
        return convertKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanExpression createBooleanExpression()
  {
    BooleanExpressionImpl booleanExpression = new BooleanExpressionImpl();
    return booleanExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral createBooleanLiteral()
  {
    BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
    return booleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringExpression createStringExpression()
  {
    StringExpressionImpl stringExpression = new StringExpressionImpl();
    return stringExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral createStringLiteral()
  {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyAccess createPropertyAccess()
  {
    PropertyAccessImpl propertyAccess = new PropertyAccessImpl();
    return propertyAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpression createOrExpression()
  {
    OrExpressionImpl orExpression = new OrExpressionImpl();
    return orExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XorExpression createXorExpression()
  {
    XorExpressionImpl xorExpression = new XorExpressionImpl();
    return xorExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanComparison createBooleanComparison()
  {
    BooleanComparisonImpl booleanComparison = new BooleanComparisonImpl();
    return booleanComparison;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringComparison createStringComparison()
  {
    StringComparisonImpl stringComparison = new StringComparisonImpl();
    return stringComparison;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotExpression createNotExpression()
  {
    NotExpressionImpl notExpression = new NotExpressionImpl();
    return notExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IsExpression createIsExpression()
  {
    IsExpressionImpl isExpression = new IsExpressionImpl();
    return isExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HasExpression createHasExpression()
  {
    HasExpressionImpl hasExpression = new HasExpressionImpl();
    return hasExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestExpression createTestExpression()
  {
    TestExpressionImpl testExpression = new TestExpressionImpl();
    return testExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcatExpression createConcatExpression()
  {
    ConcatExpressionImpl concatExpression = new ConcatExpressionImpl();
    return concatExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComparisonOperator createComparisonOperatorFromString(EDataType eDataType, String initialValue)
  {
    ComparisonOperator result = ComparisonOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertComparisonOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringOperator createStringOperatorFromString(EDataType eDataType, String initialValue)
  {
    StringOperator result = StringOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStringOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createTypeFromString(EDataType eDataType, String initialValue)
  {
    Type result = Type.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Kind createKindFromString(EDataType eDataType, String initialValue)
  {
    Kind result = Kind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslPackage getDslPackage()
  {
    return (DslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DslPackage getPackage()
  {
    return DslPackage.eINSTANCE;
  }

} //DslFactoryImpl
