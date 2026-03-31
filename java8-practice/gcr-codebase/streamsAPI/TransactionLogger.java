package streamsAPI;
import java.time.*;
import java.util.*;

public class TransactionLogger {
    public static void main(String[] args) {

        List<String> transactionIds = List.of("TXN1001", "TXN1002");

        transactionIds.forEach(id ->
                System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
