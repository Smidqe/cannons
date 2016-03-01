package application.gui.test_gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.mainclass;
import application.graphics.graphics;
import application.graphics.layer;
import application.graphics.sprite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class fx_test_gui implements Initializable {
	@FXML
	private Canvas cnv_test;
	@FXML
	private Button btn_draw, btn_rotate, btn_move, btn_clear;	
	
	private graphics __graphics; 
	
	public void draw()
	{
		
	}
	
	public void draw(double angle)
	{
		
	}
	
	@FXML
	public void draw(ActionEvent event)
	{
		__graphics.layer(0).add(new sprite());
		
	}
	
	@FXML
	public void open(ActionEvent event)
	{
		//__log.entry("Esineidenhallinta avattu.", true);
		try {
			Stage stage = new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("/application/gui/test_gui/fx_test_gui_angle.fxml"));
	        
	        Scene scene = new Scene(root);
	        
	        //stage.initStyle(StageStyle.UNDECORATED);
	        stage.setResizable(false);
	        stage.setScene(scene);   
	        stage.show();
	        
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		__graphics = graphics.instance();
		__graphics.add_layer(new layer(false, cnv_test));
		//__graphics.layer(0).add(new sprite());
		
		sprite sprite = new sprite();
		
		sprite.setFile(new File(".").getAbsolutePath() + "application/sprites/sprite_test.bmp");
		sprite.setName("Testing sprite");
		sprite.setImage(new Image(sprite.getFile().input()));
	}

}
