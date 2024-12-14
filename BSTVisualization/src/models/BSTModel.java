package models;

// Importing the controller for notifying changes in the model
import controllers.BSTController;

/**
 * The BSTModel class represents the Binary Search Tree (BST) model.
 * It handles data storage, manipulation, and traversal logic for the BST.
 * It also communicates with the controller to update the view when changes occur.
 */
public class BSTModel implements BSTModelInterface {
  private Node root; // The root node of the BST
  private BSTController controller; // The controller to notify about model changes

  /**
   * Sets the controller for this model.
   *
   * @param controller the BSTController instance
   */
  public void setController(BSTController controller) {
    this.controller = controller;
  }

  /**
   * Adds a value to the BST. If the value already exists, it won't be added.
   *
   * @param value the value to add
   * @return true if the value was added, false otherwise
   */
  public boolean add(int value) {
    if (contains(value)) { // Check if the value already exists
      return false;
    }

    if (root == null) { // If the tree is empty, set the root node
      root = new Node(value);
      controller.notifyView(root); // Notify the controller to update the view
      return true;
    }

    // Add the value recursively
    addRecursive(root, value);
    controller.notifyView(root); // Notify the controller to update the view
    return true;
  }

  /**
   * Recursive helper method to add a value to the BST.
   *
   * @param current the current node being examined
   * @param value   the value to add
   */
  private void addRecursive(Node current, int value) {
    if (value < current.getValue()) { // Navigate to the left subtree
      if (current.getLeft() == null) {
        current.setLeft(new Node(value)); // Insert the new node
      } else {
        addRecursive(current.getLeft(), value);
      }
    } else { // Navigate to the right subtree
      if (current.getRight() == null) {
        current.setRight(new Node(value)); // Insert the new node
      } else {
        addRecursive(current.getRight(), value);
      }
    }
  }

  /**
   * Deletes a value from the BST.
   *
   * @param value the value to delete
   * @return true if the value was deleted, false otherwise
   */
  public boolean delete(int value) {
    if (root == null) return false; // If the tree is empty, return false

    boolean nodeExists = contains(value); // Check if the value exists
    if (nodeExists) {
      root = deleteRecursive(root, value); // Delete the node recursively
      controller.notifyView(root); // Notify the controller to update the view
      return true;
    }
    return false;
  }

  /**
   * Recursive helper method to delete a value from the BST.
   *
   * @param current the current node being examined
   * @param value   the value to delete
   * @return the updated node after deletion
   */
  private Node deleteRecursive(Node current, int value) {
    if (value == current.getValue()) { // Node to delete found
      if (current.getLeft() == null && current.getRight() == null) {
        return null; // Case 1: No children
      }
      if (current.getRight() == null) {
        return current.getLeft(); // Case 2: One child (left)
      }
      if (current.getLeft() == null) {
        return current.getRight(); // Case 2: One child (right)
      }
      // Case 3: Two children
      int smallestValue = findSmallestValue(current.getRight());
      current.setValue(smallestValue); // Replace with smallest value in right subtree
      current.setRight(deleteRecursive(current.getRight(), smallestValue));
      return current;
    }
    if (value < current.getValue()) {
      current.setLeft(deleteRecursive(current.getLeft(), value)); // Navigate left
      return current;
    }
    current.setRight(deleteRecursive(current.getRight(), value)); // Navigate right
    return current;
  }

  /**
   * Finds the smallest value in a subtree.
   *
   * @param root the root node of the subtree
   * @return the smallest value in the subtree
   */
  private int findSmallestValue(Node root) {
    return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
  }

  /**
   * Performs an inorder traversal of the BST.
   *
   * @return a string of values in inorder sequence
   */
  public String inorder() {
    StringBuilder result = new StringBuilder();
    inorderTraversal(root, result);
    return result.toString().trim();
  }

  private void inorderTraversal(Node node, StringBuilder result) {
    if (node != null) {
      inorderTraversal(node.getLeft(), result);
      result.append(node.getValue()).append(" ");
      inorderTraversal(node.getRight(), result);
    }
  }

  /**
   * Performs a preorder traversal of the BST.
   *
   * @return a string of values in preorder sequence
   */
  public String preorder() {
    StringBuilder result = new StringBuilder();
    preorderTraversal(root, result);
    return result.toString().trim();
  }

  private void preorderTraversal(Node node, StringBuilder result) {
    if (node != null) {
      result.append(node.getValue()).append(" ");
      preorderTraversal(node.getLeft(), result);
      preorderTraversal(node.getRight(), result);
    }
  }

  /**
   * Performs a postorder traversal of the BST.
   *
   * @return a string of values in postorder sequence
   */
  public String postorder() {
    StringBuilder result = new StringBuilder();
    postorderTraversal(root, result);
    return result.toString().trim();
  }

  private void postorderTraversal(Node node, StringBuilder result) {
    if (node != null) {
      postorderTraversal(node.getLeft(), result);
      postorderTraversal(node.getRight(), result);
      result.append(node.getValue()).append(" ");
    }
  }

  /**
   * Checks if a value exists in the BST.
   *
   * @param value the value to check
   * @return true if the value exists, false otherwise
   */
  private boolean contains(int value) {
    return containsRecursive(root, value);
  }

  private boolean containsRecursive(Node current, int value) {
    if (current == null) {
      return false; // Value not found
    }
    if (value == current.getValue()) {
      return true; // Value found
    }
    return value < current.getValue()
        ? containsRecursive(current.getLeft(), value) // Search in left subtree
        : containsRecursive(current.getRight(), value); // Search in right subtree
  }
}

