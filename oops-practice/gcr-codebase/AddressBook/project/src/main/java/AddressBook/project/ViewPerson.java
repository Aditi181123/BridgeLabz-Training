package AddressBook.project;
import java.util.*;

public class ViewPerson {
	public static void view(AddressBookSystem system, Scanner sc) {
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
				SearchPerson.searchCity(system , city);
				for (Map.Entry<String, AddressBook> entry : system.getAllAddressBooks().entrySet()) {
					System.out.print( " | Address Book: " + entry.getKey());
				}
				break;
			}
			case 2 : {
				System.out.println("Enter state name");
				String state = sc.nextLine();
				SearchPerson.searchState(system , state);
				for (Map.Entry<String, AddressBook> entry : system.getAllAddressBooks().entrySet()) {
					System.out.print( " | Address Book: " + entry.getKey());
				}
				break;
			}
			default:
				System.out.println("Invalid Choice.");
				break;
			}
		}
		
	}

}
