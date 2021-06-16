
public interface Validation {
	
	String emailValidation();
	String nameValidation();
	String phoneNumberValidation();
	String genderValidation();
	boolean isEmailAndPhoneNumberFoundInDataBase(String email, String phoneNumber);
	
}