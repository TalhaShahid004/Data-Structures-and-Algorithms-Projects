public class LinkedListPriorityQueue<T> {
    private LinkedListQueue<PriorityNode<T>> queue;

    public LinkedListPriorityQueue() {
        queue = new LinkedListQueue<>();
    }

    // Enqueue an element with its priority
    public void enqueue(T data, int priority) {
        PriorityNode<T> newNode = new PriorityNode<>(data, priority);
        queue.enqueue(newNode);
    }

    // Dequeue the element with the highest priority
    public T dequeue() {
        PriorityNode<T> node = queue.dequeue();
        if (node != null) {
            return node.getData();
        }
        return null;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}

