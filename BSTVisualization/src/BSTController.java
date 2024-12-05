import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class BSTController {
  private BSTModel model;
  private BSTView view;

  public BSTController(BSTModel model, BSTView view) {
    this.model = model;
    this.view = view;

    view.getAddButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          int value = Integer.parseInt(view.getInputField().getText());
          model.add(value);
          updateView();
        } catch (NumberFormatException ex) {
          System.out.println("Invalid input!");
        }
      }
    });

    view.getDeleteButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {

          int value = Integer.parseInt(view.getInputField().getText());

//          if (e.getSource() == deleteButton) {
//            model.add(value);
//          } else {
//            model.delete(value);
//          }
//          inputField.setText("");
//          inputField.requestFocusInWindow();
          model.delete(value);
          updateView();
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "Please Enter Integer.");
        }
      }
    });
  }

  private void updateView() {
    String inorder = model.inorder();
    String preorder = model.preorder();
    String postorder = model.postorder();
    view.updateTraversal(inorder, preorder, postorder);
  }
}

