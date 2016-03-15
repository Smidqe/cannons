package application.debug;

import application.types.TTextDebug;

public class debug extends TTextDebug{
	public static log log;
	private debug instance = new debug();
	
	private debug()
	{
		super();
		
	}
	
	public debug getInstance()
	{
		return this.instance;
	}
}
