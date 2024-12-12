// Node class represents a node in a binary tree
public class Node {

    // References to left and right children in the binary tree
    private Node left;   // Reference to the left child node
    private Node right;  // Reference to the right child node

    // The value stored in the node
    private int value;   // An integer value representing the data in the node

    /**
     * Constructor to create a new Node with a given value.
     * Initializes left and right children to null.
     * 
     * @param value The integer value to be stored in the node.
     */
    public Node(int value) {
        this.value = value;  // Assign the given value to the node's data
        this.left = null;     // Initially, the left child is set to null
        this.right = null;    // Initially, the right child is set to null
    }

    /**
     * Getter method to retrieve the value stored in the node.
     * 
     * @return The integer value stored in the node.
     */
    public int getValue() {
        return value;  // Return the value stored in the node
    }

    /**
     * Getter method to access the left child of the node.
     * 
     * @return The left child node.
     */
    public Node getLeft() {
        return left;  // Return the reference to the left child node
    }

    /**
     * Getter method to access the right child of the node.
     * 
     * @return The right child node.
     */
    public Node getRight() {
        return right;  // Return the reference to the right child node
    }

    /**
     * Setter method to set or update the left child of the node.
     * 
     * @param left The new left child node to be assigned.
     */
    public void setLeft(Node left){
        this.left = left;  // Assign the given node as the left child
    }

    /**
     * Setter method to set or update the right child of the node.
     * 
     * @param right The new right child node to be assigned.
     */
    public void setRight(Node right){
        this.right = right;  // Assign the given node as the right child
    }

    /**
     * Setter method to set or update the value stored in the node.
     * 
     * @param value The new integer value to be stored in the node.
     */
    public void setValue(int value){
        this.value = value;  // Assign the given value to the node
    }
}

