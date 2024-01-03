package LinkedListBST;

public class Main {
    public static void main(String[] args) {
        // Create a new LinkedListBST.BST of Integer values
        BST<Integer> bst = new BST<>();

        // Insert some values
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Test the find method
        int keyToFind = 30;
        node<Integer> foundNode = bst.find(keyToFind);
        if (foundNode != null) {
            System.out.println("Found " + keyToFind + " in the tree.");
        } else {
            System.out.println(keyToFind + " not found in the tree.");
        }

        // Print the tree using breadth-first traversal
        System.out.println("Breadth-First Traversal:");
        bst.traverse(bst.root);

        // Print the tree using inorder traversal
        System.out.println("Inorder Traversal:");
        bst.TraverseLNR(bst.root);

        System.out.println("Preorder Traversal:");
        bst.TraverseNLR(bst.root);

        System.out.println("Postorder Traversal:");
        bst.TraverseLRN(bst.root);

        // Test the delete method
        int keyToDelete = 30;
        node<Integer> nodeToDelete = bst.find(keyToDelete);

        if (nodeToDelete != null) {
            bst.delete(nodeToDelete);
            System.out.println("Deleted " + keyToDelete + " from the tree.");
        } else {
            System.out.println(keyToDelete + " not found in the tree, so couldn't be deleted.");
        }

        // Print the tree again after deletion
        System.out.println("Tree after deletion:");
        bst.TraverseLNR(bst.root);
    }
}
