import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//following code is from zohair
public class GameButtons extends JPanel {

    //initializing all the Jbuttons
    JButton watBtn;
    JButton rivBtn;
    JButton fireBtn;
    JButton earBtn;
    JButton airBtn;
    JButton extBtn;
    Clicklistener click= new Clicklistener();

    //setting up each button to a set size and text
    public void exitBut(){
        
        extBtn = new JButton("X");
        extBtn.setBounds(5,65,50,30);
        extBtn.addActionListener(click);
        this.setLayout(null);
        this.add(watBtn);
    }

    public void waterBut(){
        watBtn = new JButton("Water Dam");
        watBtn.setBounds(1140, 20, 120, 60);
        watBtn.addActionListener(click);
        this.setLayout(null);
        this.add(watBtn);
    }

    public void riverBut(){
        rivBtn = new JButton("River Dam");
        rivBtn.setBounds(1015, 20, 120, 60);
        rivBtn.addActionListener(click);
        this.setLayout(null);
        this.add(rivBtn);
    }

    public void fireBut(){
        fireBtn = new JButton("Firefighters");
        fireBtn.setBounds(890, 20, 120, 60);
        fireBtn.addActionListener(click);
        this.setLayout(null);
        this.add(fireBtn);
    }

    public void earthBut(){
        earBtn = new JButton("Earthquake Alarm");
        earBtn.setBounds(720, 20, 165, 60);
        earBtn.addActionListener(click);        
        this.setLayout(null);
        this.add(earBtn);
    }

    public void airBut(){
        airBtn = new JButton("Tornado Siren");
        airBtn.setBounds(565, 20, 150, 60);
        airBtn.addActionListener(click);        
        this.setLayout(null);
        this.add(airBtn);
    }


    //this will add all the buttons to be able to be used
    public GameButtons() {

        this.setPreferredSize(new Dimension(1280, 100));

        waterBut();
        this.add(watBtn);

        riverBut();
        this.add(rivBtn);

        earthBut();  
        this.add(earBtn);
        
        fireBut();
        this.add(fireBtn);

        airBut();
        this.add(airBtn);

        exitBut();
        this.add(extBtn);

    }

    //This class determines the function of each button
    private class Clicklistener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //checks and performs function

            if (e.getSource() == fireBtn){
                JOptionPane.showMessageDialog(null, "Fire Fighters are now Stronger!!");
                System.out.println("Fire clicked");
                Game.buyFireFighters();
            }else if (e.getSource() == earBtn){
                JOptionPane.showMessageDialog(null, "Earthquake Siren Placed!");
                System.out.println("Earth clicked");
            }else if (e.getSource() == airBtn){
                JOptionPane.showMessageDialog(null, "Tornado Siren Placed!");
                System.out.println("Air clicked");
            }else if (e.getSource() == rivBtn){
                JOptionPane.showMessageDialog(null, "River Dam Built!");
                System.out.println("River clicked");
            }else if (e.getSource() == extBtn){
                System.out.println("Exit clicked");
                JOptionPane.showMessageDialog(null, "Exiting the Program.");
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }else if (e.getSource() == watBtn){
                JOptionPane.showMessageDialog(null, "Water Dam Built on the Ocean!");
                System.out.println("Water clicked");
            }
        }
    }
}