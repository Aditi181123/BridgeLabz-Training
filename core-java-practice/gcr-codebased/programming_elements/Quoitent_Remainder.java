package programming_elements;
import java.util.*;
public class Quoitent_Remainder {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int q = a / b ;
		int r = a % b ;
		System.out.println("The quoitent is "+q+" and reaminder is "+r+" of two number "+a+" and "+b);;
	}
}
