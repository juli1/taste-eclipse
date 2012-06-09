package nl.esa.tec.swe.taste.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {
	  private static final String VIEW_ID =
		        "nl.esa.tec.swe.taste.view";


		  private static final String BOTTOM = "bottom";

		  
		public void createInitialLayout(IPageLayout layout) {
			boolean expertEnable = nl.esa.tec.swe.taste.wizard.preferences.PreferencesHelper.getExpertModeEnable ();
			layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
			layout.addActionSet("nl.esa.tec.swe.taste.actionset");
			
			if (expertEnable)
			{
				System.out.println("[PerspectiveFactory] Add expert actions");
				layout.addActionSet("nl.esa.tec.swe.taste.actionsetexpert");
			}
			System.out.println("[PerspectiveFactory] DO NOT add expert actions");
			
        // Editors are placed for free.
        String editorArea = layout.getEditorArea();

        // Place navigator and outline to left of
        // editor area.
        IFolderLayout left =
                layout.createFolder("left", IPageLayout.LEFT, (float) 0.26, editorArea);
        left.addView(IPageLayout.ID_RES_NAV);
        left.addView(IPageLayout.ID_OUTLINE);
        left.addView("nl.esa.tec.swe.taste.views.navigator");
	}

}
