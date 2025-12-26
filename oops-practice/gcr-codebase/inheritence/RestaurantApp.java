package inheritence;

class Person {
    String name;
    int employeeId;

    public Person(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

interface Staff {
    void performDuties();
}

class Chef extends Person implements Staff {
    String cookingStyle;

    public Chef(String name, int employeeId, String cookingStyle) {
        super(name, employeeId);
        this.cookingStyle = cookingStyle;
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Designation: Chef");
        System.out.println("Cooking Style: " + cookingStyle);
        System.out.println("Responsibility: Preparing dishes and supervising kitchen operations.");
    }
}

class Waiter extends Person implements Staff {
    int assignedTables;

    public Waiter(String name, int employeeId, int assignedTables) {
        super(name, employeeId);
        this.assignedTables = assignedTables;
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Designation: Waiter");
        System.out.println("Tables Assigned: " + assignedTables);
        System.out.println("Responsibility: Serving customers and managing table service.");
    }
}

public class RestaurantApp {
    public static void main(String[] args) {

        Chef chef = new Chef("Raj", 201, "North Indian");
        Waiter waiter = new Waiter("Priya", 202, 6);

        chef.performDuties();
        System.out.println();
        waiter.performDuties();
    }
}
