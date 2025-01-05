package it.unitn.disi.prog2.giugno2018.dischi;

import javafx.scene.paint.Color;

public class DiscoD extends Disco{


    static final Color COLORE = COLORI[0];

    public DiscoD () {
        width = 100.0;
        this.setWidth(width);
        this.setHeight(HEIGHT);
        this.setFill(COLORE);
    }
}
