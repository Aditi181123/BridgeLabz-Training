package linked_list;
import java.util.*;

class Movie{
	String title;
	String director;
	int year;
	double rating;
	Movie next;
	Movie prev;

	public Movie(String title , String director , int year , double rate) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.rating = rate;
		this.next = next;
		this.prev = prev;
	}
}
public class MovieManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MovieList list = new MovieList();
		int choice;

		do { 
			System.out.println("Movie Management System");
			System.out.println("1. Add Movie at Beginning");
			System.out.println("2. Add Movie at End");
			System.out.println("3. Add Movie at Position");
			System.out.println("4. Remove Movie by Title");
			System.out.println("5. Search Movie by Director");
			System.out.println("6. Search Movie by Rating");
			System.out.println("7. Update Movie Rating by Title");
			System.out.println("8. Display All Movies (Forward)");
			System.out.println("9. Display All Movies (Reverse)");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			String title, director;
			int year, pos;
			double rating;
			
			switch(choice) {
			case 1 :
				System.out.println("Enter title , director , year and rating of the movie");
				title = sc.next();
				director = sc.next();
				year = sc.nextInt();
				rating = sc.nextDouble();
				list.addbegin(new Movie(title, director, year, rating));
				break;
			case 2:
				System.out.println("Enter title , director , year and rating of the movie");
				title = sc.next();
				director = sc.next();
				year = sc.nextInt();
				rating = sc.nextDouble();
				list.addend(new Movie(title, director, year, rating));
				break;
			case 3 :
				System.out.println("Enter the position");
				pos = sc.nextInt();
				System.out.println("Enter title , director , year and rating of the movie");
				title = sc.next();
				director = sc.next();
				year = sc.nextInt();
				rating = sc.nextDouble();
				list.addposition(new Movie(title, director, year, rating), pos);
				break;
			 case 4:
                 System.out.print("Enter Movie Title to remove: ");
                 title = sc.nextLine();
                 list.removeByTitle(title);
                 break;

             case 5:
                 System.out.print("Enter Director Name to search: ");
                 director = sc.nextLine();
                 list.searchByDirector(director);
                 break;

             case 6:
                 System.out.print("Enter Rating to search: ");
                 rating = sc.nextDouble();
                 list.searchByRating(rating);
                 break;

             case 7:
                 System.out.print("Enter Movie Title to update: ");
                 title = sc.nextLine();
                 System.out.print("Enter New Rating: ");
                 rating = sc.nextDouble();
                 list.updateRatingByTitle(title, rating);
                 break;

             case 8:
                 list.displayForward();
                 break;

             case 9:
                 list.displayReverse();
                 break;

             case 0:
                 System.out.println("Exiting...");
                 break;

             default:
                 System.out.println("Invalid choice.");
			}

		}while( choice != 0);
	}
}

class MovieList{
	Movie head = null;
	Movie tail = null;
	
	public void addbegin(Movie movie) {
		if(head == null) {
			head = tail = movie;
			return;
		}
		
		movie.next = head;
		head.prev = movie;
		head = movie;
		
		System.out.println("Movie added");
	}
	
	public void addend(Movie movie) {
		if(tail == null) {
			tail = head = movie;
			return;
		}
		
		tail.next = movie;
		movie.prev = tail;
		tail = movie;
		
		System.out.println("Movie added");
	}
	public void addposition(Movie movie, int pos) {
		if(pos <= 1 || head == null) {
			addbegin(movie);
			return;
		}

        Movie temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        movie.next = temp.next;
        movie.prev = temp;

        if (temp.next != null) {
            temp.next.prev = movie;
        } else {
            tail = movie;
        }

        temp.next = movie;
        System.out.println("Movie added");   
	}
	public void removeByTitle(String title) {
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		Movie temp = head;
		
		while(temp != null && !temp.title.equalsIgnoreCase(title)) {
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("Title not found.");
		}
		
		if(temp == head) {
			head = temp.next;
			if(head != null) {
				head.prev = null;
			}
		}
		else if(temp == tail) {
			tail = temp.prev;
			tail.prev = null;
		}
		else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
		
		System.out.println("Movie removed by title");
	}
	
	public void searchByDirector(String director) {
		if(head == null ) {
			System.out.println("List is Empty");
			return;
		}
		Movie temp = head;
		boolean found = true;
		while(temp != null) {
			if(temp.director.equalsIgnoreCase(director)) {
				System.out.println("Title: " + temp.title + ", Director: "+temp.director + ", Year of realeas: "+ temp.year + ", Rating: "+temp.rating);
				found = true;
			}
			temp = temp.next;
		}

		if(!found) {
			System.out.println("No movies found by director " + director);
		}
	}
	public void searchByRating(double rating) {
		if(head == null ) {
			System.out.println("List is Empty");
			return;
		}
		Movie temp = head;
		boolean found = true;
		while(temp != null) {
			if(temp.rating == rating) {
				System.out.println("Title: " + temp.title + ", Director: "+temp.director + ", Year of realeas: "+ temp.year + ", Rating: "+temp.rating);
				found = true;
			}
			temp = temp.next;
		}
		if(!found) {
			System.out.println("No movies found by rating " + rating);
		}
	}
	public void updateRatingByTitle(String title, double rating) {
		if(head == null ) {
			System.out.println("List is Empty");
			return;
		}
		Movie temp = head;
		boolean found = true;
		while(temp != null) {
			if(temp.title.equalsIgnoreCase(title)) {
				temp.rating = rating;
				found = true;
			}
			temp = temp.next;
		}
		if(!found) {
			System.out.println("No movies found by title " + title);
		}
	}
	public void displayForward() {
		if(head == null ) {
			System.out.println("List is Empty");
			return;
		}
		Movie temp = head;
		while(temp != null) {
			System.out.println("\n" + temp.title + "," + temp.director+ "," +temp.year+ "," +temp.rating);
			temp = temp.next;
		}
	}
	public void displayReverse() {
		if(head == null ) {
			System.out.println("List is Empty");
			return;
		}
		Movie temp = tail;
		while(temp != null) {
			System.out.println("\n" + temp.title + "," + temp.director+ "," +temp.year+ "," +temp.rating);
			temp = temp.next;
		}
	}
}
