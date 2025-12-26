package inheritence;

class Book{
	public String title;
	public int publishYear;

	public Book(String title , int year) {
		this.title = title;
		this.publishYear = year;
	}

	public void displayInfo() {
		System.out.println("\nBook Title : " + title);
		System.out.println("Publication Year : "+ publishYear);
	}
}

class author extends Book{
	public String name ;
	public String bio;
	public author(String title, int year , String name , String bio) {
		super(title, year);
		this.name = name;
		this.bio = bio;
	}

	public void displayInfo() {
		super.displayInfo();
		System.out.println("Author Name : " + name);
		System.out.println("Bio : " + bio);
	}
}
public class LibraryMangement {
	public static void main(String[]args) {
		author book = new author("The Alchemist", 1988, "Paulo Coelho", "Philosophical novel");
		book.displayInfo();
	}
}
