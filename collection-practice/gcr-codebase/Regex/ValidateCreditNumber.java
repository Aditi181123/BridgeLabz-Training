package Regex;
import java.util.*;
import java.util.regex.*;

public class ValidateCreditNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Credit card Number");
		
		String num = sc.nextLine();
		
		String regex = "^[4-5]\\d{15}$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(num);
		
		System.out.println(num + " is valid " + matcher.matches());
		
	}
}
