/* Ahmet TURGUT 150117046 Koray Emre ÞENEL 150117037
 *
 * */

import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test extends Application{

	public void start(Stage primaryStage) {
		
		Pane generalPane = new Pane();
		GridPane grid_Pane= new GridPane();
		generalPane.setPrefSize(1050, 800);
		MainMenu menu= new MainMenu();
		menu.addMenu(generalPane,grid_Pane,primaryStage);
		
	    Scene scene = new Scene(generalPane, 1050, 800);
		primaryStage.setTitle("P I P E N G A M E");  
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	public static void main(String[] args) {
	    launch(args);
	  }
	
}

