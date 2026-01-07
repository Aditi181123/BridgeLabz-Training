package collections;
import java.util.*;

public class GroupEmployees {

    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee e : employees) {
            grouped
                .computeIfAbsent(e.department, k -> new ArrayList<>())
                .add(e);
        }

        System.out.println(grouped);
    }
}

