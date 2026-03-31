package programming_elements;
import java.util.*;
public class double_operation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter value for a: ");
		double a = sc.nextDouble();

		System.out.print("Enter value for b: ");
		double b = sc.nextDouble();

		System.out.print("Enter value for c: ");
		double c = sc.nextDouble();

		double r1 = a + b * c;
		double r2 = a * b + c;
		double r3 = c + a / b;
		double r4 = a % b + c;

		System.out.println("The results of Double Operations are:" + r1 + r2 +r3 + " and "+ r4);
        
	}

}