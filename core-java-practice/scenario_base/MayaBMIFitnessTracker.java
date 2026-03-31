package scenario_base;
import java.util.Scanner;
public class MayaBMIFitnessTracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter weight(in kg) : ");
		double weight = sc.nextDouble();
		
		System.out.println("Enter height(in m) : ");
		double height = sc.nextDouble();
		
		double bmi = weight/(height * height);
		System.out.println("Your BMI : "+ bmi);
		
		if(bmi >= 30) {
			System.out.println("You are Obese");
		}
		else if(bmi >= 25 && bmi < 30) {
			System.out.println("You are OverWeight");
		}
		else if(bmi >= 18.5 && bmi < 25) {
			System.out.println("You are Normal");
		}
		else {
			System.out.println("You are UnderWeight");
		}
	}

}
