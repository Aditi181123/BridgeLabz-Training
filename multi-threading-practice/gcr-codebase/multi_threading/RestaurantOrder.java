package multi_threading;

public class RestaurantOrder {
    public static void main(String[] args) throws InterruptedException {

        Chef c1 = new Chef("Chef-1", "Pizza", 3000);
        Chef c2 = new Chef("Chef-2", "Pasta", 2000);
        Chef c3 = new Chef("Chef-3", "Salad", 1000);
        Chef c4 = new Chef("Chef-4", "Burger", 2500);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        c1.join();
        c2.join();
        c3.join();
        c4.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}

class Chef extends Thread {

    private String dish;
    private int cookTime; 

    public Chef(String name, String dish, int cookTime) {
        super(name); 
        this.dish = dish;
        this.cookTime = cookTime;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started preparing " + dish);

        int step = cookTime / 4;

        try {
            Thread.sleep(step);
            System.out.println(getName() + " preparing " + dish + ": 25% complete");

            Thread.sleep(step);
            System.out.println(getName() + " preparing " + dish + ": 50% complete");

            Thread.sleep(step);
            System.out.println(getName() + " preparing " + dish + ": 75% complete");

            Thread.sleep(step);
            System.out.println(getName() + " preparing " + dish + ": 100% complete");

            System.out.println(getName() + " finished " + dish);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
