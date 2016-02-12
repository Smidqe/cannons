package application.types;

public class TCircle {
	private TPoint center;
	private double radius;
	
	public TCircle()
	{
		
	}
	
	public void set_radius()
	{
		
	}
	
	public void set_center()
	{
		
	}
	
	public boolean touches(TPoint point)
	{
		return center.distance(point) < radius;
	}

	public double getRadius() {
		return radius;
	}
}
