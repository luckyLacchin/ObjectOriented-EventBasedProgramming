package it.unitn.prog2.lacchin.gennaio2022;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

abstract public class Casella extends StackPane {

    Rectangle rec = null;
    int val;
    Text valore;
    EventHandler<MouseEvent> mouseHandler = null;
    public Casella () {
        super();
        rec = new Rectangle(50,50);
        rec.setStroke(Color.WHITE);
        valore = new Text();
    }
}
