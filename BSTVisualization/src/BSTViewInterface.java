import javax.swing.*;

/**
 * Interface for the View component in the MVC design pattern for a Binary Search Tree (BST) visualization.
 * It extends both ActionListener and KeyListener, meaning the view can handle button actions and keyboard events.
 */
public interface BSTViewInterface {

    // /**
    //  * Sets the model that this view interacts with.
    //  * This links the view to the data (BST model) in the MVC structure.
    //  *
    //  * @param model The Binary Search Tree model.
    //  */
    // void setModel(BSTModel model);

    void setController(BSTController controller);

    /**
     * Updates the tree panel to reflect the new tree structure.
     * This method is called when the tree structure changes and needs to be redrawn.
     *
     * @param root The root node of the updated tree.
     */
    void updateTreePanel(Node root);

    /**
     * Updates the traversal panel to display the results of tree traversals.
     * This is used to show the outputs of inorder, preorder, and postorder traversals.
     *
     * @param inorder The result of the inorder traversal.
     * @param preorder The result of the preorder traversal.
     * @param postorder The result of the postorder traversal.
     */
    void updateTraversal(String inorder, String preorder, String postorder);

    /**
     * Gets the "Add" button for inserting nodes into the BST.
     * This provides a reference to the button for adding functionality or event handling.
     *
     * @return The "Add" button object.
     */
    JButton getAddButton();

    /**
     * Gets the "Delete" button for removing nodes from the BST.
     * This provides a reference to the button for deleting functionality or event handling.
     *
     * @return The "Delete" button object.
     */
    JButton getDeleteButton();

    /**
     * Gets the input field for entering values to add or delete in the BST.
     * This provides access to the text field where users can input values.
     *
     * @return The input field object.
     */
    JTextField getInputField();
}

