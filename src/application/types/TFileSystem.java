package application.types;

import java.util.ArrayList;
import java.util.Arrays;

public class TFileSystem {
	private ArrayList<TFile> files;
	private ArrayList<TFile> folders;
	
	public TFileSystem()
	{
		files = new ArrayList<TFile>();
		folders = new ArrayList<TFile>();
	}

	public boolean add(String filename, boolean directory)
	{
		TFile file = new TFile(filename);
		
		boolean exists = file.exists();
	
		if (exists)
			if (!directory)
				files.add(file);
			else
				folders.add(file);
		
		return exists;
	}
	
	public ArrayList<TFile> getFiles()
	{
		return this.files;
	}
	
	public ArrayList<TFile> getFolders()
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
	
	public TFile getFile(int index, boolean directory)
	{
		if (directory)
			return folders.get(index);
		else
			return files.get(index);
	}
	
	public ArrayList<TFile> getFiles(int index, boolean directory)
	{	
		if (directory)
			return getFile(index, directory).convert(getFile(index, directory).listFiles());
		else
			return new ArrayList<TFile>(Arrays.asList(getFile(index, directory)));
	}
	
	public ArrayList<TFile> getFiles(int index, String extension, boolean directory)
	{
		ArrayList<TFile> files = getFiles(index, directory);
		
		if (files == null || files.size() == 0)
			return null;
		
		ArrayList<TFile> filtered = new ArrayList<TFile>();
		for (TFile f : files)
			if (f.getType().equals(extension))
				filtered.add(f);
		
		return filtered;
	}
	
	public int fileCount(int index, boolean folder)
	{
		if (!folder)
			return 1;
		
		return this.getFiles(index, folder).size();
	}
	
	public int fileCount(int index, String extension, boolean directory)
	{
		if (!directory)
			return this.files.get(0).getExtension().equals(extension) ? 1 : 0;
		
		return getFiles(index, extension, directory).size();
	}
}
