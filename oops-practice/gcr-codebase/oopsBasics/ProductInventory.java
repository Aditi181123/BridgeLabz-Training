package oopsBasics;

public class ProductInventory {
	String PName;
	int price;
	static int tProduct;
	
	ProductInventory(String PName, int price){
		this.PName = PName;
		this.price = price;
		tProduct++;
	}
	
	void displayI(){
		System.out.println("Product Name : " + PName);
		System.out.println("Price : " + price);
	}
	void displaytP(){
		System.out.println("Total Products : "+ tProduct);
	}
	
	public static void main(String[] args) {
		ProductInventory product1 = new ProductInventory("p1" , 150);
		
		product1.displayI();
		product1.displaytP();
		
		ProductInventory product2 = new ProductInventory("p2" , 140);
		product2.displayI();
		product2.displaytP();
		
	}
}
