package JUnit;

public class StringUtils {
	public String reverse(String str) {

		String rev = "";
		int l = str.length();

		for(int i = l-1 ; i >= 0 ; i--) {
			rev += str.charAt(i);
		}

		return rev;
	}
	
	public boolean isPalindrome(String str) {

		String rev = "";
		int l = str.length();

		for(int i = l-1 ; i >= 0 ; i--) {
			rev += str.charAt(i);
		}
		
		if(str.equals(rev)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public String uppercase(String str) {
		
		str = str.toUpperCase();
		return str;
	}
}
