package application.types;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import application.settings.constants;


public class TLine extends Line2D{
	private TPoint start, end;
	
	public TLine()
	{
		super();
		
		this.start = new TPoint();
		this.end = new TPoint();
		
		super.setLine(start.cnvTPtoP2D(), end.cnvTPtoP2D()); //now we can use the original functions as well
	}

	public TLine(TPoint start, TPoint end) {
		super();
		
		super.setLine(start.cnvTPtoP2D(), end.cnvTPtoP2D());
		
		this.start = start;
		this.end = end;
	}
	
	public boolean intersects(TLine line)
	{
		if (start == null || end == null)
			return false;
		
		return this.intersectsLine(line.start.x, line.start.y, line.end.x, line.end.y);
	}
	
	public double length()
	{
		if (start == null || end == null)
			return 0.0;
		
		return start.distance(end);
	}
	
	public double distance(int where, TPoint from)
	{
		TPoint point = null;
		switch(where)
		{
			case constants.DISTANCE_START: point = start; 
				break;	
			
			case constants.DISTANCE_END: point = end; 
				break;
			
			case constants.DISTANCE_BETWEEN: return distance(from);
			
			default:
				return 0;
		}	
	
		return from.distance(point);
	}
	
	
	private double distance(TPoint from) {
		return (Math.abs((end.y - start.y) * from.x - (end.x - start.x)* from.y + end.x * start.y - end.y * start.x) / 
			   (Math.sqrt(Math.pow(end.y - start.y, 2)) + Math.pow(end.x - start.x, 2))
				);
	}

	public double angle()
	{
		return start.angle(end);
	}
	
	public TPoint start()
	{
		return this.start;
	}
	
	public TPoint end()
	{
		return this.end;
	}
	
	public void setStart(TPoint point)
	{
		this.start = point;
	}
	
	public void setEnd(TPoint point)
	{
		this.end = point;
	}
	
	public TPoint getStart()
	{
		return this.start;
	}
	
	public TPoint getEnd()
	{
		return this.end;
	}

	@Override
	public Rectangle2D getBounds2D() {
		Rectangle2D bounds = new Rectangle2D.Double();
		
		bounds.add(start.cnvTPtoP2D());
		bounds.add(end.cnvTPtoP2D());
		
		return bounds;
	}

	@Override
	public Point2D getP1() {
		return start.cnvTPtoP2D();
	}

	@Override
	public Point2D getP2() {
		// TODO Auto-generated method stub
		return end.cnvTPtoP2D();
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return start.getX();
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return end.getX();
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return start.getY();
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return end.getX();
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		super.setLine((new TPoint((int) x1, (int) y1)).cnvTPtoP2D(), (new TPoint((int) x2, (int) y2)).cnvTPtoP2D());
	}
}
