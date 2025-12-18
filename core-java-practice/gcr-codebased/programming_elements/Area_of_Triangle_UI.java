package programming_elements;
import java.util.*;

public class Area_of_Triangle_UI {
	public static void main(String[]args) {
		System.out.println("Enter the base and Height");
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int height = sc.nextInt();
		double area = 0.5 * base * height ;
		System.out.println("The area of Triangle is " + area);
	}
}
