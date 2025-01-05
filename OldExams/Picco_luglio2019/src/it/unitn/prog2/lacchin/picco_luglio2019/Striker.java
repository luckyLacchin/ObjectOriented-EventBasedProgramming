package it.unitn.prog2.lacchin.picco_luglio2019;

import javafx.scene.paint.Color;

public class Striker extends Enemy{

    static final Color BLUE = Color.BLUE;


    public Striker () {

        this.setFill(BLUE);
        System.out.println("Striker : " + direzione);

    }

    @Override
    public void sposta () {
        move(this.deltaX,this.deltaY);
    }
}
