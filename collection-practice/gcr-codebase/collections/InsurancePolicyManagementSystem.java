package collections;
import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagementSystem {

	// ===== Policy Class =====
	static class Policy implements Comparable<Policy> {
		int policyNumber;
		String policyHolderName;
		LocalDate expiryDate;
		String coverageType;
		double premiumAmount;

		Policy(int policyNumber, String policyHolderName,
				LocalDate expiryDate, String coverageType,
				double premiumAmount) {

			this.policyNumber = policyNumber;
			this.policyHolderName = policyHolderName;
			this.expiryDate = expiryDate;
			this.coverageType = coverageType;
			this.premiumAmount = premiumAmount;
		}

		// Uniqueness by policy number
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Policy)) return false;
			Policy p = (Policy) obj;
			return policyNumber == p.policyNumber;
		}

		@Override
		public int hashCode() {
			return Integer.hashCode(policyNumber);
		}

		// Sorting by expiry date (TreeSet)
		@Override
		public int compareTo(Policy p) {
			return this.expiryDate.compareTo(p.expiryDate);
		}

		@Override
		public String toString() {
			return policyNumber + " , " + policyHolderName + " , " +
					expiryDate + " , " + coverageType + " , ₹" + premiumAmount;
		}
	}

	// ===== Sets =====
	static Set<Policy> hashSet = new HashSet<>();
	static Set<Policy> linkedHashSet = new LinkedHashSet<>();
	static Set<Policy> treeSet = new TreeSet<>();

	// ===== Add Policy =====
	static void addPolicy(Policy p) {
		hashSet.add(p);
		linkedHashSet.add(p);
		treeSet.add(p);
	}

	// ===== Display All Policies =====
	static void display() {
		System.out.println("\nAll Unique Policies:");
		hashSet.forEach(System.out::println);
	}

	// ===== Policies Expiring in 30 Days =====
	static void expire30() {
		LocalDate limit = LocalDate.now().plusDays(30);
		System.out.println("\nPolicies Expiring Soon:");
		for (Policy p : treeSet) {
			if (!p.expiryDate.isAfter(limit)) {
				System.out.println(p);
			}
		}
	}

	// ===== Policies by Coverage Type =====
	static void coverby(String type) {
		System.out.println("\nCoverage Type: " + type);
		for (Policy p : hashSet) {
			if (p.coverageType.equalsIgnoreCase(type)) {
				System.out.println(p);
			}
		}
	}

	// ===== Duplicate Policy Numbers =====
	static void findD(List<Policy> list) {
		Set<Integer> seen = new HashSet<>();
		System.out.println("\nDuplicate Policies:");
		for (Policy p : list) {
			if (!seen.add(p.policyNumber)) {
				System.out.println(p);
			}
		}
	}

	// ===== Performance Comparison =====
	static void test(Set<Policy> set, String name) {
		Policy test = new Policy(999, "Test",
				LocalDate.now(), "Health", 5000);

		long start = System.nanoTime();
		set.add(test);
		set.contains(test);
		set.remove(test);
		long end = System.nanoTime();

		System.out.println(name + " Time: " + (end - start) + " ns");
	}

	// ===== Main Method =====
	public static void main(String[] args) {

		Policy p1 = new Policy(101, "Aditi",
				LocalDate.now().plusDays(20), "Health", 12000);
		Policy p2 = new Policy(102, "Rahul",
				LocalDate.now().plusDays(60), "Auto", 8000);
		Policy p3 = new Policy(103, "Sneha",
				LocalDate.now().plusDays(10), "Home", 15000);
		Policy p4 = new Policy(101, "Aditi",
				LocalDate.now().plusDays(20), "Health", 12000);

		addPolicy(p1);
		addPolicy(p2);
		addPolicy(p3);
		addPolicy(p4);

		display();
		expire30();
		coverby("Health");

		findD(Arrays.asList(p1, p2, p3, p4));

		System.out.println("\nPerformance Comparison:");
		test(new HashSet<>(), "HashSet");
		test(new LinkedHashSet<>(), "LinkedHashSet");
		test(new TreeSet<>(), "TreeSet");
	}
}
