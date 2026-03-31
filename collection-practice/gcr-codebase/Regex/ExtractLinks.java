package Regex;
import java.util.*;
import java.util.regex.*;

public class ExtractLinks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence");
		
		String str = sc.nextLine();
		
		String regex = "\\bhttps?://(www.)?[a-zA-Z0-9.-]+\\b";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {
			System.out.println("Links : " + matcher.group());
		}
	}
}
