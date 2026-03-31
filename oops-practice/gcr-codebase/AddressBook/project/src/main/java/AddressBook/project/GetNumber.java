package AddressBook.project;

import java.util.*;

public class GetNumber {
	public static void count(AddressBookSystem system, Scanner sc) {
		System.out.println("Enter city or state:  ");
		int choice;
		while(true) {
			System.out.println("1. City");
			System.out.println("2. State");
			choice = sc.nextInt();

			switch(choice) {
			case 1 : {
				SearchPerson.countC = 0;
				System.out.println("Enter city name");
				String city = sc.nextLine();
				SearchPerson.searchCity(system, city);
				System.out.println("Total number of Person in City " + SearchPerson.countC);
				break;
			}
			case 2 : {
				SearchPerson.countS = 0;
				System.out.println("Enter state name");
				String state = sc.nextLine();
				SearchPerson.searchState(system , state);
				System.out.println("Total number of Person in State " +SearchPerson.countS);
				break;
			}
			}
		}
	}

}
