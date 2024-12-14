import static org.junit.jupiter.api.Assertions.*;

import models.BSTModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controllers.BSTController;

public class BSTModelTest {
    private BSTModel bstModel; // Instance of the BSTModel to be tested
    private BSTController controller; // Mock controller to be used in tests

    @BeforeEach
    public void setUp() {
        controller = new BSTController(); // Initialize the controller
        bstModel = new BSTModel(); // Initialize the BSTModel
        bstModel.setController(controller); // Set the controller for the model
    }

    @Test
    public void testAdd() {
        assertTrue(bstModel.add(10)); // Add 10 to the BST
        assertTrue(bstModel.add(5));  // Add 5 to the BST
        assertTrue(bstModel.add(15)); // Add 15 to the BST
        assertFalse(bstModel.add(10)); // Attempt to add duplicate value 10
    }

    @Test
    public void testDelete() {
        bstModel.add(10); // Add 10 to the BST
        bstModel.add(5);  // Add 5 to the BST
        bstModel.add(15); // Add 15 to the BST
        
        assertTrue(bstModel.delete(5)); // Delete 5 from the BST
        assertFalse(bstModel.delete(5)); // Attempt to delete already deleted 5
        assertTrue(bstModel.delete(10)); // Delete 10 from the BST
        assertTrue(bstModel.delete(15)); // Delete 15 from the BST
        assertFalse(bstModel.delete(10)); // Attempt to delete already deleted 10
    }

    @Test
    public void testInorderTraversal() {
        bstModel.add(10); // Add 10 to the BST
        bstModel.add(5);  // Add 5 to the BST
        bstModel.add(15); // Add 15 to the BST
        
        assertEquals("5 10 15", bstModel.inorder()); // Check the result of inorder traversal
    }

    @Test
    public void testPreorderTraversal() {
        bstModel.add(10); // Add 10 to the BST
        bstModel.add(5);  // Add 5 to the BST
        bstModel.add(15); // Add 15 to the BST
        
        assertEquals("10 5 15", bstModel.preorder()); // Check the result of preorder traversal
    }

    @Test
    public void testPostorderTraversal() {
        bstModel.add(10); // Add 10 to the BST
        bstModel.add(5);  // Add 5 to the BST
        bstModel.add(15); // Add 15 to the BST
        
        assertEquals("5 15 10", bstModel.postorder()); // Check the result of postorder traversal
    }
}