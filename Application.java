package phoneBookApp;
import java.util.List;
import java.util.Scanner;

public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		Records records = new Records();

		while (true) {
			menu.displayMenu();
			int option = sc.nextInt();
			sc.nextLine();
			
			// Perform method based on user input
			switch(option) {
				// 0. Exit the program
				case 0:
					System.out.println("Thank you for using the Phone Book Application (:");
					System.exit(0);
					break;
					
				// 1. Add new records
				case 1: 
					System.out.println("Enter in the following format: "
							+ "Joyce L Byers, 114 Market St, Hawkins, IN, 46047, 7656435698, jb.stranger@gmail.com");
					String commaSeparatedString = sc.nextLine();
					Person newPerson = records.convertToPerson(commaSeparatedString);
					records.addPerson(newPerson);
					break;
					
				// 2. Search by first name
				case 2:
					System.out.println("Enter first name to search: ");
					String firstName = sc.nextLine();
					List<Person> firstNameRecordsMatch = records.searchFirstName(firstName);
					System.out.println(firstNameRecordsMatch);
					break;
					
				// 3. Search by last name
				case 3:
					System.out.println("Enter last name to search: ");
					String lastName = sc.nextLine();
					List<Person> lastNameRecordsMatch = records.searchLastName(lastName);
					System.out.println(lastNameRecordsMatch);
					break;
					
				// 4. Search by city or state
				case 4:
					System.out.println("Enter city or state to search: ");
					String cityState = sc.nextLine();
					List<Person> cityStateRecordsMatch = records.searchCityOrState(cityState);
					System.out.println(cityStateRecordsMatch);
					break;
					
				// 5. Delete a records for a given telephone number
				case 5:
					System.out.println("Enter telephone number to delete associated record: ");
					String phone1 = sc.nextLine();
					List<Person> recordDelete = records.deleteRecord(phone1);
					System.out.println(recordDelete);
					break;
					
				// 6. Update the first name on records for a given telephone number
				case 6:
					System.out.println("Enter telephone number to update associated records: ");
					String phone2 = sc.nextLine();
					System.out.println("Enter updated first name: ");
					String newFirstName = sc.nextLine();
					List<Person> updateRecord = records.updateRecord(phone2, newFirstName);
					System.out.println(updateRecord);
					break;
					
				// 7. Show all records in ascending order of their last names
				case 7:
					System.out.println(records.sortRecords());
					break;
					
				// Error
				default:
					System.out.println("An unknown error has occurred");
					break;
			}
		}
	} 
}
