package application.types;

import java.awt.Polygon;
import java.util.ArrayList;

import application.debug.debug;

public class TPolygon extends Polygon{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3381601519632911424L;
	private TPointArray points;
	private ArrayList<TLine> vertices;
	
	public TPolygon()
	{
		super();
		
		this.points = new TPointArray();
		this.vertices = new ArrayList<TLine>();
	}
	
	public void setPoints(TPointArray points)
	{
		this.points = points;
	}
	
	public TPointArray getPoints()
	{
		return this.points;
	}
	
	public boolean inside(TPoint p)
	{

		
		return false;
	}
	
	public void form()
	{
		for (int i = 0; i < this.points.size() - 1; i++)
			this.vertices.add(new TLine(this.points.get(i), this.points.get(i + 1)));
		
		debug.log.entry("Vertices formed.");
	}
	
	public void clear()
	{
		this.vertices.clear();
	}
	
	
	
	public ArrayList<TLine> getVertices()
	{
		return this.vertices;
	}
	
	public boolean touches(TPolygon poly)
	{
		for (TLine verticeA : this.vertices)
			for (TLine verticeB : poly.vertices)
				if (verticeA.intersects(verticeB))
					return true;
		
		return false;
	}
	
	public TBox bounds()
	{
		if (points.size() == 0)
			return null;
	
		
		return null;
	}
}
