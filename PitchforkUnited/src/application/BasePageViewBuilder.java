package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BasePageViewBuilder extends HBox{
	
	//Variable List: 
	//*******************
	
	//BorderPane:
	protected BorderPane mainPane, userViewPage;
	
	//Buttons:
	protected Button logoutButton, messagePortalButton;
	
	//Labels:
	protected Label welcomeLabel;
	
	//String:
	protected String userStatus, userName;
	
	protected Stage primaryStage;
	


	//This method builds the base view for the user after they sign in
	//given the user status from the sign in will determine how the rest of the page is built
	public BasePageViewBuilder(String userStatus, Stage primaryStage, String userName) {
		logoutButton = new Button("Logout");
		messagePortalButton = new Button("Message Portal");
		
		this.userName = userName; //this variable is the name of the user whether doctor, patient or nurse need this variable to access user files so it needs to be grabbed when user signs in
		this.userStatus = userStatus; //user status is needed to validate certain data and build correct pages
		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background-color: #5E0202;" + "-fx-border-color: #FFC627;" + "-fx-border-width: 3;\n");//color is #5E0202
		
		this.primaryStage = primaryStage;


		buildPage();

		this.getChildren().add(mainPane);
		
		messagePortalButton.setOnAction(e -> changeToMessagePortal()); //when message portal button clicked changeToMessagePortal is called
	}
	
	//this method determines the type of build using the user status 
	protected void buildPage() {
		try {
			if(userStatus.equals("Patient")) { //patient build is selected 
				PatientBaseViewPage patientViewPage = new PatientBaseViewPage(userStatus, primaryStage, userName);
				mainPane.getChildren().add(patientViewPage);
			}else if(userStatus.equals("Nurse")) {//nurse build is selected
				//setNurseScreen;
			}else if(userStatus.equals("Doctor")){//doctor build is selected
				//setDoctorScreen;
			}else{
				return;
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	//this method is used when the message portal button is clicked 
	private void changeToMessagePortal() {
		MessageViewBuilder messageViewBuilder = new MessageViewBuilder(userStatus, primaryStage, userName);
		messageViewBuilder.buildMessagePage();
		
	}
}
