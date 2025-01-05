package it.unitn.prog2.lacchin.luglio2022;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Testo extends Text {

    EventHandler<MouseEvent> mouseHandler = null;
    String text;
    public Testo (EventHandler<MouseEvent> mouseHandler, String text) {
        super();
        this.mouseHandler = mouseHandler;
        this.text = text;
        this.setText(text);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);
    }

}
