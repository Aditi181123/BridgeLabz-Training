package streamsAPI;
import java.time.*;
import java.util.*;

class GymMember {
    String name;
    LocalDate expiryDate;

    GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {

        List<GymMember> members = List.of(
                new GymMember("Aditi", LocalDate.now().plusDays(10)),
                new GymMember("Rahul", LocalDate.now().plusDays(40))
        );

        members.stream()
                .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(30)))
                .forEach(m -> System.out.println(m.name));
    }
}
