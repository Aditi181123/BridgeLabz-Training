package programming_elements;

import java.util.Scanner;

public class ConvertKilometerToMile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double km = sc.nextDouble();
		double m = km * 0.621371;
		System.out.println(m);
	}

}
