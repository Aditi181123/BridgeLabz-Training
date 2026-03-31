package controls_flows;
import java.util.*;
public class sumUntil0WhileandBreak {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int num ;
		int sum = 0 ;
		
		while(true) {
			System.out.print("Enter num to add and 0 or -ve num to stop : ");
			num = sc.nextInt();
			if(num <= 0) {
				break;
			}
			sum = sum + num;
		}
		System.out.println("Total sum : " + sum);
	}
}
