package lambdaExpressions;
import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    int discount;

    Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " | Rs. " + price + " | " + rating + " | " + discount + "%";
    }
}

public class ProductSort {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 20000, 4.5, 10));
        products.add(new Product("Laptop", 60000, 4.7, 20));
        products.add(new Product("Headphones", 3000, 4.2, 30));

        // Sort by price
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));

        // Sort by rating
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));

        // Sort by discount
        products.sort((p1, p2) -> Integer.compare(p2.discount, p1.discount));

        products.forEach(System.out::println);
    }
}