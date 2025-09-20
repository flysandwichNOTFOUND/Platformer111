
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Platformer extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private final int gravity = 1;
    private final int moveSpeed = 5;
    private final int jumpStrength = 20;
    public Platform p1 = new Platform(0,500,800,250);
    public Platform p2 = new Platform(100,400,600,250);
    public Platform[] platforms = new Platform[]{p1,p2};
    Player player = new Player(50,300,50);

    public Platformer() {
        timer = new Timer(20, this);
        timer.start();
        player.veloX = 0;
        player.veloY = 0;
        player.onGround = true;

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight()); // Background
        g.setColor(Color.GREEN);
        for(Platform p : platforms){
            g.fillRect(p.x, p.y, p.l, p.w);
        }
         // Ground
        g.setColor(Color.RED);
        g.fillRect(player.x, player.y, player.s, player.s); // Player
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    private void update() {
        player.x += player.veloX;
        player.y += player.veloY;
        for(Platform p : platforms){
            if (player.touchingPlatform(p)) { // Ground collision
                player.y = p.y - player.s;
                player.veloY = 0;
                player.onGround = true;
            } else {
                player.veloY += gravity;
                player.onGround = false;
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.veloX = -moveSpeed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.veloX = moveSpeed;
        }

        if (key == KeyEvent.VK_UP && player.onGround) {
            player.veloY = -jumpStrength;
            player.onGround = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            player.veloX = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main() {
        JFrame frame = new JFrame("Simple Platformer");
        //JLabel label = new JLabel("Level 1");
        //label.setPreferredSize(new Dimension(200, 50));
        Platformer game = new Platformer();
        frame.add(game);
        //frame.add(label);
        frame.repaint();
        game.repaint();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
class Player{
    int x,y;
    int s;
    int veloX = 0;
    int veloY = 0;
    boolean onGround = true;
    Player(int x, int y, int s){
        this.x = x;
        this.y = y;
        this.s = s;
    }
    boolean touchingPlatform(Platform p){
        int playerLeft = x;
        int playerRight = x+s;
        int playerTop = y;
        int playerBottom = y+s;

        int platformLeft = p.x;
        int platformRight = p.x+p.l;
        int platformTop = p.y;
        int platformBottom = p.y+p.w;
        boolean xOverlap = (playerLeft<platformRight) && (playerRight>platformLeft);
        boolean yOverlap = (playerTop<platformBottom) && (playerBottom>platformTop);
        return xOverlap&&yOverlap;
    }
}
class Platform{
    int x, y;
    int l, w;
    Platform(int x, int y, int l, int w) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.w = w;
    }
}
class Spike{
    int x, y;
    int h, w;
    Spike(int x, int y, int h, int w){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;

    }

}
