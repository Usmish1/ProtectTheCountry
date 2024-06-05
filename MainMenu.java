import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame {

    public static void main(String[] args) {
        new MainMenu();
    }

    public void startGame(){
        this.remove(loginPanel);
        this.add(gamePanel);
        MainMenu.this.revalidate();
        MainMenu.this.repaint();
        
    }
    
    private JButton playButton;
    private JButton helpButton;
    private JPanel panel1;
    private JPanel loginPanel = new LoginMenu();
    private JPanel gamePanel = new Game();
    
    public MainMenu() {

        //Settings for the panel
        this.setSize(1280,720);

        panel1= new JPanel();
        
        //Initializes The click listener class
        Clicklistener click= new Clicklistener();

        //Starts the panel and buttons
        playButton = new JButton ("Play!");
        playButton.setBounds(540, 210, 200, 100);
        playButton.addActionListener(click);
        
        helpButton = new JButton ("Help");
        helpButton.setBounds(565, 320, 150, 75);
        helpButton.addActionListener(click);

        panel1.add(playButton);
        panel1.add(helpButton);
        
        panel1.setLayout(null);
        panel1.setVisible(true);
        this.setVisible(true);
        this.add(panel1);
        this.setSize(1280, 720);
    }
    
    private class Clicklistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playButton) {
                System.out.println("Play button has been clicked, login function should be called.");
                MainMenu.this.remove(panel1);
                MainMenu.this.add(loginPanel);
                MainMenu.this.revalidate();
                MainMenu.this.repaint();
                System.out.println("Login function");
            }

            if (e.getSource() == helpButton){
                System.out.println("Showing Help Information");
            }
        }
    }
}
