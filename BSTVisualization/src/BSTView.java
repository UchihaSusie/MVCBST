import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.*;


public class BSTView extends JFrame implements ActionListener, KeyListener {
  private JTextField inputField;
  private JButton addButton, deleteButton;
  private JLabel inorderLabel, preorderLabel, postorderLabel;

  private BSTModel model;
  private TreePanel treePanel;

  public BSTView() {
    treePanel = new TreePanel();  
    setTitle("Binary Search Tree Visualization");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initializeComponents();

     // 添加事件监听器
     addButton.addActionListener(this);
     deleteButton.addActionListener(this);
     inputField.addKeyListener(this);
  }

  public void setModel(BSTModel model) {
    this.model = model;
  }

  @Override
  public void actionPerformed(ActionEvent evt) {
    if (!inputField.getText().trim().isEmpty()) {
      try {
        int data = Integer.parseInt(inputField.getText());
        if (evt.getSource() == addButton) {
          if (!model.add(data)) {
            JOptionPane.showMessageDialog(this, 
                "Integer " + data + " already exists, please choose another one",
                "Duplicate Value",
                JOptionPane.INFORMATION_MESSAGE);
            return;
          }
        } else if (evt.getSource() == deleteButton) {
          if (!model.delete(data)) {
            JOptionPane.showMessageDialog(this, 
                "Integer " + data + " does not exist in the tree",
                "Value Not Found",
                JOptionPane.INFORMATION_MESSAGE);
          }
        }
        inputField.setText("");
        inputField.requestFocusInWindow();
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
      if (!inputField.getText().trim().isEmpty()) {
        try {
          int data = Integer.parseInt(inputField.getText());
          if (!model.add(data)) {
            JOptionPane.showMessageDialog(this, 
                "Integer " + data + " already exists, please choose another one",
                "Duplicate Value",
                JOptionPane.INFORMATION_MESSAGE);
            return;
          }
          inputField.setText("");
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(this, 
              "Please enter a valid integer!",
              "Invalid Input",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    } else if (c == 'd' || c == 'D') {
      if (!inputField.getText().trim().isEmpty()) {
        try {
          int data = Integer.parseInt(inputField.getText());
          if (!model.delete(data)) {
            JOptionPane.showMessageDialog(this, 
                "Integer " + data + " does not exist in the tree",
                "Value Not Found",
                JOptionPane.INFORMATION_MESSAGE);
          }
          inputField.setText("");
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

  private void initializeComponents() {
    JPanel controlPanel = new JPanel();
    inputField = new JTextField(10);
    addButton = new JButton("Add");
    deleteButton = new JButton("Delete");

    controlPanel.add(new JLabel("Value:"));
    controlPanel.add(inputField);
    controlPanel.add(addButton);
    controlPanel.add(deleteButton);

    JPanel traversalPanel = new JPanel();
    inorderLabel = new JLabel("Inorder: ");
    preorderLabel = new JLabel("Preorder: ");
    postorderLabel = new JLabel("Postorder: ");

    traversalPanel.setLayout(new BoxLayout(traversalPanel, BoxLayout.Y_AXIS));
    traversalPanel.add(inorderLabel);
    traversalPanel.add(preorderLabel);
    traversalPanel.add(postorderLabel);

    add(treePanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.NORTH);
    add(traversalPanel, BorderLayout.SOUTH);
  }

  public JTextField getInputField() {
    return inputField;
  }

  public JButton getAddButton() {
    return addButton;
  }

  public JButton getDeleteButton() {
    return deleteButton;
  }

  public void updateTraversal(String inorder, String preorder, String postorder) {
    inorderLabel.setText("Inorder: " + inorder);
    preorderLabel.setText("Preorder: " + preorder);
    postorderLabel.setText("Postorder: " + postorder);
  }

}

