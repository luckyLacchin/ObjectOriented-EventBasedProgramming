package it.unitn.disi.prog2.giugno2018.dischi;

import it.unitn.disi.prog2.giugno2018.Palo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Disco extends Rectangle {

    static final Color [] COLORI = {Color.INDIANRED,Color.VIOLET, Color.GREENYELLOW, Color.LIGHTGREY};
    static final double HEIGHT = 10.0;
    Palo currentPalo;
    double width;

    public void setCurrentPalo (Palo p) {
        currentPalo = p;
    }

    public Palo getCurrentPalo() {
        return currentPalo;
    }

    public double getDimensione () {
        return this.width;
    }
}
