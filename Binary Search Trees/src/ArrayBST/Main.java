package ArrayBST;

public class Main {
    public static void main(String[] args) {
        // Create a BST with a size of 16
        BST<Integer> bst = new BST<>(16);

        // Insert elements into the BST
        bst.insert(6);
        bst.insert(5);
        bst.insert(8);
        bst.insert(0);
        bst.insert(0);
        bst.insert(7);
        bst.insert(9);
        bst.insert(0);
        bst.insert(0);
        bst.insert(0);
        bst.insert(0);
        bst.insert(0);
        bst.insert(0);
        bst.insert(0);
        bst.insert(12);
        bst.insert(0);

        // Test find and delete operations
        System.out.println("Searching for elements:");
        System.out.println("Find 5: " + bst.find(5)); // Should return true
        System.out.println("Find 10: " + bst.find(10)); // Should return false

        // Perform delete operations
        bst.delete(8);
        bst.delete(0);
        bst.delete(12);

        System.out.println("After deleting 8, 0, and 12:");

        // Traverse and print the tree to verify the results
        System.out.println("In-order traversal:");
        bst.traverse();
    }
}
