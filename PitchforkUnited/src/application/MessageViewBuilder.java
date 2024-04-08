package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
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
	protected Button backButton, logoutButton, sendButton, openButton;
	
	//Labels:
	protected Label messagePortalLabel, helloLabel;
	
	//Image:
	protected Image image;
	protected ImageView imageView;
	
	//BorderPanes:
	protected BorderPane mainPane;
	
	//GridPanes:
	protected GridPane topHalfPageContainer, messageContainer;
	
	//TextArea:
	protected TextArea typeMessage;
	
	//Stages:
	protected Stage primaryStage;
	
	//Dropdown:
	protected ComboBox<String> messageDropDown;
	
	//ScrollPane:
	protected ScrollPane scroll;
	
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
		sendButton = new Button("Send");
		sendButton.setEllipsisString("Send");
		backButton.setOnAction(e -> backButtonImplementation());
		openButton = new Button("Open");
		openButton.setEllipsisString("Open");
		
		//TextArea:
		typeMessage = new TextArea();
		typeMessage.setMaxSize(400, 50);
		typeMessage.setPromptText("Type Message...");
		
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
		messageContainer = new GridPane();
		messageContainer.setVgap(20);
		messageContainer.setHgap(25);
		messageContainer.setMaxSize(1000, 500);
		messageContainer.setStyle("-fx-background-color: White;" + "-fx-border-color: Black;" + "-fx-border-width: 3;\n");
		
		//ScrollPane:
		scroll = new ScrollPane();
		scroll.setContent(messageContainer);
		scroll.setMaxSize(1000, 500);
		scroll.setFitToWidth(true);
		scroll.setFitToHeight(true);
		
		//DropDown:
		messageDropDown = new ComboBox<>();
		messageDropDown.setPromptText("Message");
		messageDropDown.setMinSize(150, 25);
		
		
		//Stages:
		this.primaryStage = primaryStage;
		
			//TopHalfPageContainer:
		topHalfPageContainer.add(backButton, 0, 0);
		topHalfPageContainer.add(messagePortalLabel, 3, 0);
		topHalfPageContainer.add(logoutButton, 5, 0);
		topHalfPageContainer.add(messageDropDown, 2, 1);
		topHalfPageContainer.add(openButton, 3, 1);
		topHalfPageContainer.add(imageView, 4, 1);
		
		//MessageContainer
		messageContainer.add(sendButton,0,0);
		messageContainer.add(typeMessage, 0, 1);
		
		
		mainPane.setTop(topHalfPageContainer);
		mainPane.setCenter(scroll);
		
		//Add this part to nurse and doctor message view like it is in patient message view constructor
		/*
		//Set stage
		primaryStage.setScene(new Scene(mainPane,2000,2000));
		primaryStage.setFullScreen(true);
		primaryStage.show();
		*/
	}
	
	public void buildMessagePage() {
	
		
		try {
			if(userStatus == "Patient") {
				PatientMessageView patientView = new PatientMessageView(userStatus, primaryStage, userName);
				patientView.buildMessagePage();
			}else if(userStatus == "Nurse") {
				//setNurseScreen;
			}else if(userStatus == "Doctor"){
				//setDoctorScreen;
			}else{
				return;
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public void backButtonImplementation() {
		
		BasePageViewBuilder basePageViewBuilder = new BasePageViewBuilder(userStatus, primaryStage, userName);
		primaryStage.setScene(new Scene(basePageViewBuilder, 2000, 2000));
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
	}

}
