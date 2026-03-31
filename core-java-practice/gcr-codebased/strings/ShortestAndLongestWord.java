package strings;
import java.util.Scanner;

public class ShortestAndLongestWord {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter the text: ");
         String str = sc.nextLine();
         String[] words = splitUsingCharAt(str);

	      
	     String[][] wLengthTable = getWordsWithLengths(words);

	     
         int[] idx = findShortestAndLongest(wLengthTable);

	       
         System.out.println("\nShortest Word: " + wLengthTable[idx[0]][0] + " (Length = " + wLengthTable[idx[0]][1] + ")");

	     System.out.println("Longest Word: " + wLengthTable[idx[1]][0] + " (Length = " + wLengthTable[idx[1]][1] + ")");

	       
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

        
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

      
        int[] spaces = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaces[idx++] = i;
            }
        }

        
        String[] words = new String[wordCount];
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
        lastWord = words[wordCount - 1] ;

        return words;
    }

    
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] res = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            res[i][0] = words[i];
            res[i][1] = String.valueOf(findLength(words[i]));
        }
        return res;
    }

   
    public static int[] findShortestAndLongest(String[][] wLengthTable) {
        int min = 0;
        int max = 0;

        int minLength = Integer.parseInt(wLengthTable[0][1]);
        int maxLength = minLength;

        for (int i = 1; i < wLengthTable.length; i++) {
            int currentLength = Integer.parseInt(wLengthTable[i][1]);

            if (currentLength < minLength) {
                minLength = currentLength;
                min = i;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                max = i;
            }
        }

        return new int[]{min, max};
    }

   
}
