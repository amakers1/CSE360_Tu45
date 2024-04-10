package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NurseBaseViewPage extends BasePageViewBuilder {
	
	//Variables:
	//***********************
	boolean patientIsSelected = false;
	
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
	protected Button saveButton, logoutButton, patient1button, patient2button, patient3button, patient4button, patient5button;
	
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
		imageView.setFitHeight(250);
		imageView.setFitWidth(400);
		
		
		//Labels:
		
		// TOP SIDE
		welcomeNurseLabel = new Label("Welcome Nurse " + nurseUserName);
		welcomeNurseLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 65; -fx-text-fill: #FFC627");
		
		patientsTitleLabel = new Label("Patients");
		patientsTitleLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		vitalsTitleLabel = new Label("Vitals");
		vitalsTitleLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		historyTitleLabel = new Label("History");
		historyTitleLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		patientConcernsLabel = new Label("Patient Concerns");
		patientConcernsLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
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
		saveButton.setPrefSize(200, 250);
		saveButton.setStyle("-fx-background-color: #FFC627");
		//updateButton.setEllipsisString("Update");
		logoutButton =  new Button("Logout");
		logoutButton.setPrefSize(100, 50);
		logoutButton.setStyle("-fx-background-color: #FFC627");
		//messagePortalButton = new Button("Message Portal");
		
		//TextAreas:
		patientConcernField = new TextArea();
		pastConcernsField = new TextArea();
		pastConcernsField.setEditable(false);
		medicationsField = new TextArea();
		medicationsField.setEditable(false);
		immunizationsField = new TextArea();
		immunizationsField.setEditable(false);
		allergiesField = new TextArea();
		allergiesField.setEditable(false);
		
				
		//GridPanes:
		patientVitals = new GridPane();
		patientVitals.setVgap(75);
		patientVitals.setHgap(50);
		patientVitals.addColumn(0, patientNameLabel, weightLabel, heightLabel, temperatureLabel, bloodPressureLabel);
		patientVitals.addColumn(1, new Label(""), weightField, heightField, temperatureField, bloodPressureField);//patientNameLabel,
		patientHistory = new GridPane();
		patientHistory.setVgap(50);
		patientHistory.setHgap(50);
		patientHistory.addColumn(0, pastConcernsLabel, medicationsLabel, immunizationsLabel, allergiesLabel);
		patientHistory.addColumn(1, pastConcernsField, medicationsField, immunizationsField, allergiesField);
		patientList = new GridPane();
		
		
		//HBoxs:
		vitalsAndHistoryHBox = new HBox(15);
		vitalsAndHistoryHBox.getChildren().addAll(patientVitals, patientHistory);
		//vitalsAndHistoryHBox.setMaxWidth(500);
		
		topHBox = new HBox(150);
		topHBox.getChildren().addAll(logoutButton, welcomeNurseLabel);
		
		HBox tempHBox = new HBox(25);
		tempHBox.getChildren().addAll(patientConcernField, saveButton);
		
		
		
		// GRIDPANE:
		patient1button = new Button("Select patient");
		patient2button = new Button("Select patient");
		patient3button = new Button("Select patient");
		patient4button = new Button("Select patient");
		patient5button = new Button("Select patient");
		
		// Set up patient list
		patientList = new GridPane();
		patientList.addColumn(0, new Label("User Name"));
		patientList.addColumn(1, new Label("Name"));
		patientList.addColumn(2, new Label("Date of Birth"));
		patientList.addColumn(3, new Label(""), patient1button, patient2button, patient3button, patient4button, patient5button);
		populatePatientList();
		
		patientList.setStyle("-fx-background-color: white; -fx-grid-lines-visible: false; -fx-padding: 50px;");
		patientList.setAlignment(Pos.CENTER);

		patientList.setHgap(10); // Horizontal spacing
		patientList.setVgap(10); // Vertical spacing
		
		
		
		//VBoxs:
		vitalsAndHistoryVBox = new VBox(10);
		vitalsAndHistoryVBox.getChildren().addAll(vitalsAndHistoryHBox, patientConcernsLabel, tempHBox);
		
		leftVBox = new VBox();
		leftVBox.getChildren().addAll(patientsTitleLabel, patientList, messagePortalButton, imageView);
		leftVBox.setAlignment(Pos.CENTER);
		leftVBox.setSpacing(20); // vertical spacing
		
		// BorderPane:
		topHBox.setPadding(new Insets(30,30,57,100));
		//contactInfoPane.setPadding(new Insets(30,30,101,30));
		leftVBox.setPadding(new Insets(30,15,100,10));
		vitalsAndHistoryVBox.setPadding(new Insets(15,30,100,100));
		
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
		patient1button.setOnAction(e -> {
			getInfo(1);
		});
		patient2button.setOnAction(e -> {
			getInfo(2);
		});
		patient3button.setOnAction(e -> {
			getInfo(3);
		});
		patient4button.setOnAction(e -> {
			getInfo(4);
		});
		patient5button.setOnAction(e -> {
			getInfo(5);
		});
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
	
	private void saveInfo() {
		/*
		 * TO IMPLEMENT.....
		 * 
		 * When a button is pressed, then save to the patient's health file
		 * If no such file exists then create one and fill in basic history information
		 * 
		 */
	}
	
	private void getInfo(int row) {
		
		// get username
		Node node = getNodeByRowColumnIndex(patientList, row, 0);
		
		if(node == null) {
			return;
		}
		
		String username = ((Label)node).getText();
		
		//get name
		node = getNodeByRowColumnIndex(patientList, row, 1);
		
		if(node == null) {
			return;
		}
		
		String name = ((Label)node).getText();
		
		String filePath = "PitchforkUnited/Pitchfork United Main Folder/Patient List/" + username + "/" + username + "_Health.txt";
		
		System.out.println("getInfo: " + filePath);
		/*
		 * Function will need to be implemented to read the patient files and pull the relevant information
		 * Will be pulled from patient file where lines will be formatted with information
		 */
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
            	System.out.println(line);
                // Process each line based on its position
                switch (lineNumber) {
                    case 1:
                        //weight
                    	weightField.setText(line);
                        break;
                    case 2:
                    	//height
                    	heightField.setText(line);
                        break;
                    case 3:
                    	//temp
                    	temperatureField.setText(line);
                        break;
                    case 4:
                    	//blood pressure
                    	bloodPressureField.setText(line);
                        break;
                    case 5:
                    	//Current concerns
                    	patientConcernField.setText(line);
                        break;
                    case 6:
                    	//past concerns
                    	pastConcernsField.setText(line);
                        break;
                    case 7:
                    	//medications
                    	medicationsField.setText(line);
                        break;
                    case 8:
                    	//immunizations
                    	immunizationsField.setText(line);
                        break;
                    case 9:
                    	//allergies
                    	allergiesField.setText(line);
                        break;
                    default:
                        // Handle additional lines if needed
                        break;
                }
                lineNumber++;
            }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
		
		patientNameLabel.setText(name);
	}
	
	private Node getNodeByRowColumnIndex(GridPane gridPane, int row, int column) {
        for (Node node : gridPane.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer columnIndex = GridPane.getColumnIndex(node);
            if (rowIndex != null && columnIndex != null && rowIndex == row && columnIndex == column) {
                return node;
            }
        }
        return null; // Node not found
    }
	
	private void populatePatientList() {
		
        String parentFolderPath = "PitchforkUnited/Pitchfork United Main Folder/Patient List"; // Specify the path to the parent folder

        // Create a File object for the parent folder
        File parentFolder = new File(parentFolderPath);
        
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current directory: " + currentDirectory);

        // Check if the specified path exists and is a directory
        if (parentFolder.exists() && parentFolder.isDirectory()) {
            // Get an array of File objects representing the subdirectories
            File[] subdirectories = parentFolder.listFiles(File::isDirectory);
            int i = 1;
            // Iterate through each subdirectory and print its name
            for (File subdirectory : subdirectories) {
                patientList.add(new Label(subdirectory.getName()), 0, i);
                System.out.println(i + ": " + subdirectory.getName());
                
                
             // Read the text file (replace with your actual file path)
            String filePath = "PitchforkUnited/Pitchfork United Main Folder/Patient List/" + subdirectory.getName() + "/" +
            					subdirectory.getName() + "_Information.txt";
            
            System.out.println(filePath);
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int lineNumber = 1;
                while ((line = reader.readLine()) != null) {
                    // Process each line based on its position
                    switch (lineNumber) {
                        case 1:
                            patientList.add(new Label(line), 0, i);
                            break;
                        case 2:
                        	//System.out.println("Name: " + line);
                        	patientList.add(new Label(line), 1, i);
                            break;
                        case 3:
                        	//System.out.println("Date of Birth: " + line);
                        	patientList.add(new Label(line), 2, i);
                            break;
                        case 4:
                        	//System.out.println("Email: " + line);
                            break;
                        case 5:
                        	//System.out.println("Phone Number: " + line);
                            break;
                        default:
                            // Handle additional lines if needed
                            break;
                    }
                    lineNumber++;
                }
                } catch (IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                }
                i++;
            }
        } else {
            System.out.println("Invalid folder path or not a directory.");
        }
	}
}
