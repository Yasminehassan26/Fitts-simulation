package application;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class game implements Initializable  {
	@FXML
	private Label lives;
	@FXML
	private TextField text;
	@FXML
	private Button a;
	@FXML
	private Button b;
	@FXML
	private AnchorPane base;
	@FXML
	private Circle circle1;
	@FXML
	private Circle circle2;
/////////////////////////////////////////////////////////////////////////////////////////
	Random random = new Random();
	@FXML
	private ListView<String> list1;
	@FXML
	private ListView<String> list2;
	@FXML
	private ListView<String> list3;
	long start=0;
	long end=0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
circle2.setVisible(false);
circle2.setRadius(circle1.getRadius());

circle1.setOnMouseClicked(e -> {
    // handler code...
	 start = System.currentTimeMillis();

			circle1.setVisible(false);
			circle2.setLayoutX( random.nextInt((int) (base.getWidth()-circle2.getRadius())) );
           circle2.setLayoutY(random.nextInt((int) (base.getHeight()-circle2.getRadius())) );
		circle2.setVisible(true);	
			
});	
	
	circle2.setOnMouseClicked(e -> {
	    // handler code...
		 end = System.currentTimeMillis();
		long dt = end - start;
		circle2.setVisible(false);
		 double len1=Math.pow(circle1.getLayoutX()-circle2.getLayoutX(),2);
         double len2=Math.pow(circle1.getLayoutY()-circle2.getLayoutY(),2);
         double  len3=Math.sqrt(len1+len2);
			list1.getItems().add(String.valueOf(len3));
            list2.getItems().add(String.valueOf(circle1.getRadius()*2));
    		list3.getItems().add(String.valueOf(dt));

     	circle1.setLayoutX( random.nextInt((int) (base.getWidth()-(circle1.getRadius()*2)))  ); // random value from 0 to width
		circle1.setLayoutY (random.nextInt((int) (base.getHeight()-(circle1.getRadius()*2))));  // random value from 0 to height


       circle1.setRadius(random.nextInt(40)+10);   
       circle2.setRadius(circle1.getRadius());
       circle1.setVisible(true);

	});	
		}
			
/////////////////////////////////////////////////////////////////////////////////////////////		
		public void stop(ActionEvent event) {
			circle1.setDisable(true);
			circle2.setDisable(true);
		}
		public void begin(ActionEvent event) {
			circle1.setDisable(false);
			circle2.setDisable(false);
			circle1.setVisible(true);
			circle2.setVisible(false);
			list1.getItems().clear();
			list2.getItems().clear();
			list3.getItems().clear();

		}
		
		}




		 
////////////////////////////////////////////////////////////////////////////////////////////	
		
		

