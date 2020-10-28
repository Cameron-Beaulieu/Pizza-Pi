package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//This is the controller for the window that displays the order and the total cost of the order to the new window
public class DisplayOrderController {

	DecimalFormat twoDecimal = new DecimalFormat("0.00"); //creating decimal format for the cost 
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textOrder;

    @FXML
    private Button btnBack;

    @FXML //returns user to the home screen
    void clickBack(ActionEvent event) {
    	try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("PizzaGUIFXML.fxml"));
			Scene scene = new Scene(root,600,400);
			Stage stage = (Stage) btnBack.getScene().getWindow();
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Pizza Pi");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
        assert textOrder != null : "fx:id=\"textOrder\" was not injected: check your FXML file 'DisplayOrderFXML.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'DisplayOrderFXML.fxml'.";
        float cost=0;
        //outputting the line items and the cost to the user using methods provided in line item class
        for (LineItem item:BuildPizzaController.lineItem)
        {
        	textOrder.appendText(item.toString()+"\n");
        	cost+=item.getCost();
        }
        textOrder.appendText("\nTotal Cost $"+twoDecimal.format(cost));

    }
}
