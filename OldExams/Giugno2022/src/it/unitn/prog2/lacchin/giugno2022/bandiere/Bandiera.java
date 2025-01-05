package it.unitn.prog2.lacchin.giugno2022.bandiere;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bandiera extends Canvas {

    public GraphicsContext gc = null;
    public static double WIDTH = 60;
    public static double HEIGHT = 42;

    public Bandiera () {
        super();
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        gc = this.getGraphicsContext2D();


    }
}
