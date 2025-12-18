package programming_elements;

import java.util.Scanner;

public class VolumeOfCylinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		double h = sc.nextDouble();
		double volume = Math.PI *r*r*h;
		System.out.println(volume);
	}

}
