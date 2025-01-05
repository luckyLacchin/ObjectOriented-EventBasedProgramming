package it.unitn.prog2.lacchin.giugno2021;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class Casella extends Pane {


    Rectangle rec = null;
    EventHandler<MouseEvent> mouseEvent = null;
    Casella (EventHandler<MouseEvent> mouseEvent) {
        super();
        rec = new Rectangle(100,30);
        rec.setStroke(Color.BLUE);
        rec.setFill(Color.WHITE);
        this.getChildren().add(rec);
        this.mouseEvent = mouseEvent;
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent);
    }
}
