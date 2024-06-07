import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.random.*;
import javax.imageio.ImageIO.*;;

public class OldGame extends JFrame {
    Random rand = new Random();

    //Background image:
    ImageIcon backgroundImage = new ImageIcon("oldmap2.jpg");
    Image backgroundIMG = backgroundImage.getImage();
    Image temp = backgroundIMG.getScaledInstance(1280,720,Image.SCALE_SMOOTH);
    background=new ImageIcon(temp);
    JLabel back=new JLabel(backgroundImage);
    back.setLayout(null);
    back.setBounds(0,0,500,600);



    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private JButton startButton = new JButton("Start");
    private JPanel menuPanel = new JPanel();
    private MapPanel mapPanel = new MapPanel();

    public OldGame() {
        setTitle("2D OldGame");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        

        // Add Map Panel
        cardPanel.add(mapPanel, "Map");
        cardLayout.show(cardPanel, "Map");

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
                new OldGame().setVisible(true);
            }   
        });
    }

    // Custom Panel for Map
    class MapPanel extends JPanel {
        private String[] areas = {"City", "Forest", "Desert", "Mountains"};
        private Color[] areaColors = {Color.GRAY, Color.BLUE, Color.YELLOW, Color.LIGHT_GRAY};

        public MapPanel() {
            setPreferredSize(new Dimension(1280, 720));

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GREEN); // Green background for the map

            // Draw each area as a small square
            for (int i = 0; i < areas.length; i++) {
                g.setColor(areaColors[i]);
                int x = rand.nextInt(50, 1230);
                int y = rand.nextInt(50, 670);
                g.fillRect(x, y, 50, 50); // Adjust size and position as needed
                g.setColor(Color.BLACK);
                g.drawString(areas[i], x, y); // Label for the area
            }
        }
    }
}
