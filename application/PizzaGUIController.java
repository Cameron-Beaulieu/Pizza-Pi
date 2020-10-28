package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//This is the controller class for the main windows, it allows the user to transition to the three different possible windows 
//Possible Windows: Build Pizza, Display Order, Submit Order
public class PizzaGUIController {

    @FXML
    private Button btnBuild;

    @FXML
    private Button btnShow;

    @FXML
    private Button btnSubmit;

    @FXML
    private ImageView imageMain;

    @FXML
    void clickBuild(ActionEvent event) {
    	try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("BuildPizzaFXML.fxml"));
			Scene scene = new Scene(root,600,350);
			Stage stage = (Stage) btnBuild.getScene().getWindow();
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Build Pizza");
			//Image image = new Image("application/pizza.png");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML //change window to Display Order window 
    void clickShow(ActionEvent event) {
    	try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("DisplayOrderFXML.fxml"));
			Scene scene = new Scene(root,600,350);
			Stage stage = (Stage) btnShow.getScene().getWindow();
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Display Order");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML //changes window to submitOrder window 
    void clickSubmit(ActionEvent event) {
    	try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("SubmitOrderFXML.fxml"));
			Scene scene = new Scene(root,600,350);
			Stage stage = (Stage) btnSubmit.getScene().getWindow();
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Submit Order");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
