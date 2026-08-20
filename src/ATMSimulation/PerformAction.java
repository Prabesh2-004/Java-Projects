package ATMSimulation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerformAction {
    private void balanceModify(AccountInfo accountInfo, Scanner scanner, int userChoice) {
        System.out.print("Please enter how much you want to " + (userChoice == 2 ? "deposit: " : userChoice == 3 ? "withdraw: " : "Invalid Input"));
        try {
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                if (userChoice == 2) {
                    accountInfo.deposit(amount);
                } else if (userChoice == 3){
                    accountInfo.withdraw(amount);
                } else {
                    System.out.println("Invalid Input");
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("Invalid Input \"" + invalidInput + "\"");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }


    private void showOption(AccountInfo accountInfo, Scanner scanner) {
        boolean isATMStarted = true;
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Balance");
            System.out.println("3. Withdraw Balance");
            System.out.println("4. Exit");
            System.out.print("Please Enter what you want to perform: ");
            try {
                if (scanner.hasNextInt()) {
                    int userChoice = scanner.nextInt();
                    System.out.println();
                    switch (userChoice) {
                        case 1 -> System.out.println(accountInfo.getBalance());
                        case 2, 3 -> balanceModify(accountInfo, scanner, userChoice);
                        case 4 -> isATMStarted = false;
                        default -> System.out.println("Please enter specified number only");
                    }
                } else {
                    String invalidInput = scanner.next();
                    System.out.println("Invalid Input \"" + invalidInput + "\"");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        } while (isATMStarted);
    }

    public void startATM(AccountInfo accountInfo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------");
        System.out.println(" Welcome to SanuBank ATM ");
        System.out.println("-------------------------");
        System.out.println();

        int pinEnter = 0;
        boolean isPinIncorrect = true;
        do {
            System.out.print("Please enter you PIN: ");
            try {
                if (scanner.hasNextInt()) {
                    pinEnter++;
                    int userEnteredPin = scanner.nextInt();
                    if (userEnteredPin == accountInfo.getPin()) {
                        isPinIncorrect = false;
                        showOption(accountInfo, scanner);
                    } else {
                        if (pinEnter == 3) {
                            System.out.println("Maximum attempt used please try again later. ");
                        } else {
                            System.out.println("Invalid PIN! Please try again");
                        }
                    }
                } else {
                    String invalidInput = scanner.next();
                    System.out.println("Invalid Input \"" + invalidInput + "\" value must be in Integer");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        } while (pinEnter != 3 && isPinIncorrect);

        scanner.close();
    }
}
