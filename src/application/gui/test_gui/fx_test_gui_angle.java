package application.gui.test_gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.graphics.graphics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class fx_test_gui_angle implements Initializable {
	@FXML
	private TextField tf_angle;
	@FXML
	private Button btn_cancel, btn_ok;	
	
	private graphics __graphics;
	
	@FXML
	public void close(ActionEvent event)
	{
		if (__graphics.layer_count() == 0)
			return;
		
		System.out.println("Layer count: " + __graphics.layer_count());
		
		if (__graphics.layer(0).getSprites().size() == 0)
		{
			System.out.println("No sprites loaded");
			return;
		}
		if (event.getSource().toString().equals(""))
			
			__graphics.layer(0).getSprite(0).setAngle(0);
		else
		{
			System.out.println(tf_angle.getText());
			
			__graphics.layer(0).getSprite(0).setAngle(Integer.parseInt(tf_angle.getText()));
		}
		return;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		__graphics = graphics.instance();
	}

}
