package phoneBookApp;

import java.util.Comparator;

public class Person implements Comparator<Person>{
	
	// Data Fields
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private Address address;
	
	// Constructors
	public Person() {
	}
	
	public Person(String firstName, String middleName, String lastName, Address address, String phoneNumber, String email) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	// Getters & Setters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddlename(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// *****METHODS*****
	// To String
	@Override
	public String toString() {
		return firstName + ", " + middleName + ", " + lastName + ", " + address + ", " 
				+ phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3") + ", " + email;
	}
	
	// Comparator interface
	@Override
	public int compare(Person person1, Person person2) {
		return person1.getLastName().compareToIgnoreCase(person2.getLastName());
	}
	
}
