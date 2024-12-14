package views;

import javax.swing.*;

/**
 * The ControlPanel class represents the control interface of the Binary Search Tree (BST) application.
 * It provides input fields and buttons for interacting with the tree (e.g., adding and deleting nodes).
 * This class is part of the View in the MVC architecture.
 */
public class ControlPanel extends JPanel {

    // Input field where the user can type the value to add or delete in the BST.
    private JTextField inputField;

    // Button to trigger the addition of a new node in the BST.
    private JButton addButton;

    // Button to trigger the deletion of a node from the BST.
    private JButton deleteButton;

    /**
     * Constructor for the ControlPanel.
     * Initializes the panel with an input field, an "Add" button, and a "Delete" button.
     * Also sets up a basic layout with labels for better user interface structure.
     */
    public ControlPanel() {
        // Create input field with a default width of 10 columns.
        inputField = new JTextField(10);

        // Create the "Add" and "Delete" buttons.
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");

        // Add a label, the input field, and the buttons to the panel.
        add(new JLabel("Value:"));
        add(inputField);
        add(addButton);
        add(deleteButton);
    }

    /**
     * Returns the input field component.
     * This field is used to enter the value of the node to add or delete in the BST.
     *
     * @return The input field component.
     */
    public JTextField getInputField() {
        return inputField;
    }

    /**
     * Returns the "Add" button component.
     * This button is used to trigger the addition of a new node to the BST.
     *
     * @return The "Add" button component.
     */
    public JButton getAddButton() {
        return addButton;
    }

    /**
     * Returns the "Delete" button component.
     * This button is used to trigger the deletion of an existing node from the BST.
     *
     * @return The "Delete" button component.
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }
}
