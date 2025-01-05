package it.unitn.prog2.lacchin.giugno2021;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Vuoto extends Casella{

    Vuoto (EventHandler<MouseEvent> mouseEvent) {

        super (mouseEvent);
    }

    public void change () {
        if (super.rec.getFill() == Color.WHITE)
            super.rec.setFill(Color.GREY);
        else
            super.rec.setFill(Color.WHITE);
    }
}
