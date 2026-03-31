package algorithmAnalysis;

public class FibonacciComputation {

    // Recursive Fibonacci Implementation (O(2^n))
    public static long recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    // Iterative Fibonacci Implementation (O(N))
    public static long interative(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] value = {10, 30, 40};
        
        System.out.println("Fibonacci Computation Performance Comparison");

        for (int N : value) {
            System.out.printf("\nFibonacci (N): %,d%n", N);

            // Recursive Measurement
            long stimeR = System.nanoTime();
            long resR = 0;
            try {
                if (N <= 45) {
                    resR = recursive(N);
                } else {
                    System.out.println("  Recursive: Skipped (N too large for practical recursive computation)");
                }
            } catch (StackOverflowError e) {
                System.out.println("  Recursive: Stack Overflow (N too large)");
            }
            long etimeR = System.nanoTime();
            long durR = (etimeR - stimeR) / 1_000_000; // milliseconds
            if (N <= 45) {
                System.out.printf("  Recursive (O(2^n)) Time: %d ms (Result: %d)%n", durR, resR);
            }

            // Iterative Measurement
            long stimeI = System.nanoTime();
            long resI = interative(N);
            long etimeI = System.nanoTime();
            long durI = (etimeI - stimeI) / 1_000_000; // milliseconds
            System.out.printf("  Iterative (O(N)) Time: %d ms (Result: %d)%n", durI, resI);
        }
     }
}