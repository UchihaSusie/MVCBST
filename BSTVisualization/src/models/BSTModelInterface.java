package models;

import controllers.BSTController;

// Interface defining the model for a Binary Search Tree (BST)
public interface BSTModelInterface {
    /**
     * Sets the controller that will manage communication between the model and the view.
     *
     * @param controller an instance of BSTController to be associated with the model
     */
    void setController(BSTController controller);

    /**
     * Adds a node with the specified value to the Binary Search Tree.
     * 
     * @param value the value of the node to be added
     * @return true if the node was successfully added, false otherwise
     */
    boolean add(int value);

    /**
     * Deletes a node with the specified value from the Binary Search Tree.
     * 
     * @param value the value of the node to be deleted
     * @return true if the node was successfully deleted, false otherwise
     */
    boolean delete(int value);

    /**
     * Performs an inorder traversal of the Binary Search Tree.
     * 
     * @return a String representation of the BST in inorder traversal
     */
    String inorder();

    /**
     * Performs a preorder traversal of the Binary Search Tree.
     * 
     * @return a String representation of the BST in preorder traversal
     */
    String preorder();

    /**
     * Performs a postorder traversal of the Binary Search Tree.
     * 
     * @return a String representation of the BST in postorder traversal
     */
    String postorder();
}
