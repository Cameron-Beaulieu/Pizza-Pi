package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import javafx.scene.control.Button;

//This is the controller class for the submit order window
public class SubmitOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressBar progSubmit;

    @FXML
    private Label labSubmit;
    
    @FXML
    private Button btnConfirm;

    @FXML //using a confirm button to start animation of progress bar and text
    void clickConfirm(ActionEvent event) {
    	btnConfirm.setVisible(false);//disabling button after it has been pushed
    	//using timeline to animate, 5 cycles, 1 cycle per 3 seconds, using the animate method below
    	Timeline timeline;
        timeline = new Timeline(
    			new KeyFrame(Duration.ZERO, actionEvent -> animate()), 
    			new KeyFrame(Duration.millis(3000)));
    	timeline.setCycleCount(5);
    	timeline.playFromStart();
    }

    @FXML
    void initialize() {
        assert progSubmit != null : "fx:id=\"progSubmit\" was not injected: check your FXML file 'SubmitOrderFXML.fxml'.";
        assert labSubmit != null : "fx:id=\"labSubmit\" was not injected: check your FXML file 'SubmitOrderFXML.fxml'.";
    }
    
    //the animate method is used to output the next string in the array and to increase the progress bar
    public void animate()
    {

        String[] output= {"Making Your Order","Your Pizza Is In The Oven","Cameron Is Doing The \"Perfection Check\"",
        		"Cameron Is On The Way","Your Pizza Has Arrived"};//creating the list of outputs
        labSubmit.setText(output[(int) (progSubmit.getProgress()/0.2)]);//changing the label to the correct output
        progSubmit.setProgress(progSubmit.getProgress()+0.2);//incerasing the progress bar
    }
}
