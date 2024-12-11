import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;

public class Node {
    static int TEXT_WIDTH = 40;
    static int TEXT_HEIGHT = 40;
    JLabel data;
    Node left;
    Node right;
    Points p;
    int value;


    Node(int info) {
      data = new JLabel(info + "", SwingConstants.CENTER);
      data.setFont(new Font("Arial", Font.BOLD, 20));
      data.setBorder(BorderFactory.createLineBorder(Color.black));
      data.setOpaque(true);
      data.setBackground(Color.green);
      p = null;
      this.value = info;
    }

    public int getData() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    protected Height calculateHeight(Node root) {
        if (root == null) {
            return new Height();
        }
        Height leftChild = calculateHeight(root.left);
        Height rightChild = calculateHeight(root.right);
        Height current = new Height(leftChild.root, rightChild.root);
        current.root = 1 + Math.max(leftChild.root, rightChild.root);
        return current;
    }

  }
