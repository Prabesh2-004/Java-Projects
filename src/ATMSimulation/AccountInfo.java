package ATMSimulation;

public class AccountInfo {
    private double accountBalance = 0;
    private final int accountPin = 1234;

    public double getBalance() {
        return accountBalance;
    }

    public int getPin() {
        return accountPin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > accountBalance) {
            System.out.println("Insufficient Balance");
        } else if (amount < 1) {
            System.out.println("Invalid balance");
        } else {
            accountBalance -= amount;
        }
    }
}
