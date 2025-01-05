package it.unitn.prog2.lacchin.gennaio2020;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

abstract public class Cella extends StackPane {

    static final int WIDTH = Sudoku.HEIGHT/((Sudoku.N)*(Sudoku.N));
    Text text = null;
    int numero;
    Rectangle rectangle = null;
    EventHandler<MouseEvent> mouseHandler = null;
    Sudoku root;


    public Cella (EventHandler<MouseEvent> mouseHandler, Sudoku root) {
        super();
        this.root = root;
        rectangle = new Rectangle();
        rectangle.setStroke(Color.BLACK);
        rectangle.setWidth(Cella.WIDTH);
        rectangle.setHeight(Cella.WIDTH);
        this.mouseHandler = mouseHandler;

        addEventHandler(MouseEvent.MOUSE_CLICKED,this.mouseHandler);

    }

}
