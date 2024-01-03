package LinkedListBST;

public class node<T> {
    T data;
    node<T> left;
    node<T> right;

    node(T data) {
        this.data = data;
        left = right = null;
    }
}

