package it.unitn.prog2.lacchin.settembre2019;


import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Triangolo extends Figura {


    public Triangolo (Casella app) {
        super(app);
        figura = new Polygon();
        ((Polygon)figura).getPoints().addAll (
                Figura.RADIUS,0.0,
                0.0,Figura.RADIUS*2,
                Figura.RADIUS*2,Figura.RADIUS*2);
        figura.setStroke(Figura.BORDO);
        figura.setFill(Figura.GIALLO);
        //this.figura.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);
    }

}
