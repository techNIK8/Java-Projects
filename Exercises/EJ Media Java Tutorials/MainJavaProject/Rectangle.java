import java.awt.*;
import javax.swing.*;
//1. Added components to our JFRAME
//2. We can also add graphics but NOT to JFRAME - need to use JPANEL
public class Rectangle extends JPanel {
    JFrame frame;
    public void fireUpScreen () {
        frame = new JFrame ();
        frame.setVisible(true);
        frame.setSize (600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
    }
    public void paintComponent (Graphics g) {
        //paintComponent is the method used to paint - think of JPanel as our canvas
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 200, 200);
    
    }

public static void main(String[] args) {
Rectangle go = new Rectangle ();
go.fireUpScreen();
}
}