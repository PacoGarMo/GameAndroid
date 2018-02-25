package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameObject;

/**
 * Created by Francisco on 24/02/2018.
 */

public class Shot extends GameObject {

    public Shot() {
        super(Assets.bala100);
        this.setSpeedX(3);
        this.setX(620);
        this.setY(320);
    }

    @Override
    public void update() {
        this.setX(this.getX() - this.getSpeedX());
    }
}
