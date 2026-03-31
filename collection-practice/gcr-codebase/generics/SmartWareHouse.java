package generics;
import java.util.*;

abstract class WareHouse{
	String name ;
	public WareHouse(String name) {
		this.name = name;
	}
	public  String getname() {
		return name;
	}
	public abstract void getDetails();
}

class Electronics extends WareHouse{
	private String brand;
	public Electronics(String name , String brand) {
		super(name);
		this.brand = brand;
	}
	public void getDetails() {
		System.out.println("Name : " + getname() + ", Brand : " + brand);
	}
}

class Groceries extends WareHouse{
	private String expiryDate;
	public Groceries(String name , String date) {
		super(name);
		this.expiryDate = date;
	}
	public void getDetails() {
		System.out.println("Name : " + getname() + ", Brand : " + expiryDate);
	}
}

class Furniture extends WareHouse{
	private String material;
	public Furniture(String name , String material) {
		super(name);
		this.material = material;
	}
	public void getDetails() {
		System.out.println("Name : " + getname() + ", Brand : " + material);
	}
}

class Storage<T extends WareHouse>{
	private List<T> items;
	
	public Storage() {
		items = new ArrayList<T>();
	}

	public void addItems(T item) {
		items.add(item);
	}
	public List<T> getItems() {
		return items;
	}
}

class WareHouseUtils{
	public static void getAll(List<? extends WareHouse> items) {
		for(WareHouse item : items) {
			item.getDetails();
		}
	}
}

public class SmartWareHouse {
	public static void main(String[] args) {
		 Storage<Electronics> electronicsStorage = new Storage<>();
	        electronicsStorage.addItems(new Electronics("Laptop", "Dell"));
	        electronicsStorage.addItems(new Electronics("Phone", "Samsung"));

	        Storage<Groceries> groceriesStorage = new Storage<>();
	        groceriesStorage.addItems(new Groceries("Milk", "2025-01-10"));
	        groceriesStorage.addItems(new Groceries("Bread", "2025-01-05"));

	        Storage<Furniture> furnitureStorage = new Storage<>();
	        furnitureStorage.addItems(new Furniture("Chair", "Wood"));
	        furnitureStorage.addItems(new Furniture("Table", "Metal"));

	        System.out.println("All Electronics :");
	        WareHouseUtils.getAll(electronicsStorage.getItems());

	        System.out.println("\nAll Groceries :");
	        WareHouseUtils.getAll(groceriesStorage.getItems());

	        System.out.println("\nAll Furniture :");
	        WareHouseUtils.getAll(furnitureStorage.getItems());
	}
}
