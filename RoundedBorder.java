import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

//Zohair
public class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        //Assigning the radius to the instance variable
        this.radius = radius;
    }

    //calculate the insets for the border
    public Insets getBorderInsets(Component c) {
        // Returns a new Insets object created with the calculated insets
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    //draw the border
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        //rectangle with rounded corners as the border
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
