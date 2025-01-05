package it.unitn.prog2.lacchin.luglio2018;


import javafx.scene.shape.Polygon;

public class Esagono extends Polygon {

    public Esagono () {
        this.getPoints().addAll(
                Cella.LATO/3,0.0,
                Cella.LATO-Cella.LATO/3,0.0,
                Cella.LATO,Cella.LATO/2,
                Cella.LATO-Cella.LATO/3,Cella.LATO,
                Cella.LATO/3,Cella.LATO,
                0.0,Cella.LATO/2



        );
        this.setStroke(Figura.BORDO);
        this.setFill(Figura.YELLOW);
    }

    @Override
    public String toString () {
        return "Esagono";
    }
}
