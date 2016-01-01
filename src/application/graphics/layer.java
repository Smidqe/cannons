package application.graphics;

import java.util.ArrayList;

import application.types.TBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
@SuppressWarnings("unused")
public class layer extends Canvas{
	private ArrayList<sprite> sprites;
	private boolean __static;
	private int c_bg;
	
	public layer()
	{
		super();
	}
	
	public void clear()
	{
		this.getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
	}
	
	public void clear(TBox box)
	{
		this.getGraphicsContext2D().clearRect(box.getX1(), box.getY1(), box.width(), box.height());
	}
	
	public void refresh()
	{
		this.clear();
		
		for (sprite s : sprites)
			s.draw();
	}
	
	public void add(sprite s)
	{
		sprites.add(s);
	}
	
	public void add(ArrayList<sprite> a)
	{
		for (sprite s : a)
			this.add(s);
	}
	
	public void focus()
	{
		this.toFront();
	}
	
	public Canvas canvas()
	{
		return this.getGraphicsContext2D().getCanvas();
	}
	
	public GraphicsContext context()
	{
		return this.getGraphicsContext2D();
	}
}
