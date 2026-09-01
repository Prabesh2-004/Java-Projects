package StudentManagementSystem;

public class StudentDetailsModifier {
    private int age;
    private int id;
    private double marks;
    private String name;

    StudentDetailsModifier(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMarks(double marks) {
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
