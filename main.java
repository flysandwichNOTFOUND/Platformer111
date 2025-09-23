import javax.swing.*;        
import java.awt.*;           
import java.awt.event.*;  

public class Main {
    public static void main(String[] args) {
    JFrame frame = new JFrame("Simple Platformer");
      
    Platformer game = new Platformer();
    frame.add(game);
    frame.setSize(800, 600);
      
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); 
    frame.setVisible(true);
}
}
