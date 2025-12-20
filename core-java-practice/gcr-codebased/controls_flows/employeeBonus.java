package controls_flows;

import java.util.Scanner;

public class employeeBonus {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = sc.nextInt();

        if (yearsOfService > 5) {
            double bonus = (salary * 5)/100;
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("No bonus for less than or equal to 5 years of service.");
        }
	}
}
