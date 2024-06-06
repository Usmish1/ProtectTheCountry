import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.random.*;
import javax.imageio.ImageIO.*;

public class Game extends JFrame{
    
    public static void main(String[] args){
        
        new Game();

    }

    //Below is written by Usman. Used to create the background image of the game.
    public void createBackground(){
    JFrame gameFrame = new JFrame("Protect The Country");
    gameFrame.setSize(1280, 720);
    
    JPanel backgroundPanel = new JPanel();
        try {
            ImageIcon backgroundImage = new ImageIcon(ImageIO.read(new File("C:/Users/usman/OneDrive - Peel District School Board/temp ics/final/ProtectTheCountry/oldmap2.jpg")));
            Image backgroundIMG = backgroundImage.getImage();
            Image temp = backgroundIMG.getScaledInstance(1280,720,Image.SCALE_SMOOTH);
            backgroundImage = new ImageIcon(temp);
            JLabel back = new JLabel(backgroundImage);
            backgroundPanel.add(back);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        backgroundPanel.setVisible(true);
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(Color.green);
        this.setContentPane(backgroundPanel);

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


    public Game(){

        initialization();
        createBackground();

    }

}
