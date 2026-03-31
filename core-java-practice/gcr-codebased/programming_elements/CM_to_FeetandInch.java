package programming_elements;
import java.util.*;
public class CM_to_FeetandInch {
	public static void main(String[]args) {
		System.out.println("enter height in cm");
		Scanner sc = new Scanner(System.in);
		int cm = sc.nextInt();
		double inch = cm * 2.54;
		double foot = inch * 12 ;
		
		System.out.println("Your height in cm is "+ cm+ " while in feet is "+ foot + " and inches is "+ inch);
	}
}