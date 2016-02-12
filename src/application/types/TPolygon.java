package application.types;

import java.util.ArrayList;

public class TPolygon {
	private TPointArray points;
	private ArrayList<TLine> vertices;
	
	public TPolygon()
	{
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
	
	public boolean touches(TPolygon poly)
	{
		int[] size = {this.points.size(), poly.points.size()};
		
		for (int i = 0; i < size[0]; i++)
			for (int j = 0; j < size[1]; j++)
				if (points.points.get(i).distance(poly.points.points.get(i)) <= 1)
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
