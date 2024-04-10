package LoginPagejavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.File;
import java.io.PrintWriter;

public class CreateAccountPage extends Application {

    @Override
    public void start (Stage themainstage) {
    	BorderPane borderPane = new BorderPane();             //create a BorderPane and set the background color in Maroon and set the title
        borderPane.setStyle("-fx-background-color: #790000;");
        Text setTitle = new Text("Create Account");
        setTitle.setFont(Font.font("Arial", 28));             //set the font
        setTitle.setFill(Color.GOLD);                         //set the color            
        Button Logout = new Button("Logout");                 //set the logout button
        Logout.setStyle("-fx-background-color: #FFD800; -fx-text-fill: #790000;");
        BorderPane.setAlignment(Logout, Pos.TOP_RIGHT);
        BorderPane.setMargin(Logout, new Insets(10, 10, 0, 0));
        
        Logout.setOnAction(event -> {                         //clicked on the Login button and jump to the main stage
            LoginPage loginPage = new LoginPage();
            loginPage.start(themainstage);
        });

        BorderPane topborderpane = new BorderPane();
        topborderpane.setCenter(setTitle);
        topborderpane.setRight(Logout);
        borderPane.setTop(topborderpane);
        BorderPane.setMargin(setTitle, new Insets(70, 0, 0, 50));
        
        GridPane form = createForm();                          //set the form
        borderPane.setCenter(form);
        StackPane logoPane = theLogoPane();
        borderPane.setRight(logoPane);
        Scene scene = new Scene(borderPane, 800, 450);        //set the scene
        themainstage.setScene(scene);
        themainstage.show();
    }
    
    private GridPane createForm() {                           //create the label text field and initialize the button
        Label FirstNameLabel = new Label("First name:");
        Label lastNameLabel = new Label("Last name:");
        Label DateOfbirthLabel = new Label("Date of birth:");
        Label EmailLabel = new Label("Email:");
        Label PasswordLabel = new Label("Password:");
        Label ConfirmpasswordLabel = new Label("Confirm password:");
        TextField FirstNameField = new TextField();
        TextField LastNameField = new TextField();
        TextField DateOfbirthField = new TextField();
        TextField EmailField = new TextField();
        PasswordField PasswordField = new PasswordField();
        PasswordField ConfirmpasswordField = new PasswordField();
        Button ContinueButton = new Button("Continue");
        
        Color labelColor = Color.GOLD;
        FirstNameLabel.setTextFill(labelColor);
        lastNameLabel.setTextFill(labelColor);
        DateOfbirthLabel.setTextFill(labelColor);
        EmailLabel.setTextFill(labelColor);
        PasswordLabel.setTextFill(labelColor);
        ConfirmpasswordLabel.setTextFill(labelColor);
        ContinueButton.setStyle("-fx-background-color: #FFD800; -fx-text-fill: #790000;");

        GridPane gridPane = new GridPane();                  //create gridPane for form
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(30, 0, 0, 30));

        TextField(gridPane, FirstNameLabel, FirstNameField, 0, 0);
        TextField(gridPane, lastNameLabel, LastNameField, 1, 0);
        TextField(gridPane, DateOfbirthLabel, DateOfbirthField, 0, 1);
        TextField(gridPane, EmailLabel, EmailField, 1, 1);
        TextField(gridPane, PasswordLabel, PasswordField, 0, 2);
        TextField(gridPane, ConfirmpasswordLabel, ConfirmpasswordField, 1, 2);
        gridPane.add(ContinueButton, 2, 3, 2, 2);
        
        ContinueButton.setOnAction(event -> {
        	try {
        		String firstName = FirstNameField.getText();
        		String lastName = LastNameField.getText();
                String dateOfBirth = DateOfbirthField.getText();
                String email = EmailField.getText();
                String password = PasswordField.getText();
                
                File file = new File("AccountDetails.txt");     //store the patient personal information to the text file
                PrintWriter load = new PrintWriter(file);
                load.println("First Name: " + firstName);
                load.println("Last Name: " + lastName);
                load.println("Date of Birth: " + dateOfBirth);
                load.println("Email: " + email);
                load.println("Password: " + password);
                load.close();
                FirstNameField.clear();                       //clear the text field after stored
                LastNameField.clear();
                DateOfbirthField.clear();
                EmailField.clear();
                PasswordField.clear();
                ConfirmpasswordField.clear();
        	}catch (Exception e) {
        		e.printStackTrace();
        	}
        });
        
        return gridPane;
    }
    
    private StackPane theLogoPane() {                   //set the logo to the src resources and link the logo 
        StackPane logoPane = new StackPane();
        logoPane.setPadding(new Insets(0, 25, 0, 25));
        Image logoImage = new Image("file:///C:/Users/16027/.p2/pool/plugins/ASUHelloWorldJavaFX/src/resources/logo.png");
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitHeight(100);
        logoView.setPreserveRatio(true);
        logoPane.getChildren().add(logoView);

        return logoPane;
    }
    
    private void TextField(GridPane gridPane, Label label, Control field, int columnIndex, int rowIndex) {    //perform labels and functions to the gridPane
        field.setMaxWidth(200);
        label.setTextFill(Color.GOLD);
        gridPane.add(label, columnIndex * 2, rowIndex);
        gridPane.add(field, columnIndex * 2 + 1, rowIndex);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
