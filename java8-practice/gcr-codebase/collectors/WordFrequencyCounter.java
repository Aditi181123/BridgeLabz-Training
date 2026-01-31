package collectors;
import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String paragraph = "java stream api java collectors api";

        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.split(" "))
                        .collect(Collectors.toMap(
                                word -> word,
                                word -> 1,
                                Integer::sum
                        ));

        System.out.println(wordCount);
    }
}
