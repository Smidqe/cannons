package application.graphics.cannon;

import application.types.TBox;

@SuppressWarnings("unused")

public class cannon {
	private double x, y, angle;
	private TBox bounds;
	private barrel __barrel;
	private boolean drawn;
	
	public cannon(double x, double y)
	{
		this.x = x;
		this.y = y;
		
		__barrel = new barrel(x, y);
	}
	
	public void move(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	
	
	public void draw()
	{
		if (drawn)
			return; //no need to recreate();
		
		
		drawn = true;
	}
	
	public void rotate(double angle)
	{
		__barrel.rotate(angle);
	}
}
