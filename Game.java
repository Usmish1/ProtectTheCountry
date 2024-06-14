import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

public class Game extends JFrame{

    //Usman
    static Random rand = new Random();
    String[] Locations = {"City", "River", "Forest", "Ocean"};
    static Color[] locationColours = {Color.DARK_GRAY, new Color(0, 0, 255), new Color(1, 50, 32), new Color(0, 0, 139)};
    static int[] locationCoordsX = new int[4];
    static int[] locationCoordsY = new int[4];   
    static int[] locationSizes = {50, 50, 50, 50};


    static int score = 0;
    static Game game;
    static mapPanel map;
    static GameButtons gameButtons;

    public static DecimalFormat formatter = new DecimalFormat("#,###");


    static boolean havePurchase = false;
    static boolean haveFighters = false;
    static boolean haveDam = false;
    static boolean haveEarthquakeAlarm = false;
    static boolean haveTsunamiAlarm = false;
    static boolean haveTornadoSiren = false;

    static String[] events = new String[] {"A Fire Has Destroyed Part of the Forest!", "A Flash Flood Occured!", "Tsunami!!", "Earthquake Imminent!!", "Tornado!!!"};

    static int coins = 5000000;
    static int lost;
    

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
        gameButtons = new GameButtons();
        this.add(gameButtons, BorderLayout.SOUTH);
    

        setLocationRelativeTo(null); // Center the frame on the screen

        int e = 0;
        while (e < 4){
            locationCoordsX[e] = rand.nextInt(50, 1200);
            locationCoordsY[e] = rand.nextInt(50, 600);
            
            if (locationCoordsX[e] > 700 || locationCoordsX[e] < 530 && locationCoordsY[e] > 400 || locationCoordsY[e] < 280){
                e++;
            }
        }

        // Ensure that the city is in the middle of the map
        locationCoordsX[0] = 590;
        locationCoordsY[0] = 310;

    }

    //Code below is written by Usman. This code is ran at the start of the game to place the locations (city, forest, etc)
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
                g.fillRect(x, y, locationSizes[i], locationSizes[i]); // Adjust size and position as needed
                g.setColor(Color.BLACK);
                g.drawString(Locations[i], x, y-5); // Label for the area
        }

        //If any text should be displayed
        if (havePurchase){
            if (haveFighters){
                g.setColor(Color.BLACK);
                g.drawString("Fire Fighters are protecting this area!", locationCoordsX[2]-85, locationCoordsY[2]+65);
            }

            if (haveEarthquakeAlarm){
                g.setColor(Color.BLACK);
                g.drawString("Earthquake Alarm on Standby", 550, 290);
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

    // Usman
    public static void buyFireFighters(){
        havePurchase = true;
        haveFighters = true;
        coins -= 2000000;
        score += 25;
        gameButtons.coinTxt.setText("$" + coins);
        map.repaint();
        startRound();
    }

    public static void buyDam(){
        havePurchase = true;
        haveDam = true;
        coins -= 3000000;
        score += 25;
        gameButtons.coinTxt.setText("$" + coins);
        locationColours[1] = Color.gray;
        map.repaint();
        startRound();
    }

    public static void buyEarthquake(){
        havePurchase = true;
        haveEarthquakeAlarm = true;
        coins -= 1000000;
        score += 25;
        gameButtons.coinTxt.setText("$" + coins);
        map.repaint();
        startRound();

    }

    public static void startRound(){
        if (coins <= 0){
            
        }

        locationSizes[0] = 50;
        locationSizes[1] = 50;
        locationSizes[2] = 50;
        locationSizes[3] = 50;
        int eventType = rand.nextInt(0, 5);
    
        //Add round coins
        coins += 1000000;
        gameButtons.coinTxt.setText("$" + formatter.format(coins));

        //Fire event - Usman
        if (eventType == 0){
            if (haveFighters){
                locationSizes[2] = 25;
                lost = 250000;
            }
            else{
                lost = rand.nextInt(1000000, 2000000);
            }
            
            JOptionPane.showMessageDialog(null, events[eventType] + "\n You have lost a total of: $" + formatter.format(lost));
            coins -= lost;
            System.out.println(coins);
            gameButtons.coinTxt.setText("$" + formatter.format(coins));
            score += 50;
        }

        //Flood - Usman
        if (eventType == 1){
            if (haveDam){
                lost = 450000;
                JOptionPane.showMessageDialog(null, "Your dam protected your country! Only minor repairs are needed" + "\n You have lost a total of: $" + formatter.format(lost));
                score += 50;
            }
            else{
                lost = rand.nextInt(2000000, 2500000);
                JOptionPane.showMessageDialog(null, events[eventType] + "\n You have lost a total of: $" + formatter.format(lost));
                coins -= lost;
                gameButtons.coinTxt.setText("$" + formatter.format(coins));
                score += 50;
            }
        }

        //Tsunami - Usman
        if (eventType == 2){
            if (haveTsunamiAlarm){
                lost = 1000000;
                JOptionPane.showMessageDialog(null, "A Tsunami Occured! Your alarm protect thousands of people! \n You have lost a total of $" + formatter.format(lost));
            }
            else{
                lost = rand.nextInt(1500000, 2500000);
                 JOptionPane.showMessageDialog(null, events[eventType] + "\n You have lost a total of: $" + formatter.format(lost));
            }
            coins -= lost;
            gameButtons.coinTxt.setText("$" + formatter.format(coins));
            score += 50;
    }

        //Earthquake 
        if (eventType == 3){
            if (haveEarthquakeAlarm){
                lost = 1000000;
                JOptionPane.showMessageDialog(null, "An Earthquake Occured! Your alarm protect thousands of people! \n You have lost a total of $" + formatter.format(lost));
            }
            else{
                lost = 2000000;
                JOptionPane.showMessageDialog(null, "A Tsunami Occured! \n You have lost a total of $" + formatter.format(lost));
            }
            coins -= lost;
            gameButtons.coinTxt.setText("$" + formatter.format(coins));
            score += 50;
        }

        if (eventType == 4){
            if (haveTornadoSiren){
                lost = 1000000;
            }
            else{
                lost = 2000000;
                JOptionPane.showMessageDialog(null, "A Tornado Occured! \n You have lost a total of $" + formatter.format(lost));
            }
            coins -= lost;
            gameButtons.coinTxt.setText("$" + formatter.format(coins));
            score += 50;
        }
    }

//following is by zohair
    public Game(){

        initialization();
        createBackground();
        map = new mapPanel();
        this.add(map, BorderLayout.CENTER);

        this.setVisible(true);
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
