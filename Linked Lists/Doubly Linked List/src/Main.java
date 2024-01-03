public class Main {
    public static void main(String[] args) {
        // Test for DLinkedList<Integer>
        DLinkedList<Integer> DL1 = new DLinkedList<Integer>();

        System.out.println("Testing DLinkedList<Integer>:");

        System.out.println("Is DL1 empty? " + DL1.isEmpty());
        System.out.println("DL1 length: " + DL1.Length());

        DL1.InsertInOrder(5);
        DL1.InsertInOrder(10);
        DL1.InsertInOrder(15);
        DL1.InsertInOrder(20);
        DL1.InsertInOrder(25);

        System.out.println("DL1: " + DL1.toString());

        System.out.println("Is DL1 empty? " + DL1.isEmpty());
        System.out.println("DL1 length: " + DL1.Length());

        DL1.Delete(15);

        System.out.println("DL1 after deleting 15: " + DL1.toString());

        // Find a value in DL1
        DL1.Find(5);

        // Reverse DL1
        DL1.Reverselist();
        System.out.println("Reversed DL1: " + DL1.toString());

        DL1.clearList();

        System.out.println("DL1 after clearing: " + DL1.toString());

        System.out.println("Is DL1 empty? " + DL1.isEmpty());

        // Test for DLinkedList<String>
        DLinkedList<String> DL2 = new DLinkedList<String>();

        System.out.println("\nTesting DLinkedList<String>:");

        System.out.println("Is DL2 empty? " + DL2.isEmpty());
        System.out.println("DL2 length: " + DL2.Length());

        DL2.InsertInOrder("apple");
        DL2.InsertInOrder("banana");
        DL2.InsertInOrder("cherry");

        System.out.println("DL2: " + DL2.toString());

        System.out.println("Is DL2 empty? " + DL2.isEmpty());
        System.out.println("DL2 length: " + DL2.Length());

        DL2.Delete("banana");

        System.out.println("DL2 after deleting 'banana': " + DL2.toString());

        DL2.clearList();

        System.out.println("DL2 after clearing: " + DL2.toString());

        // Test for DLinkedList<Student>
        DLinkedList<Student> DL3 = new DLinkedList<Student>();

        System.out.println("\nTesting DLinkedList<Student>:");

        System.out.println("Is DL3 empty? " + DL3.isEmpty());
        System.out.println("DL3 length: " + DL3.Length());

        Student student1 = new Student("Alice", 101);
        Student student2 = new Student("Bob", 102);
        Student student3 = new Student("Charlie", 100);

        DL3.InsertInOrder(student1);
        DL3.InsertInOrder(student2);
        DL3.InsertInOrder(student3);

        System.out.println("DL3: " + DL3.toString());

        System.out.println("Is DL3 empty? " + DL3.isEmpty());
        System.out.println("DL3 length: " + DL3.Length());

        Node foundStudent = DL3.Find(student2);
//        if (foundStudent != null) {
//            System.out.println("Found student: " + foundStudent.toString());
//        } else {
//            System.out.println("Student not found.");
//        }

        DL3.Delete(student1);

        System.out.println("DL3 after deleting student1: " + DL3.toString());

        DL3.Reverselist();

        System.out.println("Reversed DL3: " + DL3.toString());

        DL3.clearList();

        System.out.println("DL3 after clearing: " + DL3.toString());
    }
}
