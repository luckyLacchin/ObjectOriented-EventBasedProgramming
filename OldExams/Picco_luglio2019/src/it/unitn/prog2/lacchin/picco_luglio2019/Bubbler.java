package it.unitn.prog2.lacchin.picco_luglio2019;

import javafx.scene.paint.Color;

public class Bubbler extends Enemy{

    static final Color LIGHTBLUE = Color.LIGHTBLUE;
    static final double PROBABILITA = 0.1;
    static final double AUMENTO = 0.2;


    public Bubbler () {
        this.setFill(LIGHTBLUE);
        System.out.println("Bubbler : " + direzione);
    }

    public void modifica () {
        double casuale = Math.random();
        if (casuale < PROBABILITA) {
            radius = this.getRadius() + this.getRadius() * AUMENTO;
            this.setRadius(radius);
        }
        else
            System.out.println("La palle non è aumentata!");
    }
    @Override
    public void sposta () {
        this.modifica();
        if((User.iterazione%5) == 0) {
            this.cambiaDirezione();
        }
        System.out.println("Bubbler : " + direzione);
        this.move(this.deltaX,this.deltaY);
    }
}
