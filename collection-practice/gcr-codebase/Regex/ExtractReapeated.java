package Regex;
import java.util.*;
import java.util.regex.*;

public class ExtractReapeated {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =  sc.nextLine();
		
		String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";
		
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {
			System.out.print(matcher.group(1) + ", ");
		}
	}
}
