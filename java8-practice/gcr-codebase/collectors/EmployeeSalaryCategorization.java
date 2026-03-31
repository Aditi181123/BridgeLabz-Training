package collectors;
import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    String getDepartment() { return department; }
    double getSalary() { return salary; }
}

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Aditi", "IT", 60000),
                new Employee("Rahul", "IT", 70000),
                new Employee("Neha", "HR", 50000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avgSalaryByDept);
    }
}
