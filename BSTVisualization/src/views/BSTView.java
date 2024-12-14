package views;

import controllers.BSTController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.*;
import models.Node;

/**
 * Represents the View component in the MVC architecture for the Binary Search Tree visualization.
 * Extends JFrame to provide a graphical user interface.
 * Implements ActionListener and KeyListener to handle user input and interactions.
 */
public class BSTView extends JFrame implements ActionListener, KeyListener, BSTViewInterface {

  private BSTController controller; // Controller managing the interactions between the view and the model
  private TreePanel treePanel; // Panel to visualize the Binary Search Tree
  private ControlPanel controlPanel; // Panel to handle user inputs and buttons
  private TraversalPanel traversalPanel; // Panel to display traversal outputs (inorder, preorder, postorder)

  /**
   * Constructor to initialize the BST view.
   * Sets up the GUI components and layout for the visualization.
   */
  public BSTView() {
    // Initialize panels
    treePanel = new TreePanel();
    controlPanel = new ControlPanel();
    traversalPanel = new TraversalPanel();

    // Configure the main window
    setTitle("Binary Search Tree Visualization");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set up layout and add panels to the JFrame
    add(treePanel, BorderLayout.CENTER); // Center: Tree visualization
    add(controlPanel, BorderLayout.NORTH); // Top: User controls
    add(traversalPanel, BorderLayout.SOUTH); // Bottom: Traversal results
  }

  /**
   * Sets the controller to handle interactions between the view and the model.
   *
   * @param controller an instance of BSTController
   */
  public void setController(BSTController controller) {
    this.controller = controller;
  }

  /**
   * Handles button click events for adding and deleting nodes.
   * Validates the user input and communicates with the controller to update the model.
   *
   * @param evt the action event triggered by user interaction
   */
  @Override
  public void actionPerformed(ActionEvent evt) {
    if (!controlPanel.getInputField().getText().trim().isEmpty()) { // Check if input field is not empty
      try {
        int data = Integer.parseInt(controlPanel.getInputField().getText()); // Parse input to integer

        // Handle Add button event
        if (evt.getSource() == controlPanel.getAddButton()) {
          if (!controller.add(data)) {
            JOptionPane.showMessageDialog(this,
                "Integer " + data + " already exists, please choose another one",
                "Duplicate Value",
                JOptionPane.INFORMATION_MESSAGE);
          }

          // Handle Delete button event
        } else if (evt.getSource() == controlPanel.getDeleteButton()) {
          if (!controller.delete(data)) {
            JOptionPane.showMessageDialog(this,
                "Integer " + data + " does not exist in the tree",
                "Value Not Found",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }

        // Clear input field and reset focus
        controlPanel.getInputField().setText("");
        controlPanel.getInputField().requestFocusInWindow();

      } catch (NumberFormatException e) { // Handle invalid input
        JOptionPane.showMessageDialog(this,
            "Please enter a valid integer!",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  /**
   * Handles key typed events to enable adding or deleting nodes with specific key inputs.
   * Validates input and interacts with the controller for updates.
   *
   * @param evt the key event triggered by user interaction
   */
  @Override
  public void keyTyped(KeyEvent evt) {
    char c = evt.getKeyChar();

    // Handle Enter key for adding a node
    if (c == '\n') {
      if (!controlPanel.getInputField().getText().trim().isEmpty()) {
        try {
          int data = Integer.parseInt(controlPanel.getInputField().getText());
          if (!controller.add(data)) {
            JOptionPane.showMessageDialog(this,
                "Integer " + data + " already exists, please choose another one",
                "Duplicate Value",
                JOptionPane.INFORMATION_MESSAGE);
            return;
          }
          controlPanel.getInputField().setText("");
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(this,
              "Please enter a valid integer!",
              "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
        }
      }

      // Handle 'd' key for deleting a node
    } else if (c == 'd' || c == 'D') {
      if (!controlPanel.getInputField().getText().trim().isEmpty()) {
        try {
          int data = Integer.parseInt(controlPanel.getInputField().getText());
          if (!controller.delete(data)) {
            JOptionPane.showMessageDialog(this,
                "Integer " + data + " does not exist in the tree",
                "Value Not Found",
                JOptionPane.INFORMATION_MESSAGE);
          }
          controlPanel.getInputField().setText("");
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(this,
              "Please enter a valid integer!",
              "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
        }
      }
      evt.consume();

      // Restrict input to numbers and backspace only
    } else if ((c < '0' || c > '9') && c != '\b') {
      evt.consume();
    }
  }

  @Override
  public void keyPressed(KeyEvent evt) {
    // No specific implementation required
  }

  @Override
  public void keyReleased(KeyEvent evt) {
    // No specific implementation required
  }

  /**
   * Updates the tree visualization panel with the latest BST structure.
   *
   * @param root the root node of the updated Binary Search Tree
   */
  public void updateTreePanel(Node root) {
    treePanel.updateTree(root);
  }

  /**
   * Updates the traversal results panel with the latest traversal outputs.
   *
   * @param inorder the inorder traversal result as a String
   * @param preorder the preorder traversal result as a String
   * @param postorder the postorder traversal result as a String
   */
  public void updateTraversal(String inorder, String preorder, String postorder) {
    traversalPanel.updateTraversal(inorder, preorder, postorder);
  }

  /**
   * Getter for the Add button in the control panel.
   *
   * @return the Add button component
   */
  public JButton getAddButton() {
    return controlPanel.getAddButton();
  }

  /**
   * Getter for the Delete button in the control panel.
   *
   * @return the Delete button component
   */
  public JButton getDeleteButton() {
    return controlPanel.getDeleteButton();
  }

  /**
   * Getter for the input field in the control panel.
   *
   * @return the input field component
   */
  public JTextField getInputField() {
    return controlPanel.getInputField();
  }
}

