package Regex;
import java.util.*;
import java.util.regex.*;

public class ExtractCapitalWords {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence with e mmails");
		
		String str = sc.nextLine();
		
		String regex = "\\b[A-Z][a-z]*\\b";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		boolean firstword = false;
		
		while(matcher.find()) {
			String word = matcher.group();
			
			if(!firstword && str.startsWith(word)) {
				firstword = true;
				continue;
			}
			
			System.out.print(word+ ", ");
		}
	}
}
