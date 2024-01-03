package AdjacencyList;

public class LinkedList<T> {
    Node<T> head;

    LinkedList() {
        head = null;
    }

    //1. Find the middle node of a linked list. Assume no other information is given except head pointer
    public Node<T> findMiddleNode() {
        int size = 0;

        Node current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        //empty list
        if (size == 0) {
            return null;
        }

        // even number of nodes
        if (size % 2 == 0) {
            current = head;

            for (int i = 0; i < (size / 2) - 1; i++) {
                current = current.next;
            }
            return current;
        } else {
            //odd number
            current = head;

            for (int i = 0; i < ((size + 1) / 2) - 1; i++) {
                current = current.next;
            }
            return current;
        }
    }

    //2. Write a SortedMerge(Linklist L1, Linklist L2) function that takes two singly lists, each
    //of which is sorted in increasing order, and merges the two together into one list which
    //is in increasing order. SortedMerge() should return the new list. Ideally,sortedMerge()
    //should only make one pass through each list.

    public static <T extends Comparable<T>> LinkedList<T> sortedMerge(LinkedList<T> list1, LinkedList<T> list2) {
        LinkedList<T> mergedList = new LinkedList<>();
        Node<T> current1 = list1.head;
        Node<T> current2 = list2.head;

        //merge both lists by comparison at each current pointer
        while (current1 != null && current2 != null) {
            //checks if list 1 data bigger than list 2, if yes then itll be < 0
            if (current1.data.compareTo(current2.data) < 0) {
                mergedList.insert(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insert(current2.data);
                current2 = current2.next;

            }
        }

        // Add any remaining elements from list1
        while (current1 != null) {
            mergedList.insert(current1.data);
            current1 = current1.next;
        }

        // Add any remaining elements from list2
        while (current2 != null) {
            mergedList.insert(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);

        // If the list is empty, make the new node the head.
        if (head == null) {
            head = node;
            return; // Exit the method after setting the head.
        }

        // Traverse the linked list to find the last node
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Add the new node to the last node
        temp.next = node;
    }

    public Boolean find(T data) {
        //find a node with value data
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void clear() {
        // make list empty
        head = null;
    }

    public void delete(T data) {
        if (head == null) {
            return;
        }

        Node<T> previous = null;
        Node<T> current = head;
        boolean dataFound = false;

        while (current != null) {
            if (current.data.equals(data)) {
                // Found the data, delete the node.
                if (previous == null) {
                    // If the node to be deleted is the head node.
                    head = current.next;
                } else {
                    //  If the node to be deleted is not the head node.
                    previous.next = current.next;
                }
                dataFound = true;
                break; // Exit the loop after deleting the first occurrence.
            }
            previous = current;
            current = current.next;
        }

        if (!dataFound) {
            System.out.println("AdjacencyList.Node not found. Nothing deleted");
        }
    }

    // returns a string with comma node values
    public String toString() {
        Node<T> temp = head;
        String values = "";

        while (temp != null) {
            values += temp.data;

            if (temp.next != null) {
                values += ", ";
            }

            temp = temp.next;
        }

        return values;
    }

    public void insertBefore(Node<T> node, T data) {
        if (head == null) {
            // If the list is empty, make the new node the head.
            head = node;
            return;
        }

        if (head.data.equals(data)) {
            // If the data matches the head, insert the new node at the beginning.
            node.next = head;
            head = node;
            return;
        }

        Node current = head;
        //traverse to the end of the list
        while (current.next != null) {
            if (current.next.data == data) {
                // Found the node with the matching data, insert the new node before it.
                node.next = current.next;
                current.next = node;
                return;
            }
            current = current.next;
        }

        // Data not found in the list.
        System.out.println("AdjacencyList.Node with data " + data + " not found. Nothing inserted.");
    }

}
