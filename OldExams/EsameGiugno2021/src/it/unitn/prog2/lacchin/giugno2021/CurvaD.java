package it.unitn.prog2.lacchin.giugno2021;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class CurvaD extends Casella{
    Line line = null;
    CurvaD (EventHandler<MouseEvent> mouseEvent) {
        super (mouseEvent);
        line = new Line();
        line.setStartX(0);
        line.setStartY(15);
        line.setEndX(50);
        line.setEndY(0);
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
