package application.graphics;

import application.types.TBox;
import application.types.TFile;
import application.types.TPoint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class sprite {	
	private Image img;
	private TFile source;
	private TPoint p;
	private GraphicsContext gc;
	private double angle;
	
	public sprite()
	{
	}
	
	public sprite(Image img, TFile file, TPoint p, GraphicsContext gc)
	{
		this.img = img;
		this.p = p;
		this.gc = gc;
		this.source = file;
	}
	
	public void setImage(Image img)
	{
		this.img = img;
	}
	
	public void load()
	{
		if (source == null || !source.exists())
			return;
		
		this.img = new Image(source.input());
	}
	
	public void setFile(String path)
	{
		this.source = new TFile(path, true);
	}
	
	public void setPoint(TPoint p)
	{
		this.p = p;
	}

	public void setPoint(int x, int y)
	{
		this.p = new TPoint(x, y);
	}
	
	public void setGC(GraphicsContext gc)
	{
		this.gc = gc;
	}
	
	public TBox boundaries()
	{			
		return new TBox((int) this.img.getWidth(), (int) this.img.getHeight());
	}
	
	public void draw(int x, int y) {
		if (gc == null)
			return;
		
		this.gc.drawImage(img, x, y);
	}

	public void draw(TPoint p)
	{
		this.draw(p.x, p.y);
	}
	
	public void draw()
	{
		this.draw(p.x, p.y);
	}
	
	public double angle()
	{
		return angle;
	}
	
	public void rotate(double angle)
	{
		if (gc == null)
			return;
		
		
	}
	
	public void draw(double angle)
	{
		if (gc == null)
			return;
		
		this.draw();
		
		if (angle != 0.0)
			this.gc.rotate(this.angle = angle);
	}
}
