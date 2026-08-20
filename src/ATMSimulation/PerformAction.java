package ATMSimulation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerformAction {
    private void balanceDeposit(AccountInfo accountInfo, Scanner scanner) throws InputMismatchException {
        System.out.print("Please enter how much you want to deposit: ");
        double amount = scanner.nextDouble();
        if (amount < 1) {
            System.out.println("Cannot deposit this much amount");
        } else {
            accountInfo.deposit(amount);
        }
    }

    private void balanceWithdraw(AccountInfo accountInfo, Scanner scanner) throws InputMismatchException {
        System.out.print("Please enter how much you want to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > accountInfo.balance()) {
            System.out.println("Insufficient Balance");
        } else if (amount < 1) {
            System.out.println("This amount cannot be withdraw");
        } else {
            accountInfo.withdraw(amount);
        }
    }

    private void checkPIN(int userPIN, AccountInfo accountInfo, Scanner scanner) throws InputMismatchException {
        if (userPIN == accountInfo.pin()) {
            showOption(accountInfo, scanner);
        } else {
            System.out.println("Invalid PIN! Please try again");
        }
    }

    private void showOption(AccountInfo accountInfo, Scanner scanner) throws InputMismatchException {
        boolean isATMStarted = true;
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Balance");
            System.out.println("3. Withdraw Balance");
            System.out.println("4. Exit");
            System.out.print("Please Enter what you want to perform: ");
            int userChoice = scanner.nextInt();
            System.out.println();
            switch (userChoice) {
                case 1 -> System.out.println(accountInfo.balance());
                case 2 -> balanceDeposit(accountInfo, scanner);
                case 3 -> balanceWithdraw(accountInfo, scanner);
                case 4 -> isATMStarted = false;
                default -> System.out.println("Please enter specified number only");
            }

            System.out.println();
        } while (isATMStarted);
    }

    public void startATM(AccountInfo accountInfo) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------");
        System.out.println(" Welcome to SanuBank ATM ");
        System.out.println("-------------------------");
        System.out.println();
        System.out.print("Please enter you PIN: ");
        int userEnteredPin = scanner.nextInt();

        checkPIN(userEnteredPin, accountInfo, scanner);


    }
}
