package application.types;

import javafx.scene.paint.Color;

public class TColorData {
	private TPoint point;
	private Color color;
	
	public TColorData()
	{
		point = new TPoint();
	}
	
	public TPoint pos()
	{
		return point;
	}
	
	public Color getColor()
	{
		return color;
	}
}
