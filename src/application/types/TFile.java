package application.types;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings("unused")
public class TFile extends File{
	private boolean open, read, write;
	private String name, path, type;
	private OutputStream __writer;
	private InputStream __reader;

	private static final long serialVersionUID = 1L;

	public TFile(String pathname, boolean read)
	{
		super(pathname);
		
		this.name = getName();
		this.type = type();
	}
	
	public void set_method(boolean write)
	{
		if (this.read && write)
		{
			this.read = false;
			this.write = true;
		}
		
		if (this.write && !write)
		{
			this.write = false;
			this.read = true;
		}
	}
	public String type()
	{
		return "";
	}
	
	public String path()
	{
		if (!open || path.isEmpty())
			return "";
		
		if (!path.isEmpty())
			return path;
		
		return path = this.getPath();
	}
	
	public boolean close() throws IOException
	{
		__writer.close();
		__reader.close();
		
		return (this.open = false);
	}
	public boolean isOpen()
	{
		return (this.open || this.__reader != null || this.__writer != null);
	}
	
	public boolean open() throws FileNotFoundException
	{
		if (isOpen())
			return true;
		
		if (this.write)
			this.__writer = new FileOutputStream(this.path);
		else
			this.__reader = new FileInputStream(this.path);
		
		return true;
	}
}
