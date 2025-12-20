package controls_flows;

import java.util.Scanner;

public class sumOfNaturalNumCompareByFor {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a num : ");
		int num = sc.nextInt();
		
		if(num >= 1) {
			 // Using formula
            int sumFormula = num * (num + 1) / 2;

            // Using for loop
            int sumLoop = 0;
            for(int i = 1 ; i<= num ; i++) {
            	sumLoop += i;
            }
            // Output
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using while loop: " + sumLoop);

            // Compare results
            if (sumFormula == sumLoop) {
                System.out.println("Both results match. Computation is correct.");
            } else {
                System.out.println("Results do not match. Please check the logic.");
            }
        } else {
            System.out.println("The number " + num + " is not a natural number.");
        }

	}
}
