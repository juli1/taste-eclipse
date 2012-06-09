package nl.esa.tec.swe.taste.graphic.properties;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import nl.esa.tec.swe.taste.graphic.properties.InterfaceParametersHandling.IParametersListViewer;
import nl.esa.tec.swe.taste.main.Activator;
import nl.esa.tec.swe.taste.main.DataViewWrapper;
import nl.esa.tec.swe.taste.main.MyFeatureProvider;
import nl.esa.tec.swe.taste.main.Typeprovider;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter;
import nl.esa.tec.swe.taste.metamodel.taste.TasteComponent;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.osgi.framework.Bundle;

public class


InterfaceParametersHandling extends GFPropertySection implements ITabbedPropertyConstants {
	private Table params;
	private ParametersList parametersList = new ParametersList();
	TableViewer tableViewer;
	ComboBoxCellEditor typesEditor;
	private String[] columnNames = new String[] { "Name", "Direction", "Type","" };
	private Interface associatedInterface = null;

	
	public static void printParameters (Interface itf)
	{
		if (itf == null)
			return;
		
		System.out.println("[InterfaceParametersHandling] Parameters for interface " + itf.getName());
		for (InterfaceParameter tmp : itf.getParameters())
		{
			System.out.println("[InterfaceParametersHandling] Parameter " + tmp + " name " + tmp.getName() + "type : " + tmp.getType() );
		}
	}
	
	class ImageCellEditor extends CellEditor
	{
		private Label label;
		public ImageCellEditor()
		{

	        setStyle(SWT.SINGLE);
		}


		protected Control createControl(Composite parent) 
		{
		       label = new Label (parent, SWT.SINGLE);
				URL url = null;
				
				try {
					url = new URL("platform:/plugin/nl.esa.tec.swe.taste/icons/sdl16.png");
				} catch (MalformedURLException e1) {

					e1.printStackTrace();
				}

				ImageDescriptor desc = ImageDescriptor.createFromURL(url);

				Image img = new Image(null, desc.getImageData());
		       label.setImage (img);
		        label.addMouseListener(new MouseAdapter() 
		        {
		            public void mouseUp(MouseEvent e) 
		            {
		             System.out.println("[InterfaceParametersHandling] MOUSEUP");
		            }
		        });

		       
		    
		       
		        label.addFocusListener(new FocusAdapter() 
		        {
		            public void focusLost(FocusEvent e) 
		            {
		                System.out.println("[InterfaceParametersHandling] FOCUS");
		 		    }
		        });

		        return label;
		}


		protected Object doGetValue() 
		{
			return null;
		}


		protected void doSetFocus() {
		}


		protected void doSetValue(Object value) {
			
		}
		
	}
	interface IParametersListViewer 
	{

		public void addParameter(InterfaceParameter p);


		public void removeParameter(InterfaceParameter p);

	
		public void updateParameter(InterfaceParameter p);
	}
	
	
	class ParametersListener implements SelectionListener
	{
		public ParametersListener ()
		{
			super ();
		}



		public void widgetSelected(SelectionEvent e) {
			
			int i;
			InterfaceParameter ip;
			TableItem ti;
			i = params.getSelectionIndex();
			System.out.println("[InterfaceParameters] i = " + i);
			System.out.println("[InterfaceParameters] list size = " + parametersList.getParameters().size());
			
			if (e.item instanceof TableItem)
			{
				ti = (TableItem) e.item;
				System.out.println("[InterfaceParameters] ti data: " + ti.getData());

				if (ti.getText().equals ("add param"))
				{
					parametersList.addParameter();
				}
			}
			else
			{
				System.out.println("[InterfaceParameters] selected: " + e.item);
			}
		}

		
		public void widgetDefaultSelected(SelectionEvent e) 
		{
			
		}
		
	}

	class ParameterCellModifier implements ICellModifier {
		private InterfaceParametersHandling tableViewerExample;
		private String[] columnNames;


		public ParameterCellModifier (InterfaceParametersHandling tableViewerExample) 
		{
			super();
			this.tableViewerExample = tableViewerExample;
		}


		public boolean canModify(Object element, String property) 
		{
			InterfaceParameter ip = (InterfaceParameter) element;
			if ((ip != null) && (ip.getName ().equals ("add param")))
			{
				return false;
			}
			
			return true;
		}

		

		public Object getValue(Object element, String property) 
		{
			System.out.println("[InterfaceParameters] Invoke getValue");
			// Find the index of the column
			int columnIndex = tableViewerExample.getColumnNames().indexOf(
					property);

			Object result = null;
			final InterfaceParameter ip = (InterfaceParameter) element;

			switch (columnIndex) {
			case 0: // Name column
				result = ip.getName();
				break;

			case 1: // Direction column
				result = new Integer (42);
				if (property.equals ("in"))
				{
					System.out.println("[InterfaceParameters] Change direction of parameter to IN" + ip.getName());

					ip.setDirection(Constants.PARAMETER_DIRECTION_IN);
					result = new Integer (0);
				}
				if (property.equals ("out"))
				{
					System.out.println("[InterfaceParameters] Change direction of parameter to OUT" + ip.getName());

					ip.setDirection(Constants.PARAMETER_DIRECTION_OUT);
					result = new Integer (1);
				}
				
				break;
			case 2: // Type
				int val = 0;
				
				result = new Integer (val);
				break;
			case 3: // Cross to delete
				result = "";
				if ((ip != null) && (ip.getName().equals ("add param") == false))
				{
					parametersList.removeParameter(ip);
					IFeature feature;
					IContext context;
					feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
						
						public void execute(IContext context) {
	
							associatedInterface.getParameters().remove(ip);						
						}
				
						public boolean canExecute(IContext context) {
							return true;
						}
					};
					context = new CustomContext();
					execute(feature, context);
					System.out.println("[InterfaceParameters] Action executed for setting type value");
				
				}
			default:
				
				result = "";
			}
			return result;
		}


		public void modify(Object element, String property, Object value) {
			System.out.println("[InterfaceParametersHandling] invoke modify");

			// Find the index of the column
			int columnIndex = tableViewerExample.getColumnNames().indexOf(property);

			TableItem item = (TableItem) element;
			final InterfaceParameter ip = (InterfaceParameter) item.getData();
			 IFeature feature;
			 CustomContext context;
				System.out.println("[InterfaceParametersHandling] Parameters of the associated interface before modification");
				printParameters(associatedInterface);
			switch (columnIndex) {
			case 0:
				final String val = ((String) value).trim();
				if (val.contains (" "))
				{
					break;
				}
				if (! val.matches("[a-z\\_A-Z0-9]+"))
				{
					break;
				}
				
				feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
					
					public void execute(IContext context) {

						ip.setName(val);
						
					}
			
					public boolean canExecute(IContext context) {
						return true;
					}
				};
				 context = new CustomContext();
				execute(feature, context);
				System.out.println("[InterfaceParameters] Action executed for setting parameter name");
				
				break;
			case 1: // direction column, 0 = in ; 1 = out
				int tabIndex = ((Integer) value).intValue();
				

				System.out.println("[InterfaceParameters] Table index" + tabIndex);

				
				if (tabIndex < 0)
				{
					System.out.println("[InterfaceParameters] Invalid table index" + tabIndex);
					break;
				}
				
				final String dirvalstr = tableViewerExample.getChoices(property)[tabIndex].trim();

				
				feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
					
					public void execute(IContext context) {
						int dirval = 0;
						
						if (dirvalstr == "in") {
							dirval = Constants.PARAMETER_DIRECTION_IN;
						}
						if (dirvalstr == "out") {
							dirval = Constants.PARAMETER_DIRECTION_OUT;
						}
						ip.setDirection(dirval);
						
					}
			
					public boolean canExecute(IContext context) {
						return true;
					}
				};
				 context = new CustomContext();
				execute(feature, context);
				System.out.println("[InterfaceParameters] Action executed for setting direction value");
				
				break;
			case 2:
				int idxVal = ((Integer) value).intValue();
				if (idxVal == -1)
				{
					break;
				}
				
				final String valtype = tableViewerExample.getChoices(property)[idxVal].trim();
				
				feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
					
					public void execute(IContext context) {

						ip.setType(valtype);
						
					}
			
					public boolean canExecute(IContext context) {
						return true;
					}
				};
				 context = new CustomContext();
				execute(feature, context);
				System.out.println("[InterfaceParameters] Action executed for setting type value");
				break;
			default:
				System.out.println("DEFAULT MODIFIER");
				System.out.println("name" + ip.getName());
				break;
			}
			parametersList.parameterChanged(ip);
			System.out.println("[InterfaceParametersHandling] Parameters of the associated interface before modification");
			printParameters(associatedInterface);
		}
		
	}
	
	

	class ParameterCellListener implements ICellEditorListener {

	
		public ParameterCellListener(InterfaceParametersHandling tableViewerExample) 
		{
			super();
		}

		
		public boolean canModify(Object element, String property) 
		{
			
			return true;
		}

		public void applyEditorValue() 
		{
			
		}

		public void cancelEditor() 
		{
			
		}

		public void editorValueChanged(boolean oldValidState, boolean newValidState) 
		{
			
		}
	}

	class ParametersContentProvider implements IStructuredContentProvider, IParametersListViewer {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			System.out.println("[InterfaceParametersHandling] invoke inputChanged");

			if (newInput != null)
				((ParametersList) newInput).addChangeListener(this);
			if (oldInput != null)
				((ParametersList) oldInput).removeChangeListener(this);
		}

		public void dispose() {
			parametersList.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		public Object[] getElements(Object parent) {
			return parametersList.getParameters().toArray();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#addTask(ExampleTask)
		 */
		public void addParameter(InterfaceParameter ip) {
			tableViewer.add(ip);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#removeTask(ExampleTask)
		 */
		public void removeParameter(InterfaceParameter ip) {
			tableViewer.remove(ip);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#updateTask(ExampleTask)
		 */
		public void updateParameter(InterfaceParameter ip)
		{
			String name = ip.getName();
			InterfaceParameter old = null;
			tableViewer.update(ip, null);
		}
	}

	class ParameterLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		

		/**
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object,
		 *      int)
		 */
		public String getColumnText(Object element, int columnIndex) {
			System.out.println("[InterfaceParametersHandling] invoke getColumnText");
			String result = "";
			InterfaceParameter ip = (InterfaceParameter) element;
			switch (columnIndex) 
			{
				case 0:
				{
					result = ip.getName();
					break;
				}
				
				case 1:
				{
					if (ip.getDirection() == Constants.PARAMETER_DIRECTION_IN) {
				
					result = "in";
					}
					if (ip.getDirection() == Constants.PARAMETER_DIRECTION_OUT) {
						result = "out";
					}
					break;
				}
				
				case 2:
				{
					result = ip.getType();
					break;
				}
				
				case 3:
				{
					result = null;
					break;
				}
				
				default:
				{
					break;
				}
			}
			return result;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object,
		 *      int)
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			InterfaceParameter ip = (InterfaceParameter) element;
			URL url = null;
			String iconName = null;
			
			System.out.println("[InterfaceParametersHandling] invoke getColumnImage, index" + columnIndex);
			
			if(columnIndex != 3)
			{
				return null;
			}

			
			if (ip.getName().equals ("add param"))
			{
				iconName = "add16.png";
			}
			else
			{  
				iconName = "delete.gif";
			}
			
			try 
			{
				url = new URL("platform:/plugin/nl.esa.tec.swe.taste/icons/" + iconName);
			}
			catch (MalformedURLException e1) 
			{
				System.out.println("[InterfaceParametersHandling]Exception while trying to report image at column" + columnIndex);
				e1.printStackTrace();
				return null;
			}

			ImageDescriptor desc = ImageDescriptor.createFromURL(url);

			Image img = new Image(null, desc.getImageData());
			
			return img;
		}

	}

	class ParametersList {

		private final int COUNT = 1;
		private Vector<InterfaceParameter> parameters = new Vector<InterfaceParameter>(COUNT);
		private Set changeListeners = new HashSet();

		final String[] DIRECTIONS_ARRAY = { "in", "out" };

		public ParametersList() {
			super();
			this.initData();
		}
		
		public boolean contains (InterfaceParameter ip)
		{
			return parameters.contains(ip);
		}
		
		public void add (InterfaceParameter ip)
		{
			parameters.add(ip);
		}
		
		private void initData() {
			
			InterfaceParameter p = TasteFactory.eINSTANCE.createInterfaceParameter();
			p.setName("add param");
			p.setType("");
			p.setDirection(10);
			System.out.println("[InterfaceParameters] Add parameter at index" + (parameters.size() - 1));
			parameters.add (p);
			
			if ((associatedInterface != null) && (associatedInterface.getParameters() != null))
			{
				for (InterfaceParameter tmp : associatedInterface.getParameters())
				{
					System.out.println("[InterfaceParameters] Add Parameter during initData" + tmp.getName());
					parameters.add (tmp);
				}
			}
			else
			{
				System.out.println("[InterfaceParameters] Associated interface is null !");
			}
		};

		/**
		 * Return the array that represents the directions
		 */
		public String[] getDirections() {
			return DIRECTIONS_ARRAY;
		}

		
		public String[] getTypes ()
		{
			return DataViewWrapper.getDataTypes();
		}
		/**
		 * Return the collection of tasks
		 */
		public Vector<InterfaceParameter> getParameters() {
			return parameters;
		}

		/**
		 * Add a new task to the collection of tasks
		 */
		public void addParameter() {

			final InterfaceParameter p = TasteFactory.eINSTANCE
					.createInterfaceParameter();
			p.setName("newparam");
			p.setType("");
			p.setDirection (Constants.PARAMETER_DIRECTION_IN);
			System.out.println("[InterfaceParameters] Add parameter at index" + (parameters.size() - 1));
			parameters.add( parameters.size() - 1, p);
			Iterator iterator = changeListeners.iterator();
			while (iterator.hasNext()) {
				((IParametersListViewer) iterator.next()).addParameter(p);
			}
			
			IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
				
				public void execute(IContext context) {
					PictogramElement pe = getSelectedPictogramElement();
		
					if (pe != null)  {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

						if (bo instanceof Interface)
						{
							Interface f = (Interface) bo;
							//p.setAssociatedInterface(f);
							System.out.println("[InterfaceParameters] We will add the parameters to the following interface " + f.getName() + ";" + f);
							f.getParameters().add(p);
						}
						
					}
				}
		
				public boolean canExecute(IContext context) {
					return true;
				}
			};
			CustomContext context = new CustomContext();
			execute(feature, context);
			System.out.println("[InterfaceParameters] Action executed for adding a parameter");

		}

		/**
		 * @param task
		 */
		public void removeParameter(InterfaceParameter ip) {
			parameters.remove(ip);
			Iterator iterator = changeListeners.iterator();
			while (iterator.hasNext())
				((IParametersListViewer) iterator.next()).removeParameter(ip);
		}

		/**
		 * @param task
		 */
		public void parameterChanged(InterfaceParameter ip) {
			Iterator iterator = changeListeners.iterator();
			while (iterator.hasNext())
				((IParametersListViewer) iterator.next()).updateParameter(ip);
		}

		/**
		 * @param viewer
		 */
		public void removeChangeListener(IParametersListViewer viewer) {
			changeListeners.remove(viewer);
		}

		/**
		 * @param viewer
		 */
		public void addChangeListener(IParametersListViewer viewer) {
			changeListeners.add(viewer);
		}

	}

	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);
		System.out.println("[InterfaceParameters] parent=" + parent.toString());
		

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);

		FormData data;
		

		params = factory.createTable(composite, SWT.VIRTUAL | SWT.BORDER);
		/*
		 * GridData gridData = new GridData(GridData.FILL_BOTH);
		 * gridData.grabExcessVerticalSpace = true; gridData.horizontalSpan = 3;
		 * 
		 * params.setLayoutData(gridData);
		 */
		params.setLinesVisible(true);
		params.setHeaderVisible(true);

		// 1st column with image/checkboxes - NOTE: The SWT.CENTER has no
		// effect!!
		TableColumn column = new TableColumn(params, SWT.CENTER, 0);
		column.setText("Name");
		column.setWidth(200);

		// 2nd column with task Description
		column = new TableColumn(params, SWT.LEFT, 1);
		column.setText("Direction");
		column.setWidth(50);

		// 3rd column with task Owner
		column = new TableColumn(params, SWT.LEFT, 2);
		column.setText("Type");
		column.setWidth(250);

		column = new TableColumn(params, SWT.LEFT, 3);
		column.setText("");
		column.setWidth(16);
		params.setItemCount(10);
		/*
		 * params.setItemCount (10); params.addListener (SWT.SetData, new
		 * Listener () { public void handleEvent (Event event) { TableItem item
		 * = (TableItem) event.item; int index = params.indexOf (item);
		 * item.setText ("Item " + index); System.out.println (item.getText ());
		 * } });
		 */
		params.addListener (SWT.MouseDoubleClick, 
				new Listener () 
				{ 
					public void handleEvent (Event event) 
					{ 
						System.out.println("[InterfaceParameters] call handleevent " + event.item + "data " + event.data);
						TableItem item = (TableItem) event.item;
						if ((item != null) && (item.getImage() != null))
						{
							System.out.println("[InterfaceParameters] get image not null");
						
						int index = params.indexOf (item);
						System.out.println("[InterfaceParameters] index = " + index);
						System.out.println (item.getText ());
				  
						}
					}
				});
				 
		tableViewer = new TableViewer(params);
		tableViewer.setUseHashlookup(true);

		tableViewer.setColumnProperties(columnNames);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];

		// Column 1 : Name
		editors[0] = new TextCellEditor(params);

		// Column 2 : Direction (Combo Box)
		editors[1] = new ComboBoxCellEditor(params,
				parametersList.getDirections());

		// Column 3 : Type (Free text)
		typesEditor = new ComboBoxCellEditor(params, parametersList.getTypes()); 
		editors[2] = typesEditor;
		
		// Column 4 : cross to delete a parameter
		editors[3] = new ImageCellEditor();
		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer

		tableViewer.setCellModifier(new ParameterCellModifier(this));

		params.addSelectionListener(new ParametersListener());
		tableViewer.setContentProvider(new ParametersContentProvider());
		tableViewer.setLabelProvider(new ParameterLabelProvider());
		tableViewer.setInput(parametersList);


		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		params.setLayoutData(data);
		
		CLabel valueLabel = factory.createCLabel(composite, "Parameters:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(params, 0);
		data.top = new FormAttachment(params, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		PictogramElement pe = getSelectedPictogramElement();
		System.out.println("[InterfaceParameters] pe=" + pe);

		if (pe != null) {
			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);
			System.out.println("[InterfaceParameters] bo=" + bo);

			if ((bo != null) && (bo instanceof Interface))
				associatedInterface = (Interface) bo;
			
		}

	}

	public java.util.List getColumnNames() {
		return Arrays.asList(columnNames);
	}

	public String[] getChoices(String property) {
		if (property.equals("Direction"))
		{
			return parametersList.getDirections();
		}
		if (property.equals("Type"))
		{
			return parametersList.getTypes();
		}
		
		return new String[] {};
	}

	public void refresh() {
		
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);

			if (bo == null) {
				return;
			}
			else
			{
				if (typesEditor != null )
				{
					typesEditor.setItems(DataViewWrapper.getDataTypes());
				}
				
				if ((associatedInterface == null ) && (bo instanceof Interface))
				{
					associatedInterface = (Interface)bo;
					System.out.println("[InterfaceParameters] call refresh with bo=" + bo);
					for (InterfaceParameter tmp : associatedInterface.getParameters())
					{
						System.out.println("[InterfaceParameters] Try to add the following parameter" + tmp.getName());

						if (! parametersList.contains (tmp))
						{
							System.out.println("[InterfaceParameters] Add Parameter during refresh" + tmp.getName());
							parametersList.add (tmp);
						}
						else
						{
							System.out.println("[InterfaceParameters] Parameter already added (refresh): " + tmp.getName());
						}
					}
				}
				tableViewer.refresh();
			}
		}
	}

}