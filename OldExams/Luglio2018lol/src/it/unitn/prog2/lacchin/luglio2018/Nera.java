package it.unitn.prog2.lacchin.luglio2018;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Nera extends Rectangle {

    static Color BLACK = Color.BLACK;
    static Color STROKE = Color.DARKGREEN;

    public Nera () {
        this.setWidth(Cella.LATO);
        this.setHeight(Cella.LATO);
        this.setFill(BLACK);
        this.setStroke(STROKE);
    }

}
