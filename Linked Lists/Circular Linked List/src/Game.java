import java.util.Random;

public class Game {
    Node tail;
    int size = 0;

    public void Game() {
        tail = null;
    }

    public void insert(String player) {
        Node nodeToBeInserted = new Node(player);

        //list is empty
        if (tail == null) {
            tail = nodeToBeInserted;
            tail.next = tail; // set pointer to tail
        } else {
            nodeToBeInserted.next = tail.next; //points to the 'first item'
            tail.next = nodeToBeInserted; // points prev node to newnode
            tail = nodeToBeInserted; // sets tail to newnode
        }

        size++; // Increment the size of the list
    }


    public String playGame() {

        //r = regenerate random number
        Random random = new Random();

        //if list is null, just return
        //else
        //while more than one person remains, go through the list for r number of times
        //then remove the person we land on


        //for empty list
        if (size == 0) {
            return "No Winner";
        } else {
            Node current = tail.next;
            Node prev = tail;

            //while more than 1 person remains
            while (size > 1) {
                //keep moving through the list for a certain number of steps
                int r = random.nextInt(10);

                for (int i = 0; i < r; i++) {
                    prev = current;
                    current = current.next;
                }

                //remove the person using pointers
                prev.next = current.next;

                size--;
            }
            //last player remaining
            return current.name;
        }
    }

    public String toString() {
        if (size == 0) {
            return "The game is empty.";
        } else {

            String result = "Players: ";
            Node current = tail.next;
            for (int i = 0; i < size; i++) {
                result += current.name;
                if (i < size - 1) {
                    result += " -> ";
                }
                current = current.next;
            }

            return result;
        }
    }
}
