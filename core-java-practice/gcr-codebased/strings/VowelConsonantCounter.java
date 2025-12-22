package strings;
import java.util.Scanner;

public class VowelConsonantCounter {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   
        System.out.print("Enter the string: ");
        String text = sc.nextLine();
    
        int[] count = findVowelAndConsonant(text);
   
        System.out.println("\nVowels count: " + count[0]);
        System.out.println("Consonants count: " + count[1]);
 
    }
    
    public static String check(char ch) {

       
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || 
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    public static int[] findVowelAndConsonant(String text) {
        int vCount = 0;
        int cCount = 0;

        for (int i = 0; i < text.length(); i++) {
            String res = check(text.charAt(i));

            if (res.equals("Vowel")) {
                vCount++;
            } else if (res.equals("Consonant")) {
                cCount++;
            }
        }

        return new int[]{vCount, cCount};
    }

    
}
