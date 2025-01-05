package it.unitn.prog2.lacchin.giugno2021;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ScambioC extends Casella{

    Line line = null;
    Line line2 = null;
    ScambioC (EventHandler<MouseEvent> mouseEvent) {
        super(mouseEvent);
        line = new Line();
        line.setStartX(0);
        line.setStartY(15);
        line.setEndX(100);
        line.setEndY(15);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        this.getChildren().add(line);
        line2 = new Line();
        line2.setStartX(0);
        line2.setStartY(15);
        line2.setEndX(50);
        line2.setEndY(30);
        line2.setStroke(Color.BLACK);
        line2.setStrokeWidth(3);
        this.getChildren().add(line2);
    }
}
