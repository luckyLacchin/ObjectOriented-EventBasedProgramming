package it.unitn.prog2.lacchin.gennaio2020;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Fissa extends Cella{

    static Color GREY = Color.GREY;
    public Fissa (EventHandler<MouseEvent> mouseHandler,Sudoku root) {
        super(mouseHandler,root);
        rectangle.setFill(GREY);
        text = new Text();
        text.setText(String.valueOf(root.cb.getValue()));
        this.getChildren().addAll(rectangle,text);

    }
}
