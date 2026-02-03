package AddressBook.project;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();
        AddressBook curr = null;
        
        System.out.println("Welcome to Address Book Program");
        
        while(true) {
        	System.out.println("\n Address Book System ");
        	System.out.println(" 1. Create Address Book ");
        	System.out.println(" 2. Add Contact ");
        	System.out.println(" 3. Edit Contact ");
        	System.out.println(" 4. Delete Contact ");
        	System.out.println(" 5. Search Contacts in city or state ");
        	
        	System.out.print("Choice :  ");
        	int choice = sc.nextInt();
        	
        	switch(choice) {
        	case 1 : {
        		System.out.println("Enter Address Book Name");
        		system.addAddressBook(sc.next());
        	}
        	
        	case 2 : {
        		System.out.println("Enter Address Book Name ");
        		curr = system.getAddressBook(sc.next());
        		if(curr != null) {
        			AddPerson.add(curr, sc);
        		}
        		else {
        			System.out.println("Address Book does not Exist...");
        		}
        	}
        	case 3 : {
        		System.out.println("Enter Address Book Name ");
        		curr = system.getAddressBook(sc.next());
        		if(curr != null) {
        			EditPerson.edit(curr, sc);
        		}
        		else {
        			System.out.println("Address Book does not Exist...");
        		}
        	}
        	case 4 : {
        		System.out.println("Enter Address Book Name ");
        		curr = system.getAddressBook(sc.next());
        		if(curr != null) {
        			DeletePerson.delete(curr, sc);
        		}
        		else {
        			System.out.println("Address Book does not Exist...");
        		}
        	}
        	case 5 : {
        		SearchPerson.search(system, sc);
        	}
        	}
        	
        }
    }
}
