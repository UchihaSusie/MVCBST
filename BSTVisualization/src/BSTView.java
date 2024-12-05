import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class BSTView extends JFrame implements ActionListener, KeyListener {
  private JTextField inputField;
  private JButton addButton, deleteButton;
  private JLabel inorderLabel, preorderLabel, postorderLabel;

  private BSTModel model;
  public BSTView() {
    setTitle("Binary Search Tree Visualization");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initializeComponents();
  }


  @Override
  public void actionPerformed(ActionEvent evt) {
    if (inputField.isEnabled()) {
      try {
        int data = Integer.parseInt(inputField.getText());
        if (evt.getSource() == deleteButton) {
          model.add(data);
        } else {
          model.delete(data);
        }
        inputField.setText("");
        inputField.requestFocusInWindow();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Please Enter Integer.");
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent evt) {
    char c = evt.getKeyChar();
    if (!inputField.isEnabled()) {
      return;
    } else if (c == 'a' || c == 'A' || c == '\n') {
      try {
        String data = inputField.getText();
        evt.consume(); // Not type 'a' or 'A' character in textfield
        if (!data.isEmpty()) {
          model.add(Integer.parseInt(data));
        } else {

          throw new Exception();
        }
        inputField.requestFocusInWindow();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Please Enter Integer.");
      }
      inputField.setText("");
    } else if (c == 'd' || c == 'D') {
      try {
        String data = inputField.getText();
        evt.consume(); // Not type 'd' or 'D' character in textfield
        if (!data.isEmpty()) {
          model.delete(Integer.parseInt(data));
        }
        inputField.requestFocusInWindow();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Please Enter Integer.");
      }
      inputField.setText("");
    } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
      evt.consume();
  }

  @Override
  public void keyPressed(KeyEvent evt) {
  }

  @Override
  public void keyReleased(KeyEvent evt) {
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

