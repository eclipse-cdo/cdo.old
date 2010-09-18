package org.eclipse.net4j.tools.workingset.validation;

import org.eclipse.net4j.tools.workingset.dsl.DslPackage;
import org.eclipse.net4j.tools.workingset.dsl.PropertyAccess;
import org.eclipse.net4j.tools.workingset.dsl.TestExpression;
import org.eclipse.net4j.tools.workingset.evaluation.PropertyRegistry;
import org.eclipse.net4j.tools.workingset.evaluation.TesterRegistry;

import org.eclipse.xtext.validation.Check;

public class DslJavaValidator extends AbstractDslJavaValidator
{
  @Check
  public void checkPropertyExists(PropertyAccess propertyAccess)
  {
    String property = propertyAccess.getProperty();
    if (!PropertyRegistry.INSTANCE.getAccessors().containsKey(property))
    {
      error("Property '" + property + "' cannot be resolved", DslPackage.PROPERTY_ACCESS__PROPERTY);
    }
  }

  @Check
  public void checkTesterExists(TestExpression testExpression)
  {
    String property = TesterRegistry.makeProperty(testExpression.getProperty());
    if (!TesterRegistry.INSTANCE.getTesters().containsKey(property))
    {
      error("Property '" + property + "' cannot be resolved", DslPackage.TEST_EXPRESSION__PROPERTY);
    }
  }
}
