package application.types;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class TFile extends File{
	private boolean open, read, write, binary;
	private String name, path, type;
	private OutputStream __writer;
	private InputStream __reader;

	private static final long serialVersionUID = 1L;

	public TFile(String pathname, boolean read)
	{
		super(pathname);
		
		this.name = getName();
		this.type = type();
		
		set_method(!read);
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
	
	public OutputStream output()
	{
		return __writer;
	}
	
	public InputStream input()
	{
		return __reader;
	}
	
	public boolean write(String s, boolean append)
	{
		if (!this.write || !this.open || this.binary)
			return false;
		
		OutputStreamWriter w = new OutputStreamWriter(__writer);
		try {
			
			if (append)
				w.append(s);
			else
				w.write(s);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<String> read()
	{
		if (!this.read || !this.open || this.binary)
			return null;
		
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader r;
		try {
			r = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String __tmp;
			
			while ((__tmp = r.readLine()) != null)
				lines.add(__tmp);
			
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines;
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
		
		set_method(this.write);
		
		return this.open = isOpen();
	}
}
