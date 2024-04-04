package application;

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

	
	public BasePageViewBuilder(String userStatus) {
		logoutButton = new Button("Logout");
		messagePortalButton = new Button("Message Portal");
		
		this.userStatus = userStatus;
		mainPane = new BorderPane();
		mainPane.setStyle("-fx-background-color: #5E0202;" + "-fx-border-color: #FFC627;" + "-fx-border-width: 3;\n");//color is #5E0202

		buildPage();

		//this.setPadding(new Insets(10,10,10,10));
		this.getChildren().add(mainPane);
	}
	
	
	protected void buildPage() {
		try {
			if(userStatus == "Patient") {
				PatientBaseViewPage patientViewPage = new PatientBaseViewPage(userStatus);
				mainPane.getChildren().add(patientViewPage);
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
	
}
