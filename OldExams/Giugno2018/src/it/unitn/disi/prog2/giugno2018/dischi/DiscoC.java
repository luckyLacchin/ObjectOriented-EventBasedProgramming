package it.unitn.disi.prog2.giugno2018.dischi;

import javafx.scene.paint.Color;

public class DiscoC extends Disco{

    static final Color COLORE = COLORI[1];

    public DiscoC () {
        width = 80.0;
        this.setWidth(width);
        this.setHeight(HEIGHT);
        this.setFill(COLORE);
    }
}
