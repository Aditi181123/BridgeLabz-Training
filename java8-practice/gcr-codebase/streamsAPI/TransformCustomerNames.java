package streamsAPI;
import java.util.*;

public class TransformCustomerNames {
    public static void main(String[] args) {

        List<String> names = List.of("aditi", "rahul", "neha");

        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
