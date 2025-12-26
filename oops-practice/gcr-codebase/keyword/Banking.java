package keyword;

public class Banking {
	// Static variable
	public static String BankName = "State Bank Of India";
	public static int TAccounts = 0;

	// final keyword
	public final String accNum ;
	private String AccHolderName;
	private double balance;

	Banking(String accNum , String Name , double balance){
		this.AccHolderName = Name;
		this.accNum = accNum;
		this.balance = balance;
		TAccounts++;
	}

	public static void NumAcc( int TAccounts) {
		System.out.println("Total Accounts : " + TAccounts);
	}

	void display() {
		if(this instanceof Banking) {
			System.out.println("\nBank Name : " + BankName);
			System.out.println("Account Number : " + accNum);
			System.out.println("Account Holder Name : " + AccHolderName);
			System.out.println("Total Balance : " + balance);
		}
		else {
			System.out.println("Invalid Bank Account ");
		}
	}

	// getter setter
	public String getAccHolder() {
		return AccHolderName;
	}
	public void setAccHolder(String AccHolderName) {
		this.AccHolderName = AccHolderName;
	}

	public double balance() {
		return balance;
	}

	public void deposit(double n ) {
		if(n > 0) {
			balance += n;
			System.out.println("new balance : "+ balance);
		}
		else {
			System.out.println("You are depositing invalid amount");
		}
	}

	public void withdraw(double n) {
		if(n > 0 && n < balance) {
			balance -= n ;
			System.out.println("new Balance " + balance);
		}
		else {
			System.err.println("You are withdrawing invalid ammount or insuffcient balance.");
		}
	}

	public static void main(String[] args) {
		Banking account1 = new Banking("ACC12345", "Tanya",1000.00);
		Banking account2 = new Banking("ACC67890", "Somya ",500.00);

		System.out.println("\nAccount 1 Details:");
		account1.display();
		System.out.println("\nAccount 2 Details:");
		account2.display();

		Banking.NumAcc(TAccounts);

		System.out.println("\nPerforming transactions");
		account1.deposit(200);
		account1.withdraw(150);
		account1.display();
		account2.display();
		account2.deposit(100);
		account2.withdraw(800);

	}

}
