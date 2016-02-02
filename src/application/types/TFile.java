package application.types;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TFile extends File{
	private boolean read, write, binary;
	private String name, path, type;
	private OutputStream __writer;
	private InputStream __reader;

	private static final long serialVersionUID = 1L;

	public TFile(String pathname)
	{
		this(pathname, true);
	}
	
	public TFile(String pathname, boolean read)
	{
		super(pathname);
		
		this.name = getName();
		this.type = getExtension();
		
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

	public String getExtension()
	{
	    if (!this.type.equals(""))
	    	return this.type;
		
		try {
	        return this.type = this.name.substring(this.name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	public long getSize()
	{
		return this.length();
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public OutputStream output()
	{
		return __writer;
	}
	
	public InputStream input()
	{
		return __reader;
	}
	
	public boolean write(String s, boolean overwrite)
	{
		if (!this.write || this.binary)
			return false;
		
		OutputStreamWriter w = new OutputStreamWriter(__writer);
		try {
			
			if (!overwrite)
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
		if (!this.read || this.binary)
			return null;
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
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

	public TFile convert(File file)
	{
		return new TFile(file.getAbsolutePath());
	}
	
	public ArrayList<TFile> convert(File[] listFiles) 
	{
		ArrayList<TFile> converted = new ArrayList<TFile>();
		
		for (File f : listFiles)
			converted.add(this.convert(f));
		
		return converted;
	}
}
