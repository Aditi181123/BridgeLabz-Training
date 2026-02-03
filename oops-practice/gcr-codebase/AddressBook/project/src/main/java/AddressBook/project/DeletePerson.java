package AddressBook.project;

import java.util.Scanner;

public class DeletePerson {
    public static void delete(AddressBook book, Scanner sc) {
    	
        System.out.print("First Name to delete: "); 
        String fn = sc.nextLine();
        System.out.print("Last Name to delete: "); 
        String ln = sc.nextLine();

        if (book.deletePerson(fn, ln)) {
        	System.out.println("Person deleted.");
        }
        else {
        	System.out.println("Person not found.");
        }
    }
}
