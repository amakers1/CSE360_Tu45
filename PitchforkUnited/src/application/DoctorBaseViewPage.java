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

public class DoctorBaseViewPage extends BasePageViewBuilder {
	
	//Variables:
	//***********************
	
	//VBoxs:
	protected VBox vboxLeftSide, vboxMiddleSide, vboxRightSide, vboxConcerns;
	
	//HBoxs:
	protected HBox hboxVitalsConcerns, hboxPrescribeInfo, hboxPhysical, hboxTop;
	
	//Labels:
	protected Label lblWelcome, lblPatient, lblVitals, lblWeight, lblHeight, lblTemp, 
					lblBloodPressure, lblConcernVisit, lblPhysicalExam, lblPrescribe,
					lblPatientHistory, lblPatientInfo, lblPrevConcern, lblPrevMed, 
					lblPrevImmunizations, lblAllergies, errorLabel;
	
	//TextFields:
	protected TextField txtWeight, txtHeight, txtTemp, txtBloodPressure;
	
	//Buttons:
	protected Button butLogout, butSave, butMessagePortal;
	
	//Scenes:
	protected Scene mainScene;
	
	//TextArea:
	protected TextArea txtPhysicalExam, txtPrescribe, txtPatientInfo, txtPrevConcern, 
					   txtPrevMed, txtPrevImmunizations, txtAllergies, txtConcern;
	
	//GridPane:
	protected GridPane gridPatientList, gridAllPatientInfo, gridVitals;
	
	//Image:
	protected Image image;
	protected ImageView imageView;
	
	//Strings:
	protected String doctorUserName, patientFirstName, patientLastName, 
				patientWeight, patientHeight, patientTemperature, patientBloodPressure,
				patientPastConcerns, patientMedications, patientImmunizations,
				patientAllergies, patientConcerns;
	
	//Ints:
	protected int dateOfBirth, phoneNumber;
	
	
	public DoctorBaseViewPage(String userStatus, Stage primaryStage, String doctorUserName) {
		super(userStatus, primaryStage, doctorUserName);
		this.doctorUserName = doctorUserName;
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
		
		// TOP SECTION
		lblWelcome = new Label("Welcome Dr. " + doctorUserName);
		lblWelcome.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 65; -fx-text-fill: #FFC627");
		
		lblPatient = new Label("Patients");
		lblPatient.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		
		// MIDDLE SECTION
		lblVitals = new Label("Vitals");
		lblVitals.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblWeight = new Label("Weight: ");
		lblWeight.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblHeight = new Label("Height: ");
		lblHeight.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblTemp = new Label("Temperature: ");
		lblTemp.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblBloodPressure = new Label("Blood Pressure: ");
		lblBloodPressure.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblConcernVisit = new Label("Concern for Visit: ");
		lblConcernVisit.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblPhysicalExam = new Label("Physical Exam Findings: ");
		lblPhysicalExam.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblPrescribe = new Label("Prescribe the following: ");
		lblPrescribe.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		
		// RIGHT SECTION
		lblPatientHistory = new Label("Patient History: ");
		lblPatientHistory.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblPatientInfo = new Label("Patient Information: ");
		lblPatientInfo.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblPrevConcern = new Label("Past Concerns:");
		lblPrevConcern.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblPrevMed = new Label("Medications:");
		lblPrevMed.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblPrevImmunizations = new Label("Immunizations:");
		lblPrevImmunizations.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		lblAllergies = new Label("Allergies:");
		lblAllergies.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		// MISC
		errorLabel = new Label("");
		errorLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #FFC627");
		
		
		//Non-editable TextFields / TextAreas:
		txtWeight = new TextField();
		txtWeight.setEditable(false);
		
		txtHeight = new TextField();
		txtHeight.setEditable(false);
		
		txtTemp = new TextField();
		txtTemp.setEditable(false);
		
		txtBloodPressure = new TextField();
		txtBloodPressure.setEditable(false);
		
		txtConcern = new TextArea();
		txtConcern.setEditable(false);
		
		txtPatientInfo = new TextArea();
		txtPatientInfo.setEditable(false);
		
		txtPrevConcern = new TextArea();
		txtPrevConcern.setEditable(false);
		
		txtPrevMed = new TextArea();
		txtPrevMed.setEditable(false);
		
		txtPrevImmunizations = new TextArea();
		txtPrevImmunizations.setEditable(false);
		
		txtAllergies = new TextArea();
		txtAllergies.setEditable(false);
		
		
		// editable fields
		txtPhysicalExam = new TextArea();
		txtPrescribe = new TextArea();
		
		
		//Buttons:
		butSave = new Button("Save");
		butSave.setPrefSize(200, 250);
		butSave.setStyle("-fx-background-color: #FFC627");
		
		butLogout =  new Button("Logout");
		butLogout.setPrefSize(100, 50);
		butLogout.setStyle("-fx-background-color: #FFC627");
		
		
		// minor HBoxes, VBoxes, GridPanes:
		
		gridVitals = new GridPane();
		gridVitals.addRow(0, lblVitals);
		gridVitals.addRow(1, lblWeight, txtWeight);
		gridVitals.addRow(2, lblHeight, txtHeight);
		gridVitals.addRow(3, lblTemp, txtTemp);
		gridVitals.addRow(4, lblBloodPressure, txtBloodPressure);
		
		vboxConcerns = new VBox();
		vboxConcerns.getChildren().addAll(lblConcernVisit, txtConcern);
		
		hboxVitalsConcerns = new HBox();
		hboxVitalsConcerns.getChildren().addAll(gridVitals, vboxConcerns);
		
		hboxPrescribeInfo = new HBox();
		hboxPrescribeInfo.getChildren().addAll(lblPrescribe, txtPrescribe);
		
		
		vboxMiddleSide = new VBox();
		vboxMiddleSide.getChildren().addAll(hboxVitalsConcerns, lblPhysicalExam, txtPhysicalExam, hboxPrescribeInfo, butSave);
		
		vboxRightSide = new VBox();
		vboxRightSide.getChildren().addAll(lblPatientHistory, lblPatientInfo, txtPatientInfo, 
				lblPrevConcern, txtPrevConcern, lblPrevMed, txtPrevMed, lblPrevImmunizations, txtPrevImmunizations,
				lblAllergies, txtAllergies);
		
		
		
		// GridPanes:
		// Set up patient list
		gridPatientList = new GridPane();
		gridPatientList.addColumn(0, new Label("Last Name"), new Label("Name"), new Label("Name"), new Label("Name"), new Label("Name"));
		gridPatientList.addColumn(1, new Label("First Name"), new Label("Name"), new Label("Name"), new Label("Name"), new Label("Name"));
		gridPatientList.addColumn(2, new Label("Date of Birth"), new Label("DOB"), new Label("DOB"), new Label("DOB"), new Label("DOB"));
		gridPatientList.addColumn(3, new Label(""), new Button("Select patient"), new Button("Select patient"), new Button("Select patient"), new Button("Select patient"));
		
		gridPatientList.setStyle("-fx-background-color: white; -fx-grid-lines-visible: false; -fx-padding: 50px;");
		gridPatientList.setAlignment(Pos.CENTER);

		gridPatientList.setHgap(10); // Horizontal spacing
		gridPatientList.setVgap(10); // Vertical spacing
		
		vboxLeftSide = new VBox();
		vboxLeftSide.getChildren().addAll(lblPatient, gridPatientList, butMessagePortal);
		
		// Set up patient info side
		gridAllPatientInfo = new GridPane();
		gridAllPatientInfo.addRow(0, vboxLeftSide, vboxMiddleSide, vboxRightSide);
		gridPatientList.setVgap(10);
		
		
		hboxTop = new HBox();
		hboxTop.getChildren().addAll(lblWelcome, butLogout);
		
		// BorderPane:
		//.setPadding(new Insets(30,30,57,100));
		//contactInfoPane.setPadding(new Insets(30,30,101,30));
		//leftVBox.setPadding(new Insets(30,15,100,10));
		//vitalsAndHistoryVBox.setPadding(new Insets(15,30,100,100));
		
		mainPane.setTop(hboxTop);
		mainPane.setCenter(gridAllPatientInfo);
		//mainPane.setLeft(leftPane);
		//mainPane.setRight(rightPane);
		mainPane.setBottom(new HBox(errorLabel));
		
		
		butSave.setOnAction(e -> writeFile()); // writes the patient file based on the information put into the vitals
		//butLogout.setOnAction(e -> XXXXXXX); // ***** NEED TO GO BACK TO LOGIN SCREEN
	}
	
	// function for writing
	private void writeFile() {
		try {
			if(txtPhysicalExam.getText().isBlank() || txtPrescribe.getText().isBlank() ) {
				errorLabel.setText("At least one field is empty!");
				errorLabel.setEllipsisString("At least one field is empty!");
				throw new Exception();
			}
			// Generate the file name
            String fileName = patientLastName + patientFirstName + "_Appointment_Summary.txt";

            // Create a string with all the CT scan results
            String writeInfo = java.time.LocalDate.now() + "\n" +
            					txtPhysicalExam.getText() + "\n" +
                                   txtPrescribe.getText() + "\n";

            // Write the CT scan results to the file
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(writeInfo);
            bufferedWriter.close();
			
			errorLabel.setText("Information Updated!");
		}catch(Exception e) {
			System.out.print(e);
			
		}
	}
	
	private void getInfo(int row) {
		
		// get username
		Node node = getNodeByRowColumnIndex(gridPatientList, row, 0);
		
		if(node == null) {
			return;
		}
		
		String username = ((Label)node).getText();
		
		//get name
		node = getNodeByRowColumnIndex(gridPatientList, row, 1);
		
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
                    	txtWeight.setText(line);
                        break;
                    case 2:
                    	//height
                    	txtHeight.setText(line);
                        break;
                    case 3:
                    	//temp
                    	txtTemp.setText(line);
                        break;
                    case 4:
                    	//blood pressure
                    	txtBloodPressure.setText(line);
                        break;
                    case 5:
                    	//Current concerns
                    	txtConcern.setText(line);
                        break;
                    case 6:
                    	//past concerns
                    	txtPrevConcern.setText(line);
                        break;
                    case 7:
                    	//medications
                    	txtPrevMed.setText(line);
                        break;
                    case 8:
                    	//immunizations
                    	txtPrevImmunizations.setText(line);
                        break;
                    case 9:
                    	//allergies
                    	txtAllergies.setText(line);
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
		
		lblPatientInfo.setText(name);
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
            	gridPatientList.add(new Label(subdirectory.getName()), 0, i);
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
                        	gridPatientList.add(new Label(line), 0, i);
                            break;
                        case 2:
                        	//System.out.println("Name: " + line);
                        	gridPatientList.add(new Label(line), 1, i);
                            break;
                        case 3:
                        	//System.out.println("Date of Birth: " + line);
                        	gridPatientList.add(new Label(line), 2, i);
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
