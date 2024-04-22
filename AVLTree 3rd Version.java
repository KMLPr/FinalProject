import java.util.ArrayList;

public class AVLTree{
    public class Node {
        Order data;
        Node left, right;
        int height;

        public Node(Order data) {
            this.data = data;
            this.height = 1; // Initial height is 1
        }
    }
    public Node getRoot() {
        return root;
    }

    public Node root;

    // Insert a new node into the AVL tree
    public void insert(Order order) {
        root = insert(root, order);
    }

    // Recursive method to insert a new node
    private Node insert(Node node, Order data) {
        if (node == null) {
            return new Node(data);
        }

        // Insert data based on its comparison with current node
        if (data.getTotalPrice() < node.data.getTotalPrice()) {
            node.left = insert(node.left, data);
        } else if (data.getTotalPrice() > node.data.getTotalPrice()) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate price, do not insert again
            return node;
        }

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check and balance the AVL tree
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && node.left.data.getTotalPrice() > node.data.getTotalPrice()) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && node.right.data.getTotalPrice() < node.data.getTotalPrice()) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && node.left.data.getTotalPrice() < node.data.getTotalPrice()) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && node.right.data.getTotalPrice() > node.data.getTotalPrice()) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Get height of a node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Get balance factor of a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Perform left rotation
    private Node leftRotate(Node node) {
        if (node == null || node.left == null) {
            // Null check: If the node or its left child is null, return the node itself
            return node;
        }
        Node rightChild = node.right;
        Node leftOfRightChild = rightChild.left;

        // Perform rotation
        rightChild.left = node;
        node.right = leftOfRightChild;

        // Update heights
        node.height = 1 + Math.max(height(node.left), height(node.right));
        rightChild.height = 1 + Math.max(height(rightChild.left), height(rightChild.right));

        // Return new root
        return rightChild;
    }

    // Perform right rotation
    private Node rightRotate(Node node) {
        if (node == null || node.left == null) {
            // Null check: If the node or its left child is null, return the node itself
            return node;
        }
        Node leftChild = node.left;
        Node rightOfLeftChild = leftChild.right;

        // Perform rotation
        leftChild.right = node;
        node.left = rightOfLeftChild;

        // Update heights
        node.height = 1 + Math.max(height(node.left), height(node.right));
        leftChild.height = 1 + Math.max(height(leftChild.left), height(leftChild.right));

        // Return new root
        return leftChild;
    }
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    public void delete(Order data) {
        root = delete(root, data);
    }

    // Recursive method to delete a node
    private Node delete(Node node, Order data) {
        if (node == null) {
            return node;
        }

        // Delete data based on its comparison with current node
        if (data.getTotalPrice() < node.data.getTotalPrice()) {
            node.left = delete(node.left, data);
        } else if (data.getTotalPrice() > node.data.getTotalPrice()) {
            node.right = delete(node.right, data);
        } else {
            // Node with only one child or no child
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (temp == node.left) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else { // One child case
                    node = temp;
                }
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(node.right);

                // Copy the inorder successor's data to this node
                node.data = temp.data;

                // Delete the inorder successor
                node.right = delete(node.right, temp.data);
            }
        }

        // If the tree had only one node, then return
        if (node == null) {
            return node;
        }

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check and balance the AVL tree
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Method to print the AVL tree (inorder traversal)
    public void print() {
        print(root);
    }

    // Recursive method to print the AVL tree
    private void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.data + " ");
            print(node.right);
        }
    }
}
