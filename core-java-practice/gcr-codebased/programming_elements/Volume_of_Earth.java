package programming_elements;

public class Volume_of_Earth {
	public static void main(String[] args) {
		int rofEarth = 6378;
		double rinM = rofEarth * 1.6 ;
		
		double r = Math.pow(rofEarth,3);
		double r2 = Math.pow(rinM, 3);
		double vol = (4/3) * Math.PI * r;
		double vol2 = (4/3) * Math.PI * r2;
		
		System.out.println("The volume of earth in cubic kilometers is "+ vol + " and cubic mies is " + vol2);
		
	}
}
