package collections;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);

        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
                result.add(num);
            
        }

        System.out.println(result);
    }
}
