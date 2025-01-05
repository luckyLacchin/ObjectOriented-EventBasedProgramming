package it.unitn.prog2.lacchin.gennaio2020;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Libera extends Cella{

    static final  Color [] COLORI = {Color. LIGHTYELLOW, Color.LIGHTPINK, Color.LIGHTSTEELBLUE,
             Color.LIGHTGREEN, Color.LIGHTBLUE, Color.LIGHTSALMON,
            Color.LAVENDER, Color.BISQUE, Color.HONEYDEW};
    public Libera (EventHandler<MouseEvent> mouseHandler,Sudoku root) {
        super(mouseHandler,root);
        //rectangle.setFill(Quadrato.COLORI[index]);
        text = new Text();
        text.setText("");
        this.getChildren().addAll(rectangle,text);

    }
}
