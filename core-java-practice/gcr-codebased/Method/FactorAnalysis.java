package Method;

import java.util.Scanner;

public class FactorAnalysis {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factor = findFactors(num);

        System.out.print("Factors: ");
        for (int f : factor) System.out.print(f + " ");
        System.out.println();

        System.out.println("Sum of factors: " + sumOfFactors(factor));
        System.out.println("Product of factors: " + productOfFactors(factor));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factor));
       
    }
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int sumOfFactors(int[] fact) {
        int sum = 0;
        for (int i : fact) {
            sum += i;
        }
        return sum;
    }

    public static int productOfFactors(int[] fact) {
        int product = 1;
        for (int i : fact) {
            product *= i;
        }
        return product;
    }

    public static int sumOfSquares(int[] fact) {
        int sum = 0;
        for (int i : fact) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }

}