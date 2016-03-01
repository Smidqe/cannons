package application.types;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class TCircle extends Ellipse2D{
	private TPoint center;
	private double radius;
	
	public TCircle()
	{
		super();
		
		
	}
	
	public void set_radius(double radius)
	{
		 this.radius = radius;
	}
	
	public void set_center(TPoint point)
	{
		this.center = point;
	}
	
	public void set_center(double x, double y)
	{
		this.center = new TPoint((int) x, (int) y);
	}
	
	public boolean inside(TPoint point)
	{
		return center.distance(point) < radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFrame(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		
	}
}
