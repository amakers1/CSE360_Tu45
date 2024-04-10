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

public class LoginPage extends Application {

    @Override
    public void start (Stage themainstage) {
    	BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #790000;");         //set the borderPane to the color Maroon
        Text setTitle = new Text("Pitchforks United Healthcare");
        setTitle.setFont(Font.font("Arial", 28));
        setTitle.setFill(Color.GOLD);                         //fill the title PitchForks United HealthCare to the gold
        Button forgotpasswordbutton = new Button("forgot password?");
        forgotpasswordbutton.setStyle("-fx-background-color: #FFD800; -fx-text-fill: #790000;");
        forgotpasswordbutton.setOnAction(event -> {
            ResetPassword resetPage = new ResetPassword();
            resetPage.start(themainstage);
        });
        BorderPane.setAlignment(forgotpasswordbutton, Pos.TOP_RIGHT);
        BorderPane.setMargin(forgotpasswordbutton, new Insets(10, 10, 0, 0));

        BorderPane topborderpane = new BorderPane();
        topborderpane.setCenter(setTitle);
        topborderpane.setRight(forgotpasswordbutton);
        borderPane.setTop(topborderpane);
        BorderPane.setMargin(setTitle, new Insets(70, 0, 0, 50));

        Label Usernamelabel = new Label("Username:");    //create the label UserName with the TextField and the password with the TextField
        Usernamelabel.setTextFill(Color.GOLD);
        TextField Usernamefield = new TextField();
        Usernamefield.setMaxWidth(200);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.GOLD);
        PasswordField passwordfield = new PasswordField();
        passwordfield.setMaxWidth(200);
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(50);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(10, 90, 20, 230));
        
        Button Loginbutton = new Button("Login");     //create two buttons login and sign up with the Maroon in background and gold in TextField
        Loginbutton.setStyle("-fx-background-color: #FFD800; -fx-text-fill: #790000;");
        Loginbutton.setOnAction(event -> {
        	try {
        		String username = Usernamefield.getText();
        		String password = passwordfield.getText();
        		File file = new File("UserLogins.txt");         //save the patient files and then clear the field
        		PrintWriter load = new PrintWriter(file);
        		load.println("Username: " + username);
        		load.println("Password: " + password);
        		load.close();
        		Usernamefield.clear();
        		passwordfield.clear();
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        });
        
        Button Signupbutton = new Button("Sign up");      //clicked on the signup button and jump to the createaccount page
        Signupbutton.setStyle("-fx-background-color: #FFD800; -fx-text-fill: #790000;");
        Signupbutton.setOnAction(event -> {
            CreateAccountPage accountPage = new CreateAccountPage();
            accountPage.start(themainstage);                     
        });
        
        HBox setbutton = new HBox(150);
        setbutton.getChildren().addAll(Loginbutton, Signupbutton);
        gridPane.add(Usernamelabel, 0, 0);
        gridPane.add(Usernamefield, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordfield, 1, 1);
        gridPane.add(setbutton, 0, 2, 2, 1);
        borderPane.setCenter(gridPane);
        
        StackPane insertlogo = new StackPane();                //set the logo to the src resources and link the logo          
        insertlogo.setPadding(new Insets(0, 25, 0, 25));
        Image logoinsertion = new Image("file:///C:/Users/16027/.p2/pool/plugins/ASUHelloWorldJavaFX/src/resources/logo.png");
        ImageView logoView = new ImageView(logoinsertion);
        logoView.setFitHeight(100);
        insertlogo.getChildren().add(logoView);
        BorderPane.setAlignment(insertlogo, Pos.CENTER);
        borderPane.setRight(insertlogo);
        logoView.setPreserveRatio(true);
        Scene scene = new Scene(borderPane, 800, 450);       //set the borderPane scene layout
        themainstage.setScene(scene);
        themainstage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

