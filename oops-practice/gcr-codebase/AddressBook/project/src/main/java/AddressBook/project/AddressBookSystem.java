package AddressBook.project;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {
    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {
        addressBooks.putIfAbsent(name, new AddressBook());
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public void searchByCityOrState(String value) {
        boolean found = false;
        for (AddressBook book : addressBooks.values()) {
            for (ContactPerson p : book.getPersons()) {
                if (p.getCity().equalsIgnoreCase(value) || p.getState().equalsIgnoreCase(value)) {
                    System.out.println(p);
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No person found in city/state: " + value);
    }
}
