package application.types;
import application.types.enums.e_TText;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/*
	- TTextDebug
		- Will be a singleton, since it will be used everywhere.
		- Will probably connect to multiple text sources.
		- Handles indentation
		- Handles writing to file if necessary.





*/
public class TTextDebug {
	private static TTextDebug __self = new TTextDebug();
	private int indentation, size;
	
	public TTextDebug()
	{
		this.indentation = 0;
	}
	
	public void print(String txt, e_TText method)
	{
		if (method == e_TText.HEADER || method == e_TText.SUBSTRING)
			indentation++;
		
		if (method == e_TText.FOOTER)
			indentation--;

		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < this.indentation; i++)
			builder.append("--");
		
		switch (method)
		{
			case WARNING:
			{
				builder.append("WARNING");
				break;
			}
			
			case ERROR:
			{
				builder.append("ERROR");
				break;
			}
			
			case CRITICAL:
			{
				builder.append("CRITICAL");
				break;
			}
			default:
				break;
		}
		
		System.out.println(builder.append(txt).toString());
		
		if (method == e_TText.SUBSTRING)
			indentation--;
	}
	
	public void print(Label label, String txt)
	{
		label.setText(txt);
	}
	
	public void print(TextArea area, String txt)
	{
		area.setText(txt);
	}
	
	public void print(TextField field, String txt)
	{
		field.setText(txt);
	}
	
	public int getIndention()
	{
		return this.indentation;
	}

	public static TTextDebug instance() {
		return __self;
	}
}
