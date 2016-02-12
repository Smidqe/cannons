package application.types;

import java.util.ArrayList;
import java.util.List;

public class TPointArray {
	public ArrayList<TPoint> points;
	
	public TPointArray()
	{
		points = new ArrayList<TPoint>();
	}
	
	public TPointArray(List<TPoint> list) {
		points = new ArrayList<TPoint>(list);
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
		int deleted = 0;
		
		for (int i : indexes)
			this.delete(i - deleted++);
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
	
	public void swap(int __from, int __to)
	{
		TPoint tmp = this.points.get(__from);
		
		this.points.set(__from, this.points.get(__to));
		this.points.set(__to, tmp);
	}
	
	public boolean contains(TPoint p)
	{
		return (position(p) != -1);
	}
	
	public TPoint middle()
	{
		if (points == null || points.size() == 0)
			return null;
		
		TPoint result = new TPoint();
		for (TPoint p : points)
			result.modify((int) p.getX(), (int) p.getY());
		
		result.divide(points.size());
		return result;
	}
	
	public TBox bounds()
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
	
	public TPoint get(int index)
	{
		return this.points.get(index);
	}

	public ArrayList<TPoint> getPoints()
	{
		return this.points;
	}

	public int size() {
		return this.points.size();
	}

	public void rotate(double angle, TPoint point) {
		if (this.points.size() == 0)
			return;
		
		for (TPoint p : points)
			p.rotate(angle, point);
	}

}
