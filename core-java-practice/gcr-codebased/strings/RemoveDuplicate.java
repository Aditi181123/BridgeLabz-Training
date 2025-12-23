package strings;
import java.util.*;
public class RemoveDuplicate {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter a String");
		String str = sc.next();
		
		String dup = "";
		int a = str.length();
		
		for(int i = 0 ; i < a ; i++) {
			char curr = str.charAt(i);
			boolean check = false;
			for(int j = 0 ; j < i ; j++) {
				if(str.charAt(j) == curr) {
					check = true;
					break;
				}
			}
			if(!check ) {
				dup += curr;
			}
		}
		System.out.println("String without duplicate character : " + dup);
	}
}
