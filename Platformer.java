
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
    
    private int level = 1;
    private final int maxLevels = 3; //alter this if needed

    
    //=================================Alter this to move round the terrian===============================
    private Platform[][] allLevels = {
        // Level 1
        { new Platform(0,500,800,250),
        new Platform(100,400,600,250) },
        
        // Level 2
        { 
        new Platform(0,500,800,100),
        new Platform(300,350,200,50),
        new Platform(600,250,150,50)},
        
        // Level 3
        { new Platform(0,550,800,50),
        new Platform(150,450,150,50),
        new Platform(400,350,150,50),
        new Platform(650,250,100,50) } 
    };
    //=========================================================================================================
    private Platform[] platforms = allLevels[0];
    private Player player = new Player(50,300,50);

    public Platformer() {
        timer = new Timer(20, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0,0,getWidth(),getHeight());

        g.setColor(Color.GREEN);
        for(Platform p : platforms) g.fillRect(p.x,p.y,p.l,p.w);

        g.setColor(Color.RED);
        g.fillRect(player.x, player.y, player.s, player.s);

        g.setColor(Color.BLACK);
        g.drawString("Level " + level, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    private void update() {
        player.x += player.veloX;
        player.y += player.veloY;

        boolean yCollision = false;
        for(Platform p : platforms){
            if(player.checkCollision(p)){
                if(player.resolveCollision(p)) yCollision = true;
            }
        }
        if(!yCollision){
            player.veloY += gravity;
            player.onGround = false;
        }

        if(player.x + player.s >= getWidth()) nextLevel();
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

    private void nextLevel() {
        if(level < maxLevels){
            level++;
            platforms = allLevels[level-1];
            player.x = 50;
            player.y = 300;
            player.veloX = player.veloY = 0;
        } else {
            JOptionPane.showMessageDialog(this, "You beat the game!");
            timer.stop();
        }
    }
    //why dont we do this in the main file?
    /*
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
*/
