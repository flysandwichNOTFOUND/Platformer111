
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
    private final int jumpStrength = 15;

    private int level = 1;
    private final int maxLevels = 3; //alter this if needed
    private EndPlatform[] levelEnds = {
            new EndPlatform(790,400,100,100),
            new EndPlatform(100,100,100,100)
    };

    //=================================Alter this to move round the terrian===============================
    private Platform[][] allLevels = {
            // Level 1
            {
                    new Platform(0,500,800,250)},
                   //new Platform(100,400,600,250) },

            // Level 2
            {
                    new Platform(0,500,800,250),
                    new Platform(200,450,100,50),
                    new Platform(400,350,100,50),
                    new Platform(600,150,100,50)},

            // Level 3
            { new Platform(0,550,800,50),
                    new Platform(150,450,150,50),
                    new Platform(400,350,150,50),
                    new Platform(650,250,100,50) }
    };
    //=========================================================================================================
    private Platform[] platforms = allLevels[0];
    private Player player = new Player(50,300,25);

    public Platformer() {
        timer = new Timer(20, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < 40; x++) {
            for (int y = 0; y < 30; y++) {
                g.setColor(Background.colorPixels[1][x][y]); // 假设返回 Color
                g.fillRect(x*20, y*20, 20, 20);
            }
        }
        //Color brown = new Color(139,69,19);
        //platforms
        g.setColor(Color.BLACK);
        for(Platform p : platforms) g.fillRect(p.x,p.y,p.l,p.w);
        g.setColor(Color.WHITE);
        for(Platform p : platforms) g.fillRect(p.x+5,p.y+5,p.l-10,p.w-10);

        //player draw
        g.setColor(Color.BLACK);
        g.fillRect(player.x, player.y, player.s, player.s);

        //display level
        g.setColor(Color.BLACK);
        g.drawString("Level " + level, 20, 20);

        //display end goal
        g.setColor(Color.YELLOW);
        EndPlatform ep = levelEnds[level-1];
        g.fillRect(ep.x,ep.y,ep.l,ep.w);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    private void update() { // i moved the detection part in Player.java, this is just intergrating it
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
        if(player.y>600){
            player.x = 50;
            player.y = 300;
        }
        if(player.touchingEndPlatform(levelEnds[level-1])) nextLevel();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            player.veloX = -moveSpeed;
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            player.veloX = moveSpeed;
        }

        if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W)&& player.onGround) {
            player.veloY = -jumpStrength;
            player.onGround = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)|| key == KeyEvent.VK_RIGHT) {
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

class Player {
    int x, y;
    int s;
    int veloX = 0;
    int veloY = 0;
    boolean onGround = true;

    Player(int x, int y, int s) {
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

        boolean xOverlap = (playerLeft < platformRight) && (playerRight > platformLeft);
        boolean yOverlap = (playerTop < platformBottom) && (playerBottom > platformTop);
        /*
        so what happended is, when the cube touches the wall in the first edition, it just moved the y-corrdinate up
        becuase java thought it was, um, the ground. In order to fix that, we checks the overlap and seperated the x-coalition and y-coalition
        ngl its hard
        */


        //please dont touch this part

        if (xOverlap && yOverlap) {

            int overlapX = Math.min(playerRight - platformLeft, platformRight - playerLeft);
            int overlapY = Math.min(playerBottom - platformTop, platformBottom - playerTop);

            if (overlapX < overlapY) {
                // X
                if (playerRight - platformLeft < platformRight - playerLeft) {
                    x = platformLeft - s; // left
                } else {
                    x = platformRight; // right
                }
                veloX = 0;
            } else {
                // Y
                if (playerBottom - platformTop < platformBottom - playerTop) {
                    y = platformTop - s; // top
                    onGround = true;
                } else {
                    y = platformBottom; // bottom
                }
                veloY = 0;
            }
            return true;
        }
        return false;
    }
    boolean checkCollision(Platform p) {
        int playerLeft = x, playerRight = x+s, playerTop = y, playerBottom = y+s;
        int platformLeft = p.x, platformRight = p.x+p.l, platformTop = p.y, platformBottom = p.y+p.w;

        return (playerLeft < platformRight && playerRight > platformLeft &&
                playerTop < platformBottom && playerBottom > platformTop);
    }

    boolean resolveCollision(Platform p) {
        int overlapX = Math.min((x+s) - p.x, (p.x+p.l) - x);
        int overlapY = Math.min((y+s) - p.y, (p.y+p.w) - y);

        if (overlapX < overlapY) {
            // Wall
            if ((x+s) - p.x < (p.x+p.l) - x) x = p.x - s;
            else x = p.x+p.l;
            veloX = 0;
            return false;
        } else {
            // ground
            if ((y+s) - p.y < (p.y+p.w) - y) {
                y = p.y - s;
                onGround = true;
            } else {
                y = p.y+p.w;
            }
            veloY = 0;
            return true;
        }
    }

    boolean touchingEndPlatform(EndPlatform ep){
        int playerLeft = x;
        int playerRight = x+s;
        int playerTop = y;
        int playerBottom = y+s;

        int platformLeft = ep.x;
        int platformRight = ep.x+ep.l;
        int platformTop = ep.y;
        int platformBottom = ep.y+ep.w;

        boolean xOverlap = (playerLeft < platformRight) && (playerRight > platformLeft);
        boolean yOverlap = (playerTop < platformBottom) && (playerBottom > platformTop);
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
    boolean isTouching(int playerX, int playerY, int playerSize, Platform pl){
        return false;
    }
}
class EndPlatform{
    int x, y;
    int l, w;

    EndPlatform(int x, int y, int l, int w){
        this.x = x;
        this.y=y;
        this.l = l;
        this.w = w;
    }

}
