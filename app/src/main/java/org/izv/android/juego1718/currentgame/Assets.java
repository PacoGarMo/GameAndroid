package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.media.Graphics;
import org.izv.android.juego1718.media.Image;

public class Assets {

    public static Image background, boom, cloud, jump, right, left, stand, stand_left, cloud_ungry, bala25, bala50, bala75, bala100;

    public static void load(Graphics g) {
        //fondo
        Assets.background = g.newImage("game-background-tuberia.png");
        //nube
        Assets.cloud = g.newImage("nube-background.png");
        //nube enfadada
        Assets.cloud_ungry = g.newImage("nube-ungry-background.png");
        //bomba
        Assets.boom = g.newImage("bomba.png");
        //mario
        Assets.jump = g.newImage("mario-up.png");
        Assets.right = g.newImage("mario-right.png");
        Assets.left = g.newImage("mario-left.png");
        Assets.stand = g.newImage("mario.png");
        Assets.stand_left = g.newImage("mario-stand-left.png");
        //bala
        Assets.bala25 = g.newImage("bala-25.png");
        Assets.bala50 = g.newImage("bala-50.png");
        Assets.bala75 = g.newImage("bala-75.png");
        Assets.bala100 = g.newImage("bala-100.png");
    }
}