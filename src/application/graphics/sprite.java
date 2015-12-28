package application.graphics;

import application.types.TPoint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class sprite {	
	private Image img;
	private TPoint p;
	private GraphicsContext gc;
	
	public sprite()
	{
		//img = new Image();
	}
	
	public sprite(Image img, TPoint p, GraphicsContext gc)
	{
		this.img = img;
		this.p = p;
		this.gc = gc;
	}
	
	public boolean change(String path)
	{
		return true;
	}
	
	public void draw() {
		if (gc == null)
			return;
		
		gc.drawImage(img, p.x, p.y);
	}
	
	public void draw(double angle)
	{
		if (gc == null)
			return;
		
		if (angle == 0.0)
		{
			this.draw();
			return;
		}
		
		
		
	}
}
