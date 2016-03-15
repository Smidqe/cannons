package application.debug;

import application.types.TFile;

public class log {
	protected static log self = new log();
	private TFile file;
	
	private log()
	{
		
	}
	
	public static log instance()
	{
		return self;
	}
	
	public void entry(String text)
	{
		if (file == null)
			return;
		
		file.write(text, false);
	}
	
	public void entry(boolean window, String text)
	{
		if (file == null)
			return;
		
		if (window)
		{
			//
			return;
		}
		
		entry(text);
	}
}
