import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

// Zohair
class MainMenu extends JFrame {

    // Main method to set up the main menu interface
    public void main(String[] args) {
        JFrame frame = new JFrame("PROTECTTHECITY");
        frame.setSize(1280, 720);
        frame.setLayout(null);

        JButton exit = new JButton("close");
        exit.setBounds(1225, 672, 50, 15);

        JButton play = new JButton("Play");
        play.setBounds(465, 250, 360, 120);
        play.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton helpTab = new JButton("Help");
        helpTab.setBounds(465, 400, 360, 120);
        helpTab.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton statsTab = new JButton("Stats");
        statsTab.setBounds(465, 550, 360, 120);
        statsTab.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JLabel title = new JLabel("PROTECT THE CITY!");
        title.setBounds(400, 75, 720, 75);
        title.setFont(new Font("Serif", Font.PLAIN, 52));
        
        ImageIcon image1 = new ImageIcon("oldmap2.jpg");
        JLabel imageLabel = new JLabel(image1);
        imageLabel.setBounds(0, 0, 1280, 720);

        // Adding components to the frame
        frame.add(imageLabel);
        frame.add(statsTab);
        frame.add(title);
        frame.add(helpTab);
        frame.add(exit);
        frame.add(play);
       
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Action listener for the play button
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });

        // Action listener for the help button
        helpTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                help.main(args);
            }
        });

        // Action listener for the stats button
        statsTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stats.main(args);
            }
        });

        // Action listener for the exit button
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });
    }
}