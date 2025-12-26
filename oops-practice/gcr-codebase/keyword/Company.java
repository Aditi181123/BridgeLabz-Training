package keyword;

public class Company {
	// static variable
	private static String companyName;
	private static int totalEmployees = 0;
	// final keyword
	private String name;
	private final int id;
	private String designation;

	public Company(String name, int id, String designation) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		totalEmployees++;
	}

	public static void setCompanyName(String name) {
		companyName = name;
	}

	public static void TotalEmp() {
		System.out.println("Total Employees: " + totalEmployees);
	}

	public void display() {

		if (this instanceof Company) {
			System.out.println("Company Name: " + companyName);
			System.out.println("Employee ID: " + id);
			System.out.println("Name: " + name);
			System.out.println("Designation: " + designation);
		} else {
			System.out.println("Invalid Employee Details .");
		}
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getDesignation() {
		return designation;
	}


	public static void main(String[] args) {

		Company.setCompanyName("Tech Solutions Inc.");

		Company emp1 = new Company("Thamarai", 101, "Software Engineer");
		Company emp2 = new Company("Rohan", 102, "Project Manager");

		Company.TotalEmp();

		emp1.display();
		emp2.display();
	}

}
