package controls_flows;

import java.util.Scanner;

public class divisibleBy5 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isDivisible = (number%5==0);

        if (isDivisible) {
            System.out.println("The number is divisible by 5.");
        } else {
            System.out.println("The number is not divisible by 5.");
        }
        scanner.close();
	}
}
