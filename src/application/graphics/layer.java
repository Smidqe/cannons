package application.graphics;

import java.util.ArrayList;

import application.types.TBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class layer extends Canvas{
	private String name;
	private ArrayList<sprite> sprites;
	private boolean __static;
	
	public layer()
	{
		super();
		sprites = new ArrayList<sprite>();
	}
	
	public layer(boolean Static)
	{
		this();
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
		this.getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
	}
	
	public void clear(TBox box)
	{
		this.getGraphicsContext2D().clearRect(box.getX1(), box.getY1(), box.width(), box.height());
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
			s.draw();
	}
	
	public void refresh(ArrayList<Integer> indexes)
	{
		if (this.__static)
			return;
		
		for (int i : indexes)
			this.clear(sprites.get(i).boundaries());
		
		for (int i : indexes)
			sprites.get(i).draw();
	}
	
	public ArrayList<sprite> getSprites()
	{
		if (sprites.size() == 0)
			return null;

		return new ArrayList<sprite>(sprites);
	}
	
	public sprite getSprite(int index)
	{
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
