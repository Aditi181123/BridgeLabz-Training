package M1Questions;
import java.util.*;

public class GlobalShipmentManifestValidator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		while(true) {
			for(int i = 1 ; i <= n ; i++) {
				String str = sc.next();
				sc.nextLine();
				if(Solution.valid(str)) {
					System.out.println("COMPLIANT RECORD" );
				}
				else {
					System.out.println("NON-COMPLIANT RECORD" );
				}
			}
		}
	}
}

class Solution{
	public static boolean valid(String str) {
		String [] arr = str.split("\\|");
		String code = arr[0];
		String date = arr[1];
		String mode = arr[2];
		String weight = arr[3];
		String status = arr[4];

		if(validcode(code) && validdate(date) && validmode(mode)
				&& validweight(weight) && validstatus(status)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean validcode(String code) {
		if(!code.matches("SHIP-[1-9]\\d{5}")) {
			return false;
		}

		String str = code.substring(5);

		int count = 1;
		for(int i = 1 ; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i-1)) {
				count++;
			}
			if(count > 3) {
				return false;
			}	
		}
		return true;
	}
	public static boolean validdate(String data) {
		if(!data.matches("20\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])")) {
			return false;
		}
		String[] d = data.split("\\-");
		int year = Integer.parseInt(d[0]);
		int month = Integer.parseInt(d[1]);
		int date = Integer.parseInt(d[2]);

		if(month < 1 && month > 12) {
			return false;
		}

		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			days[1] = 29;
		}

		return date >= 1 && date <= days[month-1];
	}

	public static boolean validmode(String mode) {
		if(mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT")) {
			return true;
		}
		return false;
	}
	public static boolean validweight(String weight) {
		if (!weight.matches("(0|[1-9]\\d*)(\\.\\d{1,2})?")) {
			return false;
		}
		double w = Double.parseDouble(weight);
		if(w < 0 || w > 999999.99) {
			return false;
		}
		return true;
	}
	public static boolean validstatus(String status) {
		if(status.matches("DELIVERED|CANCELLED|IN_TRANSIT")) {
			return true;}
		return false;
	}
}
