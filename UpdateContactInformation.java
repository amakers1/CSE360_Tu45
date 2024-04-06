package application;

public class UpdateContactInformation {
	
	public boolean updateContactInformation(String patientUserName, String firstName, String lastName, String email, int dateOfBirth, int phoneNumber) {
		
		WriteToFileSystem updateInfo = new WriteToFileSystem();
		if(updateInfo.updateContactInfo(patientUserName, firstName, lastName, email, dateOfBirth, phoneNumber) == true) {
			return true;
		}
		return false;
	}

}
