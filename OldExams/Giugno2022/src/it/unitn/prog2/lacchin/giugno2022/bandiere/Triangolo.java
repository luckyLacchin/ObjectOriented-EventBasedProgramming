package it.unitn.prog2.lacchin.giugno2022.bandiere;

import javafx.scene.paint.Color;

public class Triangolo extends Bandiera{

    public Triangolo (Color c1, Color c2, Color c3) {
        gc.setFill(c1);
        gc.fillPolygon( new double[]{
              0.0,WIDTH/3,0.0
        }, new double[]{
                0.0, HEIGHT / 2, HEIGHT
        },3);
        gc.setFill(c2);
        gc.fillPolygon(new double [] {
              0.0,WIDTH,WIDTH,WIDTH/3
        }, new double[] {
                0.0,0.0,HEIGHT/2,HEIGHT/2
        },4);
        gc.setFill(c3);
        gc.fillPolygon(new double[] {
                0.0,WIDTH/3,WIDTH,WIDTH
        }, new double[] {
                HEIGHT,HEIGHT/2,HEIGHT/2,HEIGHT
        },4);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0.0,0.0,WIDTH,HEIGHT);
    }

}
