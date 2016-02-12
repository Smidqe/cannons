package application.types;
import application.types.enums.e_TText;

/*
	- TTextDebug
		- Will be a singleton, since it will be used everywhere.
		- Will probably connect to multiple text sources.
		- Handles indentation
		- Handles writing to file if necessary.





*/

@SuppressWarnings("unused")
public class TTextDebug {
	private int indentation, size;
	private boolean toFile;
	private TFile file;
	
	public TTextDebug()
	{
		this.indentation = 0;
	}
	
	public void setWrite(boolean toFile)
	{
		this.toFile = toFile;
	}
	
	public void print(String txt, e_TText method)
	{
		
		
		if (method == e_TText.HEADER || method == e_TText.SUBSTRING)
			indentation++;
		
		if (method == e_TText.FOOTER)
			indentation--;
		
		
		
		
		
		if (method == e_TText.SUBSTRING)
			indentation--;
	}
	
	
	public TFile getFile()
	{
		return this.file;
	}
	
	public int getIndention()
	{
		return this.indentation;
	}
}
