package collections;
import java.util.*;

public class BankingSystem {
 
    static Map<Integer, Integer> acc = new HashMap<>();
 
    static Queue<WithDrawR> withLqueue = new LinkedList<>();
 
    static class WithDrawR {
        int accNum;
        int amount;

        WithDrawR(int accNum, int amount) {
            this.accNum = accNum;
            this.amount = amount;
        }
    }
 
    static void addAccount(int accNo, int balance) {
        acc.put(accNo, balance);
    }
 
    static void requestWithdrawal(int accNo, int amount) {
        withLqueue.add(new WithDrawR(accNo, amount));
    }
 
    static void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!withLqueue.isEmpty()) {
            WithDrawR req = withLqueue.remove();

            int balance = acc.getOrDefault(req.accNum, 0);

            if (balance >= req.amount) {
                acc.put(req.accNum, balance - req.amount);
                System.out.println("Account " + req.accNum +
                        " withdrawn ₹" + req.amount);
            } else {
                System.out.println("Account " + req.accNum +
                        " insufficient balance");
            }
        }
    }
 
    static void displayAccounts() {
        System.out.println("\nAccount Balances:");
        for (Map.Entry<Integer, Integer> entry : acc.entrySet()) {
            System.out.println("Account " + entry.getKey() +
                    " → ₹" + entry.getValue());
        }
    }
 
    static void displaySortedByBalance() {
        System.out.println("\nCustomers Sorted by Balance:");

        TreeMap<Integer, List<Integer>> balanceMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : acc.entrySet()) {
            balanceMap
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }

        for (Map.Entry<Integer, List<Integer>> entry : balanceMap.entrySet()) {
            for (int acc : entry.getValue()) {
                System.out.println("Account " + acc +
                        " → ₹" + entry.getKey());
            }
        }
    } 
    public static void main(String[] args) {

        addAccount(101, 5000);
        addAccount(102, 8000);
        addAccount(103, 3000);

        requestWithdrawal(101, 2000);
        requestWithdrawal(103, 4000);
        requestWithdrawal(102, 1000);

        displayAccounts();
        processWithdrawals();
        displayAccounts();
        displaySortedByBalance();
    }
}
