package Regex;
import java.util.*;
import java.util.regex.*;

public class LicensePlate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a License Number");
		
		String str = sc.next();
		
		String regex = "^[A-Z]{2}[0-9]{4}";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(str);
		
		System.out.println(str + " is Valid " + matcher.matches() );
	}
}
