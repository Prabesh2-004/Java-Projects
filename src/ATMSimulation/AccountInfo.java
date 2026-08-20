package ATMSimulation;

public class AccountInfo {
    private double accountBalance = 0;
    private final int accountPin = 1234;

    public double balance() {
        return accountBalance;
    }

    public int pin() {
        return accountPin;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) {
        accountBalance -= amount;
    }
}
