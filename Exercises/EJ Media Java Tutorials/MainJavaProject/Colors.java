import java.awt.*;
import javax.swing.*;

public class Colors extends JPanel {
    JFrame frame;
Color brightYellow = new Color (240,253,2);
Color darkGreen = new Color (28,89,71);
    
public void fireUpScreen() {
    frame = new JFrame();
    frame.setVisible(true);
    frame.setSize (600,600);
    frame.add(this);
}
public static void main(String[] args) {
Colors go = new Colors();
go.fireUpScreen();
}
}