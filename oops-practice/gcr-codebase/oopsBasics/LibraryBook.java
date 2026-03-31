package oopsBasics;

public class LibraryBook {
	String title;
	String author;
	double price;
	boolean available;
	
	public static void main(String[]args) {
		LibraryBook book1 = new LibraryBook("Possession" , "A S Byatt" , 500.00 );
		System.out.println("   Book 1  ");
		book1.display();
		book1.borrowBook();
		book1.display();
		book1.borrowBook();
	}

	LibraryBook(String title , String author , double price ){
		this.title = title;
		this.author = author;
		this.price = price;
		this.available = true;
	}
	
	void display() {
		System.out.println("Title : " + title);
		System.out.println("Author : " + author);
		System.out.println("Price : " + price);
		System.out.println("Available : " + available);
	}
	
	void borrowBook() {
		if(available) {
			available = false;
			System.out.println("YES , Book is available... \n");
		}
		else {
			System.out.println("NO , Book is not available... \n");
		}
	}
}
