package strings;
import java.util.*;
public class CompareTwoStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		boolean equal = str1.equals(str2);
		
		System.out.println("Result from built-in String method : " + equal);
		
		boolean compare = Compare(str1,str2);
		System.out.println("Result from user defined method : " + compare);
		
		if(equal == compare) {
			System.out.println("Both methods gives same result.");
		}
		else {
			System.out.println("Both methods gives different result.");
		}
	}

	private static boolean Compare(String str1, String str2) {
		// TODO Auto-generated method stub
		if(str1.length() != str2.length()) {
			return false;
		}
		
		for(int i = 0 ; i < str1.length(); ++i) {
			if(str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
