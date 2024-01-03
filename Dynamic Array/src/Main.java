package Task3;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Student> studentList = new MyArrayList<>();

        Student student1 = new Student("Saad", 19, 3.5);
        Student student2 = new Student("Talha", 18, 3.8);
        Student student3 = new Student("Hashir", 20, 3.2);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Student highestCGPA = studentList.findMax();
        if (highestCGPA != null) {
            System.out.println("Student with the highest CGPA:");
            System.out.println(highestCGPA);
        } else {
            System.out.println("No students in the list.");
        }

    }
}
