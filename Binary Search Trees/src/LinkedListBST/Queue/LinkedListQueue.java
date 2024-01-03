package LinkedListBST.Queue;

public class LinkedListQueue<T> {
    queueNode<T> Front;
    queueNode<T> Rear;

    public LinkedListQueue() {
        Front = null;
        Rear = null;
    }

    //enqueue
    public void enqueue(T data) {
        queueNode<T> nodeToBeAdded = new queueNode<>(data);
        if (isEmpty()) {
            Front = nodeToBeAdded;
            Rear = nodeToBeAdded;
        } else {
            Rear.next = nodeToBeAdded;
            Rear = nodeToBeAdded;
        }
    }

    //dequeue
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T data = Front.data;
        Front = Front.next;
        if (Front == null) {
            Rear = null;
        }
        return data;
    }

    //isempty
    public boolean isEmpty() {
        return Front == null;
    }

}
