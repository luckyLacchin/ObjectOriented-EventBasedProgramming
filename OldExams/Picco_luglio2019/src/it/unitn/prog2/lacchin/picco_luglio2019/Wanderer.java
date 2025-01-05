package it.unitn.prog2.lacchin.picco_luglio2019;

import javafx.scene.paint.Color;

public class Wanderer extends Enemy{

    static final Color DARKBLUE = Color.DARKBLUE;

    public Wanderer () {

        this.setFill(DARKBLUE);
        System.out.println("Wanderer : " + direzione);
    }

    @Override
    public void sposta () {
        if((User.iterazione%5) == 0) {
            this.cambiaDirezione();
            System.out.println("Wanderer : " + direzione);
        }
        move(this.deltaX, this.deltaY);
    }
}
