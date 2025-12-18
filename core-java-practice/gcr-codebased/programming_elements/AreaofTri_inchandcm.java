package programming_elements;
import java.util.*;
public class AreaofTri_inchandcm {
	public static void main(String[]args) {
		System.out.println("Enter base and height");
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		int h = sc.nextInt();
		
		double area = 0.5 * b * h;
		// i sq in = 0.155 sq cm
		double area2 = area * 0.155;
		
		System.out.println("The area of the triangle in sq in is "+area2+" and in sq cm is "+area);
		
	}
}
