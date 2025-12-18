package programming_elements;

public class Pen_Distribution {
	public static void main(String[]args) {
		int pens = 14;
		int stud = 3;
		int penperstud = pens / stud ;
		int remainpen = pens % stud;
		
		System.out.println("The Pen Per Student is " + penperstud + " and the remaining pen not distributed is " + remainpen);
	}

}
