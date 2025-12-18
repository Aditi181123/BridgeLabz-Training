package leetcode_codebase;

import java.util.Scanner;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int ans = 0, num = 0, temp = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }

            if (num < temp) {
                ans -= num;
            } else {
                ans += num;
            }
            temp = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roman number: ");
        String s = sc.nextLine();

        System.out.println("Integer value: " + romanToInt(s));

        sc.close();
    }
}
