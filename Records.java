package phoneBookApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Records {
	
	// Objects
	List<Person> people = new ArrayList<>();
	private int userId;

	// Constructors
	public Records() {
	}

	// Getters & Setters
	public List<Person> getRecords() {
		return people;
	}

	public void setRecords(List<Person> record) {
		this.people = record;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	// Convert a comma separated string to Person type
	public Person convertToPerson(String commaSeparatedString) {
		String[] stringArray = new String[7];
		stringArray = commaSeparatedString.split(", ");
		
		Address address = new Address(stringArray[1], stringArray[2], stringArray[3], stringArray[4]);
		
		// Set variables for person
		String[] fullName = stringArray[0].split(" ");
		if(fullName.length == 2) {
			// If user enters only first name & last name
			Person person = new Person(fullName[0], null, fullName[1], address, stringArray[5], stringArray[6]);
			return person;
		}
		else {
			// If user enters middle name(s)
			String nameAdd = "";
			for(int i = 1; i < fullName.length - 1; i++) {
				nameAdd = nameAdd + " " + fullName[i];
			}
			Person person = new Person(fullName[0], nameAdd, fullName[fullName.length-1], address, stringArray[5], stringArray[6]);
			return person;
		}
	}
	
	// Case 1: Add record
	public void addPerson(Person newPerson) {
		people.add(newPerson);
	}
	
	// Case 2: Search by first name
	public List<Person> searchFirstName(String firstName) {
		List<Person> firstNameRecordMatch = new ArrayList<Person>();
		
		for(int i = 0; i < people.size() ; i++) {
			if(people.get(i).getFirstName().matches(firstName)) {
				firstNameRecordMatch.add(people.get(i));
			}
		}
		return firstNameRecordMatch;
	}
	
	// Case 3: Search by last name
	public List<Person> searchLastName(String lastName) {
		List<Person> lastNameRecordMatch = new ArrayList<Person>();
		
		for(int i = 0; i < people.size() ; i++) {
			if(people.get(i).getLastName().matches(lastName)) {
				lastNameRecordMatch.add(people.get(i));
			}
		}
		return lastNameRecordMatch;
	}
	
	// Case 4: Search by city or state
	public List<Person> searchCityOrState(String cityState) {
		List<Person> cityStateSearch = new ArrayList<Person>();
		
		for(int i = 0; i < people.size() ; i++) {
			if(people.get(i).getAddress().getCity().matches(cityState)) {
				cityStateSearch.add(people.get(i));
			}

			else if(people.get(i).getAddress().getState().matches(cityState)) {
				cityStateSearch.add(people.get(i));
			}
		}

		return cityStateSearch;
	}
	
	// Case 5: Delete a records for a given telephone number
	public List<Person> deleteRecord(String phoneNumber) {
		for(int i = 0; i < people.size() ; i++) {
			if(people.get(i).getPhoneNumber().matches(phoneNumber)) {
				people.remove(people.get(i));
			}
		}
		return people;
	}
	
	// Case 6: Update the first name on records for a given telephone number
	public List<Person> updateRecord(String phoneNumber, String newFirstName) {
		for(int i = 0; i < people.size() ; i++) {
			if(people.get(i).getPhoneNumber().equals(phoneNumber)) {
				people.get(i).setFirstname(newFirstName);
			}
		}
		return people;
	}
	
	// Case 7: Show all records in ascending order of their last names
	public List<Person> sortRecords() {
		List<Person> lastNameSort = new ArrayList<Person>();
		
		Collections.sort(people, new Person());
		for(int i = 0; i < people.size(); i++) {
			lastNameSort.add(people.get(i));
		}
		return lastNameSort;
	}
	
}
