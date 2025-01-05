package it.unitn.prog2.lacchin.giugno2021;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Diritto extends Casella{

    Line line = null;
    Diritto (EventHandler<MouseEvent> mouseEvent) {
        super(mouseEvent);
        line = new Line();
        line.setStartX(0);
        line.setStartY(15);
        line.setEndX(100);
        line.setEndY(15);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        this.getChildren().add(line);
    }
    public void change () {
        if (line.getStroke() == Color.BLACK)
            line.setStroke(Color.RED);
        else
            line.setStroke(Color.BLACK);
    }

    public Line getLine() {
        return line;
    }
}
