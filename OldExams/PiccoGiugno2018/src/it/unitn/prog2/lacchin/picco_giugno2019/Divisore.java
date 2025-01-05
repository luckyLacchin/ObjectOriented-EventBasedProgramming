package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.scene.paint.Color;

public class Divisore extends Cella{

    static final Color RED = Color.RED;

    public Divisore (Griglia griglia) {
        super(griglia);
        background.setFill(RED);
        text.setText("/2");
        this.getChildren().addAll(background,text,foreground);

    }

    @Override
    public void fire () {
        griglia.lucky.punti /= 2;
        griglia.lucky.punteggio.setText("Punteggio = " + griglia.lucky.punti);
    }
}
