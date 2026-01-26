package AddressBook.project;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        while (true) {
            System.out.println("\n1 Add Address Book");
            System.out.println("2 Add Person");
            System.out.println("3 Edit Person");
            System.out.println("4 Delete Person");
            System.out.println("5 Search by City/State");
            System.out.println("6 Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 6) break;

            switch (choice) {
                case 1 : {
                    System.out.print("Address Book Name: ");
                    system.addAddressBook(sc.nextLine());
                }
                case 2 : {
                    System.out.print("Address Book Name: ");
                    AddressBook book = system.getAddressBook(sc.nextLine());
                    if (book != null) AddPerson.execute(book, sc);
                    else System.out.println("Address Book not found.");
                }
                case 3 : {
                    System.out.print("Address Book Name: ");
                    AddressBook book = system.getAddressBook(sc.nextLine());
                    if (book != null) EditPerson.execute(book, sc);
                    else System.out.println("Address Book not found.");
                }
                case 4 : {
                    System.out.print("Address Book Name: ");
                    AddressBook book = system.getAddressBook(sc.nextLine());
                    if (book != null) DeletePerson.execute(book, sc);
                    else System.out.println("Address Book not found.");
                }
                case 5 : SearchPerson.execute(system, sc);
                default : System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
