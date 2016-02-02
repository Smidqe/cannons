package application.types;

import java.util.ArrayList;
import java.util.Arrays;

import application.misc.utils;

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
		return new ArrayList<Integer>(Arrays.asList(width(), height()));
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

	public boolean touches(TBox b)
	{
		return (this.x1 == b.x2 || this.y1 == b.y2 || this.x2 == b.x1 || this.y2 == b.y1);
	}
	
	public boolean overlap(TBox b) 
	{
		return  (!((this.x1 > b.x2) || (this.x2 < b.x1) || (this.y1 > b.y2) || (this.y2 < b.y1)));
	}
	
	public boolean same(TBox box)
	{
		return similar(box, 0);
	}
	
	public boolean similar(TBox box, int threshold)
	{
		return (utils.inRange(this.width(), box.width() - threshold, box.width() + threshold) && 
				utils.inRange(this.height(), box.height() - threshold, box.height() + threshold));
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

	public void setX1(int i) {
		// TODO Auto-generated method stub
		this.x1 = i;
	}
	public void setX2(int i) {
		// TODO Auto-generated method stub
		this.x2 = i;
	}
	public void setY1(int i) {
		// TODO Auto-generated method stub
		this.y1 = i;
	}
	public void setY2(int i) {
		// TODO Auto-generated method stub
		this.y2 = i;
	}


}
