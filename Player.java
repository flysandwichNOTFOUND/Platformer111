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
