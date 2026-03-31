package programming_elements;
import java.util.*;
public class Side_of_Square {
	public static void main(String[]args) {
		System.out.println("enter the perimeter of square");
		Scanner sc = new Scanner(System.in);
		int peri = sc.nextInt();
		int side = peri / 4 ;
		
		System.out.println("The length of the side is " + side + " whose perimeter is " + peri);
		
	}

}
