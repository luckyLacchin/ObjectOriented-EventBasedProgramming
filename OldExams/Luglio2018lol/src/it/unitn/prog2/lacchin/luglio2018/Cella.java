package it.unitn.prog2.lacchin.luglio2018;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cella extends StackPane {

    static final double LATO = 50;
    Nera rectangle;
    Figura figura;

    public Cella() {
        rectangle = new Nera();
        this.getChildren().add(rectangle);
    }

    public Figura getFigura() {
        return figura;
    }

    public void removeFigura() {
        this.getChildren().remove(figura.getFigura());
        figura = null;
    }

    @Override
    public String toString () {
        if (this.figura == null)
            return "null";
        else
            return this.figura.toString();
    }
}
