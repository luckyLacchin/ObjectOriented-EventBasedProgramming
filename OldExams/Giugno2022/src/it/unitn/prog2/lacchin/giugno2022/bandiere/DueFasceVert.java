package it.unitn.prog2.lacchin.giugno2022.bandiere;

import javafx.scene.paint.Color;

public class DueFasceVert extends Bandiera{

    public DueFasceVert(Color c1, Color c2) {

        gc.setFill(c1);
        gc.fillRect(0.0,0.0,WIDTH/2,HEIGHT);
        gc.setFill(c2);
        gc.fillRect(WIDTH/2,0.0,WIDTH/2,HEIGHT);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0.0,0.0,WIDTH,HEIGHT);
    }
}
