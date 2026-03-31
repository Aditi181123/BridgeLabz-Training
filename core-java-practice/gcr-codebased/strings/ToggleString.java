package strings;
import java.util.*;
public class ToggleString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String");
		String str = sc.next();
		
		int a = str.length();
		
		System.out.print("Toggeled String : ");
		
		for(int i = 0 ; i < a ; i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch <= 'z' ) {
				System.out.print((char)(ch - 32));
			}
			else if(ch >= 'A' && ch <= 'Z') {
				System.out.print((char)(ch + 32));
			}
			else {
				System.out.print(ch);
			}
		}
		
	}
}
