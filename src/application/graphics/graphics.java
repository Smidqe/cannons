package application.graphics;

import java.util.ArrayList;

public class graphics {
	private int current_layer;
	private ArrayList<layer> layers;
	private static graphics __self = new graphics();
	
	private graphics()
	{
		current_layer = 0;
		layers = new ArrayList<layer>();
	}
	
	public void add_layer(layer layer)
	{
		layers.add(layer);
	}
	
	
	public layer get_layer(int index)
	{
		return layers.get(index);
	}
	
	public ArrayList<layer> getLayers()
	{
		return this.layers;
	}
	
	public int get_current_layer()
	{
		return current_layer;
	}

	public static graphics instance() {
		// TODO Auto-generated method stub
		return __self;
	}

	public void draw() 
	{
		for (layer l : layers)
			l.draw();
	}
}
