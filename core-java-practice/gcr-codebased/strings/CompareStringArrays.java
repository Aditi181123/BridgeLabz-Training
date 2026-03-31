package strings;
import java.util.*;
public class CompareStringArrays {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String : ");
		String str = sc.next();
		
		char [] charArr = CharAtArray(str);
		
		char [] builtArr = str.toCharArray();
		
		boolean compare = Compare(charArr , builtArr);
		
		System.out.print("String Array By Char At : " );
		for (char c : charArr) {
		    System.out.print(c + " ");
		}

		
		System.out.print(" \nString Array By Built in Method : ");
		for (char c : builtArr) {
		    System.out.print(c + " ");
		}

		
		System.out.println(" \nIs both String Arrays Same ? \n " + compare);
	}
	
	private static boolean Compare(char[] charArr, char[] builtArr) {
		// TODO Auto-generated method stub
		
		if(charArr.length != builtArr.length) {
			return false;
		}
		
		for(int i = 0 ; i < charArr.length ; i++) {
			if(charArr[i] != builtArr[i]) {
				return false;
			}
		}
		return true;
	}

	private static char[] CharAtArray(String str) {
		char [] arr = new char[str.length()];
		
		for(int i = 0 ; i < str.length() ; ++i) {
			arr[i] = str.charAt(i);
		}
		return arr;
	}
	
}
