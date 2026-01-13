package Regex;
import java.util.*;
import java.util.regex.*;

public class ReplaceBadWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] badWords = {"damn" , "stupid" , "shit"};
		
		String og = sc.nextLine();
		
		
		for(String bad : badWords) {
			 og = og.replaceAll("(?i)\\b" + bad + "\\b", "****");
			
		}
		 System.out.println(og);
	}
}
