package Method;
import java.util.*;
public class CheckNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a number:");
		int  n = sc.nextInt();
		
		int check = checknum(n);
		System.out.println(check);
		sc.close();
	}

	private static int checknum(int n) {
		// TODO Auto-generated method stub
		if(n < 0) {
			return -1;
		}
		else if(n == 0) {
			return 0;
		}
		else {
			return 1;
		}
	}
	

}