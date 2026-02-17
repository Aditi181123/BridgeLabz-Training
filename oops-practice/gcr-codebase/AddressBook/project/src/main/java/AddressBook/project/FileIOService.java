package AddressBook.project;

import java.io.*;
import java.util.List;

public class FileIOService {

    private static final String FILE_NAME = "resorces/AddressBook.txt";

    
    public static void writeToFile(AddressBook book) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Contact c : book.getPersonsList()) {
                bw.write(c.toFileString());
                bw.newLine();
            }

            System.out.println("Contacts written to file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static AddressBook readFromFile() {
        AddressBook book = new AddressBook();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = br.readLine()) != null) {
                Contact c = Contact.fromFileString(line);
                book.addPerson(c);
            }

            System.out.println("Contacts read from file successfully.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return book;
    }
}
