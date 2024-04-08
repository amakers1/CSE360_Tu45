package application;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientMessageView extends MessageViewBuilder{
	
	protected String messages;
	
	public PatientMessageView(String userStatus , Stage primaryStage,String userName) {
		super(userStatus, primaryStage, userName);
		//Set stage
		primaryStage.setScene(new Scene(mainPane,2000,2000));
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
		openButton.setOnAction(e -> displayMessage());
	}
	
	@Override
	public void buildMessagePage() {
		File doctorDirectory = new File("Pitchfork United Main Folder/Doctor List");
        if (doctorDirectory.exists() && doctorDirectory.isDirectory()) {
            File[] files = doctorDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        messageDropDown.getItems().add("Doctor " + file.getName());
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
                        messageDropDown.getItems().add("Nurse " + file.getName());
                    }
                }
            }
        }
        

	}
	
	public void displayMessage() {
		
		SendReceiveMessages receiveMessage = new SendReceiveMessages();
		
			
			String selectedItem = messageDropDown.getValue();
			String jobTitle = "";
			String receiverName = "";
            if (selectedItem != null) {
                int index = selectedItem.indexOf(' ');
                if (index != -1) { // If whitespace found
                    jobTitle = selectedItem.substring(0, index);
                    receiverName = selectedItem.substring(index + 1);
                } else { // If no whitespace found
                    jobTitle = selectedItem;
                }
            }
            
            if(jobTitle.equals("Doctor")) {
            	messages = receiveMessage.getMessage(userStatus, jobTitle, userName, receiverName);//sending message to doctor
            	parseMessages(messages, receiverName);
            	System.out.print("past Parser ");
            }else {
            	messages = receiveMessage.getMessage(userStatus, jobTitle, userName, receiverName);//sending message to nurse
            	parseMessages(messages, receiverName);
            }
			
		
	}
	
	public void parseMessages(String message, String receiverName) {
		
		System.out.print(message);
		String[] individualMessageArray = message.split("\\n");
		System.out.print(individualMessageArray.length + "\n");
		
		int rowIndex = 3;
		
		for (int i = 0; i < individualMessageArray.length; i++) {
			
			String line = individualMessageArray[i];
			System.out.print(i + "\n");
			String[] parts = line.split("/");
			
			String sender;
			String messages;
			//!!!!!!!!!!!!!!!!!!!!!!!FIX ME!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		    if (parts.length >= 2) {
		        sender = parts[0].trim();
		        messages = parts[1].trim();
		    }else {
		    	sender = parts[0].trim();
		        messages = parts[1].trim();
		    }
			System.out.print("this is the issue" + i + "\n");

			TextArea singleMessage = new TextArea(sender + " " + messages);
			singleMessage.setMaxSize(400, 50);
			
            int columnIndex = (sender.equals(receiverName)) ? 0 : 1;
            messageContainer.add(singleMessage, columnIndex, rowIndex);
            
            rowIndex++;
            
			System.out.print(i + "\n");

		}
		
	}

}
