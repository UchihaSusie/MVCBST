import javax.swing.JPanel;
import java.awt.*;

public class TreePanel extends JPanel {
    private Node root;
    private final int VERTEX_DIAMETER = 30;
    private final int VERTICAL_GAP = 50;
    private final int INITIAL_X = 400;  // 起始X坐标（屏幕中心）
    private final int INITIAL_Y = 30;   // 起始Y坐标（顶部留空）

    public TreePanel() {
        super();
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.LIGHT_GRAY);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, INITIAL_X, INITIAL_Y, getWidth() / 4);
        }
    }
    
    private void drawTree(Graphics g, Node node, int x, int y, int offset) {
        // draw node circle
        g.setColor(Color.PINK);
        g.fillOval(x - VERTEX_DIAMETER/2, y - VERTEX_DIAMETER/2, 
                   VERTEX_DIAMETER, VERTEX_DIAMETER);
        g.setColor(Color.WHITE);
        g.drawOval(x - VERTEX_DIAMETER/2, y - VERTEX_DIAMETER/2, 
                   VERTEX_DIAMETER, VERTEX_DIAMETER);
        
        // draw node value
        String value = String.valueOf(node.getValue());
        FontMetrics fm = g.getFontMetrics();
        int stringX = x - fm.stringWidth(value)/2;
        int stringY = y + fm.getHeight()/4;
        g.drawString(value, stringX, stringY);
        
        // draw left subtree
        if (node.getLeft() != null) {
            int childX = x - offset;
            int childY = y + VERTICAL_GAP;
            g.drawLine(x, y, childX, childY);
            drawTree(g, node.getLeft(), childX, childY, offset/2);
        }
        
        // draw right subtree
        if (node.getRight() != null) {
            int childX = x + offset;
            int childY = y + VERTICAL_GAP;
            g.drawLine(x, y, childX, childY);
            drawTree(g, node.getRight(), childX, childY, offset/2);
        }
    }
    
    public void updateTree(Node root) {
        this.root = root;
        repaint();
    }
} 