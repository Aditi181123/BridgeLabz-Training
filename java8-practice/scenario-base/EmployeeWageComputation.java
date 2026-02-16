package scenario;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeWageComputation {

	private static final int fullday = 8;
	private static final int parttime = 8;

	interface EmpWageBuilder {
		void addCompany(String comp, int wage, int wDays, int mHours);
		void computeWages();
		int getTotalWage(String comp);
	}

	static class CompEmpWage {
		String comp;
		int wage;
		int wDays;
		int mHours;
		int twage;
		List<Integer> dWages = new ArrayList<>();

		CompEmpWage(String comp, int wage, int wDays, int mHours) {
			this.comp = comp;
			this.wage = wage;
			this.wDays = wDays;
			this.mHours = mHours;
		}
	}

	static class EmpWageManager implements EmpWageBuilder {

		private List<CompEmpWage> company = new ArrayList<>();
		private Random ran = new Random();

		public void addCompany(String comp, int wage, int wDays, int mHours) {
			company.add(new CompEmpWage(comp, wage, wDays, mHours));
		}

		private boolean isPresent() {
			return ran.nextInt(2) == 1;
		}

		private int getWorkingHours() {
			int empType = ran.nextInt(3); // 0=absent,1=full,2=part
			switch (empType) {
			case 1: return fullday;
			case 2: return parttime;
			default: return 0;
			}
		}

		private void computeCompanyWage(CompEmpWage company) {
			int tHours = 0;
			int tDays = 0;

			while (tHours < company.mHours && tDays < company.wDays) {
				tDays++;
				int hours = getWorkingHours();
				tHours += hours;
				int dWage = hours * company.wage;
				company.dWages.add(dWage);
			}

			company.twage = company.dWages.stream().mapToInt(Integer::intValue).sum();
		}

		public void computeWages() {
			company.forEach(this::computeCompanyWage);
		}

		public int getTotalWage(String comp) {
			return company.stream()
					.filter(c -> c.comp.equalsIgnoreCase(comp))
					.map(c -> c.twage)
					.findFirst()
					.orElse(0);
		}

		public void printReport() {
			company.forEach(c -> {
				System.out.println("\nCompany: " + c.comp);
				System.out.println("Daily Wages: " + c.dWages);
				System.out.println("Total Wage: " + c.twage);
			});
		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Employee Wage Computation Program");

		Scanner sc = new Scanner(System.in);
		EmpWageManager manager = new EmpWageManager();


		System.out.print("Enter number of companies: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("\nEnter details for Company " + i);

			System.out.print("Company Name: ");
			String name = sc.nextLine();

			System.out.print("Wage Per Hour: ");
			int wage = sc.nextInt();

			System.out.print("Working Days per Month: ");
			int days = sc.nextInt();
			if(days > 31) {
				System.out.println("enter valid days");
				return;
			}
			
			System.out.print("Max Working Hours per Month: ");
			int hours = sc.nextInt();
			sc.nextLine();

			manager.addCompany(name, wage, days, hours);
		}

		manager.computeWages();
		manager.printReport();

		System.out.print("\nEnter company name to get total wage: ");
		String str = sc.nextLine();
		System.out.println("Total Wage for " + str + " = " + manager.getTotalWage(str));

	}
}