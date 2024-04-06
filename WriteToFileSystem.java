package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileSystem {
	
	//this method is used for creating a new patient folder in the patient list
	public void createNewPatientFolder(String patientUserName) { 
		
		String folderName = patientUserName;
		String pathToFolder = "Pitchfork United Main Folder/Patient List";//path to the folder we want to access might need to change depending on path
		
		File parentFolder = new File(pathToFolder);
		
		if (!parentFolder.exists() || !parentFolder.isDirectory()) { //checks if the parent folder exists it always should if not check the path to folder
            System.out.println("Parent folder does not exist or is not a directory.");
            return; // Exit the method if parent folder doesn't exist or is not a directory
        }
		
		File subFolder = new File(parentFolder, folderName);
		
		if(!subFolder.exists()) { //checks if folder exists 
			if(subFolder.mkdir()) { //creates new folder if folder does not exist
				System.out.print(patientUserName + " Folder Created");
			}else {//folder failed might need to check path
				System.out.print("Failed to create folder");
			}
		}else {//folder already exists; patient already exists
			System.out.print("Patient file already exists.");
		}
		
		
	}//end createNewPatientFolder
	
	//this method is used to add a patient to a doctor and nurse patient list 
	public void addPatientToDoctorNurseList(String patientUserName, String doctorUserName, String nurseUserName) {
		
		//these strings hold the file names and the paths to get to the respective file/folder
		String doctorFileName = doctorUserName + "_Patient_List.txt";
		String nurseFileName = nurseUserName + "_Patient_List.txt";
		String pathToDoctorFolder = "Pitchfork United Main Folder/Doctor List/" + doctorUserName;
		String pathToNurseFolder = "Pitchfork United Main Folder/Nurse List/" + nurseUserName;
		
		//these are the folders for the specific doctor/nurse
		File doctorParentFolder = new File(pathToDoctorFolder);
		File nurseParentFolder = new File(pathToNurseFolder);
		
		if (!doctorParentFolder.exists() || !doctorParentFolder.isDirectory()) { //checks if doctor folder exists
            System.out.println("Doctor parent folder does not exist or is not a directory. Must create doctor folder!");
            return; // Exit the method if parent folder doesn't exist or is not a directory
        }
		if (!nurseParentFolder.exists() || !nurseParentFolder.isDirectory()) { //checks if the nurse folder exists
            System.out.println("Nurse parent folder does not exist or is not a directory. Must create nurse folder!");
            return; // Exit the method if parent folder doesn't exist or is not a directory
        }
		
		File newDoctorFile = new File(doctorParentFolder, doctorFileName);
		if(!newDoctorFile.exists()) { //if patient list doesnt exist for the doctor this try block will create new text file
			try {
				newDoctorFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File newNurseFile = new File(nurseParentFolder, nurseFileName);
		if(!newNurseFile.exists()) { //if patient list doesnt exist for the nurse this try block will create new text file
			try {
				newNurseFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String doctorFilePath = pathToDoctorFolder + File.separator + doctorFileName;
		
		try { //this try block adds the patient name to the doctor patient list file at the end of the list and adds new line for next entry
			FileWriter fileWriter = new FileWriter(doctorFilePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(patientUserName);
            bufferedWriter.newLine();
            bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String nurseFilePath = pathToNurseFolder + File.separator + nurseFileName;
		
		try { //this try block adds the patient name to the nurse patient list file at the end of the list and adds new line for next entry
			FileWriter fileWriter = new FileWriter(nurseFilePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(patientUserName);
            bufferedWriter.newLine();
            bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	//this method is used to update the contact info for a patient
	public boolean updateContactInfo(String patientUserName, String firstName, String lastName, String email, int dateOfBirth, int phoneNumber) {
		
		String fileName = patientUserName + "_Information.txt";
		String pathToPatientFolder = "Pitchfork United Main Folder/Patient List/" + patientUserName;
		String fileContent = firstName + "\n" + lastName + "\n" + dateOfBirth + "\n" + email + "\n" + phoneNumber + "\n";
		
		String filePath = pathToPatientFolder + File.separator + fileName;
		
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(fileContent);
			return true;
		}catch (IOException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void saveUsernameAndPassword(String userName, String username, String password, String userStatus) {
		
		String fileName = userName + "_Username_Password.txt";
		String pathToFolder = "Pitchfork United Main Folder/" + userStatus + " List/" + userName;
		String fileContent = username + "\n" + password + "\n";
		
		String filePath = pathToFolder + File.separator + fileName;
		
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(fileContent);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
