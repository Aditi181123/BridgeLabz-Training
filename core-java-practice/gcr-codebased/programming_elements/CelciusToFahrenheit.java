package programming_elements;

import java.util.Scanner;

public class CelciusToFahrenheit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double celsius = sc.nextDouble();
		double fahrenheit = (celsius * 9/5) + 32;
		System.out.println(fahrenheit);
	}

}
