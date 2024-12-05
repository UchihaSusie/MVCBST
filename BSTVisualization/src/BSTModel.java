public class BSTModel {
  private Node root;

  // Node class for tree structure
  private static class Node {
    int value;
    Node left, right;

    Node(int value) {
      this.value = value;
    }
  }

  // Add node to the BST
  public boolean add(int value) {
    if (root == null) {
      root = new Node(value);
      return true;
    }
    return addRecursive(root, value);
  }

  private boolean addRecursive(Node current, int value) {
    if (value == current.value) return false; // Duplicate values not allowed
    if (value < current.value) {
      if (current.left == null) {
        current.left = new Node(value);
        return true;
      }
      return addRecursive(current.left, value);
    } else {
      if (current.right == null) {
        current.right = new Node(value);
        return true;
      }
      return addRecursive(current.right, value);
    }
  }

  // Delete a node
  public boolean delete(int value) {
    root = deleteRecursive(root, value);
    return root != null;
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
}
