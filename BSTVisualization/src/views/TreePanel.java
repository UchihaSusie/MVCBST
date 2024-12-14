package views;

import javax.swing.JPanel;
import java.awt.*;
import models.Node;

/**
 * The TreePanel class is responsible for visually rendering the binary search tree (BST)
 * on a JPanel. It uses custom drawing to display the tree structure, including nodes and edges.
 * This is part of the View in the MVC design pattern for the BST visualization application.
 */
public class TreePanel extends JPanel {

    // The root node of the binary search tree to be displayed.
    private Node root;

    // Diameter of each tree node (circle) in pixels.
    private final int VERTEX_DIAMETER = 30;

    // Vertical gap between parent and child nodes in pixels.
    private final int VERTICAL_GAP = 50;

    // Initial horizontal position for the root node.
    private final int INITIAL_X = 400;

    // Initial vertical position for the root node.
    private final int INITIAL_Y = 30;

    /**
     * Constructor for TreePanel.
     * Initializes the panel with a preferred size and a light gray background.
     */
    public TreePanel() {
        super();
        setPreferredSize(new Dimension(800, 600)); // Set the panel's size.
        setBackground(Color.LIGHT_GRAY); // Set the background color of the panel.
    }

    /**
     * Paints the component, including the tree structure.
     * This method is called automatically by Swing whenever the panel needs to be rendered.
     *
     * @param g The Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method to clear the panel.
        if (root != null) {
            // Start drawing the tree from the root node at the initial position.
            drawTree(g, root, INITIAL_X, INITIAL_Y, getWidth() / 4);
        }
    }

    /**
     * Recursively draws the binary tree, including nodes and edges.
     *
     * @param g       The Graphics object used for drawing.
     * @param node    The current node being drawn.
     * @param x       The x-coordinate of the current node.
     * @param y       The y-coordinate of the current node.
     * @param offset  The horizontal offset for child nodes.
     */
    private void drawTree(Graphics g, Node node, int x, int y, int offset) {
        // Draw the node as a pink circle with a white border.
        g.setColor(Color.PINK); // Set color for the filled circle.
        g.fillOval(x - VERTEX_DIAMETER / 2, y - VERTEX_DIAMETER / 2, VERTEX_DIAMETER, VERTEX_DIAMETER);
        g.setColor(Color.WHITE); // Set color for the circle's border.
        g.drawOval(x - VERTEX_DIAMETER / 2, y - VERTEX_DIAMETER / 2, VERTEX_DIAMETER, VERTEX_DIAMETER);

        // Draw the node's value (centered within the circle).
        String value = String.valueOf(node.getValue()); // Get the node's value as a string.
        FontMetrics fm = g.getFontMetrics(); // Get font metrics to center the value text.
        int stringX = x - fm.stringWidth(value) / 2; // Calculate x-coordinate for centering text.
        int stringY = y + fm.getHeight() / 4; // Calculate y-coordinate for centering text.
        g.drawString(value, stringX, stringY); // Draw the node's value.

        // Draw the left subtree if it exists.
        if (node.getLeft() != null) {
            int childX = x - offset; // Calculate the x-coordinate for the left child.
            int childY = y + VERTICAL_GAP; // Calculate the y-coordinate for the left child.
            g.drawLine(x, y, childX, childY); // Draw a line from the current node to the left child.
            drawTree(g, node.getLeft(), childX, childY, offset / 2); // Recursively draw the left subtree.
        }

        // Draw the right subtree if it exists.
        if (node.getRight() != null) {
            int childX = x + offset; // Calculate the x-coordinate for the right child.
            int childY = y + VERTICAL_GAP; // Calculate the y-coordinate for the right child.
            g.drawLine(x, y, childX, childY); // Draw a line from the current node to the right child.
            drawTree(g, node.getRight(), childX, childY, offset / 2); // Recursively draw the right subtree.
        }
    }

    /**
     * Updates the tree to be displayed and triggers a repaint.
     * This method is called whenever the tree structure changes.
     *
     * @param root The new root node of the tree to display.
     */
    public void updateTree(Node root) {
        this.root = root; // Update the root node.
        repaint(); // Trigger a repaint to refresh the panel.
    }
}
