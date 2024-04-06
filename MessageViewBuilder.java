package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MessageViewBuilder extends HBox{
	
	//Variables: 
	
	//Strings:
	protected String userStatus, userName;
	
	//Buttons:
	protected Button backButton, logoutButton;
	
	//Labels:
	protected Label messagePortalLabel, helloLabel;
	
	//Image:
	protected Image image;
	protected ImageView imageView;
	
	//BorderPanes:
	protected BorderPane mainPane;
	
	//GridPanes:
	protected GridPane topHalfPageContainer;
	
	//Stages:
	protected Stage primaryStage;
	
	//Dropdown:
	protected ComboBox<String> messageDropDown;
	
	public MessageViewBuilder(String userStatus , Stage primaryStage,String userName) {
		//Initialize Variables:
		
		//Strings
		this.userStatus = userStatus;
		this.userName = userName;
		
		//Buttons:
		backButton = new Button("<- Back");
		backButton.setEllipsisString("<- Back");
		logoutButton = new Button("Logout");
		logoutButton.setEllipsisString("Logout");
		backButton.setOnAction(e -> backButtonImplementation());
		
		//Labels:
		messagePortalLabel = new Label("Message Portal");
		messagePortalLabel.setEllipsisString("Message Portal");
		messagePortalLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		//Image:
		image = new Image("ASU_Hostpial_Logo_2.png");
		imageView  = new ImageView(image);
		imageView.setFitHeight(150);
		imageView.setFitWidth(200);
		
		//BorderPanes:
		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background-color: #5E0202;" + "-fx-border-color: #FFC627;" + "-fx-border-width: 3;\n");//color is #5E0202
		
		//GridPanes:
		topHalfPageContainer = new GridPane();
		topHalfPageContainer.setHgap(175);
		topHalfPageContainer.setVgap(30);
		topHalfPageContainer.setPadding(new Insets(5,5,5,5));
		
		//DropDown:
		messageDropDown = new ComboBox<>();
		
		//Stages:
		this.primaryStage = primaryStage;
		
		
	}
	
	public void buildMessagePage() {
		//TopHalfPageContainer:
		topHalfPageContainer.add(backButton, 0, 0);
		topHalfPageContainer.add(messagePortalLabel, 3, 0);
		topHalfPageContainer.add(logoutButton, 5, 0);
		topHalfPageContainer.add(messageDropDown, 2, 1);
		topHalfPageContainer.add(imageView, 4, 1);
		
		mainPane.setTop(topHalfPageContainer);
		
		//Set stage
		primaryStage.setScene(new Scene(mainPane,2000,2000));
		primaryStage.setFullScreen(true);
		primaryStage.show();

		
		
	}
	
	public void backButtonImplementation() {
		
		BasePageViewBuilder basePageViewBuilder = new BasePageViewBuilder(userStatus, primaryStage, userName);
		primaryStage.setScene(new Scene(basePageViewBuilder, 2000, 2000));
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
	}

}
