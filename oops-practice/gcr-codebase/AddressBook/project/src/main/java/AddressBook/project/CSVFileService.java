package AddressBook.project;

import com.opencsv.bean.*;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;

public class CSVFileService {

    private static final String FILE_NAME = "resoces/AddressBook.csv";

    // WRITE CSV
    public static void writeCSV(AddressBook book) {
        try (Writer writer = new FileWriter(FILE_NAME)) {

            StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder<Contact>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanToCsv.write(book.getPersonsList());

            System.out.println("Contacts written to CSV successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ CSV
    public static List<Contact> readCSV() {
        try (Reader reader = new FileReader(FILE_NAME)) {

            CsvToBean<Contact> csvToBean = new CsvToBeanBuilder<Contact>(reader)
                    .withType(Contact.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Contact> contacts = csvToBean.parse();
            System.out.println("Contacts read from CSV successfully.");
            return contacts;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
