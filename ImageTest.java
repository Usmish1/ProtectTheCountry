import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

public class ImageTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("PROTECTTHECITY");
        f.setSize(1280, 720);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load your background image (e.g., "oldmap2.jpg")
        String imagePath = "/Users/zohairbaqai/Documents/GitHub/ProtectTheCountry/oldmap2.jpg";
        BackgroundPanel backgroundPanel = new BackgroundPanel(imagePath);
        backgroundPanel.setLayout(null); // Use your preferred layout manager

        // Add your buttons, labels, and other components to the backgroundPanel
        // ...

        f.setContentPane(backgroundPanel);
        f.setVisible(true);
    }
}
