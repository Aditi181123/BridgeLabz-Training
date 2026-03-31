package generics;

import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

class book implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

class cloth implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class gadget implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println("Product: " + name + ", Price: " + price + ", Category: " + category.getCategoryName());
    }
}

class MarketUtils {
    public static <T extends Product<?>> void discount(T product, double percentage) {
        double disprice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(disprice);
        System.out.println("Applied " + percentage + "% discount on " + product.getName());
    }

    public static void catalog(List<Product<? extends Category>> catalog) {
        for (Product<? extends Category> product : catalog) {
            product.display();
        }
    }
}

public class DynamicMarketplace {
    public static void main(String[] args) {
        List<Product<? extends Category>> catalog = new ArrayList<>();

        Product<book> book = new Product<>("Java Programming", 499.99, new book());
        Product<cloth> shirt = new Product<>("T-Shirt", 299.49, new cloth());
        Product<gadget> phone = new Product<>("Smartphone", 14999.00, new gadget());

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        MarketUtils.discount(book, 10);
        MarketUtils.discount(shirt, 15);
        MarketUtils.discount(phone, 5);

        System.out.println("Catalog After Discounts");
        MarketUtils.catalog(catalog);
    }
}
