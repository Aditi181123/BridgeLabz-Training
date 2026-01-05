package review;
import java.util.*;

class User {
 private String uId;
 private String name;

 public User(String userId, String name) {
     this.uId = userId;
     this.name = name;
 }

 public String getUId() {
     return uId;
 }

 public String getName() {
     return name;
 }
}

class Driver {
 private String dId;
 private String dname;
 private boolean available;

 public Driver(String dId, String dname) {
     this.dId = dId;
     this.dname = dname;
     this.available = true;
 }

 public String getdId() {
     return dId;
 }

 public String getName() {
     return dname;
 }

 public boolean available() {
     return available;
 }

 public void setavailable(boolean available) {
     this.available = available;
 }
}


class Ride {
 private int rideId;
 private User u;
 private Driver d;
 private double dis;
 private double fare;

 public Ride(int rideId, User u, Driver d, double dis, double fare) {
     this.rideId = rideId;
     this.u = u;
     this.d = d;
     this.dis = dis;
     this.fare = fare;
 }


public int getRideId() {
     return rideId;
 }

 public User getUser() {
     return u;
 }

 public Driver getDriver() {
     return d;
 }

 public double getDistance() {
     return dis;
 }

 public double getFare() {
     return fare;
 }
}


interface FareCalculator {
 double calculateFare(double distance);
}


class Normal implements FareCalculator {
 private static final double price = 10.0;

 @Override
 public double calculateFare(double distance) {
     return distance * price;
 }
}

class PeakC implements FareCalculator {
 private static final double price = 15.0;

 @Override
 public double calculateFare(double distance) {
     return distance * price;
 }
}

class NoDriverAvailableException extends Exception {
 public NoDriverAvailableException(String message) {
     super(message);
 }
}

class RideManagementSystem {
 private Map<Integer, Ride> rides;
 private Queue<Driver> availableDrivers;
 private FareCalculator fareC;

 public RideManagementSystem(FareCalculator fareCalculator) {
     this.rides = new HashMap<>();
     this.availableDrivers = new LinkedList<>();
     this.fareC = fareCalculator;
 }

 public void addD(Driver driver) {
     if (driver.available()) {
         availableDrivers.add(driver);
     }
 }

 public Ride bookRide(User u, double dis) throws NoDriverAvailableException {
     if (availableDrivers.isEmpty()) {
         throw new NoDriverAvailableException("No drivers available at the moment.");
     }

     Driver driver = availableDrivers.poll();
     driver.setavailable(false);
     int rideId = (int)Math.random();
     double fare = fareC.calculateFare(dis);
     Ride ride = new Ride(rideId, u, driver, dis, fare);

     rides.put(rideId, ride);
     return ride;
 }

 public void completeRide(int rideId) {
     Ride ride = rides.get(rideId);
     if (ride != null) {
         Driver driver = ride.getDriver();
         driver.setavailable(true);
         availableDrivers.add(driver);
         System.out.println("Ride completed: " + rideId + ", Fare: " + ride.getFare());
     }
 }
}

public class CabBooking {
 public static void main(String[] args) {
     FareCalculator normal = new Normal();
     FareCalculator peek = new PeakC();

     RideManagementSystem system = new RideManagementSystem(normal);

     User u1 = new User("U001", "Alice");
     User u2 = new User("U002", "Bob");

     Driver d1 = new Driver("D001", "John");
     Driver d2 = new Driver("D002", "Mike");

     system.addD(d1);
     system.addD(d2);

     try {
         Ride ride1 = system.bookRide(u1, 12.5);
         System.out.println("Ride booked: " + " Fare: " + ride1.getFare());

         Ride ride2 = system.bookRide(u2, 8.0);
         System.out.println("Ride booked: "  + " Fare: " + ride2.getFare());

         system.completeRide(ride1.getRideId());
         system.completeRide(ride2.getRideId());

     } catch (NoDriverAvailableException e) {
         System.out.println(e.getMessage());
     }


    
     RideManagementSystem addR = new RideManagementSystem(peek);
     addR.addD(d1);
     addR.addD(d2);

     try {
         Ride ride3 = addR.bookRide(u1, 10.0);
         System.out.println("Ride booked: " + " Fare: " + ride3.getFare());
     } catch (NoDriverAvailableException e) {
         System.out.println(e.getMessage());
     }

 }
}


