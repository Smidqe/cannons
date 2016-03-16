package application.types;

import java.util.ArrayList;

import application.types.enums.e_TText;

public class TFolder {
	private ArrayList<TFile> files;
	private String path, name;
	
	public TFolder()
	{
		files = new ArrayList<TFile>();
		name = "";
	}
	
	public TFolder(String path)
	{
		this.path = path;
		//get folder name here.
		
		//
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public boolean search(String name, String path, boolean recursive)
	{
		
		
		
		return false;
	}
	
	public boolean search(String name, boolean recursive)
	{
		return search(name, this.path, recursive);
	}
	
	public int count()
	{
		return files.size();
	}
	
	public String name()
	{
		return name;
	}
	
	public void print()
	{
		TTextDebug debug = TTextDebug.instance();
		
		debug.print("Folder: ", e_TText.HEADER);
		
		for (TFile file : files)
			debug.print(file.getName(), e_TText.SUBSTRING);
		
		debug.print("\n", e_TText.FOOTER);
	}
}
