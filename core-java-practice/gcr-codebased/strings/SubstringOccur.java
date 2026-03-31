package strings;
import java.util.*;
public class SubstringOccur {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String ");
		String main = sc.next();
		
		System.out.println("Enter a SubString");
		String sub = sc.next();
		
		int count = 0 ;
		
		for(int i = 0 ; i <= main.length() - sub.length() ; i++) {
			boolean match = true;
			for(int j = 0 ; j < sub.length() ; j++) {
				if(main.charAt(i + j ) != sub.charAt(j)) {
					match = false;
					break;
				}
			}
			if(match) {
				count++;
			}
			
		}
		System.out.println("Number of Occurence SubString made : "+count);
	}
}
