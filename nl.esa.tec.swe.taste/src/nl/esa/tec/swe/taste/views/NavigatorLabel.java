package nl.esa.tec.swe.taste.views;

import nl.esa.tec.swe.taste.commands.NavigatorCommands;
import nl.esa.tec.swe.taste.metamodel.taste.Function;

import org.eclipse.core.resources.IProject;

public class NavigatorLabel {
	private String action;
	private IProject project;
	private int commandId = NavigatorCommands.COMMAND_UNKNOWN;
	private Function associatedFunction;
	
	
	public NavigatorLabel (IProject ip, String l)
	{
		project = ip;
		action = l;
		associatedFunction = null;
	}
	
	public NavigatorLabel (IProject ip, String l, int c)
	{
		this (ip, l);
		commandId = c;
	}
	
	public NavigatorLabel (IProject ip, String l, int c, Function f)
	{
		this (ip, l, c);
		associatedFunction = f;
	}
	
	public String getAction()
	{
		return action;
	}
	
	public IProject getProject ()
	{
		return project;
	}
	
	public Function getAssoFunction()
	{
		return associatedFunction;
	}
	
	public int getCommandId ()
	{
		return commandId;
	}
}
