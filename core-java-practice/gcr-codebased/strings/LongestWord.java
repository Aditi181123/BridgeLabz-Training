package strings;
import java.util.*;
public class LongestWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("enter a sentence");
		String str = sc.nextLine();
		
		String[] word = str.split(" ");
		String longest = "";
		
		for(int i = 0 ; i < word.length ; i++) {
			if(word[i].length() > longest.length()) {
				longest = word[i];
			}
		}
		
		System.out.println("Longest word of the Sentence : " + longest);
	}
}
