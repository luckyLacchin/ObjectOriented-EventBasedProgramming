package it.unitn.disi.prog2.giugno2018.dischi;

import javafx.scene.paint.Color;

public class DiscoA extends Disco{

    static final Color COLORE = COLORI[3];

    public DiscoA () {
        width = 40.0;
        this.setWidth(width);
        this.setHeight(HEIGHT);
        this.setFill(COLORE);
    }
}
