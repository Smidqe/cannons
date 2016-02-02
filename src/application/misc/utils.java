package application.misc;

public class utils {

	public static boolean inRange(int i, int min, int max)
	{
		return (i > min && i < max);
	}
	
	public static boolean inRange(double d, double min, double max)
	{
		return (d > min && d < max);
	}
}
