package programming_elements;

public class Profit_and_Loss {
	public static void main(String[] args) {
		int cp = 129;
		int sp = 191;
		int profit = sp - cp;
		double profitpercent = ((double)profit / cp) * 100;
		
		System.out.println("The cost price is INR " + cp + " and Selling Price is INR "+ sp +"\nThe Profit is INR "+ profit +" and the Profit Percentage is " + profitpercent);
		
		
	}

}
