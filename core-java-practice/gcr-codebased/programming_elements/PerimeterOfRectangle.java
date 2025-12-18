package programming_elements;

import java.util.Scanner;

public class PerimeterOfRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double width = sc.nextDouble();
		double length = sc.nextDouble();
		double perimeter = 2 * (length+width);
		System.out.println(perimeter);
	}

}
