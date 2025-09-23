import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Platformer p = new Platformer();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 传入一个简单的 Background 实现（你也可以替换成自己的）
            NewLabel panel = new NewLabel();
            panel.setPreferredSize(new Dimension(800, 600));

            frame.add(panel);
            frame.pack();               // 用 preferredSize
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        p.main();
    }
}
class NewLabel extends JPanel {
    private final Background background;

    public NewLabel() {
        this.background = new Background();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // 清背景 & 双缓冲配合
        // 逐像素绘制（能跑，但慢）
        for (int x = 0; x < 800; x++) {
            for (int y = 0; y < 600; y++) {
                g.setColor(background.get(x, y, 1)); // 假设返回 Color
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}
