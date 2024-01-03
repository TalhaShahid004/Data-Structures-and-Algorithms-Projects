public class Node<T> {
    T data;
    Node prev;
    Node next;

    Node(T d) {
        data = d;
        prev = null;
        next = null;
    }

}

