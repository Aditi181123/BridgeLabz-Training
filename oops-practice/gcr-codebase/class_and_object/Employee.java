package class_and_object;
import java.util.*;
public class Employee {
	//non-static variables
	String name;
	int id;
	double salary;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// user input 
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter id ");
		int id = sc.nextInt();
		System.out.print("Enter salary ");
		double salary = sc.nextDouble();
		//calling constructor
	    Employee emp=new Employee( name , id ,  salary);
	  //calling the method
	    emp.displayEmployee();
	}

	
	//Constructor
	Employee(String name, int id,double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	//creating method to display employee details
	public  void displayEmployee() {
		System.out.println("Employee Name: "+name);
		System.out.println("Employee id: "+id);
		System.out.println("Employee Salary: "+salary);
	}
	
}
