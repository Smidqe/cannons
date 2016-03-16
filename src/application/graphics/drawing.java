package application.graphics;

import javafx.scene.canvas.*;
import javafx.scene.transform.Rotate;
import application.types.TArc;
import application.types.TPoint;
import application.types.TPointArray;
import application.types.TTimer;

public class drawing {	
	private Canvas canvas;
	
	public drawing(Canvas canvas)
	{
		this.canvas = canvas;
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
	
	public int find(String name, layer layer, boolean debug)
	{
		int index = 0;
		for (sprite s : layer.getSprites())
		{
			if (s.getName().equals(name))
				return index;
			
			index++;
		}
		
		return -1;
	}
	
	public sprite find(String name, layer layer)
	{
		int location = find(name, layer, false);
		
		if (location == -1)
			return null;
		else
			return layer.getSprite(location);	
	}
	
	public void draw(sprite sprite, TArc arc)
	{
		TPointArray points = arc.getArc();
		
		double angle = 0;
		for (int i = 0; i < points.size(); i++)
		{
			if (!(i + 1 == points.size()))
				angle = points.get(i).angle(points.get(i + 1));

			draw(sprite, points.get(i));
			sprite.rotate(angle);
		}
	}

	public void draw(sprite sprite, TPoint point)
	{
		sprite.setPoint(point);
		
		draw(sprite);
	}
	
    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
	
	public void draw(double angle, sprite sprite)
	{
		context().save(); // saves the current state on stack, including the current transform
        
        rotate(context(), angle, sprite.getPoint().getX() + sprite.getImage().getWidth() / 2, sprite.getPoint().getY() + sprite.getImage().getHeight() / 2);
        
        context().drawImage(sprite.getImage(), sprite.getPoint().getX(), sprite.getPoint().getY());
        context().restore(); // back to original state (before rotation)
	}
	
	public void draw(double angle, double speed, sprite sprite)
	{
		
	}
	
	//Draws sprite along the points, (check the angle?)
	public void draw(sprite sprite, TPointArray array)
	{
		for (TPoint p : array.points)
			draw(sprite, p);
		
		//debug.log.entry("draw(sprite, array): Sprites drawn")
	}
	
	public void draw(sprite sprite)
	{
		refresh();
		
		TPoint p = sprite.getPoint();
		
		if (sprite.getImage() == null)
			System.out.println("Image is null");

		if (sprite.getRotation() != 0.0)
			draw(sprite.angle(), sprite);
		else
			canvas.getGraphicsContext2D().drawImage(sprite.getImage(), p.x, p.y);
	
	}
	
	private void refresh() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public void draw(sprite sprite, TPoint direction, double speed)
	{
		if (speed == 0)
		{
			draw(sprite, direction);
			return;
		}
		
		move(direction, sprite);
	}

	
	public Canvas canvas()
	{
		return this.canvas;
	}
	
	public GraphicsContext context()
	{
		return canvas.getGraphicsContext2D();
	}
}
