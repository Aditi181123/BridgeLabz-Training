package AddressBook.project;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {
    private Map<String, AddressBook> Books = new HashMap<>();

    public void addAddressBook(String name) {
    	 if (Books.containsKey(name)) {
             System.out.println("Address Book already exists");
         } else {
             Books.put(name, new AddressBook());
             System.out.println("Address Book created: " + name);
         }
    }

    public AddressBook getAddressBook(String name) {
        return Books.get(name);
    }

    public void displayAllBooks() {
        Books.keySet().forEach(System.out::println);
    }

	public  Map<String, AddressBook> getAllAddressBooks() {
		return Books;
	}

	
}
