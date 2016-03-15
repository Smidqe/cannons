package application.graphics.cannon;

import application.graphics.graphics;
import application.graphics.sprite;

@SuppressWarnings("unused")
public class barrel{
	private double px, py;
	private boolean created;
	private sprite __sprite;

	public barrel(double x, double y)
	{
		//super();
		
		this.px = x;
		this.py = y;
	
		created = true;
	}

	public void rotate(double angle) {
		if (!created)
			return;
		
		
	}
}
