package nl.esa.tec.swe.taste.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Vector;

import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.utils.TastedThread;
import nl.esa.tec.swe.taste.wizard.preferences.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.sun.org.apache.bcel.internal.generic.RET;

public class DataViewWrapper {
	public DataViewWrapper() {

	}
	
	public final static int LANGUAGE_C = 1;
	public final static int LANGUAGE_ADA = 2;
	private static boolean hasParsed = false;
	private static String[] retArray;

	public static String[] getDataTypes() 
	{
		Vector<String> values = new Vector<String>();
		
		IProject activeProject = null;
		String line;
		String dataVal;
		String inputFile;
		activeProject = Utils.getActiveProject();
		
		if (activeProject == null)
		{
			System.out.println("[DataViewWrapper] Null Project");
			return new String[]{"invalid"};
		}
		
		inputFile = getDataViewPath(activeProject) + "dataview.aadl";
		
		if (hasParsed)
		{
			return retArray;
		}
		System.out.println("[DataViewWrapper] current project name" + activeProject.getName());
		System.out.println("[DataViewWrapper] Dataview AADL should be in " + inputFile);

		File dataviewFile = new File (inputFile);
		{
			if (! dataviewFile.exists() )
			{
				generateDataView(activeProject, false);
			}
		}
		if (! dataviewFile.exists() )
		{
			System.out.println("[DataViewWrapper] failed to generate the dataview");
		}
		
		try
		{
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		while ((line = in.readLine()) != null)
		{
			if ((line.startsWith("DATA ")) && ( ! line.startsWith("DATA IMPLEMENTATION")))
			{
				dataVal = line.substring (5);
				if (( ! dataVal.endsWith("_Buffer")) && ( ! dataVal.endsWith("_Buffer_Max")))
				{
					System.out.println("[DataViewWrapper] add" + dataVal);
					values.add (dataVal);
				}
			}
		}
		in.close();
		}
		catch (Exception e)
		{
			System.out.println("[DataViewWrapper] Exception, dataview in aadl probably not found !");
			retArray = new String[1];
			retArray[0] = "invalid";
			return retArray;
		}
		retArray = new String[values.size()];
		for (int i = 0 ; i < values.size() ; i++)
		{
			retArray[i] = values.get(i);	
		}
		hasParsed = true;
		return retArray;
		
	}
	
	public static String getDataViewPath (IProject project)
	{
		String directory;
		
		if (project == null)
		{
			return "";
		}
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  
		File workspaceDirectory = workspace.getRoot().getLocation().toFile();
		directory = workspaceDirectory.toString() + "/" + project.getName() + "/dataview/";
		return directory;
	}
	
	public static boolean generateDataView (IProject project, boolean printWarning)
	{
		if (PreferencesHelper.generateDataViewWithCommand())
		{
			String asnFile;
			String aadlFile;

			asnFile = getDataViewPath (project) + "dataview.asn";

			if (Platform. getOS().equals(Platform.OS_WIN32))
			{
				asnFile = asnFile.replace('/', '\\');
			}
			else
			{
				asnFile = asnFile.replace('\\', '/');
			}	

			aadlFile = getDataViewPath (project) + "dataview.aadl";
			if (Platform. getOS().equals(Platform.OS_WIN32))
			{
				aadlFile = aadlFile.replace('/', '\\');
			}
			else
			{
				aadlFile = aadlFile.replace('\\', '/');
			}
			return doConversionLocal (asnFile, aadlFile, printWarning);

		}
		if (PreferencesHelper.generateDataViewWithTasted())
		{
			System.out.println("[TastedBuild] current project name" + project.getName());
			
			TastedThread builder = new TastedThread(project, true, false, false);
			builder.setCheckModel (false);
			BusyIndicator.showWhile(Activator.getDefault().getWorkbench().getDisplay(), builder);
			return true;
		}
		return false;	
	}

	public final static boolean doConversionLocal (String asnFile , String aadlFile)
	{
		return (doConversionLocal (asnFile, aadlFile, true));
	}
	
	public final static boolean doConversionLocal (String asnFile , String aadlFile, boolean printWarning)
	{
		File f;
		ProcessExecutor pe;
		
		f = new File (asnFile);
		if ( ! f.exists ())
		{
			return false;
		}

		String toolPath = PreferencesHelper.getAsn2AadlPath();
		String asn1SccPath = toolPath + "/../asn1scc/asn1.exe";
		final String command = toolPath + "/asn2aadlPlus.py";
		
		f = new File (asn1SccPath);
		if (! f.exists())
		{
			System.out.println("[DataViewWrapper] Try to raise an error");
			if (printWarning)
			{
				Utils.showError("Cannot find asn1Scc compiler", "Cannot find asn1Scc, please check your preferences");
			}
		   return false;
		}
		
		f = new File (command);
		if (! f.exists())
		{
			if (printWarning)
			{
				Utils.showError("Cannot find asn2aadlPlus compiler", "Cannot find asn2aadlPlus, please check your preferences");
			}
		   return false;
		}
		System.out.println("[DataViewWrapper] Command " + command); 
		System.out.println("[DataViewWrapper] AsnFile " + asnFile);
		System.out.println("[DataViewWrapper] AadlFile " + aadlFile);
		System.out.println("[DataViewWrapper] AsnPath " + asn1SccPath);
		
		ProcessBuilder pb = new ProcessBuilder(command, "-aadlv2", asnFile, aadlFile);
		Map<String,String> customEnv = pb.environment();
		customEnv.put("ASN1SCC", asn1SccPath);
		pe = new ProcessExecutor (pb);
		
		BusyIndicator.showWhile(Activator.getDefault().getWorkbench().getDisplay(), pe);
		
		
		if (pe.getExitValue() != 0)
		{
			if (printWarning)
			{
				Utils.showError("DataView compilation error, check ASN.1 syntax", "Error when converting the ASN data view to AADL, check your ASN.1 syntax");
			}
			return false;
		}
		
		return true;
	}

	public static boolean generateSources(String asnFile, String outputDir, int lang) {
		File f;
		ProcessExecutor pe;
		ProcessBuilder pb;
		
		System.out.println("[DataViewWrapper] AsnFile " + asnFile);
		System.out.println("[DataViewWrapper] outputDir " + outputDir);
		f = new File (asnFile);
		if ( ! f.exists ())
		{
			return false;
		}

		String toolPath = PreferencesHelper.getAsn2AadlPath();
		final String asn1SccPath = toolPath + "/../asn1scc/asn1.exe";
		
		f = new File (asn1SccPath);
		if (! f.exists())
		{
			System.out.println("[DataViewWrapper] Try to raise an error");
			Utils.showError("Cannot find asn1Scc compiler", "Cannot find asn1Scc, please check your preferences");
		   return false;
		}
		

		System.out.println("[DataViewWrapper] Asn1Scc " + asn1SccPath);
		
		if (lang == LANGUAGE_C)
		{
			pb = new ProcessBuilder(asn1SccPath, "-c", asnFile, "-o", outputDir);
		}
		else
		{
			pb = new ProcessBuilder(asn1SccPath, "-Ada", asnFile, "-o", outputDir);
		}
		
		Map<String,String> customEnv = pb.environment();
		customEnv.put("ASN1SCC", asn1SccPath);
		pe = new ProcessExecutor (pb);
		
		BusyIndicator.showWhile(Activator.getDefault().getWorkbench().getDisplay(), pe);
		
		
		if (pe.getExitValue() != 0)
		{
			Utils.showError("Cannot convert the dataview, please check the syntax", "Error when converting the ASN data view to AADL, check your ASN.1 syntax");
			return false;
		}
		
		return true;
		
	}
}
