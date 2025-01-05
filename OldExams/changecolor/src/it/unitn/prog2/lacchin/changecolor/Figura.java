package it.unitn.prog2.lacchin.changecolor;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Figura {
    Shape figure = null;
    Figura (Shape figure) {
        this.figure = figure;
        this.figure.setFill(Color.WHITE);
        this.figure.setStroke(Color.BLACK);
    }

    public Shape getFigure() {
        return figure;
    }
    public void change () {
       this.figure.setFill(Color.color(Math.random(),Math.random(),Math.random()));
    }
}
