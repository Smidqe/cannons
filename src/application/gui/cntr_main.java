package application.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

public class cntr_main implements Initializable{
	@FXML
	private TextField tf_angle, tf_velocity;

	@FXML
	private Button btn_launch, btn_settings, btn_exit;
	
	@FXML
	private void exit()
	{
		Platform.exit();
	}
	
	@FXML
	private void launch()
	{
		if (tf_angle.getText().isEmpty() || tf_velocity.getText().isEmpty())
			return;
		
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
