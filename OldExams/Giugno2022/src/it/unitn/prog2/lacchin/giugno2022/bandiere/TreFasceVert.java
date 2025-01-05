package it.unitn.prog2.lacchin.giugno2022.bandiere;

import javafx.scene.paint.Color;

public class TreFasceVert extends Bandiera{

    public TreFasceVert (Color c1, Color c2, Color c3) {

        gc.setFill(c1);
        gc.fillRect(0.0,0.0,WIDTH/3,HEIGHT);
        gc.setFill(c2);
        gc.fillRect(WIDTH/3,0.0,WIDTH/3,HEIGHT);
        gc.setFill(c3);
        gc.fillRect(WIDTH-(WIDTH/3),0.0,WIDTH/3,HEIGHT);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0.0,0.0,WIDTH,HEIGHT);
    }
}
