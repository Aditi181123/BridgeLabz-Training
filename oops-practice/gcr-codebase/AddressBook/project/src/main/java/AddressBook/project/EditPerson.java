package AddressBook.project;

import java.util.Scanner;

public class EditPerson {
    public static void execute(AddressBook book, Scanner sc) {
        System.out.print("First Name to edit: "); String fn = sc.nextLine();
        System.out.print("Last Name to edit: "); String ln = sc.nextLine();

        ContactPerson person = book.findPerson(fn, ln);
        if (person == null) {
            System.out.println("Person not found.");
            return;
        }

        System.out.print("New Address: "); person.setAddress(sc.nextLine());
        System.out.print("New City: "); person.setCity(sc.nextLine());
        System.out.print("New State: "); person.setState(sc.nextLine());
        System.out.print("New Zip: "); person.setZip(sc.nextLine());
        System.out.print("New Email: "); person.setEmail(sc.nextLine());

        System.out.println("Person updated successfully.");
    }
}
