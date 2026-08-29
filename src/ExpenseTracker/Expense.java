package ExpenseTracker;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Expense {
    public int indexValue = 0;

    public void addExpenses(String[] names, double[] amounts, Scanner scanner) {
        double expensesAmount = 0;
        System.out.print("Enter you item name: ");
        String expensesName = scanner.next();
        do {
            try {
                System.out.print("Enter you item amount: ");
                if (scanner.hasNextDouble()) {
                    expensesAmount = scanner.nextDouble();
                    if (expensesAmount <= 0) {
                        throw new InvalidAmount("Invalid Amount! Amount must be above 0");
                    } else {
                        if (indexValue == names.length) {
                            System.out.println("Sorry You are out of memory");
                        } else {
                            names[indexValue] = expensesName;
                            amounts[indexValue] = expensesAmount;
                            indexValue++;
                        }
                    }
                } else {
                    String invalidInput = scanner.next();
                    throw new InputMismatchException("Invalid amount \"" + invalidInput + "\"! Amount must be a number type");
                }
            } catch (InvalidAmount | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        } while (expensesAmount <= 0);

    }

    public void displayAllExpenses(String[] names, double[] amounts) {
        if (names[0] == null) {
            System.out.println("Nothing to show");
        } else {
            for (int i = 0; i < names.length; i++) {

                if (names[i] != null) {
                    System.out.println(names[i] + ": " + amounts[i]);
                } else {
                    break;
                }
            }
        }
    }

    public void totalExpenses(double[] amounts) {
        System.out.print("Your total expenses are: ");
        double sum = 0;
        for (double amount : amounts) {
            sum += amount;
        }
        System.out.println(sum);
    }

    public void highestExpenses(double[] amounts) {
        double highest = amounts[0];
        if (highest <= 0) {
            System.out.println("Please add expenses first");
        } else {
            for (double amount : amounts) {
                if (highest < amount) {
                    highest = amount;
                }
            }
            System.out.println(highest);
        }
    }

    public void searchExpenses(Scanner scanner, double[] amounts, String[] names) {
        boolean notFound = true;

        try {
            System.out.print("Enter a search amount: ");
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();

                for (int i = 0; i < amounts.length; i++) {
                    if (amounts[i] == amount) {
                        System.out.println(names[i] + ": " + amounts[i]);
                        notFound = false;
                    }
                }
            } else {
                String invalidAmount = scanner.next();
                throw new InputMismatchException("Please add valid number type amount: \"" + invalidAmount + "\" is invalid amount");
            }

            if (notFound) {
                System.out.println("No expenses found");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteExpenses(String[] names, double[] amounts, Scanner scanner) {
        boolean found = true;
        System.out.print("Enter a expenses name you want to delete: ");
        String expensesName = scanner.next();

        for (int i = 0; i < names.length; i++) {
            if (expensesName.equals(names[i])) {
                for (int j = i; j < names.length; j++) {
                    if (j == names.length - 1) {
                        break;
                    } else {
                        names[j] = names[j + 1];
                        amounts[j] = amounts[j + 1];
                    }
                }
                indexValue--;
                found = false;
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
            }

        }
    }

}
