package M1Questions;
import java.util.*;

public class KeyGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Generation gen = new Generation();
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0 ; i < n ; i++) {
			String str = sc.nextLine();
			gen.validate(str);
		}
	}

}

class Generation{
	public static void validate(String str) {
		if(str.isEmpty()) {
			System.out.println("Invalid Input (empty string)");
			return;
		}
		if(str.length() < 6 ) {
			System.out.println("Invalid Input (length < 6)");
			return;
		}
		if(str.contains(" ")) {
			System.out.println("Invalid Input (contains space)");
			return ;
		}
		if(str.matches(".*\\d.*")) {
			System.out.println("Invalid Input (contains digits)");
			return;
		}
		if(str.matches(".*[^0-9a-zA-Z].*")) {
			System.out.println("Invalid Input (contains special character)");
			return;
		}
		
		System.out.println("The generated key is - " + generate(str));
	}
	
	public static String generate(String str) {
		String low = str.toLowerCase();
		String asc = "";
		for(int i = 0 ; i < low.length(); i++) {
			char ch =  low.charAt(i);
			
			int ascii = ch;
			
			if(ascii % 2 == 0 ) {
				asc += "";
			}
			else {
				asc += ch;
			}
		}
		String rev = "";
		for(int i = asc.length() - 1 ; i >= 0 ; i--) {
			char ch = asc.charAt(i);
			rev += ch;
		}
		String res = "";
		for(int i = 0 ; i < rev.length(); i++) {
			char ch = rev.charAt(i);
			if(i % 2 == 0) {
				int ascii = ch - 32;
				res += (char) ascii;
			}
			else {
				res += ch;
			}
		}
		return res;
	}
}
