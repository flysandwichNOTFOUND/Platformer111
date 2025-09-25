
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
    private Platform[] levelEnds = {
        new Platform(790,400,100,100),
        new Platform(100,100,100,100)
    };


    //=================================Alter this to move round the terrian===============================
    private Platform[][] allLevels = {
        // Level 1 - simple platforms
        {
            new Platform(0,500,300,50),
            new Platform(350,450,200,50),
            new Platform(600,400,150,50)
        },
        // Level 2 - slightly harder
        {
            new Platform(0,500,250,50),
            new Platform(300,450,200,50),
            new Platform(550,400,150,50),
            new Platform(700,350,100,50)
        },
        // Level 3 - add more jumps
        {
            new Platform(0,500,200,50),
            new Platform(250,450,150,50),
            new Platform(450,400,150,50),
            new Platform(650,350,100,50)
        }
    };

    private Spike[][] levelSpikes = {
        // Level 1 spikes
        { new Spike(200, 480, 20, 20), new Spike(500, 430, 20, 20) },
        // Level 2 spikes
        { new Spike(100, 480, 20, 20), new Spike(400, 430, 20, 20), new Spike(600, 380, 20, 20) },
        // Level 3 spikes
        { new Spike(150, 480, 20, 20), new Spike(350, 430, 20, 20), new Spike(500, 380, 20, 20) }
    };

    private Platform[] levelEnds = {
        new Platform(720,400,50,50),  
        new Platform(700,200,100,50),  
        new Platform(800,200,50,50)   
    };
    //=========================================================================================================
    
    private Platform[] platforms = allLevels[0];
    private Spike[] spikes = levelSpikes[0];
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
                g.setColor(Background.colorPixels[1][x][y]); // Color
                g.fillRect(x*20, y*20, 20, 20);
            }
        }
        //Color brown = new Color(139,69,19);
        //platforms
        g.setColor(Color.BLACK);
        for(Platform p : platforms) g.fillRect(p.x,p.y,p.l,p.w);
        g.setColor(Color.WHITE);
        for(Platform p : platforms) g.fillRect(p.x+5,p.y+5,p.l-10,p.w-10);
        // Spikes
        g.setColor(Color.RED);
        for(Spike s : spikes){
            g.fillRect(s.x, s.y, s.w, s.h);
        }

        //player draw
        g.setColor(Color.BLACK);
        g.fillRect(player.x, player.y, player.s, player.s);

        //display level
        g.setColor(Color.BLACK);
        g.drawString("Level " + level, 20, 20);

        //display end goal
        g.setColor(Color.YELLOW);
        Platform ep = levelEnds[level-1];
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

        for(Spike s : spikes){
            if(s.spikeTouchesPlayer(player)){
                // reset player
                player.x = 50;
                player.y = 300;
                player.veloX = 0;
                player.veloY = 0;
            }

        }

        checkSpikes();

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

    
    private void checkSpikes() {
        for (Spike s : spikes) {
            if (s.spikeTouchesPlayer(player)) {
                
                player.x = 50;
                player.y = 300;
                player.veloX = 0;
                player.veloY = 0;
            }
        }
    }

}
