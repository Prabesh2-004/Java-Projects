package StudentManagementSystem;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentsOperation {
    int currentIndexPosition = 0;

    public void addStudents(StudentDetailsModifier[] student, Scanner scanner) {
        int id = 0;
        String name = "";
        int age = 0;
        double marks = 0;
        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.print("Enter a student Id: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    isRunning = false;
                } else {
                    String invalidInput = scanner.next();
                    System.out.println(invalidInput + ": is a invalid id type use number");
                }
            }
            isRunning = true;
            System.out.print("Enter a student name: ");
            name = scanner.nextLine();

            while (isRunning) {
                System.out.print("Enter a age of the Student: ");
                if (scanner.hasNextInt()) {
                    age = scanner.nextInt();
                    isRunning = false;
                } else {
                    String invalidInput = scanner.next();
                    System.out.println(invalidInput + ": is a invalid age type use number");
                }
            }
            isRunning = true;
            while (isRunning) {
                System.out.print("Enter a marks of the student: ");
                if (scanner.hasNextDouble()) {
                    marks = scanner.nextDouble();
                    isRunning = false;
                } else {
                    String invalidInput = scanner.next();
                    System.out.println(invalidInput + ": is a invalid marks type use number");
                }
            }
            student[currentIndexPosition] = new StudentDetailsModifier(id, name, age, marks);
            currentIndexPosition++;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getAllStudent(StudentDetailsModifier[] student) {
        System.out.println();
        for (int i = 0; i < currentIndexPosition; i++) {
            System.out.println(student[i].getId() + " " + student[i].getName() + " " + student[i].getAge() + " " + student[i].getMarks());
        }
        System.out.println();
    }

    public void luncher() {
        Scanner scanner = new Scanner(System.in);
        StudentDetailsModifier[] student = new StudentDetailsModifier[3];
//        student[0] = new StudentDetailsModifier(1, "Alex", 12, 89);
//        student[1] = new StudentDetailsModifier(2, "John", 10, 85);
//        student[2] = new StudentDetailsModifier(3, "Tony", 14, 70);

        boolean running = true;
        while (running) {
            try {
                System.out.println("1. Add Students");
                System.out.println("2. Display All Students");
                System.out.println("3. Search Students");
                System.out.println("4. Update Students");
                System.out.println("5. Delete Students");
                System.out.println("6. Calculate average marks of the students");
                System.out.println("7. Highest marks Student");
                System.out.println("8. Exit");

                System.out.print("Choose you operation: ");
                if (scanner.hasNextInt()) {
                    int userChoice = scanner.nextInt();
                    switch (userChoice) {
                        case 1 -> addStudents(student, scanner);
                        case 2 -> getAllStudent(student);
                        case 3 -> System.out.println("Choice Three");
                        case 4 -> System.out.println("Choice Four");
                        case 5 -> System.out.println("Choice Five");
                        case 6 -> System.out.println("Choice Six");
                        case 7 -> System.out.println("Choice Seven");
                        case 8 -> running = false;
                        default -> System.out.println("Invalid Choice! Please insert listed Options");
                    }
                } else {
                    scanner.next();
                    System.out.println("Invalid Input Please use number format");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }
}
