public class LinkedStack<T> {
    StackNode<T> top;

    public void Push(T data) {
        StackNode<T> nodeToPush = new StackNode<>(data);

        // stack is empty
        if (top == null) {
            top = nodeToPush;
        } else {
            nodeToPush.next = top;
            top = nodeToPush;
        }
        System.out.println("Pushed: " + data);
    }

    public T Pop() {
        // check if stack is empty
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }

        // return the top value
        T valueToReturn = top.info;
        System.out.println("Popped: " + valueToReturn);

        if (top.next == null) {
            top = null;
        } else {
            top = top.next;
        }

        return valueToReturn;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T Peek() {
        // check if stack is empty
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }

        // return the top value
        T valueToReturn = top.info;
        System.out.println("Peeked: " + valueToReturn);

        return valueToReturn;
    }
}