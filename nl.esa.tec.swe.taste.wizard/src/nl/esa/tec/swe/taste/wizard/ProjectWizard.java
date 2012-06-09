package nl.esa.tec.swe.taste.wizard;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.*;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.*;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

public class ProjectWizard extends Wizard implements INewWizard, IExecutableExtension  {
	private WizardNewProjectCreationPage firstPage;
	private IConfigurationElement config;

	private IWorkbench workbench;

	private IStructuredSelection selection;

	private IProject project;

	public ProjectWizard ()
	{
		setWindowTitle("TASTE Project");
	}


	public void addPages() {
		super.addPages();
		firstPage = new WizardNewProjectCreationPage("TASTE Project Wizard");
		firstPage.setTitle("Create a new TASTE project");
		firstPage.setDescription("Please enter the name of your new TASTE project");

		addPage(firstPage);
	}


	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		 this.selection = selection;
        this.workbench = workbench;


	}
    public void setInitializationData(IConfigurationElement config,
            String propertyName, Object data) throws CoreException {
    	this.config = config;
}


	private InputStream openContentStream() {
		String contents =
				"This is the initial file contents for *.html " +
						"file that should be word-sorted in the Preview " +
						"page of the multi-page editor";
		return new ByteArrayInputStream(contents.getBytes());
	}

	private void addFileToProject
		(IContainer container, Path path, InputStream contentStream, IProgressMonitor monitor)
				throws CoreException {
		final IFile file = container.getFile(path);

		if (file.exists()) {
			file.setContents(contentStream, true, true, monitor);
		} else {
			file.create(contentStream, true, monitor);
		}
	}


	public static InputStream generateREADME(String title) throws CoreException
	{
		final String newline = System.getProperty("line.separator");

		String line;
		
		StringBuffer sb = new StringBuffer();

		sb.append("\\_o< Welcome in project " + title + " >o_/");
		sb.append(newline);
		sb.append(newline);
		sb.append("To edit the interfaces (data types) of your system");
		sb.append(newline);
		sb.append("please edit directly the dataview.asn file.");
		sb.append(newline);
		sb.append(newline);
		sb.append("The system architecture can be defined by using");
		sb.append(newline);
		sb.append("the created diagram in the models/ directory.");

		return new ByteArrayInputStream(sb.toString().getBytes());
	}


	void createProject(IProjectDescription description, IProject proj,
			IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		try {

			monitor.beginTask("", 2000);

			proj.create(description, new SubProgressMonitor(monitor, 1000));

			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			proj.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(
					monitor, 1000));

			/*
			 * Okay, now we have the project and we can do more things with it
			 * before updating the perspective.
			 */
			IContainer container = (IContainer) proj;

			/* Add a  file */
			addFileToProject(container, new Path("README.txt"),
					generateREADME(proj.getName()), monitor);

			/* Add the style folder and the site.css file to it */
			final IFolder skelsFolder = container.getFolder(new Path("skeletons"));
			skelsFolder.create(true, true, monitor);
			
			final IFolder dataviewFolder = container.getFolder(new Path("dataview"));
			dataviewFolder.create(true, true, monitor);

			InputStream resourceStream = this.getClass().getResourceAsStream(
					"templates/dataview.asn");

			addFileToProject(container, new Path(dataviewFolder.getName()
					+ Path.SEPARATOR + "dataview.asn"),
					resourceStream, monitor);
			
			final IFolder modelsFolder = container.getFolder(new Path("models"));
			modelsFolder.create(true, true, monitor);
			InputStream archiStream = this.getClass().getResourceAsStream(
					"templates/architecture.diagram");
			addFileToProject(container, new Path(modelsFolder.getName()
					+ Path.SEPARATOR + "architecture.diagram"),
					archiStream, monitor);

			resourceStream.close();


		} catch (IOException ioe) {
			IStatus status = new Status(IStatus.ERROR, "NewFileWizard", IStatus.OK,
					ioe.getLocalizedMessage(), null);
			throw new CoreException(status);
		} finally {
			monitor.done();
		}
	}



	public boolean performFinish()
	{

		if (project != null) {
			return true;
		}

		final IProject projectHandle = firstPage.getProjectHandle();

		URI projectURI = (!firstPage.useDefaults()) ? firstPage.getLocationURI() : null;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		final IProjectDescription desc = workspace
				.newProjectDescription(projectHandle.getName());

		desc.setLocationURI(projectURI);

		/*
		 * Just like the NewFileWizard, but this time with an operation object
		 * that modifies workspaces.
		 */
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor monitor)
					throws CoreException {
				createProject(desc, projectHandle, monitor);
			}
		};

		/*
		 * This isn't as robust as the code in the BasicNewProjectResourceWizard
		 * class. Consider beefing this up to improve error handling.
		 */
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
			e.printStackTrace();
			return false;
		}

		project = projectHandle;

		if (project == null) {
			return false;
		}                

		BasicNewProjectResourceWizard.updatePerspective(config);
		BasicNewProjectResourceWizard.selectAndReveal(project, workbench
				.getActiveWorkbenchWindow());

		return true;

	}

}


/*
private void doFinish(

		String projectName,
		IProgressMonitor monitor)
				throws CoreException {
	// create a sample file
	String fileName;
	fileName = "dataview.asn";
	monitor.beginTask("Creating " + fileName, 2);
	System.out.println("Try to create file");
	IWorkspaceRoot root =  org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
	IResource resource = root.findMember(new Path(projectName));

	IContainer container = (IContainer) resource;
	final IFile file = container.getFile(new Path(fileName));
	try {
		InputStream stream = openContentStream();
		if (file.exists()) {
			file.setContents(stream, true, true, monitor);
		} else {
			file.create(stream, true, monitor);
		}
		stream.close();
	} catch (IOException e) {
	}
	monitor.worked(1);
	monitor.setTaskName("Opening file for editing...");
			getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage page =
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					try {
						IDE.openEditor(page, file, true);
					} catch (PartInitException e) {
					}
				}
			});
			monitor.worked(1);
}
*/