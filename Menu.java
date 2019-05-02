package phoneBookApp;

public class Menu {
	// Data fields
	boolean exit = false;

	// *****METHODS*****
	// Method: Display menu
	public void displayMenu() {
		System.out.println("_________________________________________________________________________");
		System.out.println("                                                                         ");
		System.out.println("                  Welcome to the Phone Book Application                  ");
		System.out.println("_________________________________________________________________________");
		System.out.println("                                                                         ");
		System.out.println("Option 1: Add new records");
		System.out.println("Option 2: Search by first name");
		System.out.println("Option 3: Search by last name");
		System.out.println("Option 4: Search by city or state");
		System.out.println("Option 5: Delete a records for a given telephone number");
		System.out.println("Option 6: Update the first name on records for a given telephone number");
		System.out.println("Option 7: Show all records in ascending order of their last names");
		System.out.println("Option 0: Exit the program\n");
	}
	
}