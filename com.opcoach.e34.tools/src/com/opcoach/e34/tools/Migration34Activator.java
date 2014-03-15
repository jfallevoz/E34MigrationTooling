package com.opcoach.e34.tools;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.FeatureModelManager;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureInfo;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Migration34Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.opcoach.e34.tools"; //$NON-NLS-1$

	// The shared instance
	private static Migration34Activator plugin;
	
	/**
	 * The constructor
	 */
	public Migration34Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		displayFeatures();
	}

	private void displayFeatures() {
		
		System.out.println("-------- start  activator -----");
         IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
         
         FeatureModelManager fmm = PDECore.getDefault().getFeatureModelManager();
         
         for (IProject p : ws.getProjects())
         {
        	 IPluginModelBase m = PDECore.getDefault().getModelManager().findModel(p);
        	 IFeatureModel fm = (IFeatureModel) fmm.getFeatureModel(p);
        	 IFeature f = (IFeature) (Platform.getAdapterManager().getAdapter(p, IFeature.class));
        	 IFeatureInfo fi = (IFeatureInfo) (Platform.getAdapterManager().getAdapter(p, IFeatureInfo.class));
        	 System.out.println("Project : " + p.getName() + " Model is " + ((m == null) ? "null" : m.getClass().toString()));
        	 
         }
 		System.out.println("-------- end in activator -----");
      
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Migration34Activator getDefault() {
		return plugin;
	}

}
