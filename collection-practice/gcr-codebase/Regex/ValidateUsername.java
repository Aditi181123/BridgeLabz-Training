package Regex;
import java.util.*;
import java.util.regex.*;

public class ValidateUsername {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Username ");
		
		String str = sc.next();
		
		String regex = "^[\\D][a-zA-Z0-9_]{4,15}";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(str);
		
        System.out.println(str + " is valid: " + matcher.matches());

	}
}
