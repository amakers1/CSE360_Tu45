package application;

public class ContactInformationValidation {
	
	public boolean validateContactInfo(String firstName, String lastName, String email, int dateOfBirth,
			int phoneNumber) {
		if(firstName.length() > 30 && lastName.length() > 30 && email.length() > 50 && String.valueOf(dateOfBirth).length() > 8 && 
			String.valueOf(phoneNumber).length() > 10) {
				return false;
		}
		UpdateContactInformation updateContactInfo = new UpdateContactInformation();
		updateContactInfo.updateContactInformation();
		return true;
	}


}
