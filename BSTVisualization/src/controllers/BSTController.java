package controllers;

// Importing required classes and interfaces
import models.BSTModel; // The model representing the Binary Search Tree
import models.Node; // A node in the Binary Search Tree
import views.BSTView; // The view that represents the UI for the BST

// The controller class to handle interactions between the model and view
public class BSTController implements BSTControllerInterface {
  private BSTModel model; // The model instance (logic and data for the BST)
  private BSTView view; // The view instance (UI representation)

  /**
   * Constructor to initialize the BSTController with the model and view.
   * It sets up necessary listeners and establishes a connection between
   * the view, model, and controller.
   *
   * @param model the BST model instance
   * @param view  the BST view instance
   */
  public BSTController(BSTModel model, BSTView view) {
    this.model = model;
    this.view = view;

    // Linking the view and model with the controller
    this.view.setController(this);
    this.model.setController(this);

    // Adding action listeners for user interactions in the view
    view.getAddButton().addActionListener(view); // Handles add button clicks
    view.getDeleteButton().addActionListener(view); // Handles delete button clicks
    view.getInputField().addKeyListener(view); // Handles keyboard input in the input field
  }

  /**
   * Adds a data element to the Binary Search Tree.
   *
   * @param data the integer value to add to the tree
   * @return true if the element was successfully added, false otherwise
   */
  public boolean add(int data) {
    return this.model.add(data); // Delegate the addition to the model
  }

  /**
   * Deletes a data element from the Binary Search Tree.
   *
   * @param data the integer value to delete from the tree
   * @return true if the element was successfully deleted, false otherwise
   */
  public boolean delete(int data) {
    return this.model.delete(data); // Delegate the deletion to the model
  }

  /**
   * Notifies the view about changes in the tree structure.
   * Updates the tree panel and traversal results in the UI.
   *
   * @param root the root node of the updated Binary Search Tree
   */
  public void notifyView(Node root) {
    if (this.view != null) {
      // Update the visual representation of the tree in the view
      this.view.updateTreePanel(root);

      // Update the traversal outputs (inorder, preorder, postorder)
      this.view.updateTraversal(
          this.model.inorder(),  // Get and display the inorder traversal
          this.model.preorder(), // Get and display the preorder traversal
          this.model.postorder() // Get and display the postorder traversal
      );
    }
  }
}
