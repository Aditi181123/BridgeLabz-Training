package programming_elements;
import java.util.*;

public class Feets_to_YardsandMiles {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter distance in feet");
		int feet = sc.nextInt();
		int yards = feet * 3 ;
		int mile = yards * 1760;
		
		System.out.println("Your height in feet is "+ feet + " while in yards is "+yards+" and in miles is "+mile );
		
	}
}
