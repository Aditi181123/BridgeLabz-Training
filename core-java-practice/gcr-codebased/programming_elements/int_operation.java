package programming_elements;

import java.util.*;

public class int_operation {

	  public static void main(String[] args) {
	       
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter value for a, b, c: ");
	        int a = sc.nextInt();

	        int b = sc.nextInt();

	        int c = sc.nextInt();

	       
	        int r1 = a + b * c;     
	        int r2 = a * b + c;      
	        int r3 = c + a / b;      
	        int r4 = a % b + c;      

	        System.out.println("The results of Int Operations are:" + r1 + r2 +r3 + " and "+ r4);
	        
	  }
	        


}