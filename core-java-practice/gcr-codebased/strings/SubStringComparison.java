package strings;
import java.util.*;
public class SubStringComparison {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter String and start and end index for substring : ");
		String str = sc.next();
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		String subStringCharAt = subStringCharAT(str, start , end);
		
		String subStringBuiltIn = str.substring(start, end);
		
		boolean compare = compare(subStringCharAt , subStringBuiltIn);
		
		System.out.println("SubSTring By Built in Method : " + subStringBuiltIn);
		System.out.println("SubSTring By Char At Method : " + subStringBuiltIn);
		
		System.out.println("Is Both SubString SAME ? \n " + compare);
		
	}
	private static boolean compare(String str1, String str2) {
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
	private static String subStringCharAT(String str, int start, int end) {
		// TODO Auto-generated method stub
		String res = "";
		for(int i = start ; i < end ;++i) {
			res += str.charAt(i);
		}
		return res ;
	}
	
}
