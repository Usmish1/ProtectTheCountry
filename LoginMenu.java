import javax.swing.*;
import java.awt.event.*;

public class LoginMenu extends JPanel {  

    private JButton b;
    private JLabel l2;
    private JTextField tf;



    public LoginMenu() {

        Clicklistener click= new Clicklistener();

        tf=new JTextField();  
        tf.setBounds(50,50, 150,20);  
        b=new JButton("Enter");  
        b.setBounds(50,100,95,30);
        b.addActionListener(click);

        JLabel l1;  
        l1=new JLabel("Please Enter Username!");  
        l1.setBounds(40,25, 150,20);

        l2 = new JLabel();
        l2.setBounds(40,75, 300,20);

        this.add(l1);
        this.add(l2);
        this.add(b);
        this.add(tf);  
        this.setLayout(null);  
        this.setVisible(true); 
    }

    private class Clicklistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b) {
                System.out.println("Login clicked");
                String data = tf.getText();   
                l2.setText("Your Username is " + data);
                MainMenu mm = new MainMenu();
                mm.startGame();
            }
        }
    }
}
