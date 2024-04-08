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
	


	
	public BasePageViewBuilder(String userStatus, Stage primaryStage, String userName) {
		logoutButton = new Button("Logout");
		messagePortalButton = new Button("Message Portal");
		
		this.userName = userName; //this variable is the name of the user whether doctor, patient or nurse need this variable to access user files so it needs to be grabbed when user signs in
		this.userStatus = userStatus;
		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background-color: #5E0202;" + "-fx-border-color: #FFC627;" + "-fx-border-width: 3;\n");//color is #5E0202
		
		this.primaryStage = primaryStage;


		buildPage();

		//this.setPadding(new Insets(10,10,10,10));
		this.getChildren().add(mainPane);
		
		messagePortalButton.setOnAction(e -> changeToMessagePortal());
	}
	
	
	protected void buildPage() {
		try {
			if(userStatus.equals("Patient")) {
				PatientBaseViewPage patientViewPage = new PatientBaseViewPage(userStatus, primaryStage, userName);
				mainPane.getChildren().add(patientViewPage);
			}else if(userStatus.equals("Nurse")) {
				//setNurseScreen;
			}else if(userStatus.equals("Doctor")){
				//setDoctorScreen;
			}else{
				return;
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	private void changeToMessagePortal() {
		MessageViewBuilder messageViewBuilder = new MessageViewBuilder(userStatus, primaryStage, userName);
		messageViewBuilder.buildMessagePage();
		
	}
}
