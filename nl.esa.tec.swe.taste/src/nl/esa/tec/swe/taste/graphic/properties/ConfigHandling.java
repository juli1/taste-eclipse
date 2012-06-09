package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.TasteComponent;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.views.properties.tabbed.*;

public class ConfigHandling extends GFPropertySection implements ITabbedPropertyConstants, ModifyListener{
	private CCombo nameText;

	private String[] ethernetConfigurations =
		{"{devname \"eth0\" , address \"127.0.0.1\" , port 1234 }",
		 "{devname \"eth0\" , address \"127.0.0.1\" , port 1235 }",
		 "{devname \"eth0\" , address \"192.168.0.1\" , port 1235 }",
		 "{devname \"eth0\" , address \"192.168.0.2\" , port 1235 }",
		};
	
	private String[] spwConfigurations =
		{"{nodeaddr 22, devname \"/dev/grspwrasta0\" }",
		 "{nodeaddr 11, devname \"/dev/grspwrasta1\" }"
		};
	
	private void addData (CCombo combo)
	{
		PictogramElement pe = getSelectedPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		String toAdd[];
		
		toAdd = null;
		System.out.println("[ConfigHandling] Try to add generic configuration data to object" + bo);

		if ((bo != null) && (bo instanceof Driver))
		{
			Driver drv = (Driver) bo;
			if (drv.getType() == null)
			{
				return;
			}
			
			System.out.println("[ConfigHandling] Driver type: " + drv.getType());
			if (drv.getType().toLowerCase().contains("ethernet"))
			{
				System.out.println("[ConfigHandling] Ethernet device found");
				toAdd = ethernetConfigurations;
			}
			if (drv.getType().toLowerCase().contains("spacewire"))
			{
				System.out.println("[ConfigHandling] Spacewire device found");
				toAdd = spwConfigurations;
			}
		}
		
		if (toAdd != null)
		{
			for (int i = 0 ; i < toAdd.length ; i++)
			{
				combo.add (toAdd[i]);
			}
		}
	}
	
	public void createControls (Composite parent,
								TabbedPropertySheetPage tabbedPropertySheetPage)
	{

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		FormData data;
	    
		nameText = factory.createCCombo(composite, SWT.SIMPLE | SWT.DROP_DOWN  );
		
		addData (nameText);
		
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		nameText.setLayoutData(data);
		

		

		CLabel valueLabel = factory.createCLabel(composite, "Configuration:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameText, 0);
		data.top = new FormAttachment(nameText, 0, SWT.CENTER);;
		valueLabel.setLayoutData(data);
		
		nameText.addModifyListener(this);
	}

	public void refresh()
	{

		PictogramElement pe = getSelectedPictogramElement();
		String name = "";
		if (pe != null)
		{
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			if (bo == null)
			{
				return;
			}
			
			if (bo instanceof Driver)
			{
				name = ((Driver) bo).getConfig();
			}
			

			if (name == null)
			{
				name = "";
			}
			nameText.removeAll();
			nameText.add (name);
			addData (nameText);
			nameText.setText(name);
			

		}
	}
	
	
	public void modifyText(ModifyEvent event)
	{
		final String newName = nameText.getText();
		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
	
			public void execute(IContext context) {
				PictogramElement pe = getSelectedPictogramElement();
	
				if (pe != null)  {
					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					// the filter assured, that it is a EClass
					if (bo instanceof Driver)
					{
						Driver f = (Driver) bo;
						System.out.println("[ConfigHandling] new selected object " + f.getName());
						System.out.println("[ConfigHandling] new property value  " + nameText.getText());
						try
						{
							f.setConfig(newName);
						}
						catch (IllegalStateException e)
						{
							System.out.println("[ConfigHandling] IllegalStateException raised");	
						}
					} 
				}
			}
	
			public boolean canExecute(IContext context) {
				return true;
			}
		};
		CustomContext context = new CustomContext();
		execute(feature, context);
		System.out.println("[ConfigHandling] EXECUTED ACTION");
	
	}
}


/*
OLD WIP CODE


public static void createConfigWindow(final Shell shell) {
	 final String[] ICONS = { "SWT.ICON_ERROR",
	      "SWT.ICON_INFORMATION", "SWT.ICON_QUESTION", "SWT.ICON_WARNING",
	      "SWT.ICON_WORKING"};

	  // Strings to show in the Buttons dropdown
	  String[] BUTTONS = { "SWT.OK", "SWT.OK | SWT.CANCEL",
	      "SWT.YES | SWT.NO", "SWT.YES | SWT.NO | SWT.CANCEL",
	      "SWT.RETRY | SWT.CANCEL", "SWT.ABORT | SWT.RETRY | SWT.IGNORE"};
    shell.setLayout(new GridLayout(2, false));

    // Create the dropdown to allow icon selection
    new Label(shell, SWT.NONE).setText("Icon:");
    final Combo icons = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
    for (int i = 0, n = ICONS.length; i < n; i++)
      icons.add(ICONS[i]);
    icons.select(0);

    // Create the dropdown to allow button selection
    new Label(shell, SWT.NONE).setText("Buttons:");
    final Combo buttons = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
    for (int i = 0, n = BUTTONS.length; i < n; i++)
      buttons.add(BUTTONS[i]);
    buttons.select(0);

    // Create the entry field for the message
    new Label(shell, SWT.NONE).setText("Message:");
    final Text message = new Text(shell, SWT.BORDER);
    message.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    // Create the label to show the return from the open call
    new Label(shell, SWT.NONE).setText("Return:");
    final Label returnVal = new Label(shell, SWT.NONE);
    returnVal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    // Create the button and event handler
    // to display the message box
    Button button = new Button(shell, SWT.PUSH);
    button.setText("Show Message");
    button.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        // Clear any previously returned value
        returnVal.setText("");

        // This will hold the style to pass to the MessageBox constructor
        int style = 0;

        // Determine which icon was selected and
        // add it to the style
        switch (icons.getSelectionIndex()) {
        case 0:
          style |= SWT.ICON_ERROR;
          break;
        case 1:
          style |= SWT.ICON_INFORMATION;
          break;
        case 2:
          style |= SWT.ICON_QUESTION;
          break;
        case 3:
          style |= SWT.ICON_WARNING;
          break;
        case 4:
          style |= SWT.ICON_WORKING;
          break;
        }

        // Determine which set of buttons was selected
        // and add it to the style
        switch (buttons.getSelectionIndex()) {
        case 0:
          style |= SWT.OK;
          break;
        case 1:
          style |= SWT.OK | SWT.CANCEL;
          break;
        case 2:
          style |= SWT.YES | SWT.NO;
          break;
        case 3:
          style |= SWT.YES | SWT.NO | SWT.CANCEL;
          break;
        case 4:
          style |= SWT.RETRY | SWT.CANCEL;
          break;
        case 5:
          style |= SWT.ABORT | SWT.RETRY | SWT.IGNORE;
          break;
        }

        // Display the message box
        MessageBox mb = new MessageBox(shell, style);
        mb.setText("Message from SWT");
        mb.setMessage(message.getText());
        int val = mb.open();
        String valString = "";
        switch (val) // val contains the constant of the selected button
        {
        case SWT.OK:
          valString = "SWT.OK";
          break;
        case SWT.CANCEL:
          valString = "SWT.CANCEL";
          break;
        case SWT.YES:
          valString = "SWT.YES";
          break;
        case SWT.NO:
          valString = "SWT.NO";
          break;
        case SWT.RETRY:
          valString = "SWT.RETRY";
          break;
        case SWT.ABORT:
          valString = "SWT.ABORT";
          break;
        case SWT.IGNORE:
          valString = "SWT.IGNORE";
          break;
        }
        returnVal.setText(valString);
      }
    });
  }


public void createControls (Composite parent,
							TabbedPropertySheetPage tabbedPropertySheetPage)
{

	super.createControls(parent, tabbedPropertySheetPage);

	TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
	Composite composite = factory.createFlatFormComposite(parent);
	FormData data;
	
	final Shell currentshell = parent.getShell();

	Button butt = factory.createButton(composite, "...", SWT.PUSH);
	data = new FormData();
    data.right = new FormAttachment(100,-10);
    //data.bottom = new FormAttachment(100,-10);
    data.top = new FormAttachment(0,10);
    
    butt.addMouseListener(new MouseListener(){
    	  public void mouseDoubleClick(MouseEvent e) {
			  System.out.println("[ConfigHandling] dclick on button");
			  createConfigWindow (currentshell);

    		  }

    		  public void mouseDown(MouseEvent e) {
    			  System.out.println("[ConfigHandling] click on button");
    			  createConfigWindow (currentshell);

    		  }


    		  public void mouseUp(MouseEvent e) {

    		  }


    		  public void mouseMove(MouseEvent e) {

    		  }


    		  public void mouseEnter(MouseEvent e) {

    		  }


    		  public void mouseExit(MouseEvent e) {

    		  }



    		  public void mouseHover(MouseEvent e) {

    		  }
    });
    
	butt.setLayoutData(data);
	
	nameText = factory.createCCombo(composite, SWT.SIMPLE | SWT.DROP_DOWN  );
	data = new FormData();
    data.right = new FormAttachment(butt,-10);
    data.top = new FormAttachment(0,10);
    data.left = new FormAttachment(15,0);
	nameText.setLayoutData(data);

	CLabel valueLabel = factory.createCLabel(composite, "Configuration:");
	data = new FormData();
    data.top = new FormAttachment(0,10);
    data.left = new FormAttachment(0,0);
    data.right = new FormAttachment(nameText,0, SWT.CENTER);
	
	valueLabel.setLayoutData(data);
	

	
	nameText.addModifyListener(this);
}

public void refresh()
{
	PictogramElement pe = getSelectedPictogramElement();
	String name = "";
	if (pe != null)
	{
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

		if (bo == null)
		{
			return;
		}
		
		if (bo instanceof Driver)
		{
			name = ((Driver) bo).getConfig();
		}
		

		if (name == null)
		{
			name = "";
		}
		(nameText).setText(name);
		

	}
}


public void modifyText(ModifyEvent event)
{
	final String newName = nameText.getText();
	IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {

		public void execute(IContext context) {
			PictogramElement pe = getSelectedPictogramElement();

			if (pe != null)  {
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
				// the filter assured, that it is a EClass
				if (bo instanceof Driver)
				{
					Driver f = (Driver) bo;
					System.out.println("[ConfigHandling] new selected object " + f.getName());
					System.out.println("[ConfigHandling] new property value  " + nameText.getText());
					try
					{
						f.setConfig(newName);
					}
					catch (IllegalStateException e)
					{
						System.out.println("[ConfigHandling] IllegalStateException raised");	
					}
				} 
			}
		}

		public boolean canExecute(IContext context) {
			return true;
		}
	};
	CustomContext context = new CustomContext();
	execute(feature, context);
	System.out.println("[ConfigHandling] EXECUTED ACTION");

}
*/