package AddressBook.project;

import java.util.*;

public class SearchPerson {
	static int countC ;
	static int countS ;
	public static void search(AddressBookSystem system, Scanner sc) {
		System.out.println("Enter city or state:  ");
		int choice;
		while(true) {
			System.out.println("1. City");
			System.out.println("2. State");
			choice = sc.nextInt();

			switch(choice) {
			case 1 : {
				System.out.println("Enter city name");
				String city = sc.nextLine();
				searchCity(system , city);
				break;
			}
			case 2 : {
				System.out.println("Enter state name");
				String state = sc.nextLine();
				searchState(system , state);
				break;
			}
			default:
				System.out.println("Invalid Choice. ");
				break;
			}
		}

	}

	static void searchState(AddressBookSystem system, String state) {
		for (Map.Entry<String, AddressBook> entry : system.getAllAddressBooks().entrySet()) {
			for (Contact person : entry.getValue().getPersons()) {
				if (person.getCity().equalsIgnoreCase(state)) {
					System.out.println(person);
					countS++;
				}
			}
		}

	}

	static void searchCity(AddressBookSystem system, String city) {
		for (Map.Entry<String, AddressBook> entry : system.getAllAddressBooks().entrySet()) {
			for (Contact person : entry.getValue().getPersons()) {
				if (person.getCity().equalsIgnoreCase(city)) {
					System.out.println(person );
					countC++;
				}
			}
		}
	}
	
}
