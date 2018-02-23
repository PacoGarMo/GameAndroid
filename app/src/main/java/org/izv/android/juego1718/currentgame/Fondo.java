package org.izv.android.juego1718.currentgame;

import org.izv.android.juego1718.generic.GameBackground;
import org.izv.android.juego1718.media.Image;

/**
 * Created by dam on 14/02/2018.
 */

public class Fondo extends GameBackground{


    public Fondo() {
        super(Assets.pk2);
        this.setMovement(Movement.MOVING);
    }
}
