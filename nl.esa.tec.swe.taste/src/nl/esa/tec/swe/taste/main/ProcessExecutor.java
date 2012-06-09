package nl.esa.tec.swe.taste.main;

import java.io.IOException;

public class ProcessExecutor implements Runnable
{
	private Process p;
	private ProcessBuilder pb;
	private int ret;
	public static final int EXEC_ERROR = -1;
	
	public ProcessExecutor(ProcessBuilder tmp)
	{
		p = null;
		pb = tmp;
		ret = 0;
	}
    
	public void run()
    {
		try {
			System.out.println("[ProcessExecutor] start task execution");

			p = pb.start();
			System.out.println("[ProcessExecutor] wait task completion");
			ret = p.waitFor();
			System.out.println("[ProcessExecutor] task finished");
		}
		catch (IOException e) 
		{
			ret = EXEC_ERROR;
			System.out.println("[ProcessExecutor] exception");
			e.printStackTrace();
		}
		catch (InterruptedException e) 
		{
			ret = EXEC_ERROR;
			System.out.println("[ProcessExecutor] exception");
			e.printStackTrace();
		}

	        	
    }
	
	public int getExitValue ()
	{

		System.out.println("[ProcessExecutor] exit value = " + ret);
		return ret;
	}
}
