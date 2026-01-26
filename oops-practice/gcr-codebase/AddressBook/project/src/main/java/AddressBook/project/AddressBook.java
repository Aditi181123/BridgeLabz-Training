package AddressBook.project;

import java.util.HashSet;
import java.util.Set;

public class AddressBook {
    private Set<ContactPerson> persons = new HashSet<>();

    public boolean addPerson(ContactPerson person) {
        return persons.add(person);
    }

    public boolean deletePerson(String firstName, String lastName) {
        return persons.removeIf(p -> p.getFullName().equalsIgnoreCase(firstName + lastName));
    }

    public ContactPerson findPerson(String firstName, String lastName) {
        for (ContactPerson p : persons) {
            if (p.getFullName().equalsIgnoreCase(firstName + lastName)) return p;
        }
        return null;
    }

    public Set<ContactPerson> getPersons() { return persons; }
}
