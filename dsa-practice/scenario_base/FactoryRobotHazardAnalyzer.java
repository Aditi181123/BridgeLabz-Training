package scenario_base;
import java.util.*;

class RobotSafetyException extends Exception{
	public RobotSafetyException (String message) {
		super(message);
	}
}

class RobotHazardAuditor{
	public double CalculateHazardRisk(double arm, int worker, String state) throws RobotSafetyException {
		ValidArmPrecision(arm);
		ValidWorkerDensity(worker);
		
		double risk = MachineRiskFactor(state);
		double hazard = ((1.0 - arm) * 15.0) + (worker * risk);
		
		return hazard;
	}
	
	private double MachineRiskFactor(String state) throws RobotSafetyException {
		ValidMachineryState(state);
		double risk = 0;
		if(state.equalsIgnoreCase("worn")) {
			risk = 1.3;
		}
		else if(state.equalsIgnoreCase("faulty")){
			risk = 2.0;
		}
		else {
			risk = 3.0;
		}
		return risk;
	}

	public boolean ValidArmPrecision(double arm) throws RobotSafetyException {
		if(arm < 0.0 || arm > 1.0) {
			throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0.");
		}
		else {
			return true;
		}
	}
	public boolean ValidWorkerDensity(int worker) throws RobotSafetyException{
		if(worker < 1 || worker > 20) {
			throw new RobotSafetyException("Error: Worker density must be 1-20.");
		}
		else {
			return true;
		}
	}
	
	public boolean ValidMachineryState(String state) throws RobotSafetyException{
		String[] str = {"worn" , "faulty" , "critical"};
		
		for(String s : str) {
			if(state.equalsIgnoreCase(s)){
				return true;
			}
		}
		throw new RobotSafetyException("Error: Unsupported machinery state.");
	}
}
public class FactoryRobotHazardAnalyzer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Arm Precision (0.0 - 1.0):");
		double arm = sc.nextDouble();
		
		System.out.println("Enter Worker Density (1 - 20):");
		int density = sc.nextInt();
		
		System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
		String state = sc.next();
		try {
		RobotHazardAuditor robo = new RobotHazardAuditor();
		robo.ValidArmPrecision(arm);
		robo.ValidWorkerDensity(density);
		robo.ValidMachineryState(state);
		
		double cal = robo.CalculateHazardRisk(arm, density, state);
		
		System.out.println("Robot Hazard Risk Score: " + cal);
		}
		catch(RobotSafetyException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
