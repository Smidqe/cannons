package application.debug;

public class log {
	protected static log self = new log();
	private log()
	{	
	}
	
	public static log instance()
	{
		return self;
	}
	
	public void entry(String text)
	{
		
	}
	
	public void entry(boolean window, String text)
	{
		if (window)
		{
			
			return;
		}
		
		entry(text);
	}
}
