package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.scene.paint.Color;

public class Base extends Cella{

    static final Color WHITE = Color.WHITE;

    public Base(int i, int j,Griglia griglia) {
        super(i,j,griglia);
        background.setFill(WHITE);
        valore = (int) (Math.random() * 11) * 100;
        text.setText(String.valueOf(valore));
        this.getChildren().addAll(background,text,foreground);

    }

    public Base(Griglia griglia) {
        super(griglia);
        background.setFill(WHITE);
        valore = (int) (Math.random() * 11) * 100;
        text.setText(String.valueOf(valore));
        this.getChildren().addAll(background,text,foreground);

    }
    @Override
    public void fire () {
        griglia.lucky.punti += this.valore;
        griglia.lucky.punteggio.setText("Punteggio = " + griglia.lucky.punti);
    }
}
