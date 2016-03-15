package application.gui.test_gui;


import java.net.URL;
import java.util.ResourceBundle;


import application.graphics.graphics;
import application.graphics.layer;
import application.graphics.sprite;
import application.types.TPoint;
import javafx.animation.AnimationTimer;
//import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class fx_test_gui implements Initializable {
	@FXML
	private Canvas cnv_test;
	@FXML
	private Button btn_draw, btn_rotate, btn_animate, btn_clear;	
	@FXML
	private ImageView img_view;
	
	private AnimationTimer animated;
	private graphics __graphics; 
	private double __angle;

	@FXML
	public void animate(ActionEvent event)
	{
		animated.start();
		
	}

	@FXML
	public void draw(ActionEvent event)
	{
		__graphics.get_layer(__graphics.get_current_layer()).draw(__graphics.get_layer(0).getSprite(0));
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
		
		sprite sprite = new sprite();

		sprite.setName("Testing sprite");
		sprite.setPoint(new TPoint(50, 50));
		sprite.setImage(new Image("/application/sprites/sprite_test.bmp"));
		
		System.out.println(cnv_test.getWidth() + ", " + cnv_test.getHeight());
		
		__graphics.add_layer(new layer(cnv_test));
		__graphics.get_layer(0).add(sprite);
		
		img_view.setImage(sprite.getImage());
		
		animated = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub

				__graphics.get_layer(0).getSprite(0).setRotation(__angle);
				__graphics.draw();
				__angle += 5;

				sprite __sprite = __graphics.get_layer(0).getSprite(0);
				TPoint __point = __sprite.getPoint();
				
				if (__point.x < cnv_test.getWidth() - 50)
				{	
					__point.offset(1, 0);
					__sprite.setPoint(__point);
				}
				
				
				if (__graphics.get_layer(0).getSprite(0).angle() % 360 == 0)
					stop();
			}
		};
	}

}
