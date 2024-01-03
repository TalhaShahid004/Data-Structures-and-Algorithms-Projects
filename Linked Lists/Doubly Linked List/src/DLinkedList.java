public class DLinkedList<T extends Comparable<T>> {
    Node head;

    DLinkedList() {
        head = null;
    }

    //implement the following Methods
//    public void InsertInOrder(T value) { …}

    public void InsertInOrder(T value) {
        Node nodeToBeInserted = new Node(value);

        //if list is empty or value less than head
        if (head == null || ((Comparable<T>) head.data).compareTo(value) < 0) {
            nodeToBeInserted.next = head;
            head = nodeToBeInserted;
            return;
        }

        Node current = head;
        //if list is not empty, then traverse the list till you get to the point before the value to be inserted
        while (current.next != null && ((Comparable<T>) current.data).compareTo(value) < 0) {
            current = current.next;
        }

        nodeToBeInserted.next = current.next;
        current.next = nodeToBeInserted;
    }

//    public Node Find(T value) { …}

    // Find a value and return the node
    public Node Find(T value) {
        Node current = head;

        // For an empty list
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        // Traverse the list
        while (current != null) {
            if (current.data.equals(value)) {
                System.out.println("Found the value: " + value);
                return current;
            }
            current = current.next;
        }

        System.out.println("Value not found");
        return null;
    }



//    public void Delete(T value) { …}

    public void Delete(T value) {
        Node current = head;

        //if list is empty, hence nothing to delete
        if (head == null) {
            return;
        }

        // Check if the head node should be deleted
        if (head.data == value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        //traverse to end of the list
        while (current.next != null) {
            if (current.next.data == value) {
                // Update the next node's prev pointer
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                }
                return;
            }
            current = current.next;
        }
    }
//    public String toString() { …}

    public String toString() {
        String result = "Doubly Linked List: ";
        Node current = head;

        while (current != null) {
            result += current.data;
            if (current.next != null) {
                result += " <-> "; // Add a separator for clarity
            }
            current = current.next;
        }

        return result;
    }


//    public void clearList() { …}

    public void clearList() {
        //start from head of the list

        while (head != null) {
            //saves an instance of the next node
            Node temp = head.next;
            //clears the head node
            head.data = null;
            head.next = null;
            head.prev = null;
            //sets head as the 'next' node
            head = temp;
        }
    }
//    public boolean isEmpty() { …}

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    //    public int Length() { …}
    public int Length() {
        int count = 0;

        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //    public void Reverselist() { …}

//    public void Reverselist() {
//        if (head == null) {
//            // If the list is empty, there's nothing to reverse
//            return;
//        }
//
//        Node current = head;
//        Node temp = null;
//
//        while (current != null) {
//            // Swap the prev and next pointers of the current node
//            temp = current.prev;
//            current.prev = current.next;
//            current.next = temp;
//
//            // Move to the next node
//            current = current.prev;
//        }
//
//        // Update the head pointer to the last node
//        head = temp == null ? head : temp.next;
//    }


    public void Reverselist() {
        Node current = head;
        Node temp = null; // Initialize temp to null

        // Swap the prev and next pointers for each node in the list
        while (current != null) {
            // Store the next node in the original list
            Node nextNode = current.next;

            // Swap prev and next pointers
            current.prev = nextNode;
            current.next = temp;

            // Move to the next node in the list
            temp = current;
            current = nextNode;
        }

        // Update the head to the last node, which is now the first node
        head = temp;
    }


}

