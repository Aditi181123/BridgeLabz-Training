package oopsBasics;

public class Student{
	public int rollNo ;
	protected String Name;
	private double CGPA;
	
	public static void main(String[] args) {
		Student s1 = new Student( 456,"tanya" , 8.21 );
		
		s1.update(8.5);
		
		Student.PostGraguateStudent PGS = s1.new PostGraguateStudent();
		
		PGS.display();
		
		
		
	}
	
	Student(int rollNo , String Name , double CGPA){
		this.CGPA = CGPA ;
		this.Name = Name ;
		this.rollNo = rollNo;
	}
	
	void update(double n){
		if(n > 0) {
			CGPA = n;
		}
	}
	
	public double cgpa() {
		return CGPA;
	}
	
	class PostGraguateStudent{
		
		void display() {
			System.out.println("Roll Number : " + rollNo);
			System.out.println("Name : " + Name);
			System.out.println("CGPA by Private :  " + CGPA); // by private method
			System.out.println("CGPA : " + cgpa()); // by public method
		}
	}
	
	
	
}
