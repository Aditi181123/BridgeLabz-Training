package pillars_of_oops;

interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public abstract double calculateInterest();

    public void displayAccount() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
	public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
	public void applyForLoan(double amount) {
        System.out.println("Loan request submitted for ₹" + amount);
    }

    @Override
	public double calculateLoanEligibility() {
        return getBalance() * 0.5;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
	public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
	public void applyForLoan(double amount) {
        System.out.println("Current account loan request submitted for ₹" + amount);
    }

    @Override
	public double calculateLoanEligibility() {
        return getBalance() * 0.3;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SA123", "Alice", 50000, 4.0);
        BankAccount acc2 = new CurrentAccount("CA456", "Bob", 100000, 2.5);

        BankAccount[] accounts = {acc1, acc2};

        for (BankAccount acc : accounts) {
             acc.displayAccount();
            double interest = acc.calculateInterest();
            System.out.println("Interest: ₹" + interest);

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan(20000);
                System.out.println("Loan Eligibility: ₹" + loan.calculateLoanEligibility());
            }
         }
    }
}