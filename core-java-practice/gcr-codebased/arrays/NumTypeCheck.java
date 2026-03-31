package arrays;
import java.util.*;
public class NumTypeCheck {
	public static void main(String[] args) {
		System.out.println("Enter number : ");
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		for(int i = 0 ; i < 5 ; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			if(num[i] > 0) {
				if(num[i] % 2 == 0) {
					System.out.println(num[i] + " is even positive number.");
				}
				else {
					System.out.println(num[i] + " is odd positive number.");
				}
			}
			else if (num[i] < 0) {
				System.out.println(num[i] + " is a negative number.");
			}
			else {
				System.out.println(num[i] + " is zero.");
			}
		}
		
		if(num[0] < num[4]) {
			System.out.println("first element is less than last element");
		}
		else if(num[0] > num[4]) {
			System.out.println("first element is greater than last element");
		}
		else {
			System.out.println("first and last elements are equal");
		}
	}
}
