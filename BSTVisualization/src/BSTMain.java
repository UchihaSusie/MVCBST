import controllers.BSTController;
import models.BSTModel;
import views.BSTView;

/**
 * The main class for the Binary Search Tree (BST) application.
 * This class serves as the entry point to initialize the MVC components
 * (Model, View, and Controller) and demonstrate basic BST operations.
 */
public class BSTMain {

  /**
   * The main method of the application.
   * It initializes the model, view, and controller, sets up the UI,
   * and demonstrates adding nodes to the BST.
   *
   * @param args Command-line arguments (not used in this application).
   */
  public static void main(String[] args) {
    // Create the model for the BST, which stores the tree data structure.
    BSTModel model = new BSTModel();

    // Create the view for visualizing the BST, including the UI components.
    BSTView view = new BSTView();

    // Create the controller, which manages the interaction between the model and the view.
    BSTController controller = new BSTController(model, view);

    // Make the view (user interface) visible.
    view.setVisible(true);

    // Add some nodes to the BST using the controller.
    // These calls demonstrate inserting nodes and updating the visualization.
    controller.add(500); // Add a root node with the value 500.
    controller.add(250); // Add a left child of 500 with the value 250.
    controller.add(350); // Add a right child of 250 with the value 350.
    controller.add(200); // Add a left child of 250 with the value 200.
    controller.add(750); // Add a right child of 500 with the value 750.
    controller.add(1000); // Add a right child of 750 with the value 1000.
    controller.add(700); // Add a left child of 750 with the value 700.
    controller.add(740); // Add a right child of 700 with the value 740.

    // At this point, the tree has been constructed and can be visualized via the BSTView.
  }
}
