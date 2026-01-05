package review;

public class NonRepeated {
	public static void main(String[] args) {
		String str = "swiss";
		
		char res = nonreapted(str);
		System.out.println(res);
		
	}

	private static char nonreapted(String str) {
		 int[] freq = new int[256];
	        int len = str.length();

	        for (int i = 0; i < len; i++) {
	            int ascii = str.charAt(i);
	            freq[ascii]++;
	        }

	        for (int i = 0; i < len; i++) {
	            int ascii = str.charAt(i);
	            if (freq[ascii] == 1) {
	                return str.charAt(i);
	            }
	        }

	        return '-';
	}
	
	
}
