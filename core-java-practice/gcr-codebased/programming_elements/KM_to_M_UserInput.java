package programming_elements;

import java.util.Scanner;

public class KM_to_M_UserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter distance in km ");
		Scanner sc = new Scanner(System.in);
		double km = sc.nextDouble();
		double m = 1.6;
		
		double mile = km * m ;
		
		System.out.println("The total miles is "+ mile + " mile for the given "+ km);
		
	}

}
