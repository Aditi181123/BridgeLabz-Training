package AddressBook.project;

import java.util.*;

public class SortPerson {

	public static void sortName(AddressBook book) {
		List<Contact> list = book.getPersonsList();
		list.sort((a, b) -> a.getFirstName().compareToIgnoreCase(b.getFirstName()));
	}

	public static void sort(AddressBook curr , Scanner sc) {
		while(true) {
			System.out.println("1. sort by city");
			System.out.println("2. sort by state");
			System.out.println("3. sort by pincode");
			
			int choice = sc.nextInt();
			List<Contact> list = curr.getPersonsList();
			switch(choice) {
			case 1 : {
				list.sort((a,b) -> a.getCity().compareToIgnoreCase(b.getCity()));
			}
			case 2 : {
				list.sort((a, b) -> a.getState().compareToIgnoreCase(b.getState()));
			}
			case 3 :{
				list.sort((a, b) -> a.getPincode().compareToIgnoreCase(b.getPincode()));
			}
			}
		}
	}
}


