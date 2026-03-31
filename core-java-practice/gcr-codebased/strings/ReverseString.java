package strings;
import java.util.*;
public class ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String str = sc.next();
		
		String rev = "";
		int a = str.length();
		for(int i = a-1 ; i >=0 ; i--) {
			rev += str.charAt(i);
			
		}
		System.out.println("Reverse String : " + rev);
	}
}
