class CollisionDetector{
    static boolean collision(Player p, Spikes s){
        return p.x + p.s > s.x && p.x < s.x + s.w &&
               p.y + p.s > s.y && p.y < s.y + s.h;
    }

    static boolean touchingEndPlatform(Player p, EndPlatform ep){
        int playerLeft = p.x;
        int playerRight = p.x+p.s;
        int playerTop = p.y;
        int playerBottom = p.y+p.s;

        int platformLeft = ep.x;
        int platformRight = ep.x+ep.l;
        int platformTop = ep.y;
        int platformBottom = ep.y+ep.w;

        boolean xOverlap = (playerLeft < platformRight) && (playerRight > platformLeft);
        boolean yOverlap = (playerTop < platformBottom) && (playerBottom > platformTop);
        return xOverlap && yOverlap;
    }

    static boolean touchingPlatform(Player p, Platform pl){
        int playerLeft = p.x;
        int playerRight = p.x+p.s;
        int playerTop = p.y;
        int playerBottom = p.y+p.s;

        int platformLeft = pl.x;
        int platformRight = pl.x+pl.l;
        int platformTop = pl.y;
        int platformBottom = pl.y+pl.w;

        boolean xOverlap = (playerLeft < platformRight) && (playerRight > platformLeft);
        boolean yOverlap = (playerTop < platformBottom) && (playerBottom > platformTop);

        /*
        so what happened is, when the cube touches the wall in the first edition, it just moved the y-coordinate up
        because Java thought it was the ground. To fix that, we check the overlap and separate X collision and Y collision
        ngl it's hard
        */

        // please don't touch this part
        if (xOverlap && yOverlap) {
            int overlapX = Math.min(playerRight - platformLeft, platformRight - playerLeft);
            int overlapY = Math.min(playerBottom - platformTop, platformBottom - playerTop);

            if (overlapX < overlapY) {
                // X collision (wall)
                if (playerRight - platformLeft < platformRight - playerLeft) {
                    p.x = platformLeft - p.s; // left
                } else {
                    p.x = platformRight; // right
                }
                p.veloX = 0;
            } else {
                // Y collision (floor/ceiling)
                if (playerBottom - platformTop < platformBottom - playerTop) {
                    p.y = platformTop - p.s; // top
                    p.onGround = true;
                } else {
                    p.y = platformBottom; // bottom
                }
                p.veloY = 0;
            }
            return true;
        }
        return false;
    }

    static boolean checkCollision(Player p, Platform pl) {
        int playerLeft = p.x, playerRight = p.x+p.s, playerTop = p.y, playerBottom = p.y+p.s;
        int platformLeft = pl.x, platformRight = pl.x+pl.l, platformTop = pl.y, platformBottom = pl.y+pl.w;

        return (playerLeft < platformRight && playerRight > platformLeft &&
                playerTop < platformBottom && playerBottom > platformTop);
    }

    static boolean resolveCollision(Player p, Platform pl) {
        int overlapX = Math.min((p.x+p.s) - pl.x, (pl.x+pl.l) - p.x);
        int overlapY = Math.min((p.y+p.s) - pl.y, (pl.y+pl.w) - p.y);

        if (overlapX < overlapY) {
            // Horizontal collision (wall)
            if ((p.x+p.s) - pl.x < (pl.x+pl.l) - p.x) p.x = pl.x - p.s;
            else p.x = pl.x + pl.l;
            p.veloX = 0;
            return false;
        } else {
            // Vertical collision (floor/ceiling)
            if ((p.y+p.s) - pl.y < (pl.y+pl.w) - p.y) {
                p.y = pl.y - p.s;
                p.onGround = true;
            } else {
                p.y = pl.y + pl.w;
            }
            p.veloY = 0;
            return true;
        }
    }
}
