package oopsBasics;

import java.util.Scanner;

public class RentalCars {
	String CName;
	String CModel;
	int days ;
	int rent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name ");
		String CName = sc.nextLine();
		
		System.out.println("Enter the Car model ");
		String CModel = sc.next();
		
		System.out.println("Enter number of days for renting car ");
		int n = sc.nextInt();
		
		RentalCars car = new RentalCars( CName, CModel , n );
		car.display();
		
	}
	
	RentalCars(String CName , String CModel , int day){
		this.CName = CName ;
		this.CModel = CModel;
		this.days = day;
		this.rent = Rent();
	}
	
	void display() {
		System.out.println("Customer Name : " + CName);
		System.out.println("Car Model : "+ CModel);
		System.out.println("Number of Days : "+ days);
		System.out.println("Rent of car will be : " + rent);
	}
	private int Rent() {
		int rent = switch(CModel.toLowerCase()){
			case "cara" -> 150;
			case "carx" -> 160;
			case "demo car" -> 200;
			case "sample car" -> 250;
			default -> 180;
		};
		
		return rent * days;
	}
}
