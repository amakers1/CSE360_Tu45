package application;

public class UpdateContactInformation {
	
	//method is to get the data saved in the file system 
	public boolean updateContactInformation(String patientUserName, String firstName, String lastName, String email, int dateOfBirth, int phoneNumber) {
		
		WriteToFileSystem updateInfo = new WriteToFileSystem();
		if(updateInfo.updateContactInfo(patientUserName, firstName, lastName, email, dateOfBirth, phoneNumber) == true) { //calls method and saves data unless false in which it is not saved
			return true;
		}
		return false;
	}

}
