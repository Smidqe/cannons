package application.misc;

import java.util.Random;

public class randoms extends Random{

	public randoms()
	{
		super();
	}
	
	public int random(int min, int max)
	{
		return min + nextInt(max - min);
	}
	
	public int random(int max)
	{
		return nextInt(max);
	}
	
	public double random(double min, double max)
	{
		return min + (nextDouble() * (max - min)); 
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
