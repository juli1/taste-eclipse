/*******************************************************************************
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package nl.esa.tec.swe.taste.branding;


import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Plug-in class for the browser example.
 */
public class TastePlugin extends AbstractUIPlugin {
    private static TastePlugin DEFAULT;
    
    public TastePlugin() {
        DEFAULT = this;
    }

    public static TastePlugin getDefault() {
        return DEFAULT;
    }

    /**
     * Logs the given throwable.
     * 
     * @param t the throwable to log
     */
    public void log(Throwable t) {
        String msg = t.getMessage();
        if (msg == null)
            msg = t.toString();
        IStatus status = new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, msg, t);
        getLog().log(status);
    }
    

}
