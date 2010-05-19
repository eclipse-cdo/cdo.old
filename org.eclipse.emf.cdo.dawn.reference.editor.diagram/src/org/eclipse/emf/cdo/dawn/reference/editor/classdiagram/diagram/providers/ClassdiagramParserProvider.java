/*******************************************************************************
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassNameEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceNameEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttribute2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttributeEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperation2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperationEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.parsers.MessageFormatParser;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ClassdiagramParserProvider extends AbstractProvider implements IParserProvider
{

  /**
   * @generated
   */
  private IParser aInterfaceName_5001Parser;

  /**
   * @generated
   */
  private IParser getAInterfaceName_5001Parser()
  {
    if (aInterfaceName_5001Parser == null)
    {
      EAttribute[] features = new EAttribute[] { ClassdiagramPackage.eINSTANCE.getABasicClass_Name() };
      MessageFormatParser parser = new MessageFormatParser(features);
      aInterfaceName_5001Parser = parser;
    }
    return aInterfaceName_5001Parser;
  }

  /**
   * @generated
   */
  private IParser aClassName_5002Parser;

  /**
   * @generated
   */
  private IParser getAClassName_5002Parser()
  {
    if (aClassName_5002Parser == null)
    {
      EAttribute[] features = new EAttribute[] { ClassdiagramPackage.eINSTANCE.getABasicClass_Name() };
      MessageFormatParser parser = new MessageFormatParser(features);
      aClassName_5002Parser = parser;
    }
    return aClassName_5002Parser;
  }

  /**
   * @generated
   */
  private IParser anAttribute_3001Parser;

  /**
   * @generated
   */
  private IParser getAnAttribute_3001Parser()
  {
    if (anAttribute_3001Parser == null)
    {
      EAttribute[] features = new EAttribute[] { ClassdiagramPackage.eINSTANCE.getAClassChild_Accessright(),
          ClassdiagramPackage.eINSTANCE.getAClassChild_DataType(), ClassdiagramPackage.eINSTANCE.getAClassChild_Name() };
      MessageFormatParser parser = new MessageFormatParser(features);
      parser.setViewPattern("{0} {2}:{1}"); //$NON-NLS-1$
      parser.setEditorPattern("{0} {2}:{1}"); //$NON-NLS-1$
      parser.setEditPattern("{0} {2}:{1}"); //$NON-NLS-1$
      anAttribute_3001Parser = parser;
    }
    return anAttribute_3001Parser;
  }

  /**
   * @generated
   */
  private IParser anOperation_3002Parser;

  /**
   * @generated
   */
  private IParser getAnOperation_3002Parser()
  {
    if (anOperation_3002Parser == null)
    {
      EAttribute[] features = new EAttribute[] { ClassdiagramPackage.eINSTANCE.getAClassChild_Accessright(),
          ClassdiagramPackage.eINSTANCE.getAClassChild_DataType(), ClassdiagramPackage.eINSTANCE.getAClassChild_Name() };
      MessageFormatParser parser = new MessageFormatParser(features);
      parser.setViewPattern("{0} {2}():{1}"); //$NON-NLS-1$
      parser.setEditorPattern("{0} {2}():{1}"); //$NON-NLS-1$
      parser.setEditPattern("{0} {2}():{1}"); //$NON-NLS-1$
      anOperation_3002Parser = parser;
    }
    return anOperation_3002Parser;
  }

  /**
   * @generated
   */
  private IParser anAttribute_3003Parser;

  /**
   * @generated
   */
  private IParser getAnAttribute_3003Parser()
  {
    if (anAttribute_3003Parser == null)
    {
      EAttribute[] features = new EAttribute[] { ClassdiagramPackage.eINSTANCE.getAClassChild_Accessright(),
          ClassdiagramPackage.eINSTANCE.getAClassChild_DataType(), ClassdiagramPackage.eINSTANCE.getAClassChild_Name() };
      MessageFormatParser parser = new MessageFormatParser(features);
      parser.setViewPattern("{0} {2}:{1}"); //$NON-NLS-1$
      parser.setEditorPattern("{0} {2}:{1}"); //$NON-NLS-1$
      parser.setEditPattern("{0} {2}:{1}"); //$NON-NLS-1$
      anAttribute_3003Parser = parser;
    }
    return anAttribute_3003Parser;
  }

  /**
   * @generated
   */
  private IParser anOperation_3004Parser;

  /**
   * @generated
   */
  private IParser getAnOperation_3004Parser()
  {
    if (anOperation_3004Parser == null)
    {
      EAttribute[] features = new EAttribute[] { ClassdiagramPackage.eINSTANCE.getAClassChild_Accessright(),
          ClassdiagramPackage.eINSTANCE.getAClassChild_DataType(), ClassdiagramPackage.eINSTANCE.getAClassChild_Name() };
      MessageFormatParser parser = new MessageFormatParser(features);
      parser.setViewPattern("{0} {2}():{1}"); //$NON-NLS-1$
      parser.setEditorPattern("{0} {2}():{1}"); //$NON-NLS-1$
      parser.setEditPattern("{0} {2}():{1}"); //$NON-NLS-1$
      anOperation_3004Parser = parser;
    }
    return anOperation_3004Parser;
  }

  /**
   * @generated
   */
  protected IParser getParser(int visualID)
  {
    switch (visualID)
    {
    case AInterfaceNameEditPart.VISUAL_ID:
      return getAInterfaceName_5001Parser();
    case AClassNameEditPart.VISUAL_ID:
      return getAClassName_5002Parser();
    case AnAttributeEditPart.VISUAL_ID:
      return getAnAttribute_3001Parser();
    case AnOperationEditPart.VISUAL_ID:
      return getAnOperation_3002Parser();
    case AnAttribute2EditPart.VISUAL_ID:
      return getAnAttribute_3003Parser();
    case AnOperation2EditPart.VISUAL_ID:
      return getAnOperation_3004Parser();
    }
    return null;
  }

  /**
   * Utility method that consults ParserService
   * 
   * @generated
   */
  public static IParser getParser(IElementType type, EObject object, String parserHint)
  {
    return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
  }

  /**
   * @generated
   */
  public IParser getParser(IAdaptable hint)
  {
    String vid = (String)hint.getAdapter(String.class);
    if (vid != null)
    {
      return getParser(ClassdiagramVisualIDRegistry.getVisualID(vid));
    }
    View view = (View)hint.getAdapter(View.class);
    if (view != null)
    {
      return getParser(ClassdiagramVisualIDRegistry.getVisualID(view));
    }
    return null;
  }

  /**
   * @generated
   */
  public boolean provides(IOperation operation)
  {
    if (operation instanceof GetParserOperation)
    {
      IAdaptable hint = ((GetParserOperation)operation).getHint();
      if (ClassdiagramElementTypes.getElement(hint) == null)
      {
        return false;
      }
      return getParser(hint) != null;
    }
    return false;
  }

  /**
   * @generated
   */
  private static class HintAdapter extends ParserHintAdapter
  {

    /**
     * @generated
     */
    private final IElementType elementType;

    /**
     * @generated
     */
    public HintAdapter(IElementType type, EObject object, String parserHint)
    {
      super(object, parserHint);
      assert type != null;
      elementType = type;
    }

    /**
     * @generated
     */
    public Object getAdapter(Class adapter)
    {
      if (IElementType.class.equals(adapter))
      {
        return elementType;
      }
      return super.getAdapter(adapter);
    }
  }

}
