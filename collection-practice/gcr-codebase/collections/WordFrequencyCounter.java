package collections;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        HashMap<String, Integer> wordCount = new HashMap<>();
 
        String filePath = "input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
 
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");
 
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word,
                                wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        System.out.println(wordCount);
    }
}
