package application.types;
//CLEAN THIS!

import java.util.ArrayList;
import java.util.Arrays;

import application.settings.constants;

@SuppressWarnings("unused")
public class TArc {
	private double angle, start_velocity;
	private TPoint start, end, peak;
	private TPointArray arc;
	
	public TArc()
	{
		this.arc = new TPointArray();
		this.start = new TPoint();
		this.end = new TPoint();
		this.peak = new TPoint();
	}
	
	private TPoint arc(double v, double ang, double time, TPoint p) //calculates a point in the arc.
	{		
		long x, y;
		double vx, vy;
		
		vx = v * Math.cos(ang);
		vy = v * Math.sin(ang) - (9.81 * time);
		
		x = Math.round(vx * time);
		y = Math.round(vy * time - (0.5 * 9.81 * Math.pow(time, 2)));
		 
		return new TPoint((int) x, (int) y); //they will never overflow because there's no screen as large!!!
	}
	
	private TPointArray arc(double v, double ang, TPoint p, double interval)
	{
		if (v == 0 || ang == 0)
			return new TPointArray(Arrays.asList(p));
		
		int i = 0;

		TPointArray __arc = new TPointArray();
		while (__arc.get(__arc.size()).y != p.y || i == 0)
			__arc.append(arc(v, ang, interval * i++, p));
		
		return __arc;
	}
	
	public TPointArray create(double velocity, double angle)
	{
		if (this.start == null)
			return null;
		
		return this.arc = arc(velocity, angle, this.start, 0.1);
	}

	public TPointArray create(TPoint start, double velocity, double angle)
	{
		return this.arc = arc(velocity, angle, start, 0.1);
	}

	public double distanceX()
	{
		if (start == null || end == null || arc == null)
			return 0;
		
		return arc.get(0).distance(arc.get(arc.size()));
	}
	
	public double distance()
	{
		if (arc == null || arc.size() == 0)
			return 0.0;
		
		double distance = 0.0;
		for (int i = 1; i < arc.size() - 1; i++)
			distance += arc.get(i).distance(arc.get(i - 1));
		
		return distance;
	}
	
	public TPointArray getArc()
	{
		return this.arc;
	}
	
	public TPoint peak()
	{
		if (arc.size() == 0)
			return null;
		
		//double dist = distance();
		//double height = arc.get(0).y + dist * Math.tan(angle) - ((constants.GRAVITATIONAL * Math.pow(dist, 2)) / (2 * start_velocity * Math.cos(angle)));
		
		return null;
	}
}
