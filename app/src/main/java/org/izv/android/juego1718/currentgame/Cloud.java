package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.GameActivity;
import org.izv.android.juego1718.generic.GameObject;

/**
 * Created by Francisco on 24/02/2018.
 */

public class Cloud extends GameObject {

    public Cloud() {
        super(Assets.cloud);
        this.setX(5);
        this.setY(20);
        this.setSpeedX(2);
    }

    @Override
    public void update() {

        if (this.getX() > this.getGraphics().getWidth() - this.getImage().getBitmap().getWidth() || this.getX() < 0) {
            this.setSpeedX(- this.getSpeedX());
        }
        this.setX(this.getX() + this.getSpeedX());

    }
}
