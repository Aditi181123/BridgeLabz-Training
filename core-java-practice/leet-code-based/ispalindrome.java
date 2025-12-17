import java.util.*;

public class ispalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter  a  number: ");
        int n = sc.nextInt();

        int a = n ;
        int r = 0;

        while (n != 0) {
            int d = n % 10;
            r = r * 10 + d;
            n = n / 10;
        }

        if (a == r) {
            System.out.println("Palindrome number");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
