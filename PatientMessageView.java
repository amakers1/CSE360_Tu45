package application;

import java.io.File;

import javafx.stage.Stage;

public class PatientMessageView extends MessageViewBuilder{
	
	public PatientMessageView(String userStatus , Stage primaryStage,String userName) {
		super(userStatus, primaryStage, userName);
	}
	
	@Override
	public void buildMessagePage() {
		File doctorDirectory = new File("Pitchfork United Main Folder/Doctor List");
        if (doctorDirectory.exists() && doctorDirectory.isDirectory()) {
            File[] files = doctorDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        messageDropDown.getItems().add(file.getName());
                    }
                }
            }
        }
        
        File nurseDirectory = new File("Pitchfork United Main Folder/Nurse List");
        if (nurseDirectory.exists() && doctorDirectory.isDirectory()) {
            File[] files = nurseDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        messageDropDown.getItems().add(file.getName());
                    }
                }
            }
        }
	}

}
