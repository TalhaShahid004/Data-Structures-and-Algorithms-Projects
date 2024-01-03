public class Student implements Comparable<Student> {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Student otherStudent) {
        if (id == otherStudent.id) {
            return 0;
        } else if (id > otherStudent.id) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Name: " + name + ", id: " + id;
    }

}


