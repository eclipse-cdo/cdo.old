package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FShareEditor extends EditorPart
{
  private ColorManager colorManager = new ColorManager();

  private TreeViewer viewer;

  public FShareEditor()
  {
  }

  @Override
  public void dispose()
  {
    colorManager.dispose();
    super.dispose();
  }

  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException
  {
    setSite(site);
    setInput(input);
    setPartName(input.getName());
  }

  @Override
  public void createPartControl(Composite parent)
  {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new FillLayout());

    viewer = new TreeViewer(composite, SWT.NONE);
    viewer.setContentProvider(new FShareContentProvider());
    viewer.setLabelProvider(new FShareLabelProvider());
    viewer.setInput(getEditorInput());
  }

  @Override
  public void setFocus()
  {
  }

  @Override
  public void doSave(IProgressMonitor monitor)
  {
    // Do nothing
  }

  @Override
  public void doSaveAs()
  {
    // Do nothing
  }

  @Override
  public boolean isDirty()
  {
    return false;
  }

  @Override
  public boolean isSaveAsAllowed()
  {
    return false;
  }

  @SuppressWarnings("unchecked")
  public class ColorManager
  {
    protected Map fColorTable = new HashMap(10);

    public void dispose()
    {
      Iterator e = fColorTable.values().iterator();
      while (e.hasNext())
      {
        ((Color)e.next()).dispose();
      }
    }

    public Color getColor(RGB rgb)
    {
      Color color = (Color)fColorTable.get(rgb);
      if (color == null)
      {
        color = new Color(Display.getCurrent(), rgb);
        fColorTable.put(rgb, color);
      }
      return color;
    }
  }
}
