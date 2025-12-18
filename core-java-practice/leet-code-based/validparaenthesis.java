package leetcode_codebase;
import java.util.*;

public class validparaenthesis {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else if (st.isEmpty()) {
                return false;
            } 
            else if (ch == ')' && st.pop() != '(') {
                return false;
            } 
            else if (ch == '}' && st.pop() != '{') {
                return false;
            } 
            else if (ch == ']' && st.pop() != '[') {
                return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter brackets string: ");
        String s = sc.nextLine();

        if (isValid(s)) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Invalid Parentheses");
        }

        sc.close();
    }
}
