import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import controllers.BSTController;
import models.BSTModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import views.BSTView;

// Testing BSTController class
public class BSTControllerTest {
    private BSTModel model;
    private BSTView view;
    private BSTController controller;

    @BeforeEach
    public void setUp() {
        model = mock(BSTModel.class); // Creating a mock object for the model
        view = mock(BSTView.class); // Creating a mock object for the view
        controller = new BSTController(model, view); // Initializing the controller
    }

    @Test
    public void testAdd() {
        int data = 5;
        when(model.add(data)).thenReturn(true); // Mocking successful addition

        boolean result = controller.add(data);
        assertTrue(result); // Verifying the return value is true
        verify(model).add(data); // Verifying the model's add method was called
    }

    @Test
    public void testDelete() {
        int data = 5;
        when(model.delete(data)).thenReturn(true); // Mocking successful deletion

        boolean result = controller.delete(data);
        assertTrue(result); // Verifying the return value is true
        verify(model).delete(data); // Verifying the model's delete method was called
    }

    @Test
    public void testNotifyView() {
        Node root = new Node(5); // Creating a root node
        controller.notifyView(root); // Notifying the view

        verify(view).updateTreePanel(root); // Verifying the view updates the tree panel
        verify(view).updateTraversal(anyList(), anyList(), anyList()); // Verifying the view updates traversal results
    }
}