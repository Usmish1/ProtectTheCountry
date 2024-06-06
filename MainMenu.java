import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class MainMenu extends JFrame {
    public void main(String[] args) {
        JFrame f = new JFrame("PROTECTTHECITY");

        f.setSize(1280, 720);
        f.setLayout(null);

        JButton exit = new JButton("close");
        exit.setBounds(1225, 672, 50, 15);

        JButton p = new JButton("Play");
        p.setBounds(465, 250, 360, 120);
        p.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton h = new JButton("Help");
        h.setBounds(465, 400, 360, 120);
        h.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JButton s = new JButton("Stats");
        s.setBounds(465, 550, 360, 120);
        s.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));

        JLabel title;
        title = new JLabel("PROTECT THE CITY!");
        title.setBounds(400, 75, 720, 75);
        title.setFont(new Font("Serif", Font.PLAIN, 52));
        
        ImageIcon image1 = new ImageIcon("oldmap2.jpg");
        JLabel imageLabel = new JLabel(image1);
        imageLabel.setBounds(0, 0, 1280, 720);

        f.add(imageLabel);
        f.add(s);
        f.add(title);
        f.add(h);
        f.add(exit);
        f.add(p);
       
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                Game.main(args);
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });

        h.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                help.main(args);
            }
        });

        s.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stats.main(args);
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }
        });

    }
}

