import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Game extends JFrame{

    //Usman
    Random rand = new Random();
    String[] Locations = {"City", "River", "Forest", "Ocean"};
    static Color[] locationColours = {Color.DARK_GRAY, new Color(0, 0, 255), new Color(1, 50, 32), new Color(0, 0, 139)};
    static int[] locationCoordsX = new int[4];
    int[] locationCoordsY = new int[4];   

    int score = 0;
    static Game game;
    static mapPanel map;
    static boolean havePurchase = false;
    static boolean haveFighters = false;
    static boolean haveDam = false;
    

    public static void main(String[] args){
        
        game = new Game();

    }

    //Written by Usman.
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
        this.setSize(1280, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Protect The Country");
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        GameButtons gameeButtons = new GameButtons();
        this.add(gameeButtons, BorderLayout.SOUTH);
    

        setLocationRelativeTo(null); // Center the frame on the screen


        for (int i = 0; i < 4; i++){
            locationCoordsX[i] = rand.nextInt(50, 1200);
            locationCoordsY[i] = rand.nextInt(50, 600);
        }

        // Ensure that the city is in the middle of the map
        locationCoordsX[0] = 590;
        locationCoordsY[0] = 310;

    }

    //Below is written by Usman. This code is ran at the start of the game to place the locations (city, forest, etc)
    public class mapPanel extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.GREEN); // Green background for the map


            // Draw each area as a small square
            

            for (int i = 0; i < 4; i++){

                int x = locationCoordsX[i];
                int y = locationCoordsY[i];

                g.setColor(locationColours[i]);
                g.fillRect(x, y, 50, 50); // Adjust size and position as needed
                g.setColor(Color.BLACK);
                g.drawString(Locations[i], x, y-5); // Label for the area
        }

        //If any text should be displayed
        if (havePurchase){
            if (haveFighters){
                g.setColor(Color.BLACK);
                g.drawString("Fire Fighters are protecting this area!", locationCoordsX[2]-50, locationCoordsY[2]+65);
            }

        }

            for (int i = 0; i < 4; i++){
                System.out.println(locationCoordsX[i] + " " + locationCoordsY[i]);
            }
        }

    }

    //Written by Usman. Used randomly at the start of a round.
    public static void startFire(){
        locationColours[2] = new Color(255, 165, 0);
        map.repaint();
        System.out.println("Starting Fire");
    }

    public static void buyFireFighters(){
        havePurchase = true;
        haveFighters = true;
        map.repaint();
    }


    public Game(){

        initialization();
        createBackground();
        map = new mapPanel();
        this.add(map, BorderLayout.CENTER);

        this.setVisible(true);

        //following line of code is by zohair
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

    }

}
