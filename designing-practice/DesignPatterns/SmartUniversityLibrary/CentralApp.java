package SmartUniversityLibrary;


public class CentralApp {
	public static void  main(String[] args) throws Exception  {
		CentralizedCatalog center = CentralizedCatalog.getInstance();
		
		User student = UserFactory.createUser("student", "Aditi");
		User faculty = UserFactory.createUser("faculty", "Dr. Mayank");
		
		center.addObserver(faculty);
		center.addObserver(student);
		
		Book book1 = new Book.BookBuilder("Design Patterns")
				.author("GoF")
				.edition("2nd")
				.build();
		
		center.addBook(book1);
	}
}
