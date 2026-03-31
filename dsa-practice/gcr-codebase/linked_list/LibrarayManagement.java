package linked_list;

import java.util.*;

class Book {
    String title, author, genre;
    int id;
    boolean available;
    Book next, prev;

    Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
    }
}

public class LibrarayManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1.AddFirst \n2.AddLast \n3.AddAtPos \n4.Remove \n5.UpdateStatus");
            System.out.println("6.SearchTitle \n7.SearchAuthor \n8.DisplayF \n9.DisplayR \n10.Count \n0.Exit");
            int ch = sc.nextInt();
            if (ch == 0) {
				break;
			}

            switch (ch) {
                case 1, 2, 3 -> {
                    System.out.print("Title Author Genre ID Available(true/false): ");
                    String title = sc.next(), author = sc.next(), genre = sc.next();
                    int id = sc.nextInt(); boolean avail = sc.nextBoolean();
                    Book b = new Book(title, author, genre, id, avail);
                    if (ch == 1) {
						lib.addFirst(b);
					} else if (ch == 2) {
						lib.addLast(b);
					} else {
                        System.out.print("Position: ");
                        lib.addAtPosition(b, sc.nextInt());
                    }
                }
                case 4 -> { System.out.print("ID to remove: "); lib.remove(sc.nextInt()); }
                case 5 -> { System.out.print("ID and new status: "); lib.updateAvailability(sc.nextInt(), sc.nextBoolean()); }
                case 6 -> { System.out.print("Title to search: "); lib.searchByTitle(sc.next()); }
                case 7 -> { System.out.print("Author to search: "); lib.searchByAuthor(sc.next()); }
                case 8 -> lib.displayForward();
                case 9 -> lib.displayReverse();
                case 10 -> System.out.println("Total Books: " + lib.count());
            }
        } 
    }
}
class Library {
    Book head = null, tail = null;

    void addFirst(Book b) {
        if (head == null) {
			head = tail = b;
		} else {
            b.next = head;
            head.prev = b;
            head = b;
        }
    }

    void addLast(Book b) {
        if (tail == null) {
			head = tail = b;
		} else {
            tail.next = b;
            b.prev = tail;
            tail = b;
        }
    }

    void addAtPosition(Book b, int pos) {
        if (pos <= 1 || head == null) {
			addFirst(b);
		} else {
            Book temp = head;
            for (int i = 1; i < pos - 1 && temp.next != null; i++) {
				temp = temp.next;
			}
            b.next = temp.next;
            if (temp.next != null) {
				temp.next.prev = b;
			}
            temp.next = b;
            b.prev = temp;
            if (b.next == null) {
				tail = b;
			}
        }
    }

    void remove(int id) {
        Book temp = head;
        while (temp != null && temp.id != id) {
			temp = temp.next;
		}
        if (temp == null) {
			return;
		}
        if (temp.prev != null) {
			temp.prev.next = temp.next;
		} else {
			head = temp.next;
		}
        if (temp.next != null) {
			temp.next.prev = temp.prev;
		} else {
			tail = temp.prev;
		}
    }

    void updateAvailability(int id, boolean available) {
        for (Book b = head; b != null; b = b.next) {
			if (b.id == id) { b.available = available; return; }
		}
    }

    void searchByTitle(String title) {
        boolean found = false;
        for (Book b = head; b != null; b = b.next) {
			if (b.title.equalsIgnoreCase(title)) {
                print(b); found = true;
            }
		}
        if (!found) {
			System.out.println("Not found");
		}
    }

    void searchByAuthor(String author) {
        boolean found = false;
        for (Book b = head; b != null; b = b.next) {
			if (b.author.equalsIgnoreCase(author)) {
                print(b); found = true;
            }
		}
        if (!found) {
			System.out.println("Not found");
		}
    }

    void displayForward() {
        for (Book b = head; b != null; b = b.next) {
			print(b);
		}
    }

    void displayReverse() {
        for (Book b = tail; b != null; b = b.prev) {
			print(b);
		}
    }

    int count() {
        int c = 0;
        for (Book b = head; b != null; b = b.next) {
			c++;
		}
        return c;
    }

    void print(Book b) {
        System.out.println(b.title + " | " + b.author + " | " + b.genre + " | " + b.id + " | " + (b.available ? "Available" : "Not Available"));
    }
}
