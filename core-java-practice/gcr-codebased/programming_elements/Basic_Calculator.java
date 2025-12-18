package programming_elements;
import java.util.*;
public class Basic_Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();

        float sum = num1 + num2;
        float difference = num1 - num2;
        float product = num1 * num2;
        float division = num2 != 0 ? num1 / num2 : 0;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " 
            + num1 + " and " + num2 + " is " 
            + sum + ", " + difference + ", " + product + ", and " + division);
        sc.close();
	}


}