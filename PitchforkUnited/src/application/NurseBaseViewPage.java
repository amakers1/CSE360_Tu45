package application;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NurseBaseViewPage extends BasePageViewBuilder {
	
	//Variables:
	//***********************
	
	//VBoxs:
	protected VBox vitalsAndHistoryVBox, leftVBox;
	
	//GridPanes
	protected GridPane patientVitals, patientHistory, patientList;
	
	//HBoxs:
	protected HBox vitalsAndHistoryHBox, topHBox;
	
	//Labels:
	protected Label welcomeNurseLabel, patientNameLabel, weightLabel, heightLabel,
					temperatureLabel, bloodPressureLabel, pastConcernsLabel,
					medicationsLabel, immunizationsLabel, allergiesLabel,
					patientsTitleLabel, vitalsTitleLabel, historyTitleLabel, 
					patientConcernsLabel, errorLabel;
	
	//TextFields:
	protected TextField weightField, heightField, temperatureField, bloodPressureField;
	
	//Buttons:
	protected Button saveButton, logoutButton;
	
	//StackPanes:
	protected StackPane contactInfoPane;
	
	//BorderPanes:
	protected BorderPane mainBorderPane;
	
	//Scenes:
	protected Scene mainScene;
	
	//TextArea:
	protected TextArea patientConcernField, pastConcernsField, medicationsField, immunizationsField, allergiesField;
	
	//GridPane:
	protected GridPane contactGrid, topPaneGrid;
	
	//Image:
	protected Image image;
	protected ImageView imageView;
	
	//Strings:
	protected String nurseUserName, patientFirstName, patientLastName, 
				patientWeight, patientHeight, patientTemperature, patientBloodPressure,
				patientPastConcerns, patientMedications, patientImmunizations,
				patientAllergies, patientConcerns;
	
	//Ints:
	protected int dateOfBirth, phoneNumber;
	
	
	public NurseBaseViewPage(String userStatus, Stage primaryStage, String nurseUserName) {
		super(userStatus, primaryStage, nurseUserName);
		this.nurseUserName = nurseUserName;
	}
	
	@Override
	public void buildPage() {
		//Intitalizing Variables:
		
		//Images:
		image = new Image("ASU_Hostpial_Logo_2.png");
		imageView  = new ImageView(image);
		imageView.setFitHeight(350);
		imageView.setFitWidth(500);
		
		
		//Labels:
		
		// TOP SIDE
		welcomeNurseLabel = new Label("Welcome Nurse");
		welcomeNurseLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		patientsTitleLabel = new Label("Patients");
		patientsTitleLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		vitalsTitleLabel = new Label("Vitals");
		vitalsTitleLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		historyTitleLabel = new Label("History");
		historyTitleLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		patientConcernsLabel = new Label("Patient Concerns");
		
		// PATIENT VITALS
		patientNameLabel = new Label("FIRST LAST");
		patientNameLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		weightLabel = new Label("Weight:");
		weightLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		heightLabel = new Label("Height:");
		heightLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		temperatureLabel = new Label("Temperature:");
		temperatureLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		bloodPressureLabel = new Label("Blood pressure:");
		bloodPressureLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		// PATIENT HISTORY
		pastConcernsLabel = new Label("Past Concerns:");
		pastConcernsLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		medicationsLabel = new Label("Medicals:");
		medicationsLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		immunizationsLabel = new Label("Immunizations:");
		immunizationsLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		allergiesLabel = new Label("Allergies:");
		allergiesLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		
		errorLabel = new Label("");
		errorLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #FFC627");

		//TextFields:
		weightField = new TextField();
		//weightField.setMinWidth(200);
		heightField = new TextField();
		temperatureField = new TextField();
		bloodPressureField = new TextField();
		
		//Buttons:
		saveButton = new Button("Save");
		//updateButton.setEllipsisString("Update");
		logoutButton =  new Button("Logout");
		//messagePortalButton = new Button("Message Portal");
		
		//TextAreas:
		patientConcernField = new TextArea();
		pastConcernsField = new TextArea();
		medicationsField = new TextArea();
		immunizationsField = new TextArea();
		allergiesField = new TextArea();
		
				
		//GridPanes:
		patientVitals = new GridPane();
		patientVitals.setVgap(75);
		patientVitals.setHgap(250);
		patientVitals.addColumn(0, patientNameLabel, weightLabel, heightLabel, temperatureLabel, bloodPressureLabel);
		patientVitals.addColumn(1,  weightField, heightField, temperatureField, bloodPressureField);//patientNameLabel,
		patientHistory = new GridPane();
		patientHistory.setVgap(50);
		patientHistory.setHgap(250);
		patientHistory.addColumn(0, pastConcernsLabel, medicationsLabel, immunizationsLabel, allergiesLabel);
		patientHistory.addRow(1, pastConcernsField, medicationsField, immunizationsField, allergiesField);
		patientList = new GridPane();
		//HBoxs:
		vitalsAndHistoryHBox = new HBox(150);
		vitalsAndHistoryHBox.getChildren().addAll(patientVitals, patientHistory);
		
		topHBox = new HBox(150);
		topHBox.getChildren().addAll(logoutButton, welcomeNurseLabel);
		
		
		//VBoxs:
		vitalsAndHistoryVBox = new VBox(50);
		vitalsAndHistoryVBox.getChildren().addAll(vitalsAndHistoryHBox, patientConcernsLabel, patientConcernField, saveButton);
		
		leftVBox = new VBox();
		leftVBox.getChildren().addAll(patientsTitleLabel, patientList, messagePortalButton, imageView);
		
		// BorderPane
		
		topHBox.setPadding(new Insets(30,100,57,100));
		//contactInfoPane.setPadding(new Insets(30,30,101,30));
		leftVBox.setPadding(new Insets(100,100,100,10));
		vitalsAndHistoryVBox.setPadding(new Insets(100,57,100,100));
		
		mainPane.setTop(topHBox);
		//mainPane.setCenter(contactInfoPane);
		mainPane.setLeft(leftVBox);
		mainPane.setRight(vitalsAndHistoryVBox);
		mainPane.setBottom(new HBox(errorLabel));
		//mainBorderPane = new BorderPane();
		//mainPane.setTop(topHBox);
		//mainPane.setCenter(contactInfoPane);
		//mainPane.setLeft(leftVBox);
		//mainPane.setRight(vitalsAndHistoryVBox);
		//mainPane.setBottom(new HBox(errorLabel));
		
		saveButton.setOnAction(e -> writeFile()); // writes the patient file based on the information put into the vitals
		//logoutButton.setOnAction(e -> XXXXXXX); // ***** NEED TO GO BACK TO LOGIN SCREEN
		//messagePortalButton.setOnAction(e -> XXXXXXXXXX); // ******* NEED TO OPEN THE MESSAGE PORTAL
	}
	
	// function for writing
	private void writeFile() {
		try {
			if(weightField.getText().isBlank() || heightField.getText().isBlank() || temperatureField.getText().isBlank() || 
					bloodPressureField.getText().isBlank() || patientConcernField.getText().isBlank()) {
				errorLabel.setText("At least one field is empty!");
				errorLabel.setEllipsisString("At least one field is empty!");
				throw new Exception();
			}
			// Generate the file name
            String fileName = patientLastName + patientFirstName + "Vitals.txt";

            // Create a string with all the CT scan results
            String vitals = weightField.getText() + "\n" +
                                   heightField.getText() + "\n" +
                                   temperatureField.getText() + "\n" +
                                   bloodPressureField.getText() + "\n" +
                                   patientConcernField.getText() + "\n";

            // Write the CT scan results to the file
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(vitals);
            bufferedWriter.close();
			
			errorLabel.setText("Information Updated!");
		}catch(Exception e) {
			System.out.print(e);
			
		}
	}
	
	private void getInfo() {
		/*
		 * Function will need to be implemented to read the patient files and pull the relevant information
		 * Will be pulled from patient file where lines will be formatted with information
		 */
	}
}
