import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

//zohair
class Login extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame("Protect The City!; Login");

        final JTextField tf = new JTextField();
        tf.setBounds(125, 120, 150, 20);


        JButton b = new JButton("Login");
        b.setBounds(150, 150, 95, 30);

        JButton c = new JButton("Continue?");
        c.setBounds(150, 300, 95, 30);

        JLabel l1;
        l1 = new JLabel("Please Enter Username!");
        l1.setBounds(125, 100, 150, 20);

        JLabel l2;
        l2 = new JLabel();
        l2.setBounds(130, 190, 300, 20);

        JLabel title;
        title = new JLabel("PROTECT THE CITY!");
        title.setBounds(110, 50, 300, 20);
        title.setFont(new Font("Serif", Font.PLAIN, 20));

        f.add(l1);
        f.add(l2);
        f.add(title);
        f.add(b);
        f.add(tf);
        f.add(c);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = tf.getText();
                l2.setText("Your Username is " + data);
                f.remove(b);
                c.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            FileWriter writer = new FileWriter("logininfo.txt", true);
                            writer.write(data + "\n");
                            writer.close();
                            System.out.println("New login credentials appended to logininfo.txt");
                        } catch (IOException x) {
                            System.out.println("An error occurred while writing to the file.");
                            x.printStackTrace();
                        }
                        SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
                        MainMenu game = new MainMenu();
                        game.main(args);
                    }
                });
            }
        });


    }
}