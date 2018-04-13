package ca.mcgill.cs.jetuml;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import java.util.Map;

/**
 * @author Martin P. Robillard
 * 
 * Utility class to provides test oracle values that are dependent on
 * a specific system configuration.
 *
 */
public final class ConfigurationSpecificValues
{
	enum Config
	{
		Undetected, Windows10, MacOs
	}
	
	public enum Value
	{
		WidthOfInterfaceNode,
		HeightOf4Xes,
		HeightOf3Xes
	}
	
	private static final int[][] VALUES = {
			{101,100},	
			{98, 84},
			{74, 64}
	};
	
	private static final Config CONFIG = detect();
	
	private ConfigurationSpecificValues() {}
	
	public static int get(Value pValue)
	{
		assumeTrue(CONFIG != Config.Undetected);
		return VALUES[pValue.ordinal()][CONFIG.ordinal()-1];
	}
	
	private static Config detect()
	{
		Config result = Config.Undetected;
		String osname = System.getProperty("os.name");
		if( osname == null )
		{
			osname = "";
		}
		if( System.getProperty("os.name").equals("Windows 10"))
		{
			result = Config.Windows10;
		}
		return result;
	}
	
	
}
