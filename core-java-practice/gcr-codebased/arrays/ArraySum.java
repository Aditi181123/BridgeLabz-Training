package arrays;
import java.util.*;
public class ArraySum {
	public static void main(String[]args) {
		Scanner sc = new Scanner (System.in);
		double [] arr = new double[10];
		double total = 0.0;
		int idx = 0;
		
		while (true) {
			System.out.println("Enter numbers ( 0 or -ve to stop) :");
			 double num = sc.nextDouble();
			 
			 if(num <= 0) {
				 break;
			 }
			 
			 if(idx == 10) {
				 System.out.println("You entered 10 numbers");
				 break;
			 }
			 arr[idx] = num;
			 idx++;
		}
		
		for(int i = 0 ; i < idx ; i++) {
			total += arr[i];
		}

        System.out.println("\nEntered numbers:");
        for (int i = 0; i < idx; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nTotal sum: " + total);
		
	}
}
