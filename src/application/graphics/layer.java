package application.graphics;

import java.util.ArrayList;

import application.types.TBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/*
	- TODO:
		- Finish
		- Move to types!
		- 



*/


public class layer extends drawing{
	private String name;
	private ArrayList<sprite> sprites;
	private boolean __static;

	public layer(Canvas canvas)
	{
		super(canvas);
		
		sprites = new ArrayList<sprite>();
	}

	public layer(boolean Static, Canvas canvas)
	{
		super(canvas);
		
		this.sprites = new ArrayList<sprite>();
		this.__static = Static;
	}
	
	public boolean isStatic()
	{
		return this.__static;
	}
	
	public void setStatic(boolean Static)
	{
		this.__static = Static;
	}
	
	public void clear()
	{
		context().clearRect(0, 0, canvas().getWidth(), canvas().getHeight());
	}
	
	public void clear(TBox box)
	{
		context().clearRect(box.getX1(), box.getY1(), box.width(), box.height());
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void refresh()
	{
		if (this.__static)
			return;
		
		this.clear();
		
		for (sprite s : sprites)
			draw(s);
	}
	
	public void refresh(ArrayList<Integer> indexes)
	{
		if (this.__static)
			return;
		
		for (int i : indexes)
			this.clear(sprites.get(i).boundaries());
		
		for (int i : indexes)
			draw(sprites.get(i));
	}
	
	public ArrayList<sprite> getSprites()
	{
		return sprites;
	}
	
	public sprite getSprite(int index)
	{
		//System.out.println("LAYER: Size(sprites): " + sprites.size());
		
		if (sprites.size() == 0)
			return null;
		
		return sprites.get(index);
	}
		
	
	public void setSprites(ArrayList<sprite> __sprites)
	{
		this.sprites = __sprites;
	}
	
	public void add(sprite s)
	{
		if (sprites == null)
			return;
		
		sprites.add(s);
	}
	
	public void add(ArrayList<sprite> a)
	{
		if (sprites.size() == 0)
			return;
		
		for (sprite s : a)
			this.add(s);
	}
	
	public void focus()
	{
		if (this.__static)
			return;
		
		canvas().toFront();
	}
	
	public void draw()
	{
		for (sprite s : sprites)
			draw(s);
		
		
	}
	
	public Canvas canvas()
	{
		return super.canvas();
	}
	
	public GraphicsContext context()
	{
		return super.context();
	}
}
