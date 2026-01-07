package collections;
import java.util.*;

public class GenerateBinaryNumbers {
 
    public static void main(String[] args) {
        int N = 5;
        generateBinary(N);
    }
    
    public static void generateBinary(int n) {

        if (n <= 0) return;

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            System.out.print(current + " ");

            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}

