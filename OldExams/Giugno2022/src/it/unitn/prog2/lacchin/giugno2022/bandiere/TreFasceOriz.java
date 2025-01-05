package it.unitn.prog2.lacchin.giugno2022.bandiere;

import javafx.scene.paint.Color;

public class TreFasceOriz extends Bandiera{

    public TreFasceOriz (Color c1, Color c2,Color c3) {

        gc.setFill(c1);
        gc.fillRect(0.0,0.0,WIDTH,HEIGHT/3);
        gc.setFill(c2);
        gc.fillRect(0.0,HEIGHT/3,WIDTH,HEIGHT/3);
        gc.setFill(c3);
        gc.fillRect(0.0,HEIGHT - HEIGHT/3,WIDTH,HEIGHT/3);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0.0,0.0,WIDTH,HEIGHT);

    }
}
