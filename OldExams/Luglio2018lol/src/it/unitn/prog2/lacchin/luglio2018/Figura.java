package it.unitn.prog2.lacchin.luglio2018;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Figura {


    static final Color YELLOW = Color.YELLOW;
    static final Color BORDO = Color.RED;
    Shape figura;

    public Figura () {}

    public Figura (Shape figura) {

        this.figura = figura;
    }

    public Shape getFigura() {
        return figura;
    }

    @Override
    public String toString () {
        return figura.toString();
    }
}
