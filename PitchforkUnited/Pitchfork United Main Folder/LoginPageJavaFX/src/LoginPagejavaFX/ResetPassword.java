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
import java.io.PrintWriter;

public class ResetPassword extends Application {

    @Override
    public void start(Stage themainstage) {
        BorderPane borderPane = new BorderPane();               //set a BorderPane with the Maroon background color
        borderPane.setStyle("-fx-background-color: #790000;");
        
        Text setTitle = new Text("Reset your password");         //set the title of the UI design
        setTitle.setFont(Font.font("Arial", 28));
        setTitle.setFill(Color.GOLD);
        borderPane.setTop(setTitle);
        BorderPane.setAlignment(setTitle, Pos.TOP_CENTER);
        BorderPane.setMargin(setTitle, new Insets(40, 0, 0, 0));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(50);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(10, 50, 20, 230));

        Label NewPasswordLabel = new Label("New password:");    //set new password labels and the text field
        NewPasswordLabel.setTextFill(Color.GOLD);
        PasswordField newpasswordField = new PasswordField();
        Label confirmnewpassword = new Label("Confirm new password:");
        confirmnewpassword.setTextFill(Color.GOLD);
        PasswordField confirmpwField = new PasswordField();
        
        Button resetButton = new Button("Reset");           //set the reset button
        resetButton.setStyle("-fx-background-color: #FFD800; -fx-text-fill: #790000;");
        resetButton.setOnAction(e -> {                      //then save to the text file
        	savePasswordToFile(
        			newpasswordField.getText(), 
        			confirmpwField.getText(),
        	        newpasswordField, 
        	        confirmpwField, 
        	        newpasswordField,
        	        confirmpwField
        	    );
        	});

        Button continueButton = new Button("Continue");       //set the continue button
        continueButton.setStyle("-fx-background-color: #FFD800; -fx-text-fill: #790000;");     //maroon in font and gold in background
        continueButton.setOnAction(e -> {
            LoginPage loginPage = new LoginPage();
            loginPage.start(themainstage);
        });

        HBox buttonBox = new HBox(30);
        buttonBox.getChildren().addAll(resetButton, continueButton);
        buttonBox.setAlignment(Pos.CENTER);
        HBox setbutton = new HBox(150);
        setbutton.setAlignment(Pos.CENTER);
        setbutton.getChildren().addAll(NewPasswordLabel, confirmnewpassword);
        gridPane.add(NewPasswordLabel, 0, 0);
        gridPane.add(newpasswordField, 1, 0);
        gridPane.add(confirmnewpassword, 0, 1);
        gridPane.add(confirmpwField, 1, 1);
        gridPane.add(buttonBox, 0, 2, 2, 2);
        borderPane.setCenter(gridPane);
        
        StackPane insertlogo = new StackPane();             //set the logo to the src resources and link the logo          
        insertlogo.setPadding(new Insets(0, 25, 0, 25));
        Image logoinsertion = new Image("file:///C:/Users/16027/.p2/pool/plugins/ASUHelloWorldJavaFX/src/resources/logo.png");
        ImageView logoView = new ImageView(logoinsertion);
        logoView.setFitHeight(100);
        insertlogo.getChildren().add(logoView);
        borderPane.setRight(insertlogo);
        logoView.setPreserveRatio(true);

        Scene scene = new Scene(borderPane, 800, 450);
        themainstage.setScene(scene);
        themainstage.show();
    }

    private void savePasswordToFile(String newPassword, String confirmPassword, TextField newPasswordField, TextField confirmPasswordField, TextField Usernamefield, TextField passwordfield) {
        try (PrintWriter load = new PrintWriter("NewPassword.txt")) {        //store to the text file
        	load.println("New Password: " + newPassword);
        	load.println("Confirm Password: " + confirmPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }                                    //clear the field
        if (newPasswordField != null) {
            newPasswordField.clear();
        }
        if (confirmPasswordField != null) {
            confirmPasswordField.clear();
        }
        if (Usernamefield != null) {
            Usernamefield.clear();
        }
        if (passwordfield != null) {
            passwordfield.clear();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
