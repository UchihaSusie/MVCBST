import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.*;


public class BSTView extends JFrame implements ActionListener, KeyListener, BSTViewInterface {
  //private BSTModel model;
  private BSTController controller;
  private TreePanel treePanel;
  private ControlPanel controlPanel;
  private TraversalPanel traversalPanel;

  public BSTView() {
    treePanel = new TreePanel();
    controlPanel = new ControlPanel();
    traversalPanel = new TraversalPanel();

    setTitle("Binary Search Tree Visualization");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // set up layout
    add(treePanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.NORTH);
    add(traversalPanel, BorderLayout.SOUTH);

  }

  public void setController(BSTController controller){
    this.controller = controller;
  }
  
  // public void setModel(BSTModel model) {
  //   this.model = model;
  // }

  @Override
  public void actionPerformed(ActionEvent evt) {
    if (!controlPanel.getInputField().getText().trim().isEmpty()) {
      try {
        int data = Integer.parseInt(controlPanel.getInputField().getText());
        if (evt.getSource() == controlPanel.getAddButton()) {
          if (!controller.add(data)) {
            JOptionPane.showMessageDialog(this, 
                "Integer " + data + " already exists, please choose another one",
                "Duplicate Value",
                JOptionPane.INFORMATION_MESSAGE);
          }
        } else if (evt.getSource() == controlPanel.getDeleteButton()) {
          if (!controller.delete(data)) {
            JOptionPane.showMessageDialog(this, 
                "Integer " + data + " does not exist in the tree",
                "Value Not Found",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
        controlPanel.getInputField().setText("");
        controlPanel.getInputField().requestFocusInWindow();
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "Please enter a valid integer!",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent evt) {
    char c = evt.getKeyChar();
    if (c == '\n') {  // 回车键
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
    } else if ((c < '0' || c > '9') && c != '\b') {  // 只允许输入数字和退格键
      evt.consume();
    }
  }

  @Override
  public void keyPressed(KeyEvent evt) {
  }

  @Override
  public void keyReleased(KeyEvent evt) {
  }

  public void updateTreePanel(Node root) {
    treePanel.updateTree(root);
  }

  public void updateTraversal(String inorder, String preorder, String postorder) {
    traversalPanel.updateTraversal(inorder, preorder, postorder);
  }

  public JButton getAddButton() {
    return controlPanel.getAddButton();
  }

  public JButton getDeleteButton() {
    return controlPanel.getDeleteButton();
  }

  public JTextField getInputField() {
    return controlPanel.getInputField();
  }

}

