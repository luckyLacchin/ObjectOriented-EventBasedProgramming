package it.unitn.prog2.lacchin.settembre2019;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vuoto extends Figura{

    public Vuoto (Casella app) {
        super(app);
        figura = new Rectangle(Figura.RADIUS * 2, Figura.RADIUS * 2);
        figura.setStroke(Color.AQUA);
        figura.setFill(Color.GREY);
        //this.figura.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);
    }

}
