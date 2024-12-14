import static org.junit.jupiter.api.Assertions.*;

import controllers.BSTController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import javax.swing.*;
import views.BSTView;

public class BSTViewTest {

    private BSTView bstView;
    private BSTController mockController;

    @BeforeEach
    public void setUp() {
        bstView = new BSTView();
        mockController = Mockito.mock(BSTController.class);
        bstView.setController(mockController);
    }

    @Test
    public void testAddNode() {
        JTextField inputField = bstView.getInputField();
        JButton addButton = bstView.getAddButton();

        // Simulate user input
        inputField.setText("10");
        Mockito.when(mockController.add(10)).thenReturn(true);

        // Simulate button click
        addButton.doClick();

        // Verify that the controller's add method was called
        Mockito.verify(mockController).add(10);
        assertEquals("", inputField.getText()); // Input field should be cleared
    }

    @Test
    public void testAddDuplicateNode() {
        JTextField inputField = bstView.getInputField();
        JButton addButton = bstView.getAddButton();

        // Simulate user input
        inputField.setText("10");
        Mockito.when(mockController.add(10)).thenReturn(false);

        // Simulate button click
        addButton.doClick();

        // Verify that the controller's add method was called
        Mockito.verify(mockController).add(10);
        // Check for dialog message (you may need to implement a way to capture dialog output)
    }

    @Test
    public void testDeleteNode() {
        JTextField inputField = bstView.getInputField();
        JButton deleteButton = bstView.getDeleteButton();

        // Simulate user input
        inputField.setText("10");
        Mockito.when(mockController.delete(10)).thenReturn(true);

        // Simulate button click
        deleteButton.doClick();

        // Verify that the controller's delete method was called
        Mockito.verify(mockController).delete(10);
        assertEquals("", inputField.getText()); // Input field should be cleared
    }

    @Test
    public void testDeleteNonExistentNode() {
        JTextField inputField = bstView.getInputField();
        JButton deleteButton = bstView.getDeleteButton();

        // Simulate user input
        inputField.setText("10");
        Mockito.when(mockController.delete(10)).thenReturn(false);

        // Simulate button click
        deleteButton.doClick();

        // Verify that the controller's delete method was called
        Mockito.verify(mockController).delete(10);
        // Check for dialog message (you may need to implement a way to capture dialog output)
    }
}