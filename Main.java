package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public void start(Stage primaryStage) {
		String userStatus = "Patient";
			BorderPane root = new BorderPane();
			BasePageViewBuilder basePageViewBuilder = new BasePageViewBuilder(userStatus, primaryStage, "ExamplePatient");
			root.getChildren().add(basePageViewBuilder);
			Scene scene = new Scene(root,2000,2000);
			WriteToFileSystem saveUP = new WriteToFileSystem();
			saveUP.saveUsernameAndPassword("NurseExample", "Username", "Password", "Nurse");
			primaryStage.setTitle("Pitchforks United");
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
