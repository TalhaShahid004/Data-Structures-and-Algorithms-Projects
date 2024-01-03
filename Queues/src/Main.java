public class Main {
    public static void main(String[] args) {

        System.out.println("----------Linked List Queue----------");
        // Create a LinkedListQueue of integers
        LinkedListQueue<Integer> queue1 = new LinkedListQueue<>();

        // Test enqueue
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // Test isEmpty
        System.out.println("Is the queue empty? " + queue1.isEmpty());

        // Test dequeue
        int dequeuedValue = queue1.dequeue();
        System.out.println("Dequeued value: " + dequeuedValue);

        // Test isEmpty again
        System.out.println("Is the queue empty? " + queue1.isEmpty());

        // Enqueue more elements
        queue1.enqueue(4);
        queue1.enqueue(5);


        System.out.println("Dequeued value: " + queue1.dequeue());
        System.out.println("Dequeued value: " + queue1.dequeue());
        System.out.println("Dequeued value: " + queue1.dequeue());
        System.out.println("Dequeued value: " + queue1.dequeue());
        System.out.println("Dequeued value: " + queue1.dequeue());


        // Test isEmpty one more time
        System.out.println("Is the queue empty? " + queue1.isEmpty());

        System.out.println();
        System.out.println("----------Circular Array Queue----------");

        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(5);

        // Enqueue some elements
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);
        queue.Enqueue(5);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.Dequeue());
        System.out.println("Dequeued: " + queue.Dequeue());

        // Enqueue more elements
        queue.Enqueue(6);
        queue.Enqueue(7);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.Dequeue());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());

        // Enqueue more elements
        queue.Enqueue(8);
        queue.Enqueue(9);

        // Check if the queue is full
        System.out.println("Is the queue full? " + queue.isFull());

        System.out.println("Dequeued: " + queue.Dequeue());
        System.out.println("Dequeued: " + queue.Dequeue());
        System.out.println("Dequeued: " + queue.Dequeue());
        System.out.println("Dequeued: " + queue.Dequeue());
        System.out.println("Dequeued: " + queue.Dequeue());

        // Check if the queue is empty again
        System.out.println("Is the queue empty? " + queue.isEmpty());

        System.out.println();

        System.out.println("----------Array Priority Queue----------");

        ArrayPriorityQueue<Integer> pq1 = new ArrayPriorityQueue<>(5);

        // Test for enqueue
        pq1.Enqueue(1);
        pq1.Enqueue(2);
        pq1.Enqueue(3);
        pq1.Enqueue(4);
        pq1.Enqueue(5);

        System.out.println(pq1);

        // Queue should be full
        pq1.Enqueue(6);

        // Tests for dequeue
        System.out.println("Dequeued: " + pq1.Dequeue());
        System.out.println("Dequeued: " + pq1.Dequeue());
        System.out.println("Dequeued: " + pq1.Dequeue());
        System.out.println("Dequeued: " + pq1.Dequeue());
        System.out.println("Dequeued: " + pq1.Dequeue());

        // Test for dequeue on an empty queue
        System.out.println("Dequeued from an empty queue: " + pq1.Dequeue());

        System.out.println(pq1); // Should be empty

        // Test peek on an empty queue
        System.out.println("Peek on an empty queue: " + pq1.peek());


        // Test adding elements again
        pq1.Enqueue(7);
        pq1.Enqueue(8);
        pq1.Enqueue(6);
        System.out.println("Peek: " + pq1.peek());

        System.out.println(pq1);

        System.out.println();
        System.out.println("----------Circular Array Priority Queue----------");

        CircularArrayPriorityQueue<Integer> pq2 = new CircularArrayPriorityQueue<>(5);

        pq2.enqueue(3);
        pq2.enqueue(1);
        pq2.enqueue(5);
        pq2.enqueue(2);
        pq2.enqueue(4);

        System.out.println(pq2);

        System.out.println("Dequeue: " + pq2.dequeue());
        System.out.println("Dequeue: " + pq2.dequeue());

        pq2.enqueue(6);
        pq2.enqueue(0);

        System.out.println(pq2);

        System.out.println();
        System.out.println("----------Linked List Priority Queue----------");

        LinkedListPriorityQueue<String> pq3 = new LinkedListPriorityQueue<>();

        // Enqueue elements with priorities
        pq3.enqueue("Task 1", 3);
        pq3.enqueue("Task 2", 1);
        pq3.enqueue("Task 3", 2);

        // Dequeue elements
        System.out.println("Dequeueing elements:");
        System.out.println(pq3.dequeue());
        System.out.println(pq3.dequeue());
        System.out.println(pq3.dequeue());

        // Check if the priority queue is empty
        System.out.println("Is the priority queue empty? " + pq3.isEmpty());

        // Attempting to dequeue from an empty queue
        System.out.println(pq3.dequeue()); // null

        System.out.println();
        System.out.println("----------Printer Priority Queue----------");

        PrinterQueueManager printQueue = new PrinterQueueManager(10);

        // Enqueue some print jobs
        printQueue.enqueueJob(new Job("Printing a short text document", 2));
        printQueue.enqueueJob(new Job("Printing a lengthy research paper", 20));
        printQueue.enqueueJob(new Job("Printing a colorful poster", 5));
        printQueue.enqueueJob(new Job("Printing a single-page invoice", 1));

        // Print the next job
        printQueue.printNextJob();

        // Peek at the next job
        Job nextJob = printQueue.peekNextJob();
        System.out.println("Next job to print: " + nextJob);

        // Print the remaining jobs
        // Print the remaining jobs
        while (printQueue.peekNextJob() != null) {
            printQueue.printNextJob();
        }


    }
}


