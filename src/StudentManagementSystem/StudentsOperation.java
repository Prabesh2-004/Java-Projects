package StudentManagementSystem;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentsOperation {
    int currentIndexPosition = 0;

    public void addStudents(StudentDetails[] student, Scanner scanner) {
        int id = 0;
        String name = "";
        int age = 0;
        double marks = 0;
        boolean isRunning = true;
        boolean found = false;
        try {
            while (isRunning) {
                System.out.print("Enter a student Id: ");
                if (scanner.hasNextInt()) {
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < currentIndexPosition; i++) {
                        if (student[i].getId() == userId) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Studnet with this Id already exist");
                    } else {
                        id = userId;
                        break;
                    }
                    found = false;
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
            if (currentIndexPosition != student.length) {
                student[currentIndexPosition] = new StudentDetails(id, name, age, marks);
                currentIndexPosition++;
            } else {
                System.out.println("Out of memory cannot add more students");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input didn't match user text in text type and number in number type" + e.getMessage());
        }

    }

    public void getAllStudents(StudentDetails[] student) {
        for (int i = 0; i < currentIndexPosition; i++) {
            System.out.println(student[i].getId() + " " + student[i].getName() + " " + student[i].getAge() + " " + student[i].getMarks());
        }
    }

    public void searchStudent(Scanner scanner, StudentDetails[] student) {
        boolean userNotFound = true;
        System.out.print("Enter a name or Id to search for Student: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            for (int i = 0; i < currentIndexPosition; i++) {
                if (id == student[i].getId()) {
                    System.out.println(student[i].getId() + " " + student[i].getName() + " " + student[i].getAge() + " " + student[i].getMarks());
                    userNotFound = false;
                }
            }
        } else {
            String name = scanner.next().toLowerCase();
            for (int i = 0; i < currentIndexPosition; i++) {
                if (name.equals(student[i].getName().toLowerCase())) {
                    System.out.println(student[i].getId() + " " + student[i].getName() + " " + student[i].getAge() + " " + student[i].getMarks());
                    userNotFound = false;
                }
            }
        }

        if (userNotFound) {
            System.out.println("Student Not Found");
        }

    }

    public void updateStudent(StudentDetails[] student, Scanner scanner) {
        boolean notFound = true;
        boolean isValidInput = true;
        String name = "";
        int age = 0;
        double marks = 0;
        for (int i = 0; i < currentIndexPosition; i++) {
            System.out.println(student[i].getId() + " " + student[i].getName() + " " + student[i].getAge() + " " + student[i].getMarks());
        }

        try {
            System.out.print("Choose student to Update using their ID: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < currentIndexPosition; i++) {
                    if (student[i].getId() == id) {
                        System.out.print("Enter a name " + "(Previous name was " + student[i].getName() + "): ");
                        name = scanner.nextLine();
                        while (isValidInput) {
                            System.out.print("Enter a age " + "(Previous age was " + student[i].getAge() + "): ");
                            if (scanner.hasNextInt()) {
                                age = scanner.nextInt();
                                isValidInput = false;
                            } else {
                                String invalidInput = scanner.next();
                                System.out.println(invalidInput + ": is invalid input please use number");
                            }
                        }
                        isValidInput = true;
                        while (isValidInput) {
                            System.out.print("Enter a marks " + "(Previous marks was " + student[i].getMarks() + "): ");
                            if (scanner.hasNextDouble()) {
                                marks = scanner.nextDouble();
                                isValidInput = false;
                            } else {
                                String invalidInput = scanner.next();
                                System.out.println(invalidInput + ": is a invalid input please number");
                            }
                        }

                        student[i].setName(name);
                        student[i].setAge(age);
                        student[i].setMarks(marks);

                        notFound = false;
                    }
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println(invalidInput + ": is not a valid ID");
                notFound = false;
            }

            if (notFound) {
                System.out.println("User not found");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(StudentDetails[] student, Scanner scanner) {
        boolean notFound = true;
        for (int i = 0; i < currentIndexPosition; i++) {
            System.out.println(student[i].getId() + " " + student[i].getName() + " " + student[i].getAge() + " " + student[i].getMarks());
        }

        try {
            System.out.print("Enter student you wanna delete using ID: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                for (int i = 0; i < currentIndexPosition; i++) {
                    if (student[i].getId() == id) {
                        for (int j = i; j < currentIndexPosition - 1; j++) {
                            student[j].setId(student[j + 1].getId());
                            student[j].setName(student[j + 1].getName());
                            student[j].setAge(student[j + 1].getAge());
                            student[j].setMarks(student[j + 1].getMarks());
                        }
                        currentIndexPosition--;
                        student[currentIndexPosition].setId(0);
                        student[currentIndexPosition].setName(null);
                        student[currentIndexPosition].setAge(0);
                        student[currentIndexPosition].setMarks(0);
                        notFound = false;
                        break;
                    }
                }
            }

            if (notFound) {
                System.out.println("User not found");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void averageMarks(StudentDetails[] student) {
        if (currentIndexPosition != 0) {
            double marks = 0;
            for (int i = 0; i < currentIndexPosition; i++) {
                marks += student[i].getMarks();
            }
            System.out.println(marks / currentIndexPosition);
        } else {
            System.out.println("Please add at least 1 Student data");
        }
    }

    public void highestMarks(StudentDetails[] student) {
        double highest = student[0].getMarks();
        int id = 0;
        String name = "";
        for (int i = 0; i < currentIndexPosition; i++) {
            if (student[i].getMarks() > highest) {
                highest = student[i].getMarks();
                id = student[i].getId();
                name = student[i].getName();
            }
        }
        System.out.println("Highest mark " + highest + " which is achieve by " + name + " whose roll is " + id);
    }

    public void launcher() {
        Scanner scanner = new Scanner(System.in);
        StudentDetails[] student = new StudentDetails[10];

        boolean running = true;
        while (running) {
            try {
                System.out.println();
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
                        case 2 -> getAllStudents(student);
                        case 3 -> searchStudent(scanner, student);
                        case 4 -> updateStudent(student, scanner);
                        case 5 -> deleteStudent(student, scanner);
                        case 6 -> averageMarks(student);
                        case 7 -> highestMarks(student);
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
