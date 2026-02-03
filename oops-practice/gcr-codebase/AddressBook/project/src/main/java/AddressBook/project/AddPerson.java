package AddressBook.project;

import java.util.Scanner;

public class AddPerson {
	public static void add(AddressBook book, Scanner sc) {
		String choice;
		do {
			System.out.print("First Name: "); String fn = sc.nextLine();
			System.out.print("Last Name: "); String ln = sc.nextLine();
			System.out.print("Address: "); String ad = sc.nextLine();
			System.out.print("City: "); String city = sc.nextLine();
			System.out.print("State: "); String state = sc.nextLine();
			System.out.print("Zip: "); String zip = sc.nextLine();
			System.out.print("Phone: "); String phone = sc.nextLine();
			System.out.print("Email: "); String email = sc.nextLine();

			Contact person = new Contact(fn, ln, ad, city, state, zip, phone, email);
			if (book.addPerson(person)) {
				System.out.println("Person added successfully.");
			}
			else {
				System.out.println("Person already exists...");
			}
			System.out.println("Add another person? (yes/no) ");
			choice = sc.next();

		}while(choice.equalsIgnoreCase("yes"));
	}
}
