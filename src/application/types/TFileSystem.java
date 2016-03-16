package application.types;

import java.util.ArrayList;
import java.util.Arrays;

/*
 	TODO:
 		- Finalise the methods and clean these functions (perhaps split something to elsewhere?)
 		
 
 
 
 
 */

public class TFileSystem {
	private static TFileSystem __self = new TFileSystem();
	private ArrayList<TFile> files;
	private ArrayList<TFolder> folders;
	
	public TFileSystem()
	{
		files = new ArrayList<TFile>();
		folders = new ArrayList<TFolder>();
	}

	public boolean add(String filename, boolean directory)
	{
		TFile file = new TFile(filename);
		
		boolean exists = file.exists();
	
		if (exists)
			files.add(file);
		
		return exists;
	}
	
	public ArrayList<TFile> getFiles()
	{
		return this.files;
	}
	
	public ArrayList<TFolder> getFolders()
	{
		return this.folders;
	}
	
	public boolean add(ArrayList<String> filenames, boolean directory)
	{
		int size = files.size();
		
		for (int i = 0; i < filenames.size(); i++)
			add(filenames.get(i), directory);
		
		if (!directory)
			return files.size() > size ? true : false;
		else
			return folders.size() > size ? true : false;
	}
	
	public TFile getFile(int index)
	{
		return files.get(index);
	}
	
	public ArrayList<TFile> getFiles(int index)
	{	
		return new ArrayList<TFile>(Arrays.asList(getFile(index)));
	}
	
	public ArrayList<TFile> getFiles(int index, String extension)
	{
		ArrayList<TFile> files = getFiles(index);
		
		if (files == null || files.size() == 0)
			return null;
		
		ArrayList<TFile> filtered = new ArrayList<TFile>();
		for (TFile f : files)
			if (f.getType().equals(extension))
				filtered.add(f);
		
		return filtered;
	}

	public static TFileSystem instance() {
		return __self;
	}
}
