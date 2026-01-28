package scenario_base;
import java.util.*;
import java.util.regex.*;

class InvalidFlightException extends Exception{
	public InvalidFlightException(String message) {
		super(message);
	}
}
class FlightUtil{

	public boolean validateFlightNumber(String str) throws InvalidFlightException {
		String regex = "^FL-[1-9]\\d{3}$";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		else {
			throw new InvalidFlightException("The flight number " + str + " invalid.");
		}
	}
	public boolean validateFlightName(String str) throws InvalidFlightException{
		String[] arr = {"SpiceJet", "Vistara", "IndiGo","Air Arabia"};

		if(str == null) {
			throw new InvalidFlightException ("The flight name " + str + " invalid.");
		}

		for (String s : arr) {
			if(str.equalsIgnoreCase(s)) {
				return true;
			}
		}
		throw new InvalidFlightException ("The flight name " + str + " invalid.");
	}
	public boolean validatePassengerCount(int count, String str) throws InvalidFlightException{
		validateFlightName(str);

		int max = 0 ;

		if(str.equalsIgnoreCase("Spicejet")) {
			max = 396;
		}
		else if(str.equalsIgnoreCase("vistara")) {
			max = 615;
		}
		else if(str.equalsIgnoreCase("indigo")) {
			max = 230;
		}
		else {
			max = 130;
		}

		if(count <= 0 || count > max ) {
			throw new InvalidFlightException ("The passenger count " + count + " is invalid for " + str);
		}
		else {
			return true;
		}

	}
	public double calculateFuelToFillTank(String str, double currlevel) throws InvalidFlightException{
		validateFlightName(str);

		double maxlevel = 0 ;

		if(str.equalsIgnoreCase("Spicejet")) {
			maxlevel = 200000;
		}
		else if(str.equalsIgnoreCase("vistara")) {
			maxlevel = 300000;
		}
		else if(str.equalsIgnoreCase("indigo")) {
			maxlevel = 250000;
		}
		else {
			maxlevel = 150000;
		}

		if(currlevel < 0 || currlevel > maxlevel ) {
			throw new InvalidFlightException ("Invalid fuel for  " + str);
		}
		else {
			return maxlevel - currlevel;
		}
	}
}

public class AeroVigil {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter flight details in this format: ");
		System.out.println("<FlightNumber>:<FlightName>:<PassengerCount>:<CurrentFuelLevel>.");
		FlightUtil util = new FlightUtil();

		try {
			String str = sc.nextLine();
			String[] details = str.split(":");

			String flightNumber = details[0];
			String flightName = details[1];
			int passengerCount = Integer.parseInt(details[2]);
			double currentFuelLevel = Double.parseDouble(details[3]);

			util.validateFlightNumber(flightNumber);
			util.validateFlightName(flightName);
			util.validatePassengerCount(passengerCount, flightName);

			double capacity = util.calculateFuelToFillTank(flightName, currentFuelLevel);
			
			System.out.println("Fuel needed to fill the tank " + capacity + " liters");

		}
		catch(InvalidFlightException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}



	}
}
