package nl.esa.tec.swe.taste.wizard.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	public PreferencePage()
	{
		super (GRID);
	}
	
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor("ASN2AADLPATH", "&ASN to AADL program PATH:", getFieldEditorParent()));
		addField(new StringFieldEditor("TASTED", "&TASTEd server (ip:port):", getFieldEditorParent()));

		addField(new BooleanFieldEditor("TASTEEXPERTMODE", "&Enable Expert Mode:", getFieldEditorParent()));
		addField(new RadioGroupFieldEditor("DATAVIEWGENERATION",
				"Generation of Data View", 1,
				new String[][] { { "&Using asn2aadl", "cmd" },
						{ "U&sing TASTEd", "net" } }, getFieldEditorParent()));
		/*addField(new BooleanFieldEditor("BOOLEAN_VALUE",
				"&An example of a boolean preference", getFieldEditorParent()));


		addField(new StringFieldEditor("MySTRING1", "A &text preference:",
				getFieldEditorParent()));
		addField(new StringFieldEditor("MySTRING2", "A &text preference:",
				getFieldEditorParent()));
		*/
	}


	public void init(IWorkbench workbench) {
		setPreferenceStore(nl.esa.tec.swe.taste.wizard.Activator.getDefault().getPreferenceStore());
		setDescription("TASTE preferences");
	}

}
