package it.unitn.prog2.lacchin.gen9012020;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Prato extends Cella{

    static final Color VERDE = Color.GREEN;
    public Prato (int i, int j, RoadGame game) {
        super(i,j, game);
        rectangle = new Rectangle(LATO,LATO);
        rectangle.setFill(VERDE);
        setMargin(rectangle,new Insets(0.5,0.5,0.5,0.5));
        this.getChildren().add(rectangle);
    }
}
