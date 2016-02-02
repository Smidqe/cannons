package application.types;

@SuppressWarnings("unused")
public class TTextDebug {
	private int indention, size;
	private boolean toFile;
	private TFile file;
	
	public TTextDebug()
	{
		this.indention = 0;
	}
	
	public void setWrite(boolean toFile)
	{
		this.toFile = toFile;
	}
	
	public void print(int something)
	{

	}
	
	
	public TFile getFile()
	{
		return this.file;
	}
	
	public int getIndention()
	{
		return this.indention;
	}
}
