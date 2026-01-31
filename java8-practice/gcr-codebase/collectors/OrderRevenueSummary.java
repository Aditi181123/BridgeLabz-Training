package collectors;
import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }
}

public class OrderRevenueSummary {
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Aditi", 2500),
                new Order("Rahul", 1800),
                new Order("Aditi", 3200)
        );

        Map<String, Double> revenue =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                o -> o.customer,
                                Collectors.summingDouble(o -> o.amount)
                        ));

        System.out.println(revenue);
    }
}
