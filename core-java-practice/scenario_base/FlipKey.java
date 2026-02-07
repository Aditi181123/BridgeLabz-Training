package scenario_base;
import java.util.*;

public class FlipKey {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String str =  sc.nextLine();
		
		System.out.println(CleanseAndInvert(str));
	}

	private static boolean isValid(String str) {
		if(str.length() <= 6) {
			return false;
		}
		if(str.matches("\s")) {
			return false;
		}
		if(!str.matches("[a-zA-Z0-9]")) {
			return false;
		}
		
		return true;
	}
	
	
	public static String CleanseAndInvert(String str) {
		String res = "";
		if(isValid(str)) {
			String asc = ASCII(str);
			String rev = reverse(asc);
			res = Camel(rev);
		}
		else {
			res = "Invalid Input";
		}
		
		return res;
	}
	
	public static String ASCII(String str) {
		String res = "";
		str = str.toLowerCase();
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			int ascii = ch;
			
			if(ascii % 2 == 0) {
				res += "";
			}
			else {
				res += ch;
			}
		}
		return res;
	}
	
	public static String reverse(String str) {
		String res = "";
		for(int i = str.length()- 1 ; i >= 0 ; i--) {
			char ch = str.charAt(i);
			res += ch;
		}
		return res;
	}
	
	public static String Camel(String str) {
		String res  = "";
		for(int i = 0 ; i < str.length(); i++) {
			if(i % 2 == 0) {
				char ch = str.charAt(i) ;
				int ascii = ch - 32;
				char ch1 =  (char) ascii;
				res += ch1;
			}
			else {
				res += str.charAt(i);
			}
		}
		return res;
	}
}
