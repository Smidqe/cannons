package application.math;

import application.types.*;
import java.util.*;

public class physics {
	public static double circle(int power, int radius)
	{
		return Math.PI * (Math.pow((double) radius, 2.0) * power);
	}
	
	public static TPoint arc(double v, double ang, double time, TPoint p) //calculates a point in the arc.
	{
		long x, y;
		double vx, vy;
		
		vx = v * Math.cos(ang);
		vy = v * Math.sin(ang) - (9.81 * time);
		
		x = Math.round(vx * time);
		y = Math.round(vy * time - (0.5 * 9.81 * Math.pow(time, 2)));
		 
		return new TPoint((int) x, (int) y); //they will never overflow because there's no screen as large!!!
	}
	
	public static ArrayList<TPoint> arc(double v, double ang, TPoint p, double interval)
	{
		int i = 0;
		
		ArrayList<TPoint> __arc = new ArrayList<TPoint>();
		while (__arc.get(__arc.size()).y != p.y || i == 0)
			__arc.add(arc(v, ang, interval * i++, p));
		
		return __arc;
	}
	
	public static double angle(TPoint s, TPoint e, double v) //gets the angle even on hills.
	{
		return (Math.atan(Math.pow(v, 2) + Math.sqrt(Math.pow(v, 4) - 9.81 * (9.81 * Math.pow(e.x - s.x, 2) + 2 * (e.y - s.y) * Math.pow(v, 2)))) / 9.81 * (e.x - s.x));
	}
	
}
