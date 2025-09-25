import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            // Add the background panel
            NewLabel backgroundPanel = new NewLabel();
            backgroundPanel.setPreferredSize(new Dimension(800, 600));
            frame.add(backgroundPanel);

            // Add the game panel (Platformer)
            Platformer game = new Platformer();
            frame.add(game);

            frame.pack();
            frame.setVisible(true);
        });
    }
}
class NewLabel extends JPanel {
    private final Background background;

    public NewLabel() {
        this.background = new Background();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // 
        // 
        for (int x = 0; x < 800; x++) {
            for (int y = 0; y < 600; y++) {
                g.setColor(background.get(x, y, 1)); // Color
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}
