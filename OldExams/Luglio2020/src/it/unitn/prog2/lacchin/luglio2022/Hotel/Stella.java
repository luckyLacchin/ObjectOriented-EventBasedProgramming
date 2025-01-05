package it.unitn.prog2.lacchin.luglio2022.Hotel;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Stella extends Polygon {

    public Stella () {
        this.getPoints().addAll(
                8.0,0.0,
                10.0,4.0,
                16.0,4.0,
                12.0,8.0,
                16.0,16.0,
                8.0,12.0,
                0.0,16.0,
                4.0,8.0,
                0.0,4.0,
                6.0,4.0

        );
        this.setFill(Color.YELLOW);
        this.setStroke(Color.BLACK);
    }
}
