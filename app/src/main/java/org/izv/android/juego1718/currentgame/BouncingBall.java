package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.JuegoNuevo;
import org.izv.android.juego1718.generic.GameObject;

import java.util.Random;

public class BouncingBall extends GameObject {

    public BouncingBall() {
        super(Assets.boom);
        this.setSpeedY(2);
    }

    public void update() {
        this.setY(this.getY() + this.getSpeedY());
    }

}