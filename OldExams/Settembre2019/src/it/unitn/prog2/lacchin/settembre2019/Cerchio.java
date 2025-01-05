package it.unitn.prog2.lacchin.settembre2019;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cerchio extends Figura {


    public Cerchio (Casella app) {
        super(app);
        figura = new Circle(Figura.RADIUS);
        figura.setStroke(Figura.BORDO);
        figura.setFill(Figura.GIALLO);
        //this.figura.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);
    }


}
