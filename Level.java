/*  Ahmet TURGUT 150117046 Koray Emre ÞENEL 150117037
 * A general table is drawn by adding images in this class. 
 * These pictures are added according to the input file. 
 * It contains methods that allow you to shift the images as pane.
 * If the layout of the pipes is correct after scrolling, it starts 
 * the animation of the ball.Adds the next level's button.
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Level {
	
	Pane[][] panes= new Pane[4][4];
	String[][] ImageNAME= new String[4][4];
	ArrayList<Pane> paneArray= new ArrayList<Pane>();
	ArrayList<Pane>	allPanes = new ArrayList<Pane>();
	ArrayList<Pane>	endPanes = new ArrayList<Pane>();
	ArrayList<Pane>	animationPanes = new ArrayList<Pane>();
	
	boolean success; 
	boolean gameEndTF;
	int counter=0;
	int level;
	
	public void addPane(GridPane pane,String str) {

		try {
			//read level txt
			Scanner input = new Scanner(new File("Level"+str+".txt"));
			level=Integer.parseInt(str);
			int a = 0;
			
			while(input.hasNextLine()) {
				//create string array for string on txt
				String[] currentLine = input.nextLine().split(",");
				String number = currentLine[0];
				String type = currentLine[1];
				String position= currentLine[2];
				
					//create switch-case statement 
				switch(number) {
	
					
				case "1":
					Pane pane1 = new Pane();
					pane1.setPrefSize(200,200);
					selection(type,position,pane,pane1,0,0,0); //call the selection method
					pane.add(pane1,0,0); //add the pane on grid pane use column and row index
					panes[0][0]=pane1; //add the pane1 to panes array 
					break;
					
				case "2":
					Pane pane2 = new Pane();
					pane2.setPrefSize(200,200);
					selection(type,position,pane,pane2,1,0,1);				
					pane.add(pane2,1,0);
					panes[1][0]=pane2;
					break;
				
				case "3":
					Pane pane3 = new Pane();
					pane3.setPrefSize(200,200);
					selection(type,position,pane,pane3,2,0,2);
					pane.add(pane3,2,0);
					panes[2][0]=pane3;
					break;
					
				case "4":
					Pane pane4 = new Pane();
					pane4.setPrefSize(200,200);
					selection(type,position,pane,pane4,3,0,3);
					pane.add(pane4,3,0);
					panes[3][0]=pane4;
					break;
					
				case "5":
					Pane pane5 = new Pane();
					pane5.setPrefSize(200,200);
					selection(type,position,pane,pane5,0,1,4);
					pane.add(pane5,0,1);
					panes[0][1]=pane5;
					break;
					
				case "6":
					Pane pane6 = new Pane();
					pane6.setPrefSize(200,200);
					selection(type,position,pane,pane6,1,1,5);
					pane.add(pane6,1,1);
					panes[1][1]=pane6;
					break;
					
				case "7":
					Pane pane7 = new Pane();
					pane7.setPrefSize(200,200);
					selection(type,position,pane,pane7,2,1,6);
					pane.add(pane7,2,1);
					panes[2][1]=pane7;
					break;
					
				case "8":
					Pane pane8 = new Pane();
					pane8.setPrefSize(200,200);
					selection(type,position,pane,pane8,3,1,7);
					pane.add(pane8,3,1);
					panes[3][1]=pane8;
					break;
					
				case "9":
					Pane pane9 = new Pane();
					pane9.setPrefSize(200,200);
					selection(type,position,pane,pane9,0,2,8);
					pane.add(pane9,0,2);
					panes[0][2]=pane9;
					break;
					
				case "10":
					Pane pane10 = new Pane();
					pane10.setPrefSize(200,200);
					selection(type,position,pane,pane10,1,2,9);
					pane.add(pane10,1,2);
					panes[1][2]=pane10;
					break;
					
				case "11":
					Pane pane11 = new Pane();
					pane11.setPrefSize(200,200);
					selection(type,position,pane,pane11,2,2,10);
					pane.add(pane11,2,2);
					panes[2][2]=pane11;
					break;
					
				case "12":
					Pane pane12 = new Pane();
					pane12.setPrefSize(200,200);
					selection(type,position,pane,pane12,3,2,11);
					pane.add(pane12,3,2);
					panes[3][2]=pane12;
					break;
					
				case "13":
					Pane pane13 = new Pane();
					pane13.setPrefSize(200,200);
					selection(type,position,pane,pane13,0,3,12);
					pane.add(pane13,0,3);
					panes[0][3]=pane13;
					break;
					
				case "14":
					Pane pane14 = new Pane();
					pane14.setPrefSize(200,200);
					selection(type,position,pane,pane14,1,3,13);
					pane.add(pane14,1,3);
					panes[1][3]=pane14;
					break;
					
				case "15":
					Pane pane15 = new Pane();
					pane15.setPrefSize(200,200);
					selection(type,position,pane,pane15,2,3,14);
					pane.add(pane15, 2, 3);
					panes[2][3]=pane15;
					break;
					
				case "16":
					Pane pane16 = new Pane();
					pane16.setPrefSize(200, 200);
					selection(type, position, pane , pane16,3,3,15);
					pane.add(pane16, 3, 3);
					panes[3][3]=pane16;
					break;
					
				}
			}
		
			} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	

 public void selection(String type,String position,GridPane pane ,Pane panex,int ii,int jj,int a ) {

	 //it takes pictures from image file according to type
	 
		 if(type.equals("Starter")) {
			 
			  if(position.equals("Vertical")) {
				  Image image= new Image("image/sv.jpg");
				  viewImage(image,  panex); //call the viewImage method 
				  ImageNAME[ii][jj]="sv"; //add name of image to array ImageNAME (Hint. using ImageName for neihbor,target pane)
				  panex.setId("bot-Starter"); //sett id 
		
				  
				  
			  }else if(position.equals("Horizontal")){
				  Image image= new Image("image/sh.jpg");
				  viewImage(image, panex);
				  ImageNAME[ii][jj]="sh";
				  panex.setId("lft-Starter");
	
			  }
		 
		 }else if(type.equals("End")) {
			 
			 if(position.equals("Vertical")) {
				  Image image= new Image("image/ev.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="ev";
				  panex.setId("ENDb-END");
				 
				  
			  }else if(position.equals("Horizontal")){
				  Image image= new Image("image/eh.jpg");
				  viewImage(image, panex);
				  ImageNAME[ii][jj]="eh";
				  panex.setId("ENDl-END");
				  
			  }
		 }else if(type.equals("Empty")) {
			 
			 if(position.equals("Free")) {
				 Image image= new Image("image/ef.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="ef";
				  panex.setId("empty");
				  
				 
				  
			 } else  if(position.equals("none")){
				  Image image= new Image("image/en.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="en";
				  panex.setId("empty");
				 
				  
			  }
		 }else if(type.equals("Pipe")) {
			 
			 if(position.equals("Vertical")) {
				 
				  Image image= new Image("image/pv.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="pv";
				  panex.setId("tb-PipeNormal");
				  
			  }else if(position.equals("Horizontal")){
				  Image image= new Image("image/ph.jpg");
				  viewImage(image, panex);
				  ImageNAME[ii][jj]="ph";
				  panex.setId("lr-PipeNormal");
				  
				  
			  }else if(position.equals("00")){
				  Image image= new Image("image/p00.jpg");
				  viewImage(image, panex);
				  ImageNAME[ii][jj]="p00";
				  panex.setId("tl-PipeNormal");
				
				 
			  }else if(position.equals("01")){
				  Image image= new Image("image/p01.jpg");
				  viewImage(image, panex);
				  ImageNAME[ii][jj]="p01";
				  panex.setId("tr-PipeNormal");
				  
				  
			  }else if(position.equals("10")){
				  Image image= new Image("image/p10.jpg");
				  viewImage(image, panex);
				  ImageNAME[ii][jj]="p10";
				  panex.setId("bl-PipeNormal");
				
				  
			  }else if(position.equals("11")){
				  Image image= new Image("image/p11.jpg");
				  viewImage(image, panex);
				  ImageNAME[ii][jj]="p11";
				  panex.setId("br-PipeNormal");
				  }
		 }
		 else if(type.equals("PipeStatic")) { 
			 if(position.equals("Vertical")) {
				  Image image= new Image("image/psv.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="psv";
				  panex.setId("tb-PipeStatic");
			  }
			 else if(position.equals("Horizontal")){
				  Image image= new Image("image/psh.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="psh";
				  panex.setId("lr-PipeStatic");
				  
				  
			  }else if(position.equals("01")){
				  Image image= new Image("image/ps01.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="ps01";
				  panex.setId("tr-PipeStatic");
				 
				  
			  }else if(position.equals("10")){
				  
				  Image image= new Image("image/ps10.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="ps10";
				  panex.setId("bl-PipeStatic");
				  
			  }else if(position.equals("11")){
				  Image image= new Image("image/ps11.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="ps11";
				  panex.setId("br-PipeStatic");
				  
			  }else if(position.equals("00")){
				  Image image= new Image("image/ps00.jpg");
				  viewImage(image,  panex);
				  ImageNAME[ii][jj]="ps00";
				  panex.setId("tl-PipeStatic");
				
				  
			  }
		 }
		 
		 allPanes.add(panex);
	 }
	
	 public void viewImage(Image image,Pane pane) {
		// adjusts the size of the image and adds it to the pane.
		 ImageView imageView = new ImageView(image); 
		 imageView.setFitHeight(200);
		 imageView.setFitWidth(200);
	      
	      pane.getChildren().add(imageView);
 //mouse detection
	    pane.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				Dragboard dragBoard= pane.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content=new ClipboardContent();
				content.putImage(image);
				dragBoard.setContent(content);
				event.consume();
			}
	    	
	    });
	      
	 }
	  
	 public void startmove(Pane menuPane,GridPane grid_Pane,Text scoreText) {
	    	if(counter == 0)
				scoreText.setText("Moves : "+0);
	    	
	    	
	    	//locates the pane in which the mouse is pressed and checks that the source is movable.
	    	grid_Pane.getChildren().forEach(event ->{
	    		
	    		event.setOnMousePressed(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						int colIndex = 0;
    	        		int rowIndex = 0;	
                        if( event.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                        	rowIndex = GridPane.getRowIndex( event);
                        	colIndex =  GridPane.getColumnIndex( event);
                        
                        	
                        	if(findSource(colIndex, rowIndex)) { //call findSource method
                        		
                        		moved(menuPane,grid_Pane,colIndex , rowIndex,scoreText); //call moved method
                        	}                        	
                        }						
					}	    			
	    		});	    		
	    	});     
	    }
	  	    
	    public void moved(Pane menuPane,GridPane grid_Pane,int colIndex , int rowIndex,Text scoreText) {
	    		
	    		paneArray= findTarget(ImageNAME,colIndex,rowIndex);
	    		Pane pane = panes[colIndex][rowIndex];
	    		paneArray.forEach(event ->{
	    	    	
	    	    	int columnMoved=GridPane.getColumnIndex(event);
	    			int rowMoved= GridPane.getRowIndex(event);
	    			int columnMoved2= GridPane.getColumnIndex(pane);
	    			int rowMoved2= GridPane.getRowIndex(pane);
	    			//sets drag
	    			event.setOnDragOver(new EventHandler<DragEvent>() {

						@Override
						public void handle(DragEvent e) {
							if(gameEndTF==false) {
								if(paneArray.contains(event)) {
									if(findSource(colIndex, rowIndex)) {
									e.acceptTransferModes(TransferMode.MOVE);
								}
							}
						}
							e.consume();
							
						}
	    				
	    			});
	    			//sets drop
	    			event.setOnDragDropped(new EventHandler<DragEvent>() {

	    				@Override
	    				public void handle(DragEvent e) {
	    					
	    					panes[columnMoved][rowMoved]=pane;
	    					panes[columnMoved2][rowMoved2]=event;
	    					String source= ImageNAME[columnMoved2][rowMoved2];
	    					String target= ImageNAME[columnMoved][rowMoved];
	    					ImageNAME[columnMoved2][rowMoved2]=target;
	    					ImageNAME[columnMoved][rowMoved]=source;
	    					allPanes.remove(columnMoved+rowMoved*4);
	    					allPanes.add(columnMoved+rowMoved*4, pane);
	    					allPanes.remove(columnMoved2+rowMoved2*4);
	    					allPanes.add(columnMoved2+rowMoved2*4,event);
	    					grid_Pane.getChildren().remove(pane);
	    					grid_Pane.getChildren().remove(event);
	    					grid_Pane.add(pane, columnMoved, rowMoved);
	    					grid_Pane.add(event, columnMoved2, rowMoved2);
	    					success=true;
	    					counter++; //counter increments on every move
	    					scoreText.setText("Moves : "+counter); //print counter
	    					gameEndCond(grid_Pane,scoreText,menuPane); //call the gameEndCond method (check true)
	    					e.setDropCompleted(success);
	    					e.consume();
	    					
	    					}});	    			
	    		});	    		
	 }	    
	    
	 	public ArrayList<Pane> findTarget(String[][] imageName,int col,int row) {
	    	//this method checks that the targets are empty. 
	    	paneArray.clear();
	    	
	    	for(int ii=0;ii<4;ii++) {
	    		
	    		for(int jj=0;jj<4;jj++) {
	    			
	    			String str= imageName[ii][jj];
	    			
	    			
	    				if(Neighbor(ii, jj, col, row)) {
	    				
	    					if(str.equals("ef")) {
	    				
	    						paneArray.add(panes[ii][jj]);

	    				}
	    			}
	    			
	    		}
	    	}

	    	return paneArray;
	    	
	    	
	    }
	    
	    public boolean findSource(int column,int row) {//this method gives approval for moving resources
	    	String name= ImageNAME[column][row];
	    	
	    	boolean value=true;;
	    	if(name.equals("ef")||name.equals("eh")||name.equals("ev")||name.equals("ps00")||name.equals("ps01")||name.equals("ps10")||name.equals("ps11")||
					name.equals("psh")||name.equals("psv")||name.equals("sh")||name.equals("sv")) {
				value=false;
				
			}
	    	
	    	return value;
	    }
	    
	    public boolean Neighbor(int ii,int jj,int col,int row) {//this method approves the positions in the upper left right
			
	    	boolean active=false;
	    	
	    	if((col-1==ii&&row==jj)||(col==ii&&row+1==jj)||(col+1==ii&&row==jj)||(col==ii&&row-1==jj)) {
	    		active=true;
	    	}                                                                                      
	    	
	    	return active;
	    	
	    }
	  
	public void gameEndCond(GridPane grid_Pane,Text scoreText,Pane menuPane) { //this method performs control according to the id of the pane.

		String way = "";
		int emptycount = 0;
		int index = 0;
		for(int i = 0 ; i<allPanes.size();i++) {
			if(allPanes.get(i).getId().contains("Starter")) {
				if(allPanes.get(i).getId().startsWith("lft")) {
					endPanes.add(allPanes.get(i));
					way = "left";
					index = i;
				}
					else if(allPanes.get(i).getId().startsWith("bot")){
					endPanes.add(allPanes.get(i));
					way = "bot";
					index = i;
					}
			}
			if(allPanes.get(i).getId().equals("empty"))
				emptycount++;
			 }
			 for(int i =0 ; i<allPanes.size()-emptycount ; i++) {
			 switch(way) {
			 
			 case "bot" : 
				 if(index + 4 < 16) {
					 index = index+4;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way = "empty";
					 }
					 else  if(allPanes.get(index).getId().substring(0, 2).contains("t")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
							 way = "right";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("l")) {
							 way = "left";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
							 way = "bot";
							 endPanes.add(allPanes.get(index));
						 }
						 
					 }
				 }
					 break;
					 
			 case "right" :
				 if(index == 3 || index == 7 || index == 11)
					 break;
				 if(index + 1 < 16) {
					 index = index+1;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way = "empty";
					 }
					 else if (allPanes.get(index).getId().contains("ENDl")) {
						 way = "END";
						 endPanes.add(allPanes.get(index));
					 }
					  else if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
							 way = "right";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
							 way = "top";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
							 way = "bot";
							 endPanes.add(allPanes.get(index));
						 }
						
					  }
					 
				 }
				 

				 break;
				 
			 case "left" :
				 if(index == 12 || index == 4 || index == 8)
					 break;
				 if(index - 1 >= 0) {
					 index = index-1;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way ="empty";
					 }
					 else if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
							 way = "left";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
							 way = "top";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
							 way = "bot";
							 endPanes.add(allPanes.get(index));
						 }
					 }
				 }
					 break;
				 
			 case "top" :
				 if(index - 4 >= 0) {
					 index = index-4;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way ="empty";
					 }
					 else if (allPanes.get(index).getId().contains("END")) {
						 way = "END";
						 endPanes.add(allPanes.get(index));
					 }
					 else if(allPanes.get(index).getId().substring(0, 2).contains("b")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
							 way = "left";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
							 way = "top";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("r")) {
							 way = "right";
							 endPanes.add(allPanes.get(index));
						 }
					 }
					 
				 }
				 break;
		 
		 case "END" :
			 if (allPanes.size()-emptycount == endPanes.size()) { 
				 gameEndTF = true;
				 for(int ii=0;ii<endPanes.size();ii++) {
					 
					 animationPanes.add(endPanes.get(ii));//if the pipes are arranged correctly, the animation method is called.
				 }
			 
			 }
				
			 break;
		 
		 case "empty":
			 break;
			 
	}
		 
	}
		 endPanes.clear();
		 if(gameEndTF) {
			animatiOnGame(grid_Pane,scoreText,menuPane);}
}
	
	public void animatiOnGame(GridPane grid_Pane,Text scoreText,Pane menuPane) { //this method create lines path and use pathtransition

			Circle circle =new Circle(30, Color.DARKMAGENTA);
			int colStart=0,rowStart=0,colEnd=0,rowEnd=0;
			
			int col = 0,row=0,col2=0,row2=0,col3=0,row3=0;
			int x=0,y=0;
			
			Path path =new Path();
			MoveTo moveTo = new MoveTo();
			colStart=GridPane.getColumnIndex(animationPanes.get(0));
			rowStart=GridPane.getRowIndex(animationPanes.get(0));
			colEnd=GridPane.getColumnIndex(animationPanes.get(animationPanes.size()-1));
			rowEnd=GridPane.getRowIndex(animationPanes.get(animationPanes.size()-1));
			
			
			if(animationPanes.get(0).getId()=="bot-Starter") {
					col=GridPane.getColumnIndex(animationPanes.get(0));
					row=GridPane.getRowIndex(animationPanes.get(0));
					moveTo.setX((200*col)+100);
					moveTo.setY((200*row)+100);
						y=((row+1)*200);
						x=(200*col)+100;
					
				}else if(animationPanes.get(0).getId()=="lft-Starter") {
					col=GridPane.getColumnIndex(animationPanes.get(0));
					row=GridPane.getRowIndex(animationPanes.get(0));
					moveTo.setX((200*col)+100);
					moveTo.setY((200*row)+100);
					x=(200*(col));
					y=(row*200)+100;
				}
				
				path.getElements().add(moveTo);
				menuPane.getChildren().add(circle);
					
					for(Pane anime: animationPanes) {
						
						
						row=GridPane.getRowIndex(anime);
						col=GridPane.getColumnIndex(anime);
						int location=animationPanes.indexOf(anime);
						
						if(location+1<animationPanes.size()) {
							row2=GridPane.getRowIndex(animationPanes.get(location+1));
							col2=GridPane.getColumnIndex(animationPanes.get(location+1));
						}
						if(location>=1) {
							row3=GridPane.getRowIndex(animationPanes.get(location-1));
							col3=GridPane.getColumnIndex(animationPanes.get(location-1));
						}
						
						
						if(anime.getId()=="tb-PipeNormal"||anime.getId()=="tb-PipeStatic") {
							if(colStart==col||row<row2) {
								 y=y+200; path.getElements().add(new VLineTo(y));
							}else if(colStart<col&&row>row2) {
								y=y-200;path.getElements().add(new VLineTo(y));
							}
						}else if(anime.getId()=="tr-PipeNormal"||anime.getId()=="tr-PipeStatic") {
							if(col3==col&&col<col2) {
								x=x+100;y=y+100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x));
							}else if(col3>col&&col==col2) {
								x=x-100;y=y-100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}
						}else if(anime.getId()=="tl-PipeNormal"||anime.getId()=="tl-PipeStatic") {
							if(row==row3&&row>row2) {
								x=x+100;y=y-100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}else if(row>row3&&row2==row) {
								x=x-100;y=y+100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x));
							}
						}else if(anime.getId()=="lr-PipeNormal"||anime.getId()=="lr-PipeStatic") {
							if(col3>col2) {
								x=x-200;path.getElements().add(new HLineTo(x));
							}else {
								x=x+200;path.getElements().add(new HLineTo(x));
							}
						}else if(anime.getId()=="bl-PipeNormal"||anime.getId()=="bl-PipeStatic") {
							if(col>col3) {
								x=x+100;y=y+100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}else {
								x=x-100;y=y-100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x));
							}
						}else if(anime.getId()=="br-PipeNormal"||anime.getId()=="br-PipeStatic") {
							if(row3>row&&col2>col) {
								x=x+100;y=y-100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x)); 
							}else {
								x=x-100;y=y+100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}
							
						}else if(anime.getId()=="ENDl-END") {
							
							x=x+150;path.getElements().add(new HLineTo(x));
							
						}else if(anime.getId()=="ENDb-END") {
							
							y=y-150; path.getElements().add(new VLineTo(y));
						}
						
					}
			
			animex(grid_Pane,scoreText,path, circle, menuPane); //call the animex method
			
		
	}

	public void animex(GridPane grid_Pane,Text scoreText,Path path,Node circle,Pane menuPane) {

		PathTransition pt = new PathTransition(); //create pathtransition and use the path on pt.
		pt.setDuration(Duration.millis(2000));
		pt.setPath(path);
		pt.setNode(circle);
		pt.setOrientation(
			PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		//if the animation runs out the ball erases
		pt.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				menuPane.getChildren().remove(circle);
				
				event.consume();
				if(gameEndTF) {
					drawLevel(grid_Pane, menuPane, scoreText);
				}
			}
			
		});
		
		pt.play();
		pt.getOnFinished();
		
	}

	public void drawLevel(GridPane grid_Pane,Pane menuPane,Text scoreTxt)  {
		//Add buttons to menu
			if(level==1 ) {
			MenuItem level2= new MenuItem(grid_Pane,850, 250,menuPane,"2",scoreTxt);
			}else if(level==2 ) {
			MenuItem level3= new MenuItem(grid_Pane,850, 300,menuPane,"3",scoreTxt);
			}else if(level==3) {
			MenuItem level4= new MenuItem(grid_Pane,850, 350,menuPane,"4",scoreTxt);
			}else if(level==4 ) {
			MenuItem level5= new MenuItem(grid_Pane,850, 400,menuPane,"5",scoreTxt);
			}else if(level==5) {
			MenuItem level6= new MenuItem(grid_Pane,850, 450,menuPane,"6",scoreTxt);
			}else if(level==6) {
				Image img =new Image("image/cong.jpg");
				ImageView imgv= new ImageView(img);
				imgv.setFitHeight(200);
				imgv.setFitWidth(800);
				imgv.setTranslateX(0);
				imgv.setTranslateY(300);
				menuPane.getChildren().add(imgv);
				
			}
		
 		
	}
	public int getCounter() { 
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}

	 
	

