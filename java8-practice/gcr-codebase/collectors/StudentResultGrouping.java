package collectors;
import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentResultGrouping {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Aditi", "A"),
                new Student("Rahul", "B"),
                new Student("Neha", "A"),
                new Student("Rohit", "B")
        );

        Map<String, List<String>> result =
                students.stream()
                        .collect(Collectors.groupingBy(
                                s -> s.grade,
                                Collectors.mapping(s -> s.name, Collectors.toList())
                        ));

        System.out.println(result);
    }
}
