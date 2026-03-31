package strings;
import java.util.Scanner;

public class WordAndLengthIn2DArray {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	      
	        System.out.print("Enter the text: ");
	        String str = sc.nextLine();

	       
	        String[] words = splitUsingCharAt(str);

	        
	        String[][] wordLengthTable = getWordsWithLengths(words);

	        
	        System.out.println("\nWord" + "\t\t" + "Length");

	        for (int i = 0; i < wordLengthTable.length; i++) {
	            String word = wordLengthTable[i][0];
	            int length = Integer.parseInt(wordLengthTable[i][1]);
	            System.out.println(word + "\t\t"+ length);
	        }

	   
	    }
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    
    public static String[] splitUsingCharAt(String str) {
        int length = findLength(str);

        
        int count = 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        
        int[] spaces = new int[count - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaces[idx++] = i;
            }
        }

        
        String[] words = new String[count];
        int start = 0;

        for (int i = 0; i < spaces.length; i++) {
            int end = spaces[i];
            String word = "";
            for (int j = start; j < end; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
            start = end + 1;
        }

       
        String lastWord = "";
        for (int i = start; i < length; i++) {
            lastWord += str.charAt(i);
        }
        words[count - 1] = lastWord;

        return words;
    }

    
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] res = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            res[i][0] = words[i];
            int len = findLength(words[i]);
            res[i][1] = String.valueOf(len);
        }

        return res;
    }

   
}

