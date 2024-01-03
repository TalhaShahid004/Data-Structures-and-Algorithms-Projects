package ArrayBST;

public class BST<T extends Comparable<T>> {
    T[] tree;

    BST(int size) {
        tree = (T[]) new Comparable[size];
    }

    public void insert(T data) {
        int index = 0;

        while (index < tree.length && tree[index] != null) {
            int compareResult = data.compareTo(tree[index]);

            if (compareResult < 0) {
                // Move to the left child
                index = 2 * index + 1;
            } else if (compareResult > 0) {
                // Move to the right child
                index = 2 * index + 2;
            } else {
                break;
            }
        }

        if (index < tree.length) {
            tree[index] = data;
        }
    }

    public boolean find(T d) {
        int index = 0;

        while (index < tree.length && tree[index] != null) {
            int compareResult = d.compareTo(tree[index]);

            if (compareResult < 0) {
                index = 2 * index + 1;
            } else if (compareResult > 0) {
                index = 2 * index + 2;
            } else {
                return true;
            }
        }

        return false;
    }



    public void delete(T data) {
        int index = 0;
        while (index < tree.length && tree[index] != null) {
            int compareResult = data.compareTo(tree[index]);

            if (compareResult < 0) {
                index = 2 * index + 1;
            } else if (compareResult > 0) {
                index = 2 * index + 2;
            } else {
                break;
            }
        }

        if (index < tree.length && tree[index] != null && data.equals(tree[index])) {
            if (tree[2 * index + 1] == null && tree[2 * index + 2] == null) {
                // No children
                tree[index] = null;
            } else if (tree[2 * index + 1] != null && tree[2 * index + 2] == null) {
                // One child on the left
                deleteOneChildLeft(index);
            } else if (tree[2 * index + 1] == null && tree[2 * index + 2] != null) {
                // One child on the right
                deleteOneChildRight(index);
            } else {
                // Two children
                deleteTwoChildren(index);
            }
        }
    }

    protected void deleteOneChildLeft(int index) {
        int leftChildIndex = 2 * index + 1;
        tree[index] = tree[leftChildIndex];
        tree[leftChildIndex] = null;
    }

    protected void deleteOneChildRight(int index) {
        int rightChildIndex = 2 * index + 2;
        tree[index] = tree[rightChildIndex];
        tree[rightChildIndex] = null;
    }

    protected void deleteTwoChildren(int index) {
        //first we need to find successor
        //the successor is at the bottom of the left of the first right of the node

        int successorIndex = index;
        successorIndex = (successorIndex*2 + 2);

        while((tree[(successorIndex * 2) + 1] != null)){
            successorIndex = (successorIndex * 2) + 1;
        }

        tree[index] = tree[successorIndex];
        tree[successorIndex] = null;
    }

    public void traverse() {
        inOrderTraversal(0); // Start the traversal from the root (index 0)
    }

    private void inOrderTraversal(int index) {
        if (index < tree.length && tree[index] != null) {
            inOrderTraversal(2 * index + 1);

            System.out.print(tree[index] + " ");

            inOrderTraversal(2 * index + 2);
        }
    }
}
