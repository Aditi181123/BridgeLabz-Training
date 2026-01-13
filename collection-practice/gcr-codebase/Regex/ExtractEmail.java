package Regex;
import java.util.*;
import java.util.regex.*;

public class ExtractEmail {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence with e mmails");
		
		String str = sc.nextLine();
		
		String regex = "\\b[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}\\b";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		
		while(matcher.find()) {
			System.out.println("Email: " + matcher.group());
		}
	}
}
