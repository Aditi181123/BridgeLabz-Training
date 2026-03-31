package programming_elements;

import java.util.Scanner;

public class SimpleIntrest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter amount , time and rate : ");
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int t = sc.nextInt();
		int r = sc.nextInt();

		int m = p * r * t;
		int s = m / 100;

		System.out.println("Interest : " + s);

	}

}
