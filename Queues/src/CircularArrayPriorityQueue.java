public class CircularArrayPriorityQueue<T extends Comparable<T>> {
    T[] queue;
    int front;
    int rear;
    int size;

    public CircularArrayPriorityQueue(int size) {
        queue = (T[]) new Comparable[size];
        front = -1;
        rear = -1;
        this.size = size;
    }

    public void enqueue(T obj) {
        // If the queue is full, don't add
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        // If the queue is empty, add at the beginning
        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = obj;
        } else {
            int i = (rear + 1) % size;
            // Find the correct position based on priority
            while (i != front && (queue[i] == null || obj == null || obj.compareTo(queue[i]) < 0)) {
                int next = (i - 1 + size) % size;
                queue[i] = queue[next];
                i = next;
            }
            queue[i] = obj;
            rear = (rear + 1) % size;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return item;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    @Override
    public String toString() {
        String s = "Queue: ";
        if (isEmpty()) {
            return s;
        }
        int i = front;
        do {
            s += queue[i];
            if (i != rear) {
                s += ", ";
            }
            i = (i + 1) % size;
        } while (i != (rear + 1) % size);
        return s;
    }

}