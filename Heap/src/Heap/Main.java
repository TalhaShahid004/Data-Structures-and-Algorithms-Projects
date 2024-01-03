package Heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);

        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(5);
        maxHeap.insert(1);

        System.out.println("Initial Heap:");
        maxHeap.print();

        System.out.println("Maximum Element: " + maxHeap.getMax());

        System.out.println("Extracted Maximum Element: " + maxHeap.extractMax());
        System.out.println("Heap after extraction:");
        maxHeap.print();
        maxHeap.remove(5);
        System.out.println("Heap after removing 5:");
        maxHeap.print();

        maxHeap.update(4, 9);
        System.out.println("Heap after updating 4 to 9:");
        maxHeap.print();

        maxHeap.insert(12);
        maxHeap.print();

        maxHeap.insert(7);
        maxHeap.print();
        
        maxHeap.insert(6);
        maxHeap.print();


        System.out.println("Maximum Element: " + maxHeap.getMax());

        System.out.println("Final Heap:");
        maxHeap.print();
    }
}


