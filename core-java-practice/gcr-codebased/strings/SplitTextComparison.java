package strings;
import java.util.Scanner;

public class SplitTextComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter the text: ");
        String str = sc.nextLine();

       
        String[] customSplit = splitUsingCharAt(str);

        
        String[] builtInSplit = str.split(" ");

        
        boolean result = compareStringArrays(customSplit, builtInSplit);

        
        System.out.print("\nWords using user-defined method: ");
        for (String word : customSplit) {
            System.out.print(word + " | ");
        }

        System.out.print("\nWords using split() method: ");
        for (String word : builtInSplit) {
            System.out.print(word + " | ");
        }

        System.out.println("\n\nAre both results same? " + result);

      
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

        
        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

       
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndexes.length; i++) {
            int end = spaceIndexes[i];
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
        words[wordCount - 1] = lastWord;

        return words;
    }

    
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

}
