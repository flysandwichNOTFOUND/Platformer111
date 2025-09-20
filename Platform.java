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
