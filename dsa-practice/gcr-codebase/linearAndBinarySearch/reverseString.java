package linearAndBinarySearch;

import java.util.Scanner;

public class reverseString {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }

    public reverseString(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String original = sc.nextLine();
        String reversed = reverse(original);
        sc.close();
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}