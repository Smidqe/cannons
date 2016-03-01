package application.graphics;

import application.types.TBox;
import application.types.TFile;
import application.types.TPoint;
//import application.types.TPolygon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class sprite {	
	private Image img;
	private TFile source;
	private TPoint p;
	private GraphicsContext gc;
	private String name;
	private TBox bounds;
	private double angle;
	//private TPolygon hitbox;
	private int layer;
	
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
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
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
	
	public boolean touches(sprite s)
	{
		return this.boundaries().touches(s.boundaries());
	}
	
	public boolean intersects(sprite s)
	{
		return this.boundaries().overlap(s.boundaries());
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
		
		Rotate r = new Rotate(angle, p.x, p.y);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}
	
	public void draw(double angle)
	{
		if (gc == null)
			return;
		
		if (angle != 0.0)
			this.gc.rotate(this.angle = angle);
	
		this.draw();
	}

	public TPoint getPoint() {
		return this.p;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public TBox getBounds() {
		// TODO Auto-generated method stub
		return this.bounds;
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return this.img;
	}

	public void setAngle(int i) {
		// TODO Auto-generated method stub
		this.angle = (double) i;
	}

	public TFile getFile() {
		// TODO Auto-generated method stub
		return this.source;
	}
}
