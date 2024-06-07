import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Game extends JFrame{

    Random rand = new Random();


    String[] Locations = {"City", "River", "Forest", "Ocean"};
    Color[] locationColors = {Color.DARK_GRAY, new Color(0, 0, 255), new Color(1, 50, 32), new Color(0, 0, 139)};
    int[] locationCoordsX = new int[4];
    int[] locationCoordsY = new int[4];   
    

    public static void main(String[] args){
        
        new Game();

    }

    //Below is written by Usman. Used to create the background image of the game. Currently doesn't work.
    // public void createBackgroundImage(){
    //     JPanel backgroundPanel = new JPanel();
    //     try {
    //         File file = new File("oldmap2.jpg");
    //         System.out.println("File exists: " + file.exists());
    //         System.out.println("File size: " + file.length() + " bytes");
    //         file.setReadable(true);
    //         Image backgroundImage = ImageIO.read(file);
    //         Image temp = backgroundImage.getScaledInstance(1280,720,Image.SCALE_SMOOTH);
    //         ImageIcon imageIcon = new ImageIcon(temp);
    //         JLabel back = new JLabel(imageIcon);
    //         backgroundPanel.add(back);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         System.out.println(e.getMessage());
    //     }

    //     this.setBackground(darkGreen);
        
    //     backgroundPanel.setVisible(true);
    //     backgroundPanel.setLayout(null);
    //     backgroundPanel.setBackground(Color.green);
    //     // this.setContentPane(backgroundPanel);
    //     // this.add(backgroundPanel);
    //     this.setVisible(true);
    // }

    public void createBackground(){

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(Color.gray);
        backgroundPanel.setVisible(true);
        this.add(backgroundPanel);
        this.setVisible(true);

    }


    //Below is writting by Usman. This code is ran when the Game class is created.
    public void initialization(){
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Protect The Country");
        this.setResizable(false);
        setLocationRelativeTo(null); // Center the frame on the screen


        for (int i = 0; i < 4; i++){
            locationCoordsX[i] = rand.nextInt(50, 1200);
            locationCoordsY[i] = rand.nextInt(50, 620);
        }

    }

    //Below is written by Usman. This code is ran at the start of the game to place the locations (city, forest, etc)
    public class mapPanel extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GREEN); // Green background for the map

            String[] Locations = {"City", "River", "Forest", "Ocean"};
            Color[] locationColors = {Color.DARK_GRAY, new Color(0, 0, 255), new Color(1, 50, 32), new Color(0, 0, 139)};
            int[] locationCoordsX = new int[4];
            int[] locationCoordsY = new int[4];

            // Draw each area as a small square
            

            for (int i = 0; i < 4; i++){

                int x = locationCoordsX[i];
                int y = locationCoordsY[i];

                g.fillRect(x, y, 50, 50); // Adjust size and position as needed
                g.setColor(Color.BLACK);
                g.drawString(Locations[i], x, y-5); // Label for the area
        }

            for (int i = 0; i < 4; i++){
                System.out.println(locationCoordsX[i] + " " + locationCoordsY[i]);
                g.fillRect(locationCoordsX[i], locationCoordsY[i], 5, 5);
                g.drawString(locationCoordsX[i] + " " + locationCoordsY[i], locationCoordsX[i], locationCoordsY[i]-20);
            }
        }

    }


    public Game(){

        initialization();
        createBackground();
        mapPanel map = new mapPanel();
        this.add(map);
        this.setVisible(true);

    }

}
