package scenario_base;
import java.util.*;

public class LexicalTwist {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first word: ");
		String w1 = sc.nextLine();
		if(!valid(w1)) {
			System.out.println(w1 + " is an invalid word");
			sc.close();
			return;
		}
		System.out.println("Enter second word: ");
		String w2 = sc.nextLine();

		if(!valid(w2)) {
			System.out.println(w2 + " is an invalid word");
			sc.close();
			return;
		}

		String twist =  lexical(w1 , w2);
		System.out.println("lexical twisted string : " + twist);
		sc.close();
	}
	private static boolean valid(String str) {
		str = str.trim();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}

	public static String lexical(String w1, String w2) {
		String rev = reverse(w1);
		String result = "" ;
		int vcount = 0;
		int ccount = 0;
		if(rev.equalsIgnoreCase(w2)) {
			result = case2(rev);
		}
		else {
			String cat = w1.concat(w2);
			for(int i = 0 ; i < cat.length() ; i++) {
				String str = check(cat.charAt(i));
				if(str.equalsIgnoreCase("vowel")) {
					vcount++;
				}
				else {
					ccount++;
				}
			}

			if(vcount > ccount) {
				String str = "";
				for (int i = 0; i < cat.length(); i++) {
					char ch = cat.charAt(i);
					if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u') {
						str += ch;
					}
				}
				result = firsttwo(str).toUpperCase();
			}
			else if(ccount > vcount){
				String str = "";
				for (int i = 0; i < cat.length(); i++) {
					char ch = cat.charAt(i);
					if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u') {
						str += "";
					}
					else {
						str += ch;
					}
				}
				result = firsttwo(str).toUpperCase();
			}
			else{
				result = "Vowels and consonants are equal.";
			}
		}
		return result;
	}
	private static String firsttwo(String str) {
		String res = "";
		for(int i = 0; i < str.length() ; i++) {
			char ch = str.charAt(i);
			boolean exists = false;
			for (int j = 0; j < res.length(); j++) {
				if (res.charAt(j) == ch) {
					exists = true;
					break;
				}
			}

			if (!exists) {
				res += ch;
			}

			if (res.length() == 2) {
				break;
			}
		}
		return res;
	}
	private static String reverse(String w1) {
		String rev =  "";
		for(int i = w1.length() -1 ; i >= 0 ; i--) {
			rev += w1.charAt(i);
		}
		return rev;
	}
	private static String case2(String rev) {
		String res = "";
		for (int i = 0; i < rev.length(); i++) {
			char ch = rev.charAt(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u') {
				ch = '@';
				res += ch;
			}
			else {
				res += ch;
			}
		}
		return res;
	}
	private static String check(char ch) {
		if(ch >= 'A' && ch <= 'Z') {
			ch = (char)(ch + 32);
		}
		if(ch >= 'a' && ch <= 'z') {
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u') {
				return "vowel";
			}
			else {
				return "consonent";
			}
		}
		return "not a letter";
	}
}
