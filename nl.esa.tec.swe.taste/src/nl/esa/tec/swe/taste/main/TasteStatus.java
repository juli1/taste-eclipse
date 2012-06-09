package nl.esa.tec.swe.taste.main;

import org.eclipse.core.runtime.IStatus;


public class TasteStatus implements IStatus {
		 
	public final static int codeAsn1NotFound = 1;
	
	
	private int code;
	private int severity;
	private String str;
	
	public TasteStatus (String msg)
	{
		this.str = msg;
	}
	
	public TasteStatus (String msg, int code, int severity)
	{
		this.str = msg;
		this.code = code;
		this.severity = severity;
	}
	
	
	public IStatus[] getChildren() {
		return null;
	}

	public int getCode() {
		return IStatus.ERROR;
	}

	public Throwable getException() {
		return null;
	}

	public String getMessage() {
		return str;
	}

	public String getPlugin() {
		return Activator.PLUGIN_ID;
	}

	public int getSeverity() {
		return IStatus.ERROR;
	}

	public boolean isMultiStatus() {
		return false;
	}

	public boolean isOK() 
	{
		return false;
	}

	public boolean matches(int severityMask) 
	{
		return false;
	}

}