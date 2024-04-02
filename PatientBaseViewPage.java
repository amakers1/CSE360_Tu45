package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PatientBaseViewPage extends BasePageViewBuilder{
	
	//Variables:
	//***********************
	
	//VBoxs:
	protected VBox topPane, leftPane, rightPane, centerPane;
	
	//Labels:
	protected Label firstNameLabel, lastNameLabel, dateOfBirthLabel, emailLabel, phoneNumberLabel;
	
	//TextFields:
	protected TextField firstNameTextField, lastNameTextField, dateOfBirthTextField, emailTextField, phoneNumberTextField;
	
	//Buttons:
	protected Button updateButton;
	
	//StackPanes:
	protected StackPane contactInfoPane, appointmentSummaryPane;
	
	//Scenes:
	protected Scene contactInfoScene, appointmentSummaryScene;
	
	//TextArea:
	protected TextArea node1, node2, node3;
	
	//GridPane:
	protected GridPane contactGrid;
	
	
	
	public PatientBaseViewPage() {
		super();
	}
	@Override
	public void buildPage() {
		//Intitalizing Variables:
		
		//Labels:
		firstNameLabel = new Label("First Name");
		lastNameLabel = new Label("Last Name");
		dateOfBirthLabel = new Label("Date of Birth");
		emailLabel = new Label("Email");
		phoneNumberLabel = new Label("Phone Number");
		
		//TextFields:
		firstNameTextField = new TextField();
		lastNameTextField = new TextField();
		dateOfBirthTextField = new TextField();
		emailTextField = new TextField();
		phoneNumberTextField = new TextField();
		
		//Buttons:
		updateButton = new Button("Update");
		
		//TextAreas:
		node1 = new TextArea();
		node2 = new TextArea();
		node3 = new TextArea();
		
		//StackPanes:
		contactInfoPane = new StackPane();
		appointmentSummaryPane = new StackPane();
		
		//GridPanes:
		contactGrid = new GridPane();
		contactGrid.addColumn(0, firstNameLabel, lastNameLabel, dateOfBirthLabel, emailLabel, phoneNumberLabel);
		contactGrid.addColumn(1, firstNameTextField, lastNameTextField, dateOfBirthTextField, emailTextField, phoneNumberTextField);
		
		//VBoxs:
		topPane = new VBox(50);
		centerPane = new VBox(50);
		centerPane.getChildren().addAll(contactGrid);
		
		mainPane.setTop(topPane);
		contactInfoPane.getChildren().addAll(centerPane);
		mainPane.setCenter(contactInfoPane);
	}

}
