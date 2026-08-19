package NumberGuessingGame;

import java.util.Scanner;

public class Main {

    public void startGame(Scanner scanner) {
        boolean isPlaying = true;


        while (isPlaying) {
            System.out.println();
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println("4. Exit");
            System.out.print("choose a Level: ");
            try {
                if (scanner.hasNextInt()) {
                    int userChoice = scanner.nextInt();
                    switch (userChoice) {
                        case 1, 2, 3 -> gameLevel(userChoice, scanner);
                        case 4 -> isPlaying = false;
                        default -> System.out.println("Please enter a number that are specified above. ");
                    }
                } else {
                    String invalidInput = scanner.next();
                    System.out.println("Invalid input: " + invalidInput + " . Please enter a valid number (1-4).");
                    throw new IllegalArgumentException("Invalid input provided: " + invalidInput);
                }
            } catch (Exception e) {
                System.out.println("Exception " + e.getMessage());
            }

        }
    }

    public void gameLevel(int difficulty, Scanner scanner) {
        int easyMaxAttempt = 15, mediumMaxAttempt = 10, hardMaxAttempt = 5;

        switch (difficulty) {
            case 1 -> playGame(scanner, easyMaxAttempt);
            case 2 -> playGame(scanner, mediumMaxAttempt);
            case 3 -> playGame(scanner, hardMaxAttempt);
            default -> System.out.println("Invalid Input");
        }
    }

    public void playGame(Scanner scanner, int maxAttempts) {
        int randomNumber = (int) (Math.random() * 100) + 1;
        try {
            int attemptCount = 0;
            int guesses;
            do {
                System.out.print("Enter your guessed number 1 to 100: ");
                if (scanner.hasNextInt()) {
                    guesses = scanner.nextInt();
                    if (guesses > 100 || guesses < 1) {
                        System.out.println("Please enter a number 1 to 100");
                    } else {
                        attemptCount++;
                        if (randomNumber > guesses) {
                            System.out.println("Low");
                        } else if (randomNumber < guesses) {
                            System.out.println("High");
                        }
                        if (guesses == randomNumber) {
                            System.out.println("Correct Guess! It was " + randomNumber + " and you took " + attemptCount + " attempts"
                            );
                        } else if (maxAttempts == attemptCount){
                            System.out.println("Out of Attempts. " + randomNumber + " was actual answer.");
                        }
                    }
                } else {
                    String invalidInput = scanner.next();
                    System.out.println("Invalid input: " + invalidInput + " . Please enter a valid number (1-100).");
                    throw new IllegalArgumentException("Invalid input provided: " + invalidInput);
                }
            } while (guesses != randomNumber && maxAttempts != attemptCount);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println(" Welcome to number guessing Game ");
        System.out.println("---------------------------------");

        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.startGame(scanner);
        scanner.close();
    }
}
