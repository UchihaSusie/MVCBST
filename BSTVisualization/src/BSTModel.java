public class BSTModel implements BSTModelInterface{
  private Node root;
  private BSTController controller;

  public void setController(BSTController controller){
    this.controller = controller;
  }


  public boolean add(int value) {
    if (contains(value)) {
      return false;
    }
    
    if (root == null) {
      root = new Node(value);
      //notifyView();
      controller.notifyView(root);
      return true;
    }
    
    addRecursive(root, value);
    //notifyView();
    controller.notifyView(root);
    return true;
  }

  private void addRecursive(Node current, int value) {
    if (value < current.getValue()) {
      if (current.getLeft() == null) {
        current.setLeft(new Node(value));;
      } else {
        addRecursive(current.getLeft(), value);
      }
    } else {
      if (current.getRight() == null) {
        current.setRight(new Node(value));
      } else {
        addRecursive(current.getRight(), value);
      }
    }
  }

  // Delete a node in the BST
  public boolean delete(int value) {
    if (root == null) return false;
    
    boolean nodeExists = contains(value);
    if (nodeExists) {
      root = deleteRecursive(root, value);
      controller.notifyView(root);
      //notifyView();
      return true;
    }
    return false;
  }

  private Node deleteRecursive(Node current, int value) {
    if (value == current.getValue()) {
      // Node to delete found
      if (current.getLeft() == null && current.getRight() == null) {
        return null;
      }
      if (current.getRight() == null) {
        return current.getLeft();
      }
      if (current.getLeft() == null) {
        return current.getRight();
      }
      // Node with two children: get smallest in right subtree
      int smallestValue = findSmallestValue(current.getRight());
      current.setValue(smallestValue);
      current.setRight(deleteRecursive(current.getRight(), smallestValue)); 
      return current;
    }
    if (value < current.getValue()) {
      current.setLeft(deleteRecursive(current.getLeft(), value));
      return current;
    }
    current.setRight(deleteRecursive(current.getRight(), value)); 
    return current;
  }

  private int findSmallestValue(Node root) {
    return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
  }

  // Traversals
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

  //Check if contain when add and delete
  private boolean contains(int value) {
    return containsRecursive(root, value);
  }

  private boolean containsRecursive(Node current, int value) {
    if (current == null) {
      return false;
    }
    if (value == current.getValue()) {
      return true;
    }
    return value < current.getValue()
        ? containsRecursive(current.getLeft(), value)
        : containsRecursive(current.getRight(), value);
  }
}
