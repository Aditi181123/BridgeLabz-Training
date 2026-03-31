package class_and_object;

public class StudentsGrades {
	String name;
	String rollNumber;
	double[] marks;
	
	public static void main(String[] args) {
		//variables to store the marks
		double[] mark1 = {90,70,95};
		double[] mark2 = {60,85,70};
		
		//calling object constructor 
		StudentsGrades student1 = new StudentsGrades("Harshit", "221500726", mark1);
		StudentsGrades student2 = new StudentsGrades("Aditiya","2215000099",mark2);
		
		//calling the display method
		student1.display();
		student2.display();
	}
	//Creating constructor
	StudentsGrades(String name,String rollNumber,double[] marks) {
		this.name=name;
		this.rollNumber=rollNumber;
		this.marks=marks;
	}
	//creating method to calculate grade
	public String calculateGrade(double[] marks ) {
		
		//variable to store the total marks
		
		double totalMarks = calculateTotalMarks(marks);
		
		//to check the grade of student
		if(totalMarks >= 80 && totalMarks<=100) {
			return "Grade A";
		}
		else if((totalMarks >=60)&&(totalMarks <80)){
			return "Grade B";
		}
		else if((totalMarks >=50)&&(totalMarks <60)) {
			return "Grade C";
		}
		else if((totalMarks >=40)&&(totalMarks <50)) {
			return "Grade D";
		}
		else {
			return "Grade F";
		}
		
	}
	
	//Creating the method to display the students details
	public void display() {
		System.out.println("Student Name: "+name);
		
		System.out.println("Student RollNumber: "+rollNumber);
		
		System.out.println("Student Marks:");
		
		for(int i=0;i < marks.length ; i++ ) {
			System.out.println("Mark"+(i+1)+": "+marks[i]);
		}
		
		System.out.println(calculateGrade(marks));
	}
	
	//creating the method to calculate the total marks
	public double calculateTotalMarks(double[] marks)
	{
		double sum = 0;
		for(int i=0;i < marks.length ; i++ ) {
			sum+=marks[i];
		}
		return sum/3;
	}
	

}
