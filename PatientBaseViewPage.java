package application;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class PatientBaseViewPage extends BasePageViewBuilder{
	
	//Variables:
	//***********************
	
	//VBoxs:
	protected VBox rightPane, centerPane, appointmentSummaryPane;
	
	//HBoxs:
	protected HBox topPane, leftPane;
	
	//Labels:
	protected Label firstNameLabel, lastNameLabel, dateOfBirthLabel, emailLabel, phoneNumberLabel, errorLabel;
	
	//TextFields:
	protected TextField firstNameTextField, lastNameTextField, dateOfBirthTextField, emailTextField, phoneNumberTextField;
	
	//Buttons:
	protected Button updateButton, contactInfoButton, appointmentSummaryButton;
	
	//StackPanes:
	protected StackPane contactInfoPane;
	
	//Scenes:
	protected Scene contactInfoScene, appointmentSummaryScene;
	
	//TextArea:
	protected TextArea node1, node2, node3;
	
	//GridPane:
	protected GridPane contactGrid, topPaneGrid;
	
	//Image:
	protected Image image;
	protected ImageView imageView;
	
	//Strings:
	protected String firstName, lastName, email;
	
	//Ints:
	protected int dateOfBirth, phoneNumber;
	
	public PatientBaseViewPage(String userStatus) {
		super(userStatus);
		
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
		firstNameLabel = new Label("First Name");
		firstNameLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		firstNameLabel.setEllipsisString("First Name");
		lastNameLabel = new Label("Last Name");
		lastNameLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		dateOfBirthLabel = new Label("Date of Birth");
		dateOfBirthLabel.setEllipsisString("Date of Birth");
		dateOfBirthLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		emailLabel = new Label("Email");
		emailLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		phoneNumberLabel = new Label("Phone Number");
		phoneNumberLabel.setEllipsisString("Phone Number");
		phoneNumberLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		welcomeLabel = new Label("Welcome, PatientName");
		welcomeLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 25; -fx-text-fill: #FFC627");
		errorLabel = new Label("");
		errorLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #FFC627");

		//TextFields:
		firstNameTextField = new TextField();
		firstNameTextField.setMinWidth(200);
		lastNameTextField = new TextField();
		dateOfBirthTextField = new TextField();
		emailTextField = new TextField();
		phoneNumberTextField = new TextField();
		
		//Buttons:
		updateButton = new Button("Update");
		updateButton.setEllipsisString("Update");
		contactInfoButton =  new Button("Contact Information");
		appointmentSummaryButton = new Button("Appointment Summary");
		
		//TextAreas:
		node1 = new TextArea();
		node1.setMinWidth(607);
		node1.setMinHeight(151);
		node2 = new TextArea();
		node2.setMinWidth(603);
		node2.setMinHeight(150);
		node3 = new TextArea();
		node3.setMinWidth(603);
		node3.setMinHeight(150);
		
		//StackPanes:
		contactInfoPane = new StackPane();
		
		//GridPanes:
		contactGrid = new GridPane();
		contactGrid.setVgap(75);
		contactGrid.setHgap(250);
		contactGrid.addColumn(0, firstNameLabel, lastNameLabel, dateOfBirthLabel, emailLabel, phoneNumberLabel, errorLabel);
		contactGrid.addColumn(1, firstNameTextField, lastNameTextField, dateOfBirthTextField, emailTextField, phoneNumberTextField, updateButton);
		topPaneGrid = new GridPane();
		topPaneGrid.setVgap(50);
		topPaneGrid.setHgap(250);
		topPaneGrid.addRow(0, welcomeLabel,messagePortalButton, logoutButton);
		topPaneGrid.addRow(1, contactInfoButton,new Label("") , appointmentSummaryButton);
		
		//HBoxs:
		topPane = new HBox(150);
		topPane.getChildren().addAll(topPaneGrid);
		
		//VBoxs:
		appointmentSummaryPane = new VBox(50);
		appointmentSummaryPane.getChildren().addAll(node1, node2, node3);
		centerPane = new VBox(50);
		
		leftPane = new HBox();
		leftPane.getChildren().add(new Label(""));
		rightPane = new VBox();
		rightPane.getChildren().add(imageView);
		centerPane.getChildren().addAll(contactGrid);
		
		topPane.setPadding(new Insets(30,100,57,100));
		contactInfoPane.setPadding(new Insets(30,30,120,30));
		leftPane.setPadding(new Insets(100,100,100,10));
		rightPane.setPadding(new Insets(100,57,100,100));
		contactInfoPane.getChildren().add(centerPane);
		mainPane.setTop(topPane);
		mainPane.setCenter(contactInfoPane);
		mainPane.setLeft(leftPane);
		mainPane.setRight(rightPane);
		
		updateButton.setOnAction(e -> getData());
		appointmentSummaryButton.setOnAction(e -> contactInfoPane.getChildren().setAll(appointmentSummaryPane));
		contactInfoButton.setOnAction(e -> contactInfoPane.getChildren().setAll(contactGrid));
		
	}
	
	private void getData() {
		try {
			if(firstNameTextField.getText().isBlank() || lastNameTextField.getText().isBlank() || emailTextField.getText().isBlank() || 
					dateOfBirthTextField.getText().isBlank() || phoneNumberTextField.getText().isBlank()) {
				errorLabel.setText("At least one field is empty!");
				errorLabel.setEllipsisString("At least one field is empty!");
				throw new Exception();
			}
			ContactInformationValidation contactInfoValidation = new ContactInformationValidation();
			
			
			firstName = firstNameTextField.getText();
			lastName = lastNameTextField.getText();
			email = emailTextField.getText();
			dateOfBirth = Integer.parseInt(dateOfBirthTextField.getText());
			phoneNumber = Integer.parseInt(phoneNumberTextField.getText());
			
			if(contactInfoValidation.validateContactInfo(firstName, lastName, email, dateOfBirth, phoneNumber) == false) {
				errorLabel.setText("A field has too many characters!");
				errorLabel.setEllipsisString("A field has too many characters!");
				throw new Exception();
			}
			
			System.out.print(firstName + lastName + email + dateOfBirth + phoneNumber);
			
			errorLabel.setText("Information Updated!");
		}catch(NumberFormatException e) {
			System.out.print(e);
			errorLabel.setText("Date of Birth and Phone Number need to be numbers!");
			errorLabel.setEllipsisString("Date of Birth and Phone Number need to be numbers!");
			errorLabel.setStyle("-fx-font-family: Times New Roman; -fx-font-size: 15; -fx-text-fill: #FFC627");
			
			
		}catch(Exception e) {
			System.out.print(e);
			
		}
	}
}
