package it.unitn.prog2.lacchin.luglio2018;

import javafx.scene.shape.Polygon;

public class Triangolo extends Polygon {

    public Triangolo () {

        this.getPoints().addAll(Cella.LATO/2,0.0,
                0.0,Cella.LATO,
                Cella.LATO,Cella.LATO);
        this.setStroke(Figura.BORDO);
        this.setFill(Figura.YELLOW);
    }

    @Override
    public String toString () {
        return "Triangolo";
    }
}
