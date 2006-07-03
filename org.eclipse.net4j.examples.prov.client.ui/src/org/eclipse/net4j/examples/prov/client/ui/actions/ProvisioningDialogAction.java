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
package org.eclipse.net4j.examples.prov.client.ui.actions;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.RequestWithConfirmation;
import org.eclipse.net4j.examples.client.ClientActivator;
import org.eclipse.net4j.examples.client.ui.BusyTemplate;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.examples.prov.Site;
import org.eclipse.net4j.examples.prov.client.DensityProvisioningClientPlugin;
import org.eclipse.net4j.examples.prov.client.protocol.LoadSiteRequest;
import org.eclipse.net4j.examples.prov.client.protocol.SaveSiteRequest;
import org.eclipse.net4j.examples.prov.client.ui.DensityProvisioningClientUiPlugin;
import org.eclipse.net4j.examples.prov.client.ui.dialogs.ProvisioningDialog;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;


/**
 * Our sample action implements workbench action delegate. The action proxy will be created by the
 * workbench and shown in the UI. When the user tries to use the action, this delegate will be
 * created and execution will be delegated to it.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class ProvisioningDialogAction implements IWorkbenchWindowActionDelegate
{
  private IWorkbenchWindow window;

  /**
   * The constructor.
   */
  public ProvisioningDialogAction()
  {
  }

  /**
   * The action has been activated. The argument of the method represents the 'real' action sitting
   * in the workbench UI.
   * 
   * @see IWorkbenchWindowActionDelegate#run
   */
  public void run(IAction action)
  {
    try
    {
      Channel channel = openChannel();
      if (channel == null)
      {
        MessageDialog.openError(window.getShell(), "Provisioning Administration",
                "A channel could not be opened.");
        return;
      }

      Site site = loadSite(channel);
      if (channel == null)
      {
        MessageDialog.openError(window.getShell(), "Provisioning Administration",
                "The site could not be loaded from the Density server.");
        return;
      }

      ProvisioningDialog dialog = new ProvisioningDialog(window.getShell(), channel, site);
      int code = dialog.open();

      if (code == Dialog.OK)
      {
        saveSite(channel, site);
      }

      channel.stop();
    }
    catch (Exception ex)
    {
      DensityProvisioningClientUiPlugin.getDefault().error(
              "Problem during administration of Provisioning", ex);
    }
  }

  /**
   * Selection in the workbench has been changed. We can change the state of the 'real' action here
   * if we want, but this can only happen after the delegate has been created.
   * 
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  public void selectionChanged(IAction action, ISelection selection)
  {
  }

  /**
   * We can use this method to dispose of any system resources we previously allocated.
   * 
   * @see IWorkbenchWindowActionDelegate#dispose
   */
  public void dispose()
  {
  }

  /**
   * We will cache window object in order to be able to provide parent shell for the message dialog.
   * 
   * @see IWorkbenchWindowActionDelegate#init
   */
  public void init(IWorkbenchWindow window)
  {
    this.window = window;
  }

  private Channel openChannel()
  {
    try
    {
      // Ensure that the ProvisioningClientProtocol is loaded
      DensityProvisioningClientPlugin.getContainer();

      Connector connector = ClientActivator.getConnector();
      Channel channel = connector.addChannel(ProvisioningProtocol.PROTOCOL_NAME);
      return channel;
    }
    catch (Exception ex)
    {
      DensityProvisioningClientUiPlugin.getDefault().error("Could not open provisioning channel",
              ex);
      return null;
    }
  }

  private Site loadSite(final Channel channel)
  {
    return (Site)new BusyTemplate(window.getShell())
    {
      @Override
      protected Object run() throws Exception
      {
        RequestWithConfirmation request = new LoadSiteRequest();
        return (Site)channel.transmit(request);
      }
    }.execute();
  }

  private int saveSite(final Channel channel, final Site site)
  {
    return (Integer)new BusyTemplate(window.getShell())
    {
      @Override
      protected Object run() throws Exception
      {
        RequestWithConfirmation request = new SaveSiteRequest(site);
        return channel.transmit(request);
      }
    }.execute();
  }
}
