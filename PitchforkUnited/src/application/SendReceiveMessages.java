package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SendReceiveMessages {
	
	
	
	public void sendMessage(String message, String senderUserStatus, String receiverUserStatus, String senderUserName, String receiverUserName) {
		String senderFileName;
		String receiverFileName;
		String pathToSender;
		String pathToReceiver;
		
		if(senderUserStatus == "Patient") {
			pathToSender = "Pitchfork United Main Folder/Patient List/" + senderUserName + "/Conversations";
		}else if(senderUserStatus == "Doctor") {
			pathToSender = "Pitchfork United Main Folder/Doctor List/" + senderUserName + "/Conversations";
		}else {
			pathToSender = "Pitchfork United Main Folder/Nurse List/" + senderUserName + "/Conversations";
		}
		
		if(receiverUserStatus == "Patient") {
			pathToReceiver = "Pitchfork United Main Folder/Patient List/" + receiverUserName + "/Conversations";
		}else if(receiverUserStatus == "Doctor") {
			pathToReceiver = "Pitchfork United Main Folder/Doctor List/" + receiverUserName + "/Conversations";
		}else {
			pathToReceiver = "Pitchfork United Main Folder/Nurse List/" + receiverUserName + "/Conversations";
		}
		
		senderFileName = senderUserName + "_Conversation_With_" + receiverUserName + ".txt";
		receiverFileName = receiverUserName + "_Conversation_With_" + senderUserName + ".txt";
		
		String fileContent = senderUserName + "/ " + message + "\n";
		
		String senderPath = pathToSender + File.separator + senderFileName;
		String receiverPath = pathToReceiver + File.separator + receiverFileName;
		
		try { //this try block adds the patient name to the doctor patient list file at the end of the list and adds new line for next entry
			FileWriter fileWriter = new FileWriter(senderPath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContent);
            bufferedWriter.newLine();
            bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try { //this try block adds the patient name to the nurse patient list file at the end of the list and adds new line for next entry
			FileWriter fileWriter = new FileWriter(receiverPath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContent);
            bufferedWriter.newLine();
            bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getMessage(String senderUserStatus, String receiverUserStatus, String senderUserName, String receiverUserName) {
		
		String message = "";
		String senderFileName;
		String pathToSender;

		
		if(senderUserStatus == "Patient") {
			pathToSender = "Pitchfork United Main Folder/Patient List/" + senderUserName + "/Conversations";
		}else if(senderUserStatus == "Doctor") {
			pathToSender = "Pitchfork United Main Folder/Doctor List/" + senderUserName + "/Conversations";
		}else {
			pathToSender = "Pitchfork United Main Folder/Nurse List/" + senderUserName + "/Conversations";
		}
		
		senderFileName = senderUserName + "_Conversation_With_" + receiverUserName + ".txt";
		
		String senderFilePath = pathToSender + File.separator + senderFileName;
		

		try(BufferedReader reader = new BufferedReader(new FileReader(senderFilePath))) {
			String line;
			while((line = reader.readLine()) != null) {
				message += line + "\n";
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
		return message;
	}
	
}
