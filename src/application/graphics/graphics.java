package application.graphics;

import javafx.scene.canvas.*;

import java.util.ArrayList;

import application.misc.utils;
import application.types.TArc;
import application.types.TPoint;
import application.types.TPointArray;
import application.types.TTimer;

public class graphics {
	private ArrayList<layer> layers;
	
	protected graphics()
	{
		super();
		
		layers = new ArrayList<layer>();
	}

	public layer layer(int index)
	{
		if (!utils.inRange(index, 0, layers.size()))
			return null;
		
		return layers.get(index);
	}

	public GraphicsContext graphics_context(int index)
	{
		if (!utils.inRange(index, 0, layers.size()))
			return null;
		
		return layer(index).getGraphicsContext2D();
	}
	
	public void rotate(double angle, double speed, sprite sprite)
	{
		if (speed == 0)
			draw(angle, sprite);
	
		
	}
	
	public void move(TPoint direction, int duration, sprite sprite)
	{
		TTimer timer = new TTimer();
		TPoint point = sprite.getPoint();
		
		do 
		{
			draw(sprite, point);			
			point.offset(direction);
		} while (duration > timer.getTime());
		
		sprite.setPoint(point);
	}
	
	public void move(TPoint direction, sprite sprite)
	{
		this.move(direction, 0, sprite);
	}
	
	public void move(TPointArray path, sprite sprite)
	{
		if (path == null || path.size() == 0)
			return;
			
		for (TPoint p : path.points)
			move(p, sprite);
	}
	
	public void move(TArc arc, sprite sprite)
	{
		move(arc.getArc(), sprite);
	}
	
	public void add_layer()
	{
		layers.add(new layer());
	}
	
	public void add_layer(int num)
	{
		for (int i = 0; i < num; i++)
			add_layer();
	}
	
	public sprite find(String name)
	{
		return null;
	}
	
	public void draw(sprite sprite, TArc arc)
	{
	
	}

	public void draw(sprite sprite, TPoint point)
	{
		sprite.setPoint(point);
		
		draw(sprite);
	}
	
	public void draw(double angle, sprite sprite)
	{
		
	}
	
	public void draw(double angle, double speed, sprite sprite)
	{
		
	}
	
	public void draw(sprite sprite, TPointArray array)
	{
		for (TPoint p : array.points)
			draw(sprite, p);
		
		
	}
	
	public void draw(sprite sprite)
	{
		TPoint p = sprite.getPoint();
		GraphicsContext current = this.layers.get(sprite.getLayer()).getGraphicsContext2D();
	
		current.drawImage(sprite.getImage(), p.x, p.y);
	}
	
	public void draw(sprite sprite, TPoint direction, double speed)
	{
		if (speed == 0)
		{
			draw(sprite, direction);
			return;
		}
		
		
	}
	
	public static graphics getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
