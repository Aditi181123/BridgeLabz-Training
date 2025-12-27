package pillars_of_oops;

interface Taxable {
	double calculateTax();
	String getTaxDetails();
}
abstract class Product implements Taxable{
	private int Pid;
	private String name;
	private double price;
	
	public Product(int Pid , String name , double price) {
		this.Pid = Pid;
		this.name = name;
		this.price = price;
	}
	
	public int getPid() {
		return Pid;
	}
	
	public String getname() {
		return name;
	}
	
	public double getprice() {
		return price;
	}
	
	public void setprice(double price) {
		this.price = price;
	}
	
	public abstract double calculateDiscount();
	
	void display() {
		System.out.println("\nProduct id : " + Pid);
		System.out.println("Product name : " + name);
		System.out.println("Price : " + price);
		System.out.println("Tax Details : " + getTaxDetails());
	}
}

class Electronics extends Product implements Taxable{

	public Electronics(int Pid, String name, double price) {
		super(Pid, name, price);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double calculateDiscount() {
		// TODO Auto-generated method stub
		return getprice() * 0.10;
	}
	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return getprice() * 0.18;
	}

	@Override
	public String getTaxDetails() {
		// TODO Auto-generated method stub
		return "Electronics Tax 18% " ;
	}
}

class Clothing extends Product implements Taxable{
	
	public Clothing( int Pid ,String name , double price) {
		super(Pid , name , price);
	}
	
	@Override
	public double calculateDiscount() {
		return getprice() * 0.10;
	}
	@Override
	public double calculateTax() {
		return getprice() * 0.20;
	}
	
	@Override
	public String getTaxDetails() {
		return "Clothing Tax 20%" ;
	}
}

class Groceries extends Product implements Taxable{
	public Groceries (int Pid , String name , double price) {
		super(Pid, name , price);
	}
	
	@Override
	public double calculateDiscount() {
		return getprice() * 0.10;
	}
	@Override
	public double calculateTax() {
		return getprice() * 0.08;
	}
	
	public String getTaxDetails() {
		return "Grocries Tax 8% " ;
	}
}
public class ECommercePlatform{
	 public static void finalprice(Product[] products) {
	     for (Product product : products) {
	         product.display();

	         double discount = product.calculateDiscount();
	         double tax = 0;

	         if (product instanceof Taxable) {
	             Taxable taxable = (Taxable) product;
	             tax = taxable.calculateTax();
	             System.out.println(taxable.getTaxDetails());
	         }

	         double finalPrice = product.getprice() + tax - discount;
	         System.out.printf("Discount: ₹%.2f\n", discount);
	         System.out.printf("Tax: ₹%.2f\n", tax);
	         System.out.printf("Final Price: ₹%.2f\n", finalPrice);
	     }
	 }
	public static void main(String[] args) {
		Product p1 = new Electronics(101, "Smartphone", 20000);
		Product p2 = new Clothing(102, "Jeans", 1500);
		Product p3 = new Groceries(103, "Rice", 1000);
		
		 Product[] productList = {p1, p2, p3};
	     finalprice(productList);
	     }
	
}
