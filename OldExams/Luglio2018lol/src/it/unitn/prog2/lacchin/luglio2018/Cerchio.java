package it.unitn.prog2.lacchin.luglio2018;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cerchio extends Circle { // la cosa migliore è che il cerchio estendesse figura!

    static final double RADIUS = Cella.LATO/2;
    public Cerchio () {
        super();
        this.setRadius(RADIUS);
        this.setStroke(Figura.BORDO);
        this.setFill(Figura.YELLOW);
    }

    @Override
    public String toString () {
        return "Cerchio";
    }

}
