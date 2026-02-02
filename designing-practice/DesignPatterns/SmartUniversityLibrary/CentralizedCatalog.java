package SmartUniversityLibrary;
import java.util.*;

interface Observer {
    void update(String message);
}

public class CentralizedCatalog {

	// volatile to deal with multi threads && instance to make data one object for different  attributes
	private static volatile CentralizedCatalog instance; 
	// attributes of the catalog
	private List<Book> books = new ArrayList<>();
	private List<Observer> obser = new ArrayList<>();

	// constructor
	private CentralizedCatalog () {}

	// get object
	public static CentralizedCatalog getInstance() {
		if(instance == null) {
			synchronized(CentralizedCatalog.class) { // to simplify the all threads (synchronized)
				if(instance == null) {
					instance = new CentralizedCatalog();
				}
			}
		}
			return instance;
	}
	
	public void addBook(Book book) {
		books.add(book);
		newBook(book.getTiltle());
	}
	
	public void addObserver(Observer o) {
		obser.add(o);
	}
	
	public void removeObserver (Observer o) {
		obser.remove(o);
	}
	
	private void newBook(String bookName) {
		for (Observer o : obser) {
			o.update( "New book available: " + bookName);
		}
	}
}

