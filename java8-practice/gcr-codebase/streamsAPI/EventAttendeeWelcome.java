package streamsAPI;
import java.util.*;

public class EventAttendeeWelcome {
    public static void main(String[] args) {

        List<String> attendees = List.of("Aditi", "Rahul", "Neha");

        attendees.forEach(a ->
                System.out.println("Welcome to the event, " + a)
        );
    }
}
