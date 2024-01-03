package Task3;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double cgpa;

    public Student(String name, int age, double cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Student otherStudent) {
        if (cgpa == otherStudent.cgpa) {
            return 0;
        } else if (cgpa > otherStudent.cgpa) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", CGPA: " + cgpa;
    }


}
