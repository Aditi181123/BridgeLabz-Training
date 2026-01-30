package Junit_Test.test;

public class program {
	private double balance;
	public program(double bal) {
		this.balance = bal;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Deposit amount cannot be negative");
		}
		balance += amount;
	}
	
	public void withdraw(double amount){
		if(amount > balance) {
			throw new IllegalArgumentException("Insufficient funds.");
		}
		
		balance -= amount;
	}
}
