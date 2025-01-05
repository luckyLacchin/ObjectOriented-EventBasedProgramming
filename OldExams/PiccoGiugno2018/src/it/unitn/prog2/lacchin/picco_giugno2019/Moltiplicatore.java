package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.scene.paint.Color;

public class Moltiplicatore extends Cella{

    static final Color GREEN = Color.GREEN;

    public Moltiplicatore (Griglia griglia) {
        super(griglia);
        background.setFill(GREEN);
        text.setText("x2");
        this.getChildren().addAll(background,text,foreground);
    }

    @Override
    public void fire () {
        griglia.lucky.punti *= 2;
        griglia.lucky.punteggio.setText("Punteggio = " + griglia.lucky.punti);
    }
}
