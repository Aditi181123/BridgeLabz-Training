package AddressBook.project;

import java.util.*;

public class AddressBook {
	private Set<Contact> persons = new HashSet<>();

	public boolean addPerson(Contact person) {
		return persons.add(person);
	}

	public boolean deletePerson(String firstName, String lastName) {
	    for (Contact p : persons) {
	        if (p.getFullName().equalsIgnoreCase(firstName + " " + lastName)){
	            persons.remove(p);
	            return true;
	        }
	    }
	    return false;
	}

	public Contact findPerson(String firstName, String lastName) {
		for (Contact p : persons) {
			if (p.getFullName().equalsIgnoreCase(firstName + lastName)) {
				return p;
			}
		}
		return null;
	}

	public Set<Contact> getPersons() { 
		return persons;
	}
	public List<Contact> getPersons() {
	    return persons;
	}
}
