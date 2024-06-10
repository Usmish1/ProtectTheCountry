import javax.swing.*;
import java.awt.*;

public class GameButtons extends JPanel {

    JButton watBtn;
    JButton rivBtn;
    JButton fireBtn;
    JButton earBtn;
    JButton airBtn;

    public void waterBut(){
        watBtn = new JButton("Water Dam");
        watBtn.setBounds(1150, 620, 120, 60);
        watBtn.setBorder(new RoundedBorder(20));
        this.setLayout(null);
        this.add(watBtn);
    }

    public void riverBut(){
        rivBtn = new JButton("River Dam");
        rivBtn.setBounds(1025, 620, 120, 60);
        rivBtn.setBorder(new RoundedBorder(20));
        this.setLayout(null);
        this.add(rivBtn);
    }

    public void fireBut(){
        fireBtn = new JButton("Firefighters");
        fireBtn.setBounds(900, 620, 120, 60);
        fireBtn.setBorder(new RoundedBorder(20));
        this.setLayout(null);
        this.add(fireBtn);
    }

    public void earthBut(){
        earBtn = new JButton("Earthquake Alarm");
        earBtn.setBounds(730, 620, 165, 60);
        earBtn.setBorder(new RoundedBorder(20));        
        this.setLayout(null);
        this.add(earBtn);
    }

    public void airBut(){
        airBtn = new JButton("Tornado Siren");
        airBtn.setBounds(575, 620, 150, 60);
        airBtn.setBorder(new RoundedBorder(20));        
        this.setLayout(null);
        this.add(airBtn);
    }

    public void confirmBut(){

    }

    public void exitBut(){

    }

    public void resBut(){

    }


    public GameButtons() {
        waterBut();
        this.add(watBtn);
        this.setBounds(0, 0, 1280, 720);

        riverBut();
        this.add(rivBtn);
        this.setBounds(0, 0, 1280, 720);

        earthBut();  
        this.add(earBtn);
        this.setBounds(0, 0, 1280, 720); 
        
        fireBut();
        this.add(fireBtn);
        this.setBounds(0, 0, 1280, 720);

        airBut();
        this.add(airBtn);
        this.setBounds(0, 0, 1280, 720);
 
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.add(new GameButtons());
        frame.setVisible(true);
        frame.setLayout(null);

    };
}
