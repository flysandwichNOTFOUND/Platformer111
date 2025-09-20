public class Spikes {
    private int x, y, width, height;
    private boolean touched;

    public Spikes(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.touched = false;
    }

    public boolean spikeTouchesPlayer(Platform player) {
        touched =
            x < player.getX() + player.getWidth() &&
            x + width > player.getX() &&
            y < player.getY() + player.getHeight() &&
            y + height > player.getY();
        return touched;
    }

    public int getX() { 
        return x;
        }
    public int getY() {
        return y; 
        }
    public boolean isTouched() {
        return touched; 
        }
}
