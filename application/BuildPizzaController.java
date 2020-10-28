package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.text.DecimalFormat;
import application.Pizza.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//This is the Controller for the window that allows the user to create a Pizza 
public class BuildPizzaController {
	//creating a decimal format for the cost and a public line item to store the orders to be displayed
	DecimalFormat twoDecimal = new DecimalFormat("0.00");
	public static ArrayList<LineItem> lineItem=new ArrayList<>();//had to be public static to be accessed across all controllers
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radSmall;

    @FXML
    private ToggleGroup Size;

    @FXML
    private RadioButton radMed;

    @FXML
    private RadioButton radLarge;

    @FXML
    private RadioButton radSing;

    @FXML
    private ToggleGroup Cheese;

    @FXML
    private RadioButton radDoub;

    @FXML
    private RadioButton radTri;

    @FXML
    private Spinner<Integer> spinQuant;

    @FXML
    private CheckBox checkVeg;

    @FXML
    private CheckBox checkPine;

    @FXML
    private CheckBox checkGreen;

    @FXML
    private CheckBox checkHam;

    @FXML
    private Label labCost;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnCost;

    @FXML
    void clickAdd(ActionEvent event) throws IllegalPizza {
    	//going through all parameters for a pizza and checking their values based on controls on the screen
    	String size=((RadioButton)(Size.getSelectedToggle())).getId();
    	String cheese=((RadioButton)(Cheese.getSelectedToggle())).getId();
    	String pine="None";
    	String green="None";
    	String ham="None";
    	boolean veg=false;
    	
    	if(checkVeg.isSelected())
    		veg=true;
    	if(checkPine.isSelected())
    		pine="Single";
    	if(checkGreen.isSelected())
    		green="Single";
    	if(checkHam.isSelected())
    		ham="Single";
    	Pizza pizza=new Pizza(size,veg, cheese, pine, green, ham);//creation of single pizza
    	LineItem newLine=new LineItem(spinQuant.getValue(),pizza);//creation of order based on pizza and quantity spinner
    	lineItem.add(newLine);//adding the pizza to the array list to be displayed later
    	
    	//automatically going back to the main menu
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

    @FXML //returning back to the main menu
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
    
    @FXML //generating the cost and changing a label to output it on the GUI
    void clickCost(ActionEvent event) throws IllegalPizza {
    	String size=((RadioButton)(Size.getSelectedToggle())).getId();
    	String cheese=((RadioButton)(Cheese.getSelectedToggle())).getId();
    	String pine="None";
    	String green="None";
    	String ham="None";
    	boolean veg=false;
    	
    	if(checkVeg.isSelected())
    		veg=true;
    	if(checkPine.isSelected())
    		pine="Single";
    	if(checkGreen.isSelected())
    		green="Single";
    	if(checkHam.isSelected())
    		ham="Single";
    	Pizza pizza=new Pizza(size,veg, cheese, pine, green, ham);//creation of pizza to output cost, not saving it yet incase user makes changes
    	labCost.setText("$"+(twoDecimal.format(spinQuant.getValue()*pizza.getCost())));//output of the cost
    }

    @FXML
    void clickDoub(ActionEvent event) {

    }

    @FXML
    void clickGreen(ActionEvent event) {

    }

    @FXML
    void clickHam(ActionEvent event) {

    }

    @FXML
    void clickLarge(ActionEvent event) {

    }

    @FXML
    void clickMed(ActionEvent event) {

    }

    @FXML
    void clickPine(ActionEvent event) {

    }

    @FXML
    void clickSing(ActionEvent event) {

    }

    @FXML
    void clickSmall(ActionEvent event) {

    }

    @FXML
    void clickTri(ActionEvent event) {

    }

    @FXML //if vegetarian is selected ham may not be selected, as such it is set to false and disabled until vegetarian is unselected
    void clickVeg(ActionEvent event) {
    	if(checkVeg.isSelected())
    	{
    		checkHam.setSelected(false);
    		checkHam.setDisable(true);
    	}
    	else
    		checkHam.setDisable(false);
    	

    }

    @FXML
    void initialize() {
        assert radSmall != null : "fx:id=\"radSmall\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert Size != null : "fx:id=\"Size\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert radMed != null : "fx:id=\"radMed\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert radLarge != null : "fx:id=\"radLarge\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert radSing != null : "fx:id=\"radSing\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert Cheese != null : "fx:id=\"Cheese\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert radDoub != null : "fx:id=\"radDoub\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert radTri != null : "fx:id=\"radTri\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert spinQuant != null : "fx:id=\"spinQuant\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert checkVeg != null : "fx:id=\"checkVeg\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert checkPine != null : "fx:id=\"checkPine\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert checkGreen != null : "fx:id=\"checkGreen\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert checkHam != null : "fx:id=\"checkHam\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert labCost != null : "fx:id=\"labCost\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'BuildPizzaFXML.fxml'.";

    }
    
    
}
