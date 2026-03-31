package strings;
import java.util.*;
public class PalindromeCheck {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String str = sc.next();
		
		int len = str.length();
		
		boolean palin = true;
		
		for(int i = 0 ; i < len / 2 ; i++) {
			if(str.charAt(i) != str.charAt(len-i-1)) {
				palin = false;
				break;
			}
		}
		
		if(palin) {
			System.out.println("String is palindrome");
		}
		else {
			System.out.println("String is not palindrome");
		}
	}
}
