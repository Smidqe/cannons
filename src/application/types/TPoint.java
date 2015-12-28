package application.types;

import java.awt.MouseInfo;
import java.awt.Point;

public class TPoint extends Point {

	@Override
	public String toString(){
		return new String("P: (" + this.x + ", " + this.y + ")\n");
	}

	public void print()
	{
		System.out.println(this.toString());
	}
	
	public TPoint()
	{
	}
	
	public TPoint(int X, int Y){
		this.x = X;
		this.y = Y;
	}

	public void offset(int X, int Y){
		this.x += X;
		this.y += Y;
	}

	public void offset(int a){
		this.offset(a, a);
	}
	
	public TPoint convert(Point p){
		return new TPoint(p.x, p.y);
	}
	
	public TPoint pos(){	
		return convert(MouseInfo.getPointerInfo().getLocation());
	}
	
	public double angle(TPoint p)
	{
		double r = ((Math.atan2((p.y - this.y), (p.x - this.x)) * (180.0 / Math.PI)) + 90.0);
	  	
		if (r < 0.0)
	  		r = (r + 360.0);
	  	
	  	return r;
	}
	
	private static final long serialVersionUID = 1L;
}