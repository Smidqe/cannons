package application.files;

import java.util.ArrayList;
import application.types.TFile;

public class files {
	
	private ArrayList<TFile> __files;
	private static files instance = new files();
	
	private files()
	{
		__files = new ArrayList<TFile>();
	}
	
	public files getInstance()
	{
		return instance;
	}
	
	public ArrayList<TFile> getList()
	{
		return __files;
	}
	
	public ArrayList<TFile> getOpen()
	{
		if (__files.size() == 0)
			return null;
		
		ArrayList<TFile> r = new ArrayList<TFile>();
		
		for (int i = 0; i < __files.size(); i++)
			if (__files.get(i).isOpen())
				r.add(__files.get(i));
				
		return r;
	}

	public int getOpen(boolean print)
	{
		ArrayList<TFile> r = this.getOpen();
		
		if (print)
			System.out.println("Amount of files in use: " + r.size());
	
		return r.size();
	}
	
	public int amount()
	{
		return __files.size();
	}
}
