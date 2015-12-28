package application.types;

import java.util.ArrayList;

public class TBox {
	private int x1, x2, y1, y2;
	public TBox()
	{
	}
	
	public TBox(int width, int height)
	{
		this.x2 = width;
		this.y2 = height;
	}

	public TBox(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public TBox(TPoint s, TPoint e)
	{
		this.x1 = s.x;
		this.y1 = s.y;
		
		this.x2 = e.x;
		this.y2 = e.y;
	}
	
	public int width()
	{
		return Math.abs(x2 - x1);
	}
	
	public int height()
	{
		return Math.abs(y2 - y1);
	}

	public int area()
	{
		return width() * height();
	}

	public void shift(int dx, int dy)
	{
		this.x1 += dx;
		this.x2 += dx;
		
		this.y1 += dy;
		this.y2 += dy;
	}
	
	public void shift(TPoint p)
	{
		shift(p.x, p.y);
	}
	
	public TPoint middle()
	{
		return new TPoint((int) width() / 2, (int) height() / 2);
	}
	
	public ArrayList<Integer> dimensions()
	{
		ArrayList<Integer> r = new ArrayList<Integer>();
		
		r.add(width());
		r.add(height());
		
		return r;
	}
	
	public void normalize()
	{
		int tmp = 0;
		
		if (this.x1 > this.x2)
		{
			tmp = this.x1;
			
			this.x2 = this.x1;
			this.x1 = tmp;
		}
		
		if (this.y1 > this.y2)
		{
			tmp = this.y1;
			
			this.y2 = this.y1;
			this.y1 = tmp;
		}
	}
	
	public TBox copy()
	{
		return new TBox(width(), height());
	}
	
	public void set(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void set(TPoint p1, TPoint p2)
	{
		this.set(p1.x, p1.y, p2.x, p2.y);
	}
	
	public void edit(int x1, int y1, int x2, int y2)
	{
		this.x1 += x1;
		this.y1 += y1;
		this.x2 += x2;
		this.y2 += y2;
	}
	
	public void shrink(int size)
	{
		this.edit(size, size, -size, -size);
	}
	
	public void expand(int size)
	{
		this.edit(-size, -size, size, size);
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}
}
