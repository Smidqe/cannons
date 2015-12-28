package application.graphics;

import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import application.types.*;

@SuppressWarnings("unused")
public class graphics extends Canvas{
	private GraphicsContext __gh; 
	private layer __layer;
	
	protected graphics()
	{
		super();
		__gh = super.getGraphicsContext2D();
	//	__layer.layer(0);
	}

	public void background()
	{
	//	__gh = __layer.current().getGraphicsContext2D();
		__gh.setStroke(Color.LIGHTGREY);
		__gh.rect(0, 0, getWidth(), getHeight());
	}
	public void draw(int t) {
		// TODO Auto-generated method stub
	}
	
	public void draw_image(double x, double y)
	{
		__gh.drawImage(new Image(""), x, y);
	}
}
