package programming_elements;
import java.util.*;
public class Total_Purchases {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter unit price and quantity");
		int uP = sc.nextInt();
		int quan = sc.nextInt();
		int total = uP * quan;
		
		System.out.println("The total purchase price is INR "+total+" if the quantity "+quan+" and unit price is IMR "+uP);
		
	}
}
