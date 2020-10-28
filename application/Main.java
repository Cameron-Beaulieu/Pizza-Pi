package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

//Loading the initial window PizzaGUIFXML, see PizzaGUIController for details
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("PizzaGUIFXML.fxml"));
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pizza Pi");
			Image image = new Image("/application/pizza-icon.png");//creating window icon
			primaryStage.getIcons().add(image);
			primaryStage.setResizable(false);//decided to make the windows not resizable
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//launching the initial window
	public static void main(String[] args) {
		launch(args);
	}
}//end main class
