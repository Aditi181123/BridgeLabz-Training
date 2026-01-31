package streamsAPI;
import java.util.*;

public class IoTSensorReadings {
    public static void main(String[] args) {

        List<Integer> readings = List.of(30, 70, 90, 40);

        readings.stream()
                .filter(r -> r > 60)
                .forEach(System.out::println);
    }
}
