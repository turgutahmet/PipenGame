/* Ahmet TURGUT 150117046  Koray Emre ÞENEL 150117037
 * this class creates the menu and adds the background image to the scene.
 * */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;	
public class MainMenu {

	public void addMenu(Pane menuPane,GridPane grid_Pane,Stage primaryStage) {
			
			
			Image image= new Image("image/background.jpg");
			ImageView imageView = new ImageView(image); 
			imageView.setFitHeight(800);
			imageView.setFitWidth(1050);
			menuPane.getChildren().add(imageView);
	    
			Rectangle line=new Rectangle(10,800); //for text game name
			line.setStroke(Color.BLACK);
			line.setTranslateX(800);
			line.setTranslateY(0);
			
			
			
	    	Rectangle headLine = new Rectangle(450, 60);
	    	headLine.setStroke(Color.WHITE);
	 		headLine.setStrokeWidth(3);
	 		headLine.setFill(null);
	 		headLine.setTranslateX(265);
	 		headLine.setTranslateY(50);
	 		Text txt= new Text("P I P E N G A M E");
	 		txt.setFill(Color.WHITE);
	 		txt.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));
	 		txt.setTranslateX(300);
	 		txt.setTranslateY(100);
	 		menuPane.getChildren().addAll(txt,headLine,line); //add children 
	 		
	 		Text scoreTxt= new Text("Moves: "); //score 
			scoreTxt.setFill(Color.WHITE);
			scoreTxt.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
			scoreTxt.setTranslateX(850);
			scoreTxt.setTranslateY(150);
			menuPane.getChildren().add(scoreTxt);
	 		
	 		MenuItem level1= new MenuItem(grid_Pane, 850, 200,menuPane,"1",scoreTxt); //create  MenuItem for level1
	 		MenuItem viewCredits= new MenuItem("View Credits",menuPane,850,650); //create MenuItem for viewCredits
	 		MenuItem exit= new MenuItem("E x i t",menuPane,850,600,primaryStage); //create MenuItem  for exit
			
			
	}
	
	
	
}
