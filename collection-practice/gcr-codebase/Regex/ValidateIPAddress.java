package Regex;
import java.util.*;
import java.util.regex.*;

public class ValidateIPAddress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your IP Address");
		
		String ip = sc.nextLine();
		
		String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[0-9]?\\d)\\.){3}" 
				+ "((25[0-5]|2[0-4]\\d|1\\d{2}|[0-9]?\\d))$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ip);
		
		System.out.println(ip + " is valid " + matcher.matches());
		
	}
}
