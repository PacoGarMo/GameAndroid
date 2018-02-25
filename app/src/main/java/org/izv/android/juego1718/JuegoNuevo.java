package org.izv.android.juego1718;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;

import org.izv.android.juego1718.currentgame.Assets;
import org.izv.android.juego1718.currentgame.Background;
import org.izv.android.juego1718.currentgame.BouncingBall;
import org.izv.android.juego1718.currentgame.Cloud;
import org.izv.android.juego1718.currentgame.Fondo;
import org.izv.android.juego1718.currentgame.Shot;
import org.izv.android.juego1718.currentgame.Tipejo;
import org.izv.android.juego1718.generic.GenericGameActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by dam on 14/02/2018.
 */

public class JuegoNuevo extends GenericGameActivity {

    private  BouncingBall b1, b2;
    private Tipejo t;
    private Cloud c1, c2;
    private Shot s;
    private boolean bombasFuera = false;

    int count, count2 = 0;

    @Override
    public void start() {

        //fondo
        addGameObject(new Fondo());

        //nubes
        c1 = new Cloud();
        addGameObject(c1);
        c2 = new Cloud();
        c2.setY(80);
        c2.setX(600);
        addGameObject(c2);

        //mario
        t = new Tipejo();
        addGameObject(t);
        //bala
        s = new Shot();
        addGameObject(s);

        b1 = new BouncingBall();

        b2 = new BouncingBall();
    }

    @Override
    public void update() {
        super.update();
        if(s.getX() < 0){
            s = new Shot();
            addGameObject(s);
        }
        chocaBala(t, s);
        chocaBomba(t, b1);
        chocaBomba(t, b2);

        if(count >= 200){
            c1.setImage(Assets.cloud_ungry);
            c2.setImage(Assets.cloud_ungry);
            //bombas
            bombasFuera = true;
        }

        if(bombasFuera){
            if(count2 >= 150){
                fuego();
                count2 = 0;
            }
            count = 0;
        }
        count++;
        count2++;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private boolean chocaBala(Tipejo t, Shot s){

        //cuando choca con una bomba
        boolean shot = t.instersects(s);

        if(shot){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
//            alert();

        }

        return true;
    }

    private boolean chocaBomba(Tipejo t, BouncingBall b){

        //cuando choca con una bomba
        boolean shot = t.instersects(b);

        if(shot){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
//            alert();

        }

        return true;
    }

    public void fuego(){

        b1 = new BouncingBall();

        b2 = new BouncingBall();

        b1.setX(c1.getX());
        b1.setY(c1.getY());
        addGameObject(b1);

        b2.setX(c2.getX());
        b2.setY(c2.getY());

        addGameObject(b2);
    }

//    private void alert(){
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(JuegoNuevo.);
//        builder1.setMessage("You Lose");
//        builder1.setCancelable(true);
//
//        builder1.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                startActivity(getIntent());
//            }
//        });
//
//        builder1.setNegativeButton("Surrender", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                System.exit(0);
//            }
//        });
//
//        AlertDialog alertGameOver = builder1.create();
//        alertGameOver.show();
//    }

}
