public class ArrayPriorityQueue<T extends Comparable<T>> {
    T[] Queue;
    int Front;

    ArrayPriorityQueue() {
        Queue = (T[]) new Comparable[10];
        Front = -1;
    }

    ArrayPriorityQueue(int size) {
        Queue = (T[]) new Comparable[size];
        Front = -1;
    }

    public void Enqueue(T obj) {
        //ie add an object to the queue according to the priority
        //decide priority on insertion

        //if list is empty add in first
        if (isEmpty()) {
            Queue[++Front] = obj;
            return;
        }

        //if list is full, don't add
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }


        int i;
        //if list is open, add according to value
        for (i = Front; i >= 0 && obj.compareTo(Queue[i]) < 0; i--) {
            Queue[i + 1] = Queue[i];
        }

        Queue[i + 1] = obj;
        Front++;
    }

    public T Dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return Queue[Front--];
        }
    }

    public boolean isEmpty() {
        //if f == -1
        return Front == -1;
    }

    public boolean isFull() {
        //return if full
        return Front + 1 == Queue.length;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return Queue[Front];
    }


    @Override
    public String toString() {
        String s = "Queue: ";

        for (int i = Front; i >= 0; i--) {
            if (i != 0) {
                s = s + Queue[i] + ", ";
            } else {
                s = s + Queue[i];
            }
        }


        return s;
    }


}
