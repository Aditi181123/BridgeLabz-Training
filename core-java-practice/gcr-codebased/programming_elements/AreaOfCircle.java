package programming_elements;

import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		double area = Math.PI * r*r;
		System.out.println(area);
	}

}
