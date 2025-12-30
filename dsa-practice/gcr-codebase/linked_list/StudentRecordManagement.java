package linked_list;
import java.util.*;

class student{
	int rollno ;
	String name;
	int age;
	char grade;
	student next;

	public student(int rollno , String name , int age , char grade ) {
		this.rollno = rollno;
		this.age = age;
		this.grade = grade;
		this.name =name;
		this.next = null;
	}
}
public class StudentRecordManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentList list = new StudentList();

		int choice;

		 do{
			System.out.println("Student Record Management System ... ");
			System.out.println("1. Add Student at Beginning");
			System.out.println("2. Add Student at End");
			System.out.println("3. Add Student at Position");
			System.out.println("4. Delete Student by Roll Number");
			System.out.println("5. Search Student by Roll Number");
			System.out.println("6. Update Grade by Roll Number");
			System.out.println("7. Display All Students");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			int rollno , age , position;
			String name ;
			char grade;
			
			switch(choice) {
			case 1 :
				System.out.print("Enter Roll No, Name, Age, Grade: ");
				rollno = sc.nextInt();
				name = sc.next();
				age = sc.nextInt();
				grade = sc.next().charAt(0);
				list.addbegin( new student(rollno , name , age , grade));
				break;
			case 2 :
				System.out.print("Enter Roll No, Name, Age, Grade: ");
				rollno = sc.nextInt();
				name = sc.next();
				age = sc.nextInt();
				grade = sc.next().charAt(0);
				list.addend(new student(rollno , name , age , grade));
				break;
			case 3 :
				 System.out.print("Enter Position: ");
                 position = sc.nextInt();
                 System.out.print("Enter Roll No, Name, Age, Grade: ");
                 rollno = sc.nextInt();
                 name = sc.next();
                 age = sc.nextInt();
                 grade = sc.next().charAt(0);
                 list.addposition(new student(rollno , name , age , grade),position);
                 break;
			case 4 :
				System.out.println("Enter roll no to delete");
				rollno = sc.nextInt();
				list.deleteroll(rollno);
				break;
			case 5 :
				System.out.println("Enter roll no to search");
				rollno = sc.nextInt();
				list.searchroll(rollno);
				break;
			case 6 :
				System.out.println("Enter roll no to update the grades");
				rollno = sc.nextInt();
				grade = sc.next().charAt(0);
				list.update(rollno , grade);
				break;
			case 7 :
				 list.display();
                 break;
			case 0 :
				System.out.println("Exiting...");
				break;
			default:
                System.out.println("Invalid choice.");
			}

		}
		 while(choice != 0);

	}
}

class StudentList {
	student head = null;
	
	// add student at beginning
	public void addbegin(student newstud) {
		newstud.next = head;
		head = newstud;
		
		System.out.println("Added the student");
	}

	// add student at ending
	public void addend(student student) {
		// if list is null
		if(head == null) {
			head = student;
			return;
		}
		
		// if list is not null
		student curr = head;
		while(curr.next != head) {
			curr = curr.next;
		}
		
		curr.next = student;
		System.out.println("Added the student");

	}
	
	// add list at specific position
	public void addposition(student stud, int pos) {
		// if position 0 or list is null
		if(pos <= 1 || head == null) {
			stud.next = head.next;
			head = stud;
			return;
		}
		
		// at position 
		student curr = head;
		
		for(int i = 1 ; i < pos - 1 && curr != null ; i++) {
			curr = curr.next;
		}
		
		stud.next = curr.next;
		curr.next = stud;
		System.out.println("Added the student");

	}
	
	// delete list by roll number
	public void deleteroll(int rollno) {
		// if list is null
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		
		// if roll no is first
		if(head.rollno == rollno) {
			head = head.next;
			System.out.println("Student Deleted");
			return;
		}
		
		student curr = head;
		
		while(curr.next != null && curr.next.rollno != rollno) {
			curr = curr.next;
		}
		
		// if roll is not in list
		if(curr.next == null) {
			System.out.println("Roll number not found");
		}
		else {
			// if roll is in list and deleted
			curr.next = curr.next.next;
			System.out.println("Student Deleted");
		}
	}
	
	// search student by roll number 
	public void searchroll(int rollno) {
		// if list is empty
		if(head == null ) {
			System.out.println("List is Empty");
			return;
		}
		
		student curr = head;
		while(curr != null) {
			if(curr.rollno == rollno) {
				System.out.println("Rollno: " + curr.rollno + ", Name: " + curr.name+", Age: " + curr.age+", Grade: " + curr.grade );
				return;
			}
			curr = curr.next;
		}
		System.out.println("Student not found");
		
	}
	
	//update the grade 
	public void update(int rollno , char grade) {
		if(head == null) {
			System.out.println("list is empty");
			return;
		}
		
		student curr = head;
		while(curr != null) {
			if(curr.rollno == rollno) {
				curr.grade = grade;
				System.out.println("Grade updated ");
				return;
			}
			curr = curr.next;
		}
		
		System.out.println("Student not found");
	}
	
	// display the record 
	public void display() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }

        student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollno + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}