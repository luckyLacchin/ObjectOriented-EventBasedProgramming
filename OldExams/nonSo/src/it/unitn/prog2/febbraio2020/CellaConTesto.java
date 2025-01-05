package it.unitn.prog2.febbraio2020;

import javafx.scene.text.Text;

public class CellaConTesto extends Cella{


    public CellaConTesto (String stringa, int column, Griglia griglia) {
        super(column,griglia);
        testo = new Text();
        testo.setText(stringa);
        this.getChildren().addAll(background,testo);
    }
}
