package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BasePageViewBuilder extends HBox{
	
	//Variable List: 
	//*******************
	
	//BorderPane:
	protected BorderPane mainPane;
	
	//Buttons:
	protected Button logoutButton, messagePortalButton;
	
	//Labels:
	protected Label welcomeLabel;
	
	//String:
	protected String userStatus;
	
	
	public BasePageViewBuilder() {
		logoutButton = new Button("Logout");
		messagePortalButton = new Button("Message Portal");
		
		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background-color: #5E0202;"); //color is #5E0202
		
		this.setPadding(new Insets(10,10,10,10));
		this.getChildren().add(mainPane);
	}
	
	/*
	private void configureBuildPage() {
		if(userStatus == "Patient") {
			setPatientScreen;
		}else if(userStatus == "Nurse") {
			setNurseScreen;
		}else if(userStatus == "Doctor"){
			setDoctorScreen;
		}else{
		Error;
		}
	}
	*/
}
