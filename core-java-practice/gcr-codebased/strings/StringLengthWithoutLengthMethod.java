package strings;
import java.util.Scanner;
public class StringLengthWithoutLengthMethod {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a String");
		String str = sc.next();
		
		int length = findLength(str);
		
		System.out.println("Length of string : " + length);
		
		System.out.println("Length by Bulit in Method : " + str.length());
	}	
	
	private static int findLength(String str) {
		int count = 0;
		try {
			while(true) {
				str.charAt(count);
				count++ ;
			}
		}
		catch(StringIndexOutOfBoundsException e) {
			return count;
		}
	}
}
