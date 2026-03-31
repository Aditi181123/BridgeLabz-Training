package Regex;
import java.util.*;
import java.util.regex.*;

public class ExtractDate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence");
		
		String str = sc.nextLine();
		
		String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {
			System.out.println("Dates : " + matcher.group());
		}
	}
}
