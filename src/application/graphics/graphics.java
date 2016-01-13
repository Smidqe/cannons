package application.graphics;

//FIGURE OUT WHETHER TO USE THIS OR SOMETHING ELSE!!!!!!

import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import application.types.*;
import application.misc.utils;

@SuppressWarnings("unused")
public class graphics extends Canvas{
	public enum LAYER {BACKGROUND, GROUND, BARRELS, TURRETS};
	
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
	
	public void background()
	{
		graphics_context(0).setStroke(Color.LIGHTGREY);
		graphics_context(0).rect(0, 0, getWidth(), getHeight());
	}
	public void draw(int t) {
		// TODO Auto-generated method stub
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
	
	public void draw_arc()
	{
	
	}
}
