package StudentManagementSystem;

public class StudentDetailsModifier {
    int age;
    int id;
    double marks;
    String name;

    StudentDetailsModifier(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
    public double getMarks() {
        return this.marks;
    }

}
