package application;

public class ContactInformationValidation {
	
	//method is to validate the contact info for the patient when they want to update it
	public boolean validateContactInfo(String patientName, String firstName, String lastName, String email, int dateOfBirth,
			int phoneNumber) {
		if(firstName.length() > 30 && lastName.length() > 30 && email.length() > 50 && String.valueOf(dateOfBirth).length() > 8 && 
			String.valueOf(phoneNumber).length() > 10) {
				return false;
		}
		UpdateContactInformation updateContactInfo = new UpdateContactInformation();
		
		return updateContactInfo.updateContactInformation(patientName, firstName, lastName, email, dateOfBirth, phoneNumber); //returns the boolean to determine whether data saved or not
	}


}
