package it.unitn.disi.prog2.giugno2018.dischi;

import javafx.scene.paint.Color;

public class DiscoB extends Disco{

    static final Color COLORE = COLORI[2];

    public DiscoB () {
        width = 60.0;
        this.setWidth(width);
        this.setHeight(HEIGHT);
        this.setFill(COLORE);
    }
}
