package scenario_base;
import java.util.*;

public class TheCoffeeCounterChronicles {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (true) {
		
		System.out.println("Enter coffee type : \n 1 - Espresso \n 2 - Americano \n 3 - Cappuccino \n 4 - Latte \n 5 - Mocha \n 0 - exit");
		
		int ctype = sc.nextInt();
		
		
		double gst = 0.05;
		
		int pOfc = 0 ;
		
		if(ctype == 0) {
			System.out.println("Thank You For Vising The Coffee Counter Chronicles...");
			break;
		}
		
		
		
		switch (ctype) {
		   case 1 :
			   pOfc = 89;
			   break;
		case 2 :
			pOfc = 109;
			break;
		case 3 :
			pOfc = 159;
			break;
		case 4:
			pOfc = 129;
			break;
		case 5 :
			pOfc = 179;
			break;
		default:
			System.out.println("Enter valid type.");
			continue;
		}

		System.out.print("Enter quantity : ");
		
		int quan = sc.nextInt();
		
		if(quan <= 0) {
			System.out.println("Enter valid Quantity...");
			continue;
		}
		
		int baseTotal = pOfc * quan ;
		double gstTotal  = baseTotal * gst ;
		double total = baseTotal + gstTotal;
		
		System.out.println("Base Total : " + baseTotal);
		System.out.println("GST Amount : "+ gstTotal);
		System.out.println("Payable Amount : " + total);
		
		}
	}
	
}
