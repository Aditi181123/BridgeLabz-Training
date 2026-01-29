package functionalInterfaces;

interface SensitiveData { 
}

class CustomerDetails implements SensitiveData {

	private String name;
	private String ssn;

	CustomerDetails(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	public String toString() {
		return "CustomerDetails [name: " + name + ", ssn: " + ssn + "]";
	}
}

class ProductInfo {
	String productName = "Health Insurance";
}

class EncryptionService {

	static void process(Object obj) {

		if (obj instanceof SensitiveData) {
			System.out.println("Encrypting sensitive data: " + obj);
		} else {
			System.out.println("No encryption required for: " + obj);
		}
	}
}

public class SensitiveDataApp {

	public static void main(String[] args) {

		CustomerDetails customer = new CustomerDetails("Aditi", "123-45-6789");
		ProductInfo product = new ProductInfo();

		EncryptionService.process(customer);
		EncryptionService.process(product);
	}
}
