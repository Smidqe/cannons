package application.settings;
import application.graphics.*;
import application.types.TFileSystem;

import java.util.ArrayList;



public class setup {
	private String path_main, path_sprites;
	
	public setup(String folder)
	{
		this.path_main = folder;
	}

	public String get_main_folder()
	{
		return this.path_main;
	}
	
	public ArrayList<sprite> load_sprites()
	{
		if (path_sprites == null || path_sprites.equals(""))
			return null;

		TFileSystem files = TFileSystem.instance();	


		return null;
	}
	
	public boolean load_all()
	{
		return false;
	}
	
	public boolean load_settings()
	{
		return false;
	}
	
}
