package it.unitn.prog2.lacchin.gennaio2020;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NonInizializzata extends Cella{

    static Color WHITE = Color.WHITE;
    public NonInizializzata (EventHandler<MouseEvent> mouseHandler,Sudoku root) {
        super(mouseHandler,root);
        rectangle.setFill(WHITE);
        rectangle.setStroke(Color.BLACK);
        this.getChildren().add(rectangle);
    }
}
