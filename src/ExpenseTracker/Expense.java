package ExpenseTracker;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Expense {
    private int currentPosition = 0;

    public void addExpenses(String[] names, double[] amounts, Scanner scanner) {
        double expensesAmount = 0;
        String expensesName;
        try {
            System.out.print("Enter you item name: ");
            expensesName = scanner.next();
        } catch (NoSuchElementException e) {
            System.out.println("No input available for item name.");
            return;
        }
        do {
            try {
                System.out.print("Enter you item amount: ");
                if (scanner.hasNextDouble()) {
                    expensesAmount = scanner.nextDouble();
                    if (expensesAmount <= 0) {
                        throw new InvalidAmount("Invalid Amount! Amount must be above 0");
                    } else {
                        if (currentPosition == names.length) {
                            System.out.println("Sorry You are out of memory");
                            return;
                        } else {
                            names[currentPosition] = expensesName;
                            amounts[currentPosition] = expensesAmount;
                            currentPosition++;
                        }
                    }
                } else {
                    String invalidInput = scanner.next();
                    throw new InputMismatchException("Invalid amount \"" + invalidInput + "\"! Amount must be a number type");
                }
            } catch (InvalidAmount | InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("No input available for amount.");
                return;
            }
        } while (expensesAmount <= 0);
    }

    public void displayAllExpenses(String[] names, double[] amounts) {
        if (currentPosition == 0) {
            System.out.println("Nothing to show");
        } else {
            for (int i = 0; i < currentPosition; i++) {
                System.out.println(names[i] + ": " + amounts[i]);
            }
        }
    }

    public void totalExpenses(double[] amounts) {
        if (currentPosition == 0) {
            System.out.println("Please add expenses first");
            return;
        }
        System.out.print("Your total expenses are: ");
        double sum = 0;
        for (int i = 0; i < currentPosition; i++) {
            sum += amounts[i];
        }
        System.out.println(sum);
    }

    public void highestExpenses(double[] amounts) {
        if (currentPosition == 0) {
            System.out.println("Please add expenses first");
            return;
        }
        double highest = amounts[0];
        for (int i = 1; i < currentPosition; i++) {
            if (amounts[i] > highest) {
                highest = amounts[i];
            }
        }
        System.out.println(highest);
    }

    public void searchExpenses(Scanner scanner, double[] amounts, String[] names) {
        if (currentPosition == 0) {
            System.out.println("Please add expenses first");
            return;
        }

        boolean notFound = true;
        boolean invalid = true;

        while (invalid) {
            try {
                System.out.print("Enter a search amount: ");
                if (scanner.hasNextDouble()) {
                    double amount = scanner.nextDouble();
                    invalid = false;

                    for (int i = 0; i < currentPosition; i++) {
                        if (amounts[i] == amount) {
                            System.out.println(names[i] + ": " + amounts[i]);
                            notFound = false;
                        }
                    }

                    if (notFound) {
                        System.out.println("No expenses found");
                    }
                } else {
                    String invalidAmount = scanner.next();
                    throw new InputMismatchException("Please add valid number type amount: \"" + invalidAmount + "\" is invalid amount");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("No input available for search amount.");
                return;
            }
        }
    }

    public void deleteExpenses(String[] names, double[] amounts, Scanner scanner) {
        if (currentPosition == 0) {
            System.out.println("Please add expenses first");
            return;
        }

        boolean found = true;
        String expensesName;

        try {
            System.out.print("Enter a expenses name you want to delete: ");
            expensesName = scanner.next();
        } catch (NoSuchElementException e) {
            System.out.println("No input available for expense name.");
            return;
        }

        for (int i = 0; i < currentPosition; i++) {
            if (expensesName.equals(names[i])) {
                for (int j = i; j < currentPosition - 1; j++) {
                    names[j] = names[j + 1];
                    amounts[j] = amounts[j + 1];
                }
                currentPosition--;
                names[currentPosition] = null;
                amounts[currentPosition] = 0;
                found = false;
                break;
            }
        }

        if (found) {
            System.out.println("No expenses found");
        }
    }

    public void expensesModifier() {
        boolean isRunning = true;
        String[] names = new String[10];
        double[] amounts = new double[10];

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("1. Add Expenses");
            System.out.println("2. Get All Expenses");
            System.out.println("3. Calculate total Expenses");
            System.out.println("4. Find highest Expenses");
            System.out.println("5. Search Expenses");
            System.out.println("6. Delete Expenses");
            System.out.println("7. Exit");

            try {
                System.out.print("Choose your number: ");
                if (scanner.hasNextInt()) {
                    int userChoice = scanner.nextInt();

                    switch (userChoice) {
                        case 1 -> {
                            addExpenses(names, amounts, scanner);
                        }
                        case 2 -> {
                            displayAllExpenses(names, amounts);
                        }
                        case 3 -> {
                            totalExpenses(amounts);
                        }
                        case 4 -> {
                            highestExpenses(amounts);
                        }
                        case 5 -> {
                            searchExpenses(scanner, amounts, names);
                        }
                        case 6 -> {
                            deleteExpenses(names, amounts, scanner);
                        }
                        case 7 -> isRunning = false;
                        default -> System.out.println("Invalid Command");
                    }
                } else {
                    scanner.next();
                    throw new InputMismatchException("Enter a valid number that is specified above");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("No input available. Exiting.");
                isRunning = false;
            }

        }
    }

}
