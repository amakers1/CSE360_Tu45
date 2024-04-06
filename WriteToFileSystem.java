package application;

import java.io.File;

public class WriteToFileSystem {
	
	public void createNewPatientFolder(String patientName) { //this method is used for creating a new patient folder in the patient list
		
		String folderName = patientName;
		String pathToFolder = "Pitchfork United Main Folder/Patient List";
		
		File parentFolder = new File(pathToFolder);
		
		if (!parentFolder.exists() || !parentFolder.isDirectory()) {
            System.out.println("Parent folder does not exist or is not a directory.");
            return; // Exit the method if parent folder doesn't exist or is not a directory
        }
		
		File subFolder = new File(parentFolder, folderName);
		
		if(!subFolder.exists()) {
			if(subFolder.mkdir()) {
				System.out.print(patientName + " Folder Created");
			}else {
				System.out.print("Failed to create folder");
			}
		}else {
			System.out.print("Patient file already exists.");
		}
		
		
	}
	
	

}
