package views;

import javax.swing.*;

public class ControlPanel extends JPanel{
    private JTextField inputField;
    private JButton addButton, deleteButton;

    public ControlPanel() {
        inputField = new JTextField(10);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");

        add(new JLabel("Value:"));
        add(inputField);
        add(addButton);
        add(deleteButton);
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
    
}
