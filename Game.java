import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Game extends JFrame{

    public Color darkGreen = new Color(1, 50, 32);
    
    public static void main(String[] args){
        
        new Game();

    }

    //Below is written by Usman. Used to create the background image of the game. Currently doesn't work.
    public void createBackgroundImage(){
        JPanel backgroundPanel = new JPanel();
        try {
            File file = new File("oldmap2.jpg");
            System.out.println("File exists: " + file.exists());
            System.out.println("File size: " + file.length() + " bytes");
            file.setReadable(true);
            Image backgroundImage = ImageIO.read(file);
            Image temp = backgroundImage.getScaledInstance(1280,720,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(temp);
            JLabel back = new JLabel(imageIcon);
            backgroundPanel.add(back);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        this.setBackground(darkGreen);
        
        backgroundPanel.setVisible(true);
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(Color.green);
        // this.setContentPane(backgroundPanel);
        // this.add(backgroundPanel);
        this.setVisible(true);
    }

    public void createBackground(){

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(darkGreen);
        backgroundPanel.setVisible(true);
        this.add(backgroundPanel);
        this.setVisible(true);

    }


    //Below is writting by Usman. This code is ran when the Game class is created.
    public void initialization(){
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Protect The Country");
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    //Below is written by Usman. This code is ran at the start of the game to place the points of interest (city, forest, etc)
    public void placePois(){

        
    }


    public Game(){

        initialization();
        createBackground();

    }

}
