package views;

import javax.swing.*;

/**
 * The TraversalPanel class represents the panel in the Binary Search Tree (BST) visualization
 * application that displays the results of tree traversals (inorder, preorder, postorder).
 * This class is part of the View in the MVC architecture.
 */
public class TraversalPanel extends JPanel {

    // Label to display the result of the inorder traversal of the BST.
    private JLabel inorderLabel;

    // Label to display the result of the preorder traversal of the BST.
    private JLabel preorderLabel;

    // Label to display the result of the postorder traversal of the BST.
    private JLabel postorderLabel;

    /**
     * Constructor for the TraversalPanel.
     * Initializes the panel with labels for displaying traversal results and arranges them in a vertical layout.
     */
    public TraversalPanel() {
        // Initialize labels for each traversal type.
        inorderLabel = new JLabel("Inorder: ");
        preorderLabel = new JLabel("Preorder: ");
        postorderLabel = new JLabel("Postorder: ");

        // Set layout manager to organize labels vertically.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the labels to the panel in the order they should appear.
        add(inorderLabel);
        add(preorderLabel);
        add(postorderLabel);
    }

    /**
     * Updates the traversal labels with new results.
     * This method is called when the tree structure changes and traversal results need to be refreshed.
     *
     * @param inorder  The result of the inorder traversal as a string.
     * @param preorder The result of the preorder traversal as a string.
     * @param postorder The result of the postorder traversal as a string.
     */
    public void updateTraversal(String inorder, String preorder, String postorder) {
        // Update the text of each label with the new traversal results.
        inorderLabel.setText("Inorder: " + inorder);
        preorderLabel.setText("Preorder: " + preorder);
        postorderLabel.setText("Postorder: " + postorder);
    }
}
