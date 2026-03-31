package lambdaExpressions;

import java.util.*;

public class UpperCaseNames {
    public static void main(String[] args) {

        List<String> names = List.of("rahul", "neha", "amit");

        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}