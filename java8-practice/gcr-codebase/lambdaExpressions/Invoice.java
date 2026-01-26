package lambdaExpressions;
import java.util.*;
import java.util.stream.*;

class InvoiceDetails {
    String transactionId;

    InvoiceDetails(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice for Txn: " + transactionId;
    }
}

public class Invoice{
    public static void main(String[] args) {

        List<String> transactionIds = List.of("TXN1001", "TXN1002", "TXN1003");

        List<InvoiceDetails> invoices =
                transactionIds.stream()
                              .map(InvoiceDetails::new)
                              .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}