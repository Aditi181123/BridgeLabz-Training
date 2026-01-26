package AddressBook.project;

import java.util.Scanner;

public class SearchPerson {
    public static void execute(AddressBookSystem system, Scanner sc) {
        System.out.print("Enter City or State to search: ");
        system.searchByCityOrState(sc.nextLine());
    }
}
