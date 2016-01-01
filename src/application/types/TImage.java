package application.types;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

public class TImage extends Image{

	public TImage(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}
	/*
	public TColorData T2DArray()
	{
		int x, y;
		
		ArrayList<TPointArray> r = new ArrayList<TPointArray>((int) this.getWidth());
		
		for (x = 0; x < this.getWidth(); x++)
			for (y = 0; y < this.getHeight(); y++)
				r.get(x).append(p);
	}
	*/
	public ArrayList<TPoint> outlines()
	{
	//	PixelReader r = this.getPixelReader();
		
		
		
		return null;
	}
}
