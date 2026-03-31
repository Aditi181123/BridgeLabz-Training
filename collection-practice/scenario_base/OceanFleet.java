package scenario_base;
import java.util.*;

class Vessel{
	private String vesselId;
	public String vesselName;
	private double avgSpeed;
	public String vesselType;

	public Vessel() {

	}

	public Vessel(String id , String name , double avg , String type) {
		this.setVesselId(id);
		this.vesselName = name;
		this.setAvgSpeed(avg);
		this.vesselType = type;
	}

	public String getVesselId() {
		return vesselId;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public void display() {
		System.out.println(vesselId + " | " + vesselName + " | " + vesselType + " | " + getAvgSpeed() + " knots");
	}
}

class VesselUtil{
	private List<Vessel> vList = new ArrayList<>();

	public List<Vessel> getvList() {
		return vList;
	}

	public void setvList(List<Vessel> vList) {
		this.vList = vList;
	}

	public void addVesselPerformance(Vessel vessel) {
		vList.add(vessel);
	}

	public Vessel getVesselById(String vesselId) {
		for(Vessel v : vList) {
			if(v.getVesselId().equalsIgnoreCase(vesselId)) {
				return v;
			}
		}
		return null;

	}

	public List<Vessel> getHighPerformanceVessels() {
		List<Vessel> high = new ArrayList<>();
		double max = 0;

		for(Vessel v : vList) {
			if(v.getAvgSpeed() > max) {
				max = v.getAvgSpeed();
			}
		}

		for(Vessel v : vList) {
			if(v.getAvgSpeed() == max) {
				high.add(v);
			}
		}
		return high;

	}

}

public class OceanFleet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VesselUtil util = new VesselUtil();
		System.out.println("Enter the number of vessels to be added");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter vessel details");
		for(int i = 0 ; i < n ; i++) {
			String str = sc.nextLine();
			String[] arr = str.split(":");

			Vessel v = new Vessel(arr[0] , arr[1] , Double.parseDouble(arr[2]) , arr[3] );
			util.addVesselPerformance(v);
		}
		
		System.out.println("Enter the Vessel Id to check speed");
		String Id = sc.next();
		
		Vessel found = util.getVesselById(Id);
		
		if(found != null) {
			System.out.println(Id + " | " + found.vesselName + " | " + found.vesselType + " | " + found.getAvgSpeed() + " knots");
		}
		else {
			System.out.println("Vessel Id " + Id + " not found.");
		}
		
		System.out.println("High performance vessels are");
		List<Vessel> high = util.getHighPerformanceVessels();
		for(Vessel v : high) {
			System.out.println(v.getVesselId() + " | " + v.vesselName + " | " + v.vesselType + " | " + v.getAvgSpeed() + " knots");
		}
		
	}
}
