package extra;
import java.util.Scanner;

public class PalindromeChecker {
	 public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	        String str = sc.next();
	        boolean result = isPalindrome(str);
	        if (result) {
	            System.out.println("Palindrome");
	        } else {
	            System.out.println("Not Palindrome");
	        }
	        
	    }
   
    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

   
}
