package M1Questions;
import java.util.*;

abstract class Festival {
    String name, location, date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void display();
}

class MusicFestival extends Festival {
    String headliner, genre;
    int price;

    MusicFestival(String name, String location, String date, String headliner, String genre, int price) {
        super(name, location, date);
        this.headliner = headliner;
        this.genre = genre;
        this.price = price;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + genre);
        System.out.println("Ticket Price: " + price);
    }
}

class FoodFestival extends Festival {
    String cuisine;
    int stalls, fee;

    FoodFestival(String name, String location, String date, String cuisine, int stalls, int fee) {
        super(name, location, date);
        this.cuisine = cuisine;
        this.stalls = stalls;
        this.fee = fee;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + stalls);
        System.out.println("Entry Fee: " + fee);
    }
}

class ArtFestival extends Festival {
    String artType;
    int artists, fee;

    ArtFestival(String name, String location, String date, String artType, int artists, int fee) {
        super(name, location, date);
        this.artType = artType;
        this.artists = artists;
        this.fee = fee;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + artists);
        System.out.println("Exhibition Fee: " + fee);
    }
}

public class FestivalManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Festival> map = new HashMap<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("EXIT")) break;

            String[] parts = line.split(" ");

            if (parts[0].equals("ADD_FESTIVAL")) {
                String type = parts[1];

                if (type.equals("MUSIC")) {
                    Festival f = new MusicFestival(parts[2], parts[3], parts[4], parts[5], parts[6], Integer.parseInt(parts[7]));
                    map.put(parts[2], f);
                } else if (type.equals("FOOD")) {
                    Festival f = new FoodFestival(parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
                    map.put(parts[2], f);
                } else if (type.equals("ART")) {
                    Festival f = new ArtFestival(parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
                    map.put(parts[2], f);
                }
            } else if (parts[0].equals("DISPLAY_DETAILS")) {
                Festival f = map.get(parts[1]);
                if (f != null) f.display();
            }
        }
    }
}