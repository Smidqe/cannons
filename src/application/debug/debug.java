package application.debug;

public class debug {
	public static log log;
	private debug instance = new debug();
	
	private debug()
	{
		
	}
	
	public debug getInstance()
	{
		return this.instance;
	}
}
