package multi_threading;
import java.time.LocalDateTime;

public class BankingSystem {

	public static void main(String[] args) throws InterruptedException {
		BankAccount acc = new BankAccount();

		Thread T1 = new Thread(new Transaction(acc, "Customer-1" , 1000));
		T1.setName("Customer-1");
		System.out.println(T1.getName() + " Thread State Before Start: " + T1.getState());
		T1.start();

		Thread T2 = new Thread(new Transaction(acc, "Customer-2" , 5000));
		T2.setName("Customer-2");
		System.out.println(T2.getName() + " Thread State Before Start: " + T2.getState());
		T2.start();
		
		Thread T3 = new Thread(new Transaction(acc, "Customer-3" , 6000));
		T3.setName("Customer-2");
		System.out.println(T3.getName() + " Thread State Before Start: " + T3.getState());
		T3.start();
		
		
		Thread T4 = new Thread(new Transaction(acc, "Customer-4" , 14000));
		T4.setName("Customer-2");
		System.out.println(T4.getName() + " Thread State Before Start: " + T4.getState());
		T4.start();
	}

}

class BankAccount{
	private int balance = 10000;
	public int getBalance() {
		return balance;
	}

	public boolean withdraw(String customer , int amount) {

		System.out.println("[ " + customer + " ] : Attempting to Withdraw " + amount );

		if(balance >= amount) {
			try {
				Thread.sleep(100);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			int bal = balance - amount;
			System.out.println("Transaction successful: " + customer + ", Amount: " + amount + ", Balance: " + bal + ", Time: "
					+ LocalDateTime.now());
			return true;
		}
		else {
			System.out.println("Transaction failure: " + customer + ", Amount: " + amount + ", Insufficient Balance: " + balance + ", Time: "
					+ LocalDateTime.now());
			return false;
		}
	}
}

class Transaction implements Runnable{
	private BankAccount account;
	private String customer;
	private int amount;

	public Transaction(BankAccount acc , String name , int amt) {
		this.account =acc;
		this.customer = name;
		this.amount = amt;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " State Before: " + Thread.currentThread().getState());
		account.withdraw(customer, amount);
	}

}