import javax.swing.*;

public class TraversalPanel extends JPanel {
    private JLabel inorderLabel;
    private JLabel preorderLabel;
    private JLabel postorderLabel;

    public TraversalPanel() {
        inorderLabel = new JLabel("Inorder: ");
        preorderLabel = new JLabel("Preorder: ");
        postorderLabel = new JLabel("Postorder: ");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(inorderLabel);
        add(preorderLabel);
        add(postorderLabel);
    }

    public void updateTraversal(String inorder, String preorder, String postorder) {
        inorderLabel.setText("Inorder: " + inorder);
        preorderLabel.setText("Preorder: " + preorder);
        postorderLabel.setText("Postorder: " + postorder);
    }
}
