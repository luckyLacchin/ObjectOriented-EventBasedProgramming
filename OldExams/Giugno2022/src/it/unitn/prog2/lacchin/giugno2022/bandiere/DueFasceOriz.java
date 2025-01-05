package it.unitn.prog2.lacchin.giugno2022.bandiere;

import javafx.scene.paint.Color;

public class DueFasceOriz extends Bandiera{

    public DueFasceOriz (Color c1, Color c2) {
        gc.setFill(c1);
        gc.fillRect(0.0,0.0,WIDTH,HEIGHT/2);
        gc.setFill(c2);
        gc.fillRect(0.0,HEIGHT/2,WIDTH,HEIGHT/2);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0.0,0.0,WIDTH,HEIGHT);
    }
}
