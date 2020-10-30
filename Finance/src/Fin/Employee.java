package Fin;

public abstract class Employee implements Payable {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String firstName, String lastName, String
			socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		
	}
	
	// get first name
	public String getFirstName() {
		return firstName;
	}

	// get last name 
	public String getLastName() {
		return lastName;
	}
	
	// get social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	@Override 
	public String toString() {
		return String.format("%s %s%nsocial security number: %s", getFirstName(),getLastName(),
				getSocialSecurityNumber());
	}
	
	
}
