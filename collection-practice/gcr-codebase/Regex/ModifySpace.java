package Regex;
import java.util.*;

public class ModifySpace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence");
		
		String str = sc.nextLine();
		
		String replaced = str.replaceAll("\\s+" , " ");
		
		System.out.println("Replaced String: " + replaced);
	}
}
