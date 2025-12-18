package programming_elements;

public class University_fee_discount {
	public static void main(String[]args) {
		int fee = 125000;
		int disP = 10;
		int dis = (fee * disP )/ 100;
		int remain = fee - dis;
		System.out.println("The discount amount is INR "+ dis + " and final discounted fee is INR "+ remain);
		
	}
}
