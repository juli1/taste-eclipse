package nl.esa.tec.swe.taste.wizard.preferences;

public class PreferencesHelper {
	
	
	public static boolean getExpertModeEnable()
	{
		return (nl.esa.tec.swe.taste.wizard.Activator.getDefault().getPreferenceStore().getBoolean ("TASTEEXPERTMODE"));
	}
	
	public static String getAsn2AadlPath()
	{
		return (nl.esa.tec.swe.taste.wizard.Activator.getDefault().getPreferenceStore().getString("ASN2AADLPATH"));
	}
	
	public static String getTastedServer()
	{
		return (nl.esa.tec.swe.taste.wizard.Activator.getDefault().getPreferenceStore().getString("TASTED"));
	}
	
	public static String getAsn1SccPath()
	{
		return (getAsn2AadlPath() + "../asn1scc/asn1.exe");
	}
	
	
	public static boolean generateDataViewWithTasted ()
	{
		return (nl.esa.tec.swe.taste.wizard.Activator.getDefault().getPreferenceStore().getString("DATAVIEWGENERATION").equalsIgnoreCase("net"));
	}

	public static boolean generateDataViewWithCommand ()
	{
		return (nl.esa.tec.swe.taste.wizard.Activator.getDefault().getPreferenceStore().getString("DATAVIEWGENERATION").equalsIgnoreCase("cmd"));
	}
}
