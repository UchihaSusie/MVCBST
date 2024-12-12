/**
 * Interface representing the Controller component in the MVC design pattern for a Binary Search Tree (BST) visualization.
 * The controller connects the view and model, handling user interactions and updating the model accordingly.
 */
public interface BSTControllerInterface {
  
    /**
     * Adds an integer value to the binary search tree.
     *
     * @param data The integer value to be added to the tree.
     * @return true if the value is successfully added; false if it already exists.
     */
    boolean add(int data);

    /**
     * Deletes an integer value from the binary search tree.
     *
     * @param data The integer value to be deleted from the tree.
     * @return true if the value is successfully deleted; false if it does not exist.
     */
    boolean delete(int data);

    /**
     * Notifies the view whenever changes occur in the model (e.g., updates to the tree structure).
     *
     * @param root The root node of the updated binary search tree graph and traversals
     */
    void notifyView(Node root);
}

