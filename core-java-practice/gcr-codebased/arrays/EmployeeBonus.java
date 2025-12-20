package arrays;
import java.util.*;
public class EmployeeBonus {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        final int employee = 10;

			double[] salary = new double[employee];
	        double[] years = new double[employee];
	        double[] bonus = new double[employee];
	        double[] newSalary = new double[employee];

	        double tBonus = 0, tOldSalary = 0, tNewSalary = 0;

	        for (int i = 0; i < employee; i++) {
	            System.out.println("Employee " + (i + 1));
	            System.out.print("Enter salary: ");
	            double sal = sc.nextDouble();
	            System.out.print("Enter years of service: ");
	            double yr = sc.nextDouble();

	            if (sal <= 0 || yr < 0) {
	                System.out.println("Invalid input. Try again.");
	                i--;
	                continue;
	            }

	            salary[i] = sal;
	            years[i] = yr;
	        }

	        for (int i = 0; i < employee; i++) {
	            if (years[i] > 5)
	                bonus[i] = salary[i] * 0.05;
	            else
	                bonus[i] = salary[i] * 0.02;

	            newSalary[i] = salary[i] + bonus[i];
	            tBonus += bonus[i];
	            tOldSalary += salary[i];
	            tNewSalary += newSalary[i];
	        }

	        System.out.println("\nTotal Bonus Paid: " + tBonus);
	        System.out.println("Total Old Salary: " + tOldSalary);
	        System.out.println("Total New Salary: " + tNewSalary);
	  }
}
