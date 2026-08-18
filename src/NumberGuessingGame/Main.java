package NumberGuessingGame;

import java.util.Scanner;

public class Main {

    public void Easy() {
        int randomNumber = (int) (Math.random() * 10) + 1;
        int numberOfGuess = 0;

        Scanner scanner = new Scanner(System.in);

        int guesses;
        try {
            do {
                System.out.print("Enter your guessed number 1 to 10: ");
                guesses = scanner.nextInt();
                if (guesses > 10 | guesses < 1) {
                    System.out.println("Please enter a number 1 to 10");
                } else {
                    numberOfGuess++;
                    if (randomNumber > guesses) {
                        System.out.println("Low");
                    } else if (randomNumber < guesses) {
                        System.out.println("High");
                    } else {
                        System.out.println("Correct Guess! It was " + randomNumber + " and you took " + numberOfGuess + " attempts");
                    }
                }
            } while (guesses != randomNumber);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }


    }

    public void Medium() {
        int randomNumber = (int) (Math.random() * 50) + 1;
        int numberOfGuess = 0;

        Scanner scanner = new Scanner(System.in);

        int guesses;
        try {
            do {
                System.out.print("Enter your guessed number 1 to 50: ");
                guesses = scanner.nextInt();
                if (guesses > 50 | guesses < 1) {
                    System.out.println("Please enter a number 1 to 50");
                } else {
                    numberOfGuess++;
                    if (randomNumber > guesses) {
                        System.out.println("Low");
                    } else if (randomNumber < guesses) {
                        System.out.println("High");
                    } else {
                        System.out.println("Correct Guess! It was " + randomNumber + " and you took " + numberOfGuess + " attempts");
                    }
                }
            } while (guesses != randomNumber);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }


    }

    public void High() {
        int randomNumber = (int) (Math.random() * 100) + 1;
        int numberOfGuess = 0;
        Scanner scanner = new Scanner(System.in);

        int guesses;
        try {
            do {
                System.out.print("Enter your guessed number 1 to 100: ");
                guesses = scanner.nextInt();
                if (guesses > 100 | guesses < 1) {
                    System.out.println("Please enter a number 1 to 100");
                } else {
                    numberOfGuess++;
                    if (randomNumber > guesses) {
                        System.out.println("Low");
                    } else if (randomNumber < guesses) {
                        System.out.println("High");
                    } else {
                        System.out.println("Correct Guess! It was " + randomNumber + " and you took " + numberOfGuess + " attempts");
                    }
                }
            } while (guesses != randomNumber);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

    }

    public static void main(String[] args) {
        boolean isPlaying = true;

        Main main = new Main();

        System.out.println("---------------------------------");
        System.out.println(" Welcome to number guessing Game ");
        System.out.println("---------------------------------");

        Scanner scanner = new Scanner(System.in);

        while (isPlaying) {
            System.out.println();
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println("4. Exit");
            System.out.print("choose a Level: ");
            int userChoice = scanner.nextInt();
            System.out.println();
            try {
                switch (userChoice) {
                    case 1 -> main.Easy();
                    case 2 -> main.Medium();
                    case 3 -> main.High();
                    case 4 -> isPlaying = false;
                    default -> System.out.println("Please enter a number that are specified above. ");
                }
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }

        }
        scanner.close();
    }
}
