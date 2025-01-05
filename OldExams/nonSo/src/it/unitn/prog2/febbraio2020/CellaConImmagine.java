package it.unitn.prog2.febbraio2020;

import javafx.scene.image.ImageView;

public class CellaConImmagine extends Cella{
    ImageView iw = null;
    public CellaConImmagine (ImageView iw, int column, Griglia griglia) {
        super(column,griglia);
        this.iw = iw;
        this.getChildren().addAll(background,this.iw);
    }
}
