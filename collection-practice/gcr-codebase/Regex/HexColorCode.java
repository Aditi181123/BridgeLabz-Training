package Regex;
import java.util.*;
import java.util.regex.*;

public class HexColorCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a hex color code starts with # ");
		
		String str = sc.next();
		
		String regex = "^#[A-Fa-f0-9]{6}";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(str);
		
		System.out.println(str + " is Valid " + matcher.matches() );
	}
}
