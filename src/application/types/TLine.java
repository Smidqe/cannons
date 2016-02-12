package application.types;
import application.settings.constants;

public class TLine {
	private TPoint start, end;
	
	public TLine()
	{
		this.start = new TPoint();
		this.end = new TPoint();
	}

	public TLine(TPoint start, TPoint end) {
		this.start = start;
		this.end = end;
	}
	
	public boolean intersects(TLine line)
	{
		if (start == null || end == null)
			return false;
		

	
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
}
