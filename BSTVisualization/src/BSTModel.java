public class BSTModel {
  private Node root;
  private BSTView view;

  public void setView(BSTView view) {
    this.view = view;
  }

  private void notifyView() {
    if (view != null) {
      view.updateTreePanel(root);
      view.updateTraversal(
        inorder(),
        preorder(),
        postorder()
      );
    }
  }

  public Node getRoot() {
    return root;
}

  // Add node to the BST
  public boolean add(int value) {
    if (contains(value)) {
      return false;
    }
    
    if (root == null) {
      root = new Node(value);
      notifyView();
      return true;
    }
    
    addRecursive(root, value);
    notifyView();
    return true;
  }

  private void addRecursive(Node current, int value) {
    if (value < current.value) {
      if (current.left == null) {
        current.left = new Node(value);
      } else {
        addRecursive(current.left, value);
      }
    } else {
      if (current.right == null) {
        current.right = new Node(value);
      } else {
        addRecursive(current.right, value);
      }
    }
  }

  // Delete a node in the BST
  public boolean delete(int value) {
    if (root == null) return false;
    
    boolean nodeExists = contains(value);
    if (nodeExists) {
      root = deleteRecursive(root, value);
      notifyView();
      return true;
    }
    return false;
  }

  private Node deleteRecursive(Node current, int value) {
    if (current == null) return null;
    if (value == current.value) {
      // Node to delete found
      if (current.left == null && current.right == null) {
        return null;
      }
      if (current.right == null) {
        return current.left;
      }
      if (current.left == null) {
        return current.right;
      }
      // Node with two children: get smallest in right subtree
      int smallestValue = findSmallestValue(current.right);
      current.value = smallestValue;
      current.right = deleteRecursive(current.right, smallestValue);
      return current;
    }
    if (value < current.value) {
      current.left = deleteRecursive(current.left, value);
      return current;
    }
    current.right = deleteRecursive(current.right, value);
    return current;
  }

  private int findSmallestValue(Node root) {
    return root.left == null ? root.value : findSmallestValue(root.left);
  }

  // Traversals
  public String inorder() {
    StringBuilder result = new StringBuilder();
    inorderTraversal(root, result);
    return result.toString().trim();
  }

  private void inorderTraversal(Node node, StringBuilder result) {
    if (node != null) {
      inorderTraversal(node.left, result);
      result.append(node.value).append(" ");
      inorderTraversal(node.right, result);
    }
  }

  public String preorder() {
    StringBuilder result = new StringBuilder();
    preorderTraversal(root, result);
    return result.toString().trim();
  }

  private void preorderTraversal(Node node, StringBuilder result) {
    if (node != null) {
      result.append(node.value).append(" ");
      preorderTraversal(node.left, result);
      preorderTraversal(node.right, result);
    }
  }

  public String postorder() {
    StringBuilder result = new StringBuilder();
    postorderTraversal(root, result);
    return result.toString().trim();
  }

  private void postorderTraversal(Node node, StringBuilder result) {
    if (node != null) {
      postorderTraversal(node.left, result);
      postorderTraversal(node.right, result);
      result.append(node.value).append(" ");
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
    if (value == current.value) {
      return true;
    }
    return value < current.value 
        ? containsRecursive(current.left, value)
        : containsRecursive(current.right, value);
  }
}
