/* Ahmet TURGUT 150117046  Koray Emre ÞENEL 150117037
 * We use this class to create buttons * */


import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuItem extends StackPane {
	public MenuItem(GridPane grid_Pane,int x,int y,Pane menuPane,String str,Text scoreTxt) { //level
		Image img =new Image("image/level"+str+".jpg");
		ImageView imgv= new ImageView(img);
		imgv.setFitHeight(40);
		imgv.setFitWidth(130);
		imgv.setTranslateX(x);
		imgv.setTranslateY(y);
		imgv.setId(str);
		for(Node node:menuPane.getChildren()) {
			if(node.getId()==str) {
				
			}else menuPane.getChildren().add(imgv); break;
		}
		
		
		
			//if pressed the button create a level object and call the addPane and startMove method
		imgv.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				menuPane.getChildren().remove(grid_Pane);
				menuPane.getChildren().add(grid_Pane);
				
				
				Level lvl= new Level();
				
				lvl.addPane(grid_Pane, str);
				lvl.startmove(menuPane,grid_Pane,scoreTxt);
				
			}
			
		});
		}

	
	
	public MenuItem(String itemName,Pane menuPane,int x,int y, Stage primaryStage) { //exit
		Image img =new Image("image/exit.jpg");
		ImageView imgv= new ImageView(img);
		imgv.setFitHeight(40);
		imgv.setFitWidth(130);
		imgv.setTranslateX(x);
		imgv.setTranslateY(y);
		menuPane.getChildren().add(imgv);
		
		imgv.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				primaryStage.close();
			}
			
		});
	}
	
	public MenuItem(String itemName,Pane menuPane,int x,int y) { //credits
		Image img =new Image("image/credits.jpg");
		ImageView imgv= new ImageView(img);
		imgv.setFitHeight(40);
		imgv.setFitWidth(130);
		imgv.setTranslateX(x);
		imgv.setTranslateY(y);
		menuPane.getChildren().add(imgv);
		
		imgv.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				Text text= new Text("Ahmet TURGUT");
				Text text2=new Text("Koray Emre ÞENEL");
				text.setFill(Color.WHITE);
				text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
				text.setTranslateX(850);
				text.setTranslateY(750);
				text2.setFill(Color.WHITE);
				text2.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
				text2.setTranslateX(850);
				text2.setTranslateY(780);
				menuPane.getChildren().add(text);
				menuPane.getChildren().add(text2);
			}
			
		});
	}
	
	
}
