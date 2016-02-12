package application.types;

//@SuppressWarnings("unused")
public class TLevel {
	private String path;
	private TPoint player, enemy;
	
	public TLevel()
	{
		
	}
	
	
	public String getPath()
	{
		return this.path;
	}
	
	public TPoint getPlayerPosition()
	{
		return this.player;
	}
	
	public TPoint getEnemyPosition()
	{
		return this.enemy;
	}
}
