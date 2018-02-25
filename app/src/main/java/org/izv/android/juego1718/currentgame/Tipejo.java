package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameObject;
import org.izv.android.juego1718.media.Animation;

/**
 * Created by dam on 14/02/2018.
 */

public class Tipejo extends GameObject{

    private static final int MAXSALTO = 15;

    private Animation animation;
    private Long tiempo;
    private boolean saltando = false;
    private int salto = 0;

    public Tipejo() {
        super(Assets.stand);
        this.setX(5);
        this.setY(310);

        animation = new Animation();
        animation.addFrame(Assets.stand, 350);

        tiempo = System.currentTimeMillis();
    }

    @Override
    public void update() {
        if (getTouchHandler().isMoving() && getTouchHandler().isMovingUp()){
            this.setSpeedX(2);
            if(!saltando){
                salto = -MAXSALTO;
                setSpeedY(salto);
                saltando = true;
            }
        } else if (getTouchHandler().isMoving() && getTouchHandler().isMovingRight()){
            animation = new Animation();
            animation.addFrame(Assets.stand, 250);
            animation.addFrame(Assets.right, 250);
            animation.update((System.currentTimeMillis() - tiempo));
            this.setImage(animation.getImage());
            this.setSpeedX(5);
        } else if (getTouchHandler().isMoving() && getTouchHandler().isMovingLeft()){
            animation = new Animation();
            animation.addFrame(Assets.stand_left, 250);
            animation.addFrame(Assets.left, 250);
            animation.update((System.currentTimeMillis() - tiempo));
            this.setImage(animation.getImage());
            this.setSpeedX(-5);
        } else {
            animation.update((System.currentTimeMillis() - tiempo));
            tiempo = System.currentTimeMillis();
            this.setImage(Assets.stand);
            this.setSpeedX(0);
        }

        if (saltando){
            setY(getY() + getSpeedY());
            setX(getX() + 2);
            this.setImage(Assets.jump);
            setSpeedY(getSpeedY() + 1);
            salto++;
            if(salto > MAXSALTO){
                saltando = false;
                setSpeedY(0);
            }

        }

        if(this.getX() + this.getSpeedX() > 585){
            this.setX(585);
        }
        this.setX(this.getX() + this.getSpeedX());
    }
}
