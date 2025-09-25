public class Spike {
    int x, y, w, h;
    boolean touched;

    public Spike(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.touched = false;
    }

    public boolean spikeTouchesPlayer(Player p) {
        touched =
            x < p.x + p.s &&
            x + w > p.x &&
            y < p.y + p.s &&
            y + h > p.y;
        return touched;
    }
}
