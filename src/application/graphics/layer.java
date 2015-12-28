package application.graphics;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
@SuppressWarnings("unused")
public class layer extends Canvas{
	private ArrayList<sprite> sprites;
	private boolean __static;
	
	
	public layer()
	{
		super();
	}
	
	public void clear()
	{
		
	}
	
	public void refresh()
	{
		this.clear();
		
		for (int i = 0; i < sprites.size(); i++)
			sprites.get(i).draw();
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
