package application.types;

import java.util.ArrayList;

public class TPointArray {
	public ArrayList<TPoint> points;
	
	public TPointArray()
	{
		points = new ArrayList<TPoint>();
	}
	
	public void append(TPoint p)
	{
		if (points == null)
			return;
		
		points.add(p);
	}
	
	public void append(TPointArray a)
	{
		if (points == null)
			return;
		
		for (TPoint p : a.points)
			this.append(p);
	}
	
	public void delete(int index)
	{
		if (!(index >= 0 && index <= points.size()))
			return;
		
		points.remove(index);
	}
	
	public void delete(ArrayList<Integer> indexes)
	{
		for (int i : indexes)
			this.delete(i);
	}
	
	public int position(TPoint p)
	{
		if (points.size() == 0)
			return -1;
		
		int i;
		for (i = 0; i < points.size(); i++)
			if (points.get(i).equals(p))
				return i;
		
		return -1;
	}
	
	public boolean inside(TPoint p)
	{
		return (position(p) != -1);
	}
	
	public TBox bounds() //TODO: Finish
	{
		if (points == null || points.size() == 0)
			return null;
		
		TBox b = new TBox(points.get(0), points.get(0));
		
		for (TPoint p : points)
		{
			//check if the point is to the left, move the starting point
			b.setX1(p.x < b.getX1() ? p.x : b.getX1());
			b.setY1(p.y < b.getY1() ? p.x : b.getY1());
			
			//check if the point is to the right, increase the size of the box (move the second point)
			b.setX2(p.x > b.getX2() ? p.x : b.getX2());
			b.setY2(p.x > b.getY2() ? p.x : b.getY2());
		}
		
		return b;
	}
	
	public ArrayList<TPoint> getPoints()
	{
		return this.points;
	}

	public int size() {
		return this.points.size();
	}

}
