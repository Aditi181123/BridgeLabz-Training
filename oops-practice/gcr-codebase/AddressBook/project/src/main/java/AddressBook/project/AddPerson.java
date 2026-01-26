package AddressBook.project;

import java.util.Scanner;

public class AddPerson {
    public static void execute(AddressBook book, Scanner sc) {
        System.out.print("First Name: "); String fn = sc.nextLine();
        System.out.print("Last Name: "); String ln = sc.nextLine();
        System.out.print("Address: "); String ad = sc.nextLine();
        System.out.print("City: "); String city = sc.nextLine();
        System.out.print("State: "); String state = sc.nextLine();
        System.out.print("Zip: "); String zip = sc.nextLine();
        System.out.print("Phone: "); String phone = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();

        ContactPerson person = new ContactPerson(fn, ln, ad, city, state, zip, phone, email);
        if (book.addPerson(person)) System.out.println("Person added successfully.");
        else System.out.println("Duplicate person. Cannot add.");
    }
}
