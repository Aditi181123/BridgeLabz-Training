package JUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTest {

    Performance service = new Performance();

    @Test
    @Timeout(2) // seconds
    void testLongRunningTaskPerformance() throws InterruptedException {
        service.longRunningTask();
    }
}