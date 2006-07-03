/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov.client.ui.dialogs;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Request;
import org.eclipse.net4j.examples.client.ClientActivator;
import org.eclipse.net4j.examples.client.ui.BusyTemplate;
import org.eclipse.net4j.examples.mvc.DensityMvcPlugin;
import org.eclipse.net4j.examples.mvc.IRecordController;
import org.eclipse.net4j.examples.mvc.ISequenceController;
import org.eclipse.net4j.examples.mvc.binding.SelectionViewBinding;
import org.eclipse.net4j.examples.mvc.controller.MetaDataRecordController;
import org.eclipse.net4j.examples.mvc.controller.SelectionSequenceController;
import org.eclipse.net4j.examples.mvc.swt.AbstractControlledDialog;
import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvFactory;
import org.eclipse.net4j.examples.prov.Site;
import org.eclipse.net4j.examples.prov.client.protocol.UploadArchiveRequest;
import org.eclipse.net4j.examples.prov.provider.ProvItemProviderAdapterFactory;
import org.eclipse.net4j.util.IOHelper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;


public class ProvisioningDialog extends AbstractControlledDialog
{
  private static ComposedAdapterFactory emfAdapterFactory;

  private Channel channel;

  private Site site;

  private CheckboxTableViewer featuresTable; // TODO Introduce ICheckableAspect to MVC

  private IRecordController<Category, Control> recordController;

  private ISequenceController<EList, Category, Control> sequenceController;

  public ProvisioningDialog(Shell parentShell, Channel channel, Site site)
  {
    super(parentShell);
    setShellStyle(SWT.RESIZE | getShellStyle());
    this.channel = channel;
    this.site = site;
  }

  @Override
  protected Control createDialogArea(Composite parent)
  {
    Composite container = (Composite)super.createDialogArea(parent);

    Composite main = new Composite(container, SWT.NONE);
    main.setLayoutData(new GridData(GridData.FILL_BOTH));
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    main.setLayout(gridLayout);

    SashForm sashForm = new SashForm(main, SWT.NONE);
    final GridData gridData_2 = new GridData(GridData.FILL_BOTH);
    sashForm.setLayoutData(gridData_2);

    Group left = new Group(sashForm, SWT.NONE);
    left.setLayout(new GridLayout());
    left.setText("Categories");

    Composite categoriesContainer = new Composite(left, SWT.NONE);
    categoriesContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
    final GridLayout gridLayout_7 = new GridLayout();
    gridLayout_7.marginWidth = 0;
    gridLayout_7.marginHeight = 0;
    categoriesContainer.setLayout(gridLayout_7);

    List categoriesList = new List(categoriesContainer, SWT.BORDER);
    categoriesList.setData("target", "categoriesList");
    categoriesList.setLayoutData(new GridData(GridData.FILL_BOTH));

    final Composite composite_1 = new Composite(left, SWT.NONE);
    composite_1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    final GridLayout gridLayout_4 = new GridLayout();
    gridLayout_4.marginWidth = 0;
    gridLayout_4.marginHeight = 0;
    gridLayout_4.numColumns = 2;
    composite_1.setLayout(gridLayout_4);

    final Label label = new Label(composite_1, SWT.NONE);
    label.setText("Label:");

    Text labelText = new Text(composite_1, SWT.BORDER);
    labelText.setData("target", "labelText");
    labelText.setData("fieldName", "label");
    labelText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    final Label label_1 = new Label(composite_1, SWT.NONE);
    label_1.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
    label_1.setText("Description:");

    Text descriptionText = new Text(composite_1, SWT.MULTI | SWT.BORDER | SWT.WRAP);
    descriptionText.setData("target", "descriptionText");
    descriptionText.setData("fieldName", "description");
    final GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
    gridData.heightHint = 40;
    descriptionText.setLayoutData(gridData);

    final Composite composite_4 = new Composite(left, SWT.NONE);
    composite_4.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
    final GridLayout gridLayout_6 = new GridLayout();
    gridLayout_6.marginWidth = 0;
    gridLayout_6.marginHeight = 0;
    gridLayout_6.numColumns = 3;
    composite_4.setLayout(gridLayout_6);

    Button newButton = new Button(composite_4, SWT.NONE);
    newButton.setData("sequenceAction", "new");
    newButton.setData("target", "newButton");
    newButton.setText("New...");

    Button deleteButton = new Button(composite_4, SWT.NONE);
    deleteButton.setData("sequenceAction", "delete");
    deleteButton.setData("target", "deleteButton");
    deleteButton.setText("Delete");

    Button resetButton = new Button(composite_4, SWT.NONE);
    resetButton.setData("recordAction", "load");
    resetButton.setData("target", "resetButton");
    resetButton.setText("Reset");

    final Composite composite_2 = new Composite(sashForm, SWT.NONE);
    final GridLayout gridLayout_5 = new GridLayout();
    gridLayout_5.horizontalSpacing = 10;
    gridLayout_5.numColumns = 2;
    gridLayout_5.marginWidth = 0;
    gridLayout_5.marginHeight = 0;
    composite_2.setLayout(gridLayout_5);

    final Composite composite_3 = new Composite(composite_2, SWT.NONE);
    final GridData gridData_3 = new GridData();
    gridData_3.widthHint = 0;
    composite_3.setLayoutData(gridData_3);

    Group right = new Group(composite_2, SWT.NONE);
    right.setLayoutData(new GridData(GridData.FILL_BOTH));
    final GridLayout gridLayout_3 = new GridLayout();
    gridLayout_3.numColumns = 2;
    right.setLayout(gridLayout_3);
    right.setText("Features");

    Composite featuresContainer = new Composite(right, SWT.NONE);
    featuresContainer.setLayoutData(new GridData(GridData.FILL_BOTH));

    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginWidth = 0;
    gridLayout_1.marginHeight = 0;
    featuresContainer.setLayout(gridLayout_1);

    final Composite composite = new Composite(right, SWT.NONE);
    composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
    final GridLayout gridLayout_2 = new GridLayout();
    gridLayout_2.marginWidth = 0;
    gridLayout_2.marginHeight = 0;
    composite.setLayout(gridLayout_2);

    Button uploadArchiveButton = new Button(composite, SWT.NONE);
    uploadArchiveButton.setData("target", "uploadArchiveButton");
    uploadArchiveButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    uploadArchiveButton.setText("Upload Archive...");

    Button uploadFolderButton = new Button(composite, SWT.NONE);
    uploadFolderButton.setData("target", "uploadFolderButton");
    uploadFolderButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    uploadFolderButton.setText("Upload Folder...");

    Button removeButton = new Button(composite, SWT.NONE);
    removeButton.setData("target", "removeButton");
    removeButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    removeButton.setText("Remove");

    sashForm.setWeights(new int[] {2, 3});
    createFeaturesTable(featuresContainer);

    return container;
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent)
  {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    createButton(parent, IDialogConstants.HELP_ID, IDialogConstants.HELP_LABEL, false);
  }

  @Override
  protected Point getInitialSize()
  {
    return new Point(700, 375);
  }

  @Override
  protected void initControllers()
  {
    recordController = new MetaDataRecordController<Category, Control>(DensityMvcPlugin
            .getAdapterManager(), "record")
    {
      @Override
      public void enableView(boolean on)
      {
        super.enableView(on);
        featuresTable.setAllGrayed(!on);
        featuresTable.getTable().setEnabled(on);
      }

      @Override
      public void clearView()
      {
        super.clearView();
        featuresTable.setAllChecked(false);
      }

      @Override
      public void loadView()
      {
        super.loadView();
        Category category = getRecordTarget();

        if (category != null)
        {
          EList features = getSite().getFeatures();

          for (Iterator it = features.iterator(); it.hasNext();)
          {
            Feature feature = (Feature)it.next();
            featuresTable.setChecked(feature, category.getFeature(feature.getId(), feature
                    .getVersion()) != null);
          }
        }
      }

      @Override
      public void saveView()
      {
        super.saveView();

        Category category = getRecordTarget();
        EList features = category.getFeatures();
        features.clear();

        Object[] checked = featuresTable.getCheckedElements();
        for (int i = 0; i < checked.length; i++)
        {
          Feature feature = (Feature)checked[i];
          features.add(EcoreUtil.copy(feature));
        }
      }
    };

    addController(recordController);

    sequenceController = new SelectionSequenceController<EList, Category, Control>(DensityMvcPlugin
            .getAdapterManager(), "sequence", "sequence", "categoriesList", recordController)
    {
      @Override
      protected String itemToString(Object item)
      {
        return ((Category)item).getName();
      }

      @Override
      protected Object createNewItem()
      {
        InputDialog dlg = new InputDialog(getShell(), "New Category",
                "Please enter the name of the new category:", "", new NewCategoryValidator(
                        getSite()));

        if (dlg.open() != InputDialog.OK)
        {
          return null;
        }

        Category item = ProvFactory.eINSTANCE.createCategory();
        item.setName(dlg.getValue());
        return item;
      }
    };

    sequenceController.setNewBinding("newButton"); // TODO Make SequenceController MetaData-aware
    sequenceController.setDeleteBinding("deleteButton");
    addController(sequenceController);

    sequenceController.setSequenceTarget(getSite().getCategories());

    new SelectionViewBinding(sequenceController, "uploadArchiveButton")
    {
      public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
              int stateMask, boolean doit)
      {
        onUploadArchive();
        return true;
      }
    };

    new SelectionViewBinding(sequenceController, "uploadFolderButton")
    {
      public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
              int stateMask, boolean doit)
      {
        onUploadFolder();
        return true;
      }
    };
  };

  public Site getSite()
  {
    return site;
  }

  protected void createFeaturesTable(Composite parent)
  {
    GridData data = new GridData(GridData.FILL_BOTH);
    data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
    data.heightHint = IDialogConstants.ENTRY_FIELD_WIDTH;

    IStructuredContentProvider contentProvider = new IStructuredContentProvider()
    {
      public Object[] getElements(Object inputElement)
      {
        EList features = (EList)inputElement;
        return features.toArray(new Object[features.size()]);
      }

      public void dispose()
      {
      }

      public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
      {
      }
    };

    featuresTable = CheckboxTableViewer.newCheckList(parent, SWT.BORDER);
    featuresTable.getTable().setLayoutData(data);
    featuresTable.setContentProvider(contentProvider);
    featuresTable.setLabelProvider(new AdapterFactoryLabelProvider(getEmfAdapterFactory()));
    featuresTable.setSorter(new ViewerSorter());
    featuresTable.setInput(getSite().getFeatures());

    // featuresTable.addSelectionChangedListener(new ISelectionChangedListener()
    // {
    // public void selectionChanged(SelectionChangedEvent event)
    // {
    // }
    // });

    featuresTable.addCheckStateListener(new ICheckStateListener()
    {
      public void checkStateChanged(CheckStateChangedEvent event)
      {
        sequenceController.setRecordDirty(true);
      }
    });
  }

  protected void onUploadArchive()
  {
    FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
    dialog.setText("Select an archive to upload");
    dialog.setFilterExtensions(new String[] {"*.zip; *.jar", "*.zip", "*.jar", "*.*"});
    dialog
            .setFilterNames(new String[] {"All Archives", "ZIP Archives", "JAR Archives",
                    "All Files"});

    final String fileName = dialog.open();

    if (fileName != null)
    {
      uploadArchive(fileName);
    }
  }

  protected void onUploadFolder()
  {
    DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN);
    dialog.setText("Select a folder to upload");

    final String folderName = dialog.open();

    if (folderName != null)
    {
      final File temp = ClientActivator.getTempManager().createTempFolder("upload");
      final File source = new File(folderName);
      final File target = new File(temp, source.getName() + ".zip");

      new BusyTemplate(getShell())
      {
        @Override
        protected Object run() throws Exception
        {
          IOHelper.zip(source, target, true);

          return null;
        }
      }.execute();

      uploadArchive(target.getAbsolutePath());
      ClientActivator.getTempManager().release(temp);
    }
  }

  protected void uploadArchive(final String fileName)
  {
    Feature[] features = (Feature[])new BusyTemplate(getShell())
    {
      @Override
      protected Object run() throws Exception
      {
        Request request = new UploadArchiveRequest(fileName);
        return channel.transmit(request);
      }
    }.execute();

    if (features == null)
    {
      MessageDialog.openError(getShell(), "Upload Archive",
              "An error has occured and no features have been installed.");
    }
    else
    {
      for (int i = 0; i < features.length; i++)
      {
        Feature feature = features[i];
        getSite().addFeature(feature.getId(), feature.getVersion());
      }

      featuresTable.refresh();
    }
  }

  public static class NewCategoryValidator implements IInputValidator
  {
    private Site site;

    public NewCategoryValidator(Site site)
    {
      this.site = site;
    }

    public String isValid(String newText)
    {
      if (newText == null || newText.length() == 0)
      {
        return "The name of the new category must not be empty!";
      }
      else if (site.getCategory(newText) != null)
      {
        return "A category with the name '" + newText + "' does already exist!";
      }

      return null;
    }
  }

  public static ComposedAdapterFactory getEmfAdapterFactory()
  {
    if (emfAdapterFactory == null)
    {
      // Create an adapter factory that yields item providers.
      java.util.List factories = new ArrayList();
      factories.add(new ResourceItemProviderAdapterFactory());
      factories.add(new ProvItemProviderAdapterFactory());
      // factories.add(new ReflectiveItemProviderAdapterFactory());

      emfAdapterFactory = new ComposedAdapterFactory(factories);
    }

    return emfAdapterFactory;
  }
}
