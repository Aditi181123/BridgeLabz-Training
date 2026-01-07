package collections;
import java.util.*;

public class VotingSystem {
 
    static Map<String, Integer> voteCount = new HashMap<>();
 
    static Map<String, Integer> voteOrder = new LinkedHashMap<>();
 
    static void vote(String candidate) {
 
        voteCount.put(candidate,
                voteCount.getOrDefault(candidate, 0) + 1);
 
        voteOrder.put(candidate,
                voteOrder.getOrDefault(candidate, 0) + 1);
    }
 
    static void vorder() {
        System.out.println("\nVotes in Order Cast:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
 
    static void sresults() {
        System.out.println("\nSorted Results:");
        TreeMap<String, Integer> sorted = new TreeMap<>(voteCount);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
 
    static void dfinalC() {
        System.out.println("\nFinal Vote Count:");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        vote("Alice");
        vote("Bob");
        vote("Alice");
        vote("Carol");
        vote("Bob");

        vorder();
        dfinalC();
        sresults();
    }
}
