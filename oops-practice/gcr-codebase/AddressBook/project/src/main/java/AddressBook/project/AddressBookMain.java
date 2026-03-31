package AddressBook.project;

import java.util.List;
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
        	System.out.println(" 5. Search Contacts in City or State ");
        	System.out.println(" 6. View Contacts by City or State ");
        	System.out.println(" 7. Get Number of Contacts in City or State  ");
        	System.out.println(" 8. Sort Entries by Name ");
        	System.out.println(" 9. Sort Entries by City , State , Zip ");
        	System.out.println("10. Save Address Book to File");
        	System.out.println("11. Load Address Book from File");
        	System.out.println("12. Save Address Book as CSV");
        	System.out.println("13. Load Address Book from CSV");


        	
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
        	case 6 : {
        		ViewPerson.view(system,sc);
        	}
        	case 7 : {
        		GetNumber.count(system, sc);
        	}
        	case 8 :{
        		System.out.println("Enter Address Book Name ");
        		curr = system.getAddressBook(sc.next());
        		if(curr != null) {
        			SortPerson.sortName(curr);
        		}
        		else {
        			System.out.println("Address Book does not Exist...");
        		}
        	}
        	case 9 :{
        		System.out.println("Enter Address Book Name ");
        		curr = system.getAddressBook(sc.next());
        		if(curr != null) {
        			SortPerson.sort(curr, sc);
        		}
        		else {
        			System.out.println("Address Book does not Exist...");
        		}
        	}
        	case 10: {
        	    System.out.println("Enter Address Book Name ");
        	    curr = system.getAddressBook(sc.next());
        	    if (curr != null) {
        	        FileIOService.writeToFile(curr);
        	    }
        	}
        	case 11: {
        	    AddressBook loaded = FileIOService.readFromFile();
        	    system.addAddressBook("LoadedBook");
        	    system.getAddressBook("LoadedBook").getPersonsList().addAll(loaded.getPersonsList());
        	}
        	case 12: {
        	    System.out.println("Enter Address Book Name");
        	    curr = system.getAddressBook(sc.next());
        	    if (curr != null) {
        	        CSVFileService.writeCSV(curr);
        	    }
        	    break;
        	}

        	case 13: {
        	    List<Contact> contacts = CSVFileService.readCSV();
        	    system.addAddressBook("CSVBook");
        	    AddressBook csvBook = system.getAddressBook("CSVBook");
        	    csvBook.addAll(contacts);
        	    System.out.println("Loaded Address Book as CSVBook");
        	    break;
        	}

        	}
        	
        }
    }
}
