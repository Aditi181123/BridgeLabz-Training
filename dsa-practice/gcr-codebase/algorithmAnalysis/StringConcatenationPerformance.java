package algorithmAnalysis;

public class StringConcatenationPerformance {

    public static void main(String[] args) {
        int[] count = {1000, 10000, 100000}; 
        
        System.out.println("String Concatenation Performance Comparison");

        for (int N : count) {
            System.out.printf("\nOperations Count (N): %,d%n", N);

            // Using String
            long stimeS = System.nanoTime();
            String str = "";
            for (int i = 0; i < N; i++) {
                str += "a";
            }
            long etimeS = System.nanoTime();
            long durS = (etimeS - stimeS) / 1_000_000; // milliseconds
            System.out.printf("  String (O(N^2)) Time: %d ms%n", durS);

            // Using StringBuilder
            long stimeSBd = System.nanoTime();
            StringBuilder sbd = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sbd.append("a");
            }
            long etimeSBd = System.nanoTime();
            long durSBd = (etimeSBd - stimeSBd) / 1_000_000; // milliseconds
            System.out.printf("  StringBuilder (O(N)) Time: %d ms%n", durSBd);

            // Using StringBuffer
            long stimeSBf = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sbf.append("a");
            }
            long etimeSBf = System.nanoTime();
            long durSBf = (etimeSBf - stimeSBf) / 1_000_000; // milliseconds
            System.out.printf("  StringBuffer (O(N)) Time: %d ms%n", durSBf);
          
        }

      }
}