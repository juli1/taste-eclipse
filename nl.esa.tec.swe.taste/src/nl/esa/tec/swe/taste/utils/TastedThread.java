package nl.esa.tec.swe.taste.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;


import org.eclipse.core.resources.IProject;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.main.Tasted;

public class TastedThread implements Runnable
{
	private IProject activeProject;
	private boolean generateDataView;
	private boolean generateSkels;
	private boolean buildProject;
	private boolean checkModel;

	
	public TastedThread (IProject p, boolean mustGenerateDataView, boolean mustGenerateSkels, boolean mustBuildProject)
	{
		this.generateDataView = mustGenerateDataView;
		this.buildProject = mustBuildProject;
		this.generateSkels = mustGenerateSkels;
		activeProject = p;
	}
	
	public void setCheckModel (boolean v)
	{
		this.checkModel = v;
	}
	
	public void run() 
	{ 
		File f;
		String inputZip = null;
		String outputZip = null;
		
		try
		{
			f = File.createTempFile("project",".tgz",null);
			System.out.println("[Utils] Input Zip in " + f.getCanonicalPath());
			inputZip = f.getCanonicalPath();

		}
		catch (IOException e)
		{
			System.out.println("[Utils] Error in tasteBuild");
			e.printStackTrace();
			return;
		}


		f.delete();
		try
		{
			f = File.createTempFile("project",".tgz",null);
			System.out.println("[Utils] Output Zip in " + f.getCanonicalPath());
			outputZip = f.getCanonicalPath();

		}
		catch (IOException e)
		{
			System.out.println("[Utils] Error in tasteBuild");
			e.printStackTrace();
			return;
		}


		f.delete();
		Tasted tasted = Utils.getTastedServer ();
		if (generateDataView)
		{
			Utils.exportProject(activeProject, inputZip, false);
			
			tasted.generateDataView (inputZip, outputZip);

			TarInputStream tin;
			try {
				tin = new TarInputStream( new GZIPInputStream
						(new FileInputStream(new File(outputZip))));

				TarEntry tarEntry = tin.getNextEntry();

				while (tarEntry != null)
				{
					if (tarEntry.getName().equalsIgnoreCase("dataview.aadl"))
					{
						FileOutputStream fout = new FileOutputStream(Utils.getCurrentTasteProjectPath() + "/dataview/dataview.aadl");

						tin.copyEntryContents(fout);
						fout.close();
					}
					tarEntry = tin.getNextEntry();
				}
				tin.close();
			} catch (FileNotFoundException e) {
				System.out.println("[TastedThread] Does not find file");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("[TastedThread] I/O error");
				e.printStackTrace();
			}

		}


		
		if (generateSkels)
		{
			Utils.exportProject(activeProject, inputZip);
			
			tasted.generateSkels (inputZip, outputZip);

			TarInputStream tin;
			try {
				tin = new TarInputStream( new GZIPInputStream
						(new FileInputStream(new File(outputZip))));

				TarEntry tarEntry = tin.getNextEntry();

				while (tarEntry != null)
				{
					if (tarEntry.getName().contains("skels/"))
					{
						if (! tarEntry.isDirectory())
						{
							String target = Utils.getCurrentTasteProjectPath() + "/" + tarEntry.getName().replaceFirst("skels", "skeletons");
							
							File targetFile = new File (target);
							System.out.println (" parent = " + targetFile.getParent());
							if (! targetFile.getParentFile().exists())
							{
								targetFile.getParentFile().mkdirs();
							}
							System.out.println("[Utils] Copy file: " + tarEntry.getName() + " to " + target);

							FileOutputStream fout = new FileOutputStream(target);

							tin.copyEntryContents(fout);
							fout.close();
						}
						else
						{
							File targetdir = new File (Utils.getCurrentTasteProjectPath() + "/" + tarEntry.getName().replaceFirst("skels", "skeletons"));
							if (!targetdir.exists())
							{
								targetdir.mkdir();
							}
						}
					}
					tarEntry = tin.getNextEntry();
				}
				tin.close();
			} catch (FileNotFoundException e) {
				System.out.println("[Utils] Does not find file");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("[Utils] I/O error");
				e.printStackTrace();
			}

		}



		if (buildProject)
		{
			Utils.exportProject(activeProject, inputZip);
			tasted.buildProject (inputZip, outputZip);
			File binDir =  new File (Utils.getCurrentTasteProjectPath() + "/binaries");
			if (! binDir.exists())
			{
				binDir.mkdir();
			}
			TarInputStream tin;
			try {
				tin = new TarInputStream( new GZIPInputStream
						(new FileInputStream(new File(outputZip))));

				TarEntry tarEntry = tin.getNextEntry();

				while (tarEntry != null)
				{
					if ( ( ! tarEntry.isDirectory() ) && (tarEntry.getName().contains("binary")) && (tarEntry.getName().contains("binaries")))
					{
						String dest = Utils.getCurrentTasteProjectPath() + "/binaries/" + tarEntry.getName().replaceFirst("binary/binaries/", "");
						System.out.println("[Utils] Copy " + tarEntry.getName() + " in " + dest);


						FileOutputStream fout = new FileOutputStream(dest);

						tin.copyEntryContents(fout);
						fout.close();
					}
					tarEntry = tin.getNextEntry();
				}
				tin.close();
			} catch (FileNotFoundException e) {
				System.out.println("[Utils] Does not find file");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("[Utils] I/O error");
				e.printStackTrace();
			}
		}
	}
}
