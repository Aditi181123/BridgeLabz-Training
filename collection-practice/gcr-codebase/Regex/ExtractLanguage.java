package Regex;
import java.util.*;
import java.util.regex.*;

public class ExtractLanguage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String regex = "\\b(Java|Python|JavaScript|C\\+\\+|C#|Go|Ruby|PHP|Swift|Kotlin)\\b";
		

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {
			System.out.println("Programing Language: " + matcher.group());
		}
	}
}
