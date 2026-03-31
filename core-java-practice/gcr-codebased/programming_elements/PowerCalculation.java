package programming_elements;

import java.util.Scanner;

public class PowerCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double base = sc.nextDouble();
		double exponent = sc.nextDouble();
		double result = Math.pow(base, exponent);

		System.out.println("Result = " + result);
	}
}
