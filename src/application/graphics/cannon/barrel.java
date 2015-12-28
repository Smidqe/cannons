package application.graphics.cannon;

import application.graphics.graphics;

@SuppressWarnings("unused")
public class barrel extends graphics{
	private double px, py;
	private boolean created;

	public barrel(double x, double y)
	{
		super();
		
		this.px = x;
		this.py = y;
	
		created = true;
	}

	public void rotate(double angle) {
		if (!created)
			return;
		
		
	}
}
