package LinkedListBST;

import LinkedListBST.Queue.LinkedListQueue;

public class BST<T extends Comparable<T>> {
    node<T> root;

    public BST() {
        root = null;
    }

    public void insert(T key) {
        node<T> nodeToBeAdded = new node(key);

        // Case 1 where the tree is empty (root is null)
        if (root == null) {
            root = nodeToBeAdded;
        } else {
            // Case 2: tree isn't empty
            node<T> current = root;
            node<T> prev = root;

            // Traversing until you get to the right position to insert
            while (current != null) {
                if (key.compareTo(current.data) < 0) {
                    // Go left if key data is less than the current data
                    prev = current;
                    current = current.left;
                } else if (key.compareTo(current.data) > 0) {
                    // Go right if key data is more than the current data
                    prev = current;
                    current = current.right;
                } else {
                    // Value is the same, shouldn't be inserted
                    System.out.println("Invalid data. Data already exists");
                    return; // Exit the method
                }
            }

            if (key.compareTo(prev.data) < 0) {
                // Go left
                prev.left = nodeToBeAdded;
            } else if (key.compareTo(prev.data) > 0) {
                // Go right
                prev.right = nodeToBeAdded;
            } else {
                // Value is the same, shouldn't be inserted
                System.out.println("Invalid. Data already exists");
            }
        }
    }


    public node find(T key) {
        node<T> current = root;

        // Stops when null value is found or the key matches the current LinkedListBST.node's data
        while (current != null && key.compareTo(current.data) != 0) {
            if (key.compareTo(current.data) > 0) {
                current = current.right; // Key data is more than current data, go right
            } else if (key.compareTo(current.data) < 0) {
                current = current.left; // Key data is less than current data, go left
            }
        }

        return current;
    }

    // Print tree using Breadth first traversal
    public void traverse(node n) {
        if (n == null) {
            return; // Nothing to print
        }

        LinkedListQueue<node> queue = new LinkedListQueue<>();
        queue.enqueue(n);

        while (!queue.isEmpty()) {
            node current = queue.dequeue();
            System.out.println(current.data);
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }

    // Print tree using Inorder traversal
    public void TraverseLNR(node n) {
        if (n == null) {
            return;
        }

        TraverseLNR(n.left);
        System.out.println(n.data);
        TraverseLNR(n.right);
    }

    public void TraverseNLR(node n) {
        if (n == null) {
            return;
        }

        System.out.println(n.data);
        TraverseNLR(n.left);
        TraverseNLR(n.right);
    }

    public void TraverseLRN(node n) {
        if (n == null) {
            return;
        }

        TraverseLRN(n.left);
        TraverseLRN(n.right);
        System.out.println(n.data);
    }

    public void delete(node n) {
        node<T> parent = null;
        node<T> current = root;

        //find parent and current LinkedListBST.node
        while (current != null && current.data.compareTo((T) n.data) != 0) {
            parent = current;
            if (current.data.compareTo((T) n.data) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        // LinkedListBST.node not found
        if (current == null) {
            return;
        }

        //handle 3 cases

        // leaf LinkedListBST.node
        if (current.left == null && current.right == null) {
            delNoChild(parent, current);
        } else if ((current.left == null && current.right != null) || (current.right == null && current.left != null)) {
            //one child
            delOneChild(parent, current);
        } else {
            //two children
            node<T> successorParent = root;
            node<T> successor = root.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            //delete successor
            if (successor != root) {
                successorParent.left = successor.right;
            } else {
                root = successor;
            }

            n.data = successor.data;
        }
    }

    protected void delNoChild(node<T> parent, node<T> temp) {
        if (parent.left == temp) {
            parent.left = null;
        } else if (parent.right == temp) {
            parent.right = null;
        }
    }

    protected void delOneChild(node<T> parent, node<T> temp) {
        if (temp.left != null) {
            if (parent.left == temp) {
                parent.left = temp.left;
            } else {
                parent.right = temp.left;
            }
        } else {
            if (parent.left == temp) {
                parent.left = temp.right;
            } else {
                parent.right = temp.right;
            }
        }
    }

}
