package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
import javafx.scene.layout.ColumnConstraints;
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
	protected Button butLogout, butSave;
	// Button messagePortalButton
	
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
	protected String doctorUserName;
	
	//Ints:
	protected int dateOfBirth, phoneNumber;
	
	String currentPatientUserName = "";
	
	
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
		doctorUserName = "Day"; //test for name
		lblWelcome = new Label("Welcome Dr. " + doctorUserName);
		lblWelcome.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 65; -fx-text-fill: #FFC627");
		
		lblPatient = new Label("Patients");
		lblPatient.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		
		
		// MIDDLE SECTION
		lblVitals = new Label("Vitals");
		lblVitals.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblVitals.setEllipsisString("Vitals");
		
		lblWeight = new Label("  Weight: ");
		lblWeight.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblWeight.setEllipsisString("  Weight: ");
		
		lblHeight = new Label("  Height: ");
		lblHeight.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblHeight.setEllipsisString("  Height: ");
		
		lblTemp = new Label("  Temperature: ");
		lblTemp.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblTemp.setEllipsisString("  Temperature: ");
		
		lblBloodPressure = new Label("  Blood Pressure: ");
		lblBloodPressure.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblBloodPressure.setEllipsisString("  Blood Pressure: ");
		
		lblConcernVisit = new Label("Concern for Visit: ");
		lblConcernVisit.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblConcernVisit.setEllipsisString("Concern for Visit: ");
		
		lblPhysicalExam = new Label("Physical Exam Findings: ");
		lblPhysicalExam.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblPhysicalExam.setEllipsisString("Physical Exam Findings: ");
		
		lblPrescribe = new Label("Prescribe the following: ");
		lblPrescribe.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblPrescribe.setEllipsisString("Prescribe the following: ");
		
		
		// RIGHT SECTION
		lblPatientHistory = new Label("Patient History: ");
		lblPatientHistory.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblPatientHistory.setEllipsisString("Patient History: ");
		
		lblPatientInfo = new Label("Patient Information: ");
		lblPatientInfo.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblPatientInfo.setEllipsisString("Patient Information: ");
		
		lblPrevConcern = new Label("Past Concerns: ");
		lblPrevConcern.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblPrevConcern.setEllipsisString("Past Concerns: ");
		
		lblPrevMed = new Label("Medications: ");
		lblPrevMed.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblPrevMed.setEllipsisString("Medications: ");
		
		lblPrevImmunizations = new Label("Immunizations: ");
		lblPrevImmunizations.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblPrevImmunizations.setEllipsisString("Immunizations: ");
		
		lblAllergies = new Label("Allergies: ");
		lblAllergies.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		lblAllergies.setEllipsisString("Allergies: ");
		
		// MISC
		errorLabel = new Label("");
		errorLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #FFC627");
		
		
		//Non-editable TextFields / TextAreas:
		txtWeight = new TextField();
		txtWeight.setEditable(false);
		//txtWeight.setPrefSize(50, 100);
		txtWeight.setPrefColumnCount(2);
		
		txtHeight = new TextField();
		txtHeight.setEditable(false);
		
		txtTemp = new TextField();
		txtTemp.setEditable(false);
		
		txtBloodPressure = new TextField();
		txtBloodPressure.setEditable(false);
		
		txtConcern = new TextArea();
		txtConcern.setEditable(false);
		txtConcern.setPrefRowCount(4);
		
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
		//txtPhysicalExam.setPrefColumnCount(1);
		txtPhysicalExam.setPrefRowCount(4);
		txtPrescribe = new TextArea();
		txtPrescribe.setPrefRowCount(4);
		
		
		//Buttons:
		butSave = new Button("Save");
		butSave.setPrefSize(100,50);
		butSave.setStyle("-fx-background-color: #FFC627; -fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #000000");
		
		logoutButton.setPrefSize(100,50);
		logoutButton.setStyle("-fx-background-color: #FFC627; -fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #000000");
		
		messagePortalButton.setPrefSize(200,50);
		messagePortalButton.setStyle("-fx-background-color: #FFC627; -fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #000000");
		
		
		// minor HBoxes, VBoxes, GridPanes:
		
		gridVitals = new GridPane();
		gridVitals.setVgap(5);
		gridVitals.setHgap(5);
		gridVitals.getColumnConstraints().add(new ColumnConstraints(200)); //column 1 size
		gridVitals.getColumnConstraints().add(new ColumnConstraints(148)); //column 2 size
		gridVitals.addRow(0, lblVitals);
		gridVitals.addRow(1, lblWeight, txtWeight);
		gridVitals.addRow(2, lblHeight, txtHeight);
		gridVitals.addRow(3, lblTemp, txtTemp);
		gridVitals.addRow(4, lblBloodPressure, txtBloodPressure);
		
		vboxConcerns = new VBox(10);
		vboxConcerns.getChildren().addAll(lblConcernVisit, txtConcern);
		
		hboxVitalsConcerns = new HBox(20);
		hboxVitalsConcerns.getChildren().addAll(gridVitals, vboxConcerns);
		
		hboxPrescribeInfo = new HBox(20);
		hboxPrescribeInfo.getChildren().addAll(lblPrescribe, txtPrescribe);
		
		
		vboxMiddleSide = new VBox(20);
		vboxMiddleSide.getChildren().addAll(hboxVitalsConcerns, lblPhysicalExam, txtPhysicalExam, lblPrescribe, txtPrescribe, butSave);
		
		vboxRightSide = new VBox(20);
		vboxRightSide.setMinWidth(400);
		vboxRightSide.getChildren().addAll(lblPatientHistory, lblPatientInfo, txtPatientInfo,
				lblPrevConcern, txtPrevConcern, lblPrevMed, txtPrevMed, lblPrevImmunizations, txtPrevImmunizations,
				lblAllergies, txtAllergies);
		//lblPatientInfo, txtPatientInfo,
		
		Button butP1 = new Button("Select");
		Button butP2 = new Button("Select");
		Button butP3 = new Button("Select");
		Button butP4 = new Button("Select");
		
		// GridPanes:
		// Set up patient list
		gridPatientList = new GridPane();
		gridPatientList.addColumn(0, new Label("File Name"));
		gridPatientList.addColumn(1, new Label("Patient Last Name"));
		gridPatientList.addColumn(2, new Label("Date of Birth"));
		gridPatientList.addColumn(3, new Label(""), butP1, butP2, butP3, butP4);
		
		gridPatientList.setStyle("-fx-background-color: white; -fx-grid-lines-visible: false; -fx-padding: 10px;");
		//gridPatientList.setAlignment(Pos.CENTER);

		gridPatientList.setHgap(10); // Horizontal spacing
		gridPatientList.setVgap(10); // Vertical spacing
		populatePatientList();
		
		vboxLeftSide = new VBox();
		vboxLeftSide.getChildren().addAll(lblPatient, gridPatientList, messagePortalButton, imageView);
		
		// Set up patient info side
		gridAllPatientInfo = new GridPane();
		gridAllPatientInfo.addRow(0, vboxLeftSide, vboxMiddleSide, vboxRightSide);
		gridAllPatientInfo.setVgap(10);
		gridAllPatientInfo.setHgap(40);
		gridAllPatientInfo.setPadding(new Insets(15,30,100,50));
		
		
		hboxTop = new HBox(150);
		hboxTop.getChildren().addAll(logoutButton, lblWelcome);
		hboxTop.setPadding(new Insets(30,30,50,100));
		
		
		mainPane.setTop(hboxTop);
		mainPane.setCenter(gridAllPatientInfo);
		//mainPane.setLeft(leftPane);
		//mainPane.setRight(rightPane);
		mainPane.setBottom(new HBox(errorLabel));
		
		butP1.setOnAction(e -> {
			getInfo(1); // select patient 1 in list
		});
		butP2.setOnAction(e -> {
			getInfo(2); // select patient 2 in list
		});
		butP3.setOnAction(e -> {
			getInfo(3); // select patient 3 in list
		});
		butP4.setOnAction(e -> {
			getInfo(4); // select patient 4 in list
		});
		
		butSave.setOnAction(e -> writeFile()); // writes the patient file based on the information put into the vitals
		//logoutButton.setOnAction(e -> XXXXXXX); // ***** NEED TO GO BACK TO LOGIN SCREEN
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
            
			String directoryPath = "PitchforkUnited/Pitchfork United Main Folder/Patient List/" + currentPatientUserName;
			String fileName = txtPatientInfo.getText() + "_Appointment_Summary.txt";
            System.out.println("Filename: " + fileName);

            // Create a string with all the text
            String writeInfo = java.time.LocalDate.now() + "\n" +
            					txtPhysicalExam.getText() + "\n" +
                                   txtPrescribe.getText() + "\n\n";
            System.out.println("Writing this into the file: \n" + writeInfo);
            /*
            // Write the CT scan results to the file
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(writeInfo);
            bufferedWriter.close();
            
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            out.println(writeInfo);
            out.close();
            */
            
            Path filePath = Paths.get(directoryPath, fileName);
            
            try {
                Files.write(filePath, writeInfo.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE,
						StandardOpenOption.APPEND);
                System.out.println("Data written to file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
			
			errorLabel.setText("Information Updated!");
			txtPhysicalExam.setText("");
			txtPrescribe.setText("");
		}catch(Exception e) {
			System.out.print(e);
			
		}
	}
	
	private void getInfo(int row) {
		
		//reset all textboxes to empty before loading
		txtWeight.setText("");
		txtHeight.setText("");
		txtTemp.setText("");
		txtBloodPressure.setText("");
		txtConcern.setText("");
		txtPrevConcern.setText("");
		txtPrevMed.setText("");
		txtPrevImmunizations.setText("");
		txtAllergies.setText("");
		
		// get username
		Node node = getNodeByRowColumnIndex(gridPatientList, row, 0);
		
		if(node == null) {
			errorLabel.setText("No existing patient!");
			errorLabel.setEllipsisString("No existing patient!");
			return;
		}
		
		String username = ((Label)node).getText();
		
		//get name
		node = getNodeByRowColumnIndex(gridPatientList, row, 1);
		
		if(node == null) {
			errorLabel.setText("Name missing!");
			errorLabel.setEllipsisString("Name missing!");
			return;
		}
		
		String name = ((Label)node).getText();
		
		currentPatientUserName = username;
		
		String filePath = "PitchforkUnited/Pitchfork United Main Folder/Patient List/" + username + "/" + username + "_Health.txt";
		String filePathSum = "PitchforkUnited/Pitchfork United Main Folder/Patient List/" + username + "/" + username + "_Appointment_Summary.txt";
		
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
                    	//medications
                    	txtPrevMed.setText(line);
                        break;
                    case 7:
                    	//immunizations
                    	txtPrevImmunizations.setText(line);
                        break;
                    case 8:
                    	//allergies
                    	txtAllergies.setText(line);
                        break;
                    case 9:
                    	//if needed
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
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePathSum))) {
			String line;
            while ((line = reader.readLine()) != null) {
            	String newLine = txtPrevConcern.getText() + line + "\n";
            	txtPrevConcern.setText(newLine);
            }
		} catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
		
		txtPatientInfo.setText(username);
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
