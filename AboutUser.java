import java.io.Serializable;

public class AboutUser implements Serializable{
	private String workExperience = "";
	private String education = "";
	private String relationship = "";
	private String city = "";
	
	/** no-args constructor*/
	public AboutUser() {
	}
	
	/** args constructor that take values of workExperience, education, relationship and city as parameter 
	 *  and set this values in data fields */
	public AboutUser(String workExperience, String education, String relationship, String city) {
		this.workExperience = workExperience;
		this.education = education;
		this.relationship = relationship;
		this.city = city;
	}
	
	/** Setters for data fields */
	public void editWorkExperience(String work) {
		workExperience = work;
	}
	
	public void editEducation(String newEducation) {
		education = newEducation; 
	}
	
	public void editRelationship(String newRelationship) {
		relationship = newRelationship;
	}
	
	public void editCity(String newCity) {
		city = newCity;
	}
	
	/** Getters for data fields */
	public String getWorkExperience() {
		return workExperience;
	}
	
	public String getEducation() {
		return education;
	}
	
	public String getRelationShip() {
		return relationship;
	}
	
	public String getCity() {
		return city;
	}
	
	/** overriding toString method to return string contains about of user*/
	public String aboutToString() {
		return "Work Experience is " + workExperience + "\nEducation is " + education + "\nRelationship " + relationship +
				"\nCity Lived in " + city;
	}
}