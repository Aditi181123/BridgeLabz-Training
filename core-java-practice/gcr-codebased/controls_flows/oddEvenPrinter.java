package controls_flows;

import java.util.Scanner;

public class oddEvenPrinter {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is even.");
                } else {
                    System.out.println(i + " is odd.");
                }
            }
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }
	}
}
