package nl.esa.tec.swe.taste.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class MainView extends ViewPart {
    private Label label;
	public MainView() {
		super ();
	}

    public void setFocus() {
        label.setFocus();
    }
public void createPartControl(Composite parent) {
        label = new Label(parent, 0);
        label.setText("Hello World");
}

}
