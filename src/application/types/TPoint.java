package application.types;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.geom.Point2D;

public class TPoint extends Point {

	@Override
	public String toString(){
		return new String("Point: (" + this.x + ", " + this.y + ")\n");
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
	
	public void modify(int x, int y)
	{
		this.x += x;
		this.y += y;
	}

	public void multiply(int x, int y)
	{
		this.x *= x;
		this.y *= y;
	}
	
	public void multiply(int v)
	{
		this.multiply(v, v);
	}
	
	public void modify(int v)
	{
		this.modify(v, v);
	}
	
	public boolean equals(TPoint p)
	{
		return (this.x == p.x && this.y == p.y);
	}
	
	public void offset(int X, int Y)
	{
		this.x += X;
		this.y += Y;
	}

	public void offset(TPoint p){
		this.offset((int) p.getX(), (int) p.getY());
	}
	
	public TPoint cnvPtoTP(Point p)
	{
		return new TPoint(p.x, p.y);
	}
	
	public Point2D cnvTPtoP2D()
	{
		return new Point2D.Double(this.x, this.y);
	}
	
	public TPoint pos()
	{	
		return cnvPtoTP(MouseInfo.getPointerInfo().getLocation());
	}
	
	public double angle(TPoint p)
	{
		double r = ((Math.atan2((p.y - this.y), (p.x - this.x)) * (180.0 / Math.PI)) + 90.0);
	
	  	return (r >= 0.0) ? r : r + 360.0;
	}
	
	public double distance(TPoint p)
	{
		return distance(this.x, this.y, p.x, p.y);
	}
	
	private static final long serialVersionUID = 1L;

	public double distance(TBox bounds, boolean center) {
		if (center)
			return (distance(bounds.middle()));
		
		return bounds.distance(this, center);
	}

	public void divide(int xdiv, int ydiv)
	{
		this.x /= xdiv;
		this.y /= ydiv;
	}
	
	public void divide(int size) {
		this.divide(size, size);
	}

	public void rotate(double angle, TPoint middle) {
		this.x = (int) Math.round(middle.x + Math.cos(angle) * (this.x - middle.x) - Math.sin(angle) * (this.y - middle.y));
		this.y = (int) Math.round(middle.y + Math.sin(angle) * (this.x - middle.x) + Math.cos(angle) * (this.y - middle.y));
	}
	
	
}
