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
		//Set stage to the correct screen so page is displayed
		primaryStage.setScene(new Scene(mainPane,2000,2000));
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
		refreshButton.setOnAction(e -> displayMessage()); //when refresh is clicked displayMessage is called and process to get messages and conversation is started
	}
	
	@Override
	public void buildMessagePage() {
		//sets the doctor title before the doctor name so the patient knows who they are talking to and used later for parsing
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
        //sets the nurse title before the nurse name so the patient knows who they are talking to and used later for parsing
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
		//MessageContainer
		messageContainer.getChildren().clear(); //this is to clear when a new person to message is clicked and refresh button is clicked
		messageContainer.add(sendButton,0,0); //have to re add these guys
		messageContainer.add(typeMessage, 0, 1); //this one too
			
			String selectedItem = messageDropDown.getValue();
			String jobTitle = "";
			String receiverName = "";
			//this if branch is to determine the job title and name of the person they are messaging it is necessary for the parse of the messages
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
		
		String[] individualMessageArray = message.split("\\n");//splits the entire message into individual parts in oder to build each text area node
		
		int rowIndex = 3;
		
		for (int i = 0; i < individualMessageArray.length; i++) {
			
			String line = individualMessageArray[i];
			String[] parts = line.split("/:"); //splits the name of sender and the message from sender
			
			String sender;
			String messages;
			//I dont know how this section works please do not change unless you understand
		    if (parts.length >= 2) {
		        sender = parts[0].trim();
		        messages = parts[1].trim();
		    }else {
		    	sender = parts[0];
		        messages = parts[1];
		    }

			TextArea singleMessage = new TextArea(sender + ": " + messages); //new text area node is built 
			singleMessage.setMaxSize(400, 50);
			
            int columnIndex = (sender.equals(receiverName)) ? 0 : 1; //this part determines which side the message is on depending on the user 
            //user is on the right and person the are conversing with is on the left
            messageContainer.add(singleMessage, columnIndex, rowIndex);
            
            rowIndex++;

		}
		
	}

}
