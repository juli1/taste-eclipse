package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;

public class Constants {
	public final static int PLATFORM_NATIVE_INDEX    = 0;
	public final static int PLATFORM_LINUX32_INDEX   = 1;
	public final static int PLATFORM_LINUX64_INDEX   = 2;
	public final static int PLATFORM_LEON2_INDEX     = 3;
	public final static int PLATFORM_WIN32_INDEX     = 4;

	
	public final static int LANGUAGE_C_INDEX           = 0;
	public final static int LANGUAGE_ADA_INDEX         = 1;
	public final static int LANGUAGE_RTDS_INDEX        = 2;
	public final static int LANGUAGE_SIMULINK_INDEX    = 3;
	
	
	
	public final static int DRIVER_ETHERNET_INDEX      = 0;
	public final static int DRIVER_SPACEWIRE_INDEX     = 1;
	public final static int DRIVER_SERIAL_INDEX        = 2;
	public final static int DRIVER_1553_INDEX          = 3;
	
	public final static int BUS_ETHERNET_INDEX      = 0;
	public final static int BUS_SPACEWIRE_INDEX     = 1;
	public final static int BUS_SERIAL_INDEX        = 2;
	public final static int BUS_1553_INDEX          = 3;
	
	public final static int INTERFACE_CYCLIC_INDEX          = 0;
	public final static int INTERFACE_SPORADIC_INDEX        = 1;
	public final static int INTERFACE_PROTECTED_INDEX       = 2;
	public final static int INTERFACE_UNPROTECTED_INDEX     = 3;
	
	public final static int PARAMETER_DIRECTION_IN = 1;
	public final static int PARAMETER_DIRECTION_OUT = 2;
	
	
	public static String getDriverComponentName (Driver drv)
	{
		String ret;
		ret = "ocarina_drivers::generic_sockets_ip.pohic";
		if ((drv == null) || (drv.getType() == null))
		{
			return ret;
		}
		
		if (drv.getType().equals("Ethernet"))
		{
			ret = "ocarina_drivers::generic_sockets_ip.pohic";
			if (drv.getAssociatedBoard().getType().equals("Leon2"))
			{
				ret = "ocarina_drivers::leon_ethernet.raw";
			}
		}
		
		if (drv.getType().equals("SpaceWire"))
		{
			ret = "ocarina_drivers::usb_brick_spacewire.pohic";
			if (drv.getAssociatedBoard().getType().equals("Leon2"))
			{
				ret = "ocarina_drivers::rasta_spacewire.pohic";
			}
		}
		
		if (drv.getType().equals("Serial"))
		{
			
			ret = "ocarina_drivers::generic_serial.raw";
			if (drv.getAssociatedBoard().getType().equals("Leon2"))
			{
				ret = "ocarina_drivers::rasta_serial.raw";
			}
		}
		return ret;
	}
	
	
	public static String getBusComponentName (Bus bus)
	{
		String ret;
		
		ret = "ocarina_buses::ip.i";
		
		if ((bus == null) || (bus.getType() == null))
		{
			return ret;
		}
		
		if (bus.getType().equals("Ethernet"))
		{
			ret = "ocarina_buses::ip.i";
		}
		
		if (bus.getType().equals("SpaceWire"))
		{
			ret = "ocarina_buses::spacewire.generic";	
		}
		
		if (bus.getType().equals("Serial"))
		{
			ret = "ocarina_buses::serial.generic";
		}
		return ret;
	}
	
	public static String getProcessorComponentName (Board board)
	{
		String ret;
		
		ret = "ocarina_processors_x86::x86.linux32";
		if ((board == null) || (board.getType() == null))
		{
			return ret;
		}
		
		if (board.getType().equals("Native"))
		{
			ret = "ocarina_processors_x86::x86.native";
		}
		
		if (board.getType().equals("Win32"))
		{
			ret = "ocarina_processors_x86::x86.win32";
		}
		
		if (board.getType().equals("Linux 32 bits"))
		{
			ret = "ocarina_processors_x86::x86.linux32";
		}
		
		if (board.getType().equals("Linux 64 bits"))
		{
			ret = "ocarina_processors_x86::x86.linux64";
		}
		
		if (board.getType().equals("Leon2"))
		{
			ret = "ocarina_processors_leon::leon.rtems_posix";
		}
	
		
		return ret;
	}
}
