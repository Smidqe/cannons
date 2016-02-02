package application.types;

import java.util.Calendar;

public class TTimer {
	private long start;
	private boolean paused;

	public TTimer()
	{
		this.paused = false;
		this.start = 0;
	}
	
	public void start()
	{
		if (this.paused)
			return;
		
		this.start = Calendar.getInstance().getTimeInMillis();
	}
	
	public void pause()
	{
		
	}
	
	public void reset()
	{
		
	}
	
	public long getTime()
	{
		return Calendar.getInstance().getTimeInMillis() - this.start;
	}
}
