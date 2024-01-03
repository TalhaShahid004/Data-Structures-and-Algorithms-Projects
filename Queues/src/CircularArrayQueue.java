public class CircularArrayQueue<T> {
    T[] Queue;
    int Front;
    int Rear;

    public CircularArrayQueue() {
        Queue = (T[]) new Object[10];
        Front = -1;
        Rear = -1;
    }

    public CircularArrayQueue(int size) {
        Queue = (T[]) new Object[size];
        Front = -1;
        Rear = -1;
    }

    public void Enqueue(T obj) {
        //is full
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        //is empty
        if (isEmpty()) {
            Front = 0;
        }

        //has space
        Rear = (Rear + 1) % Queue.length;
        Queue[Rear] = obj;
    }

    public T Dequeue() {
        if (isEmpty()) {
            return null;
        }

        T itemToBeReturned = Queue[Front];

        if (Front == Rear) {
            Front = -1;
            Rear = -1;
        } else {
            Front = (Front + 1) % Queue.length;
        }

        return itemToBeReturned;
    }

    public boolean isEmpty() {
        return Front == -1 && Rear == -1;
    }

    public boolean isFull() {
        return (Rear + 1) % Queue.length == Front;
    }
}
