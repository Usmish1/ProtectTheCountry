import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private JButton startButton = new JButton("Start");
    private JPanel menuPanel = new JPanel();
    private MapPanel mapPanel = new MapPanel();

    public Game() {
        setTitle("2D Game");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        // Main Menu Panel
        menuPanel.add(startButton);
        

        // Add Map Panel
        cardPanel.add(mapPanel, "Map");
        cardLayout.show(cardPanel, "Map");
        //new Game().setVisible(true);

        // Start Button Action
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Map");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game().setVisible(true);
            }   
        });
    }

    // Custom Panel for Map
    class MapPanel extends JPanel {
        private String[] areas = {"City", "Forest", "Desert", "Mountains"};
        private Color[] areaColors = {Color.GRAY, Color.GREEN, Color.YELLOW, Color.LIGHT_GRAY};

        public MapPanel() {
            setPreferredSize(new Dimension(800, 600));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GREEN); // Green background for the map

            // Draw each area as a small square
            for (int i = 0; i < areas.length; i++) {
                g.setColor(areaColors[i]);
                g.fillRect(50 + i * 100, 250, 50, 50); // Adjust size and position as needed
                g.setColor(Color.BLACK);
                g.drawString(areas[i], 50 + i * 100, 245); // Label for the area
            }
        }
    }
}
