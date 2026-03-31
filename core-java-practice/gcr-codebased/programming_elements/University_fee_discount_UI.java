package programming_elements;

import java.util.*;

public class University_fee_discount_UI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter fee and discount Percent");
		Scanner sc = new Scanner(System.in);
		
		int fee = sc.nextInt();
		double DP = sc.nextDouble();
		double dis = (fee * DP )/ 100 ;
		
		double disfee = fee - dis ;
		System.out.println("The discount amount is INR "+ dis + " and final discounted fee is INR "+ disfee); 
	}

}
