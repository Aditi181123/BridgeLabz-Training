package class_and_object;

import java.util.*;

public class Circle {
	
	//non-static variables
	double radius;
	
	//constructors
	Circle(double radius){
		this.radius=radius;
	}
	
	//Creating area method 
	public void area() {
		System.out.printf("Area of circle: %.4f",(Math.PI*radius*radius));
	}
	
	//Creating circumference method  
	public void circumference() {
		System.out.printf("\nCircumference of circle: %.4f ",(2*Math.PI*radius));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		// calling constructor
	    Circle circle = new Circle(r);
	    // calling area method
	    circle.area();

	    // calling circumference method
	    circle.circumference(); 
	}
}
