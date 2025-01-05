package it.unitn.prog2.lacchin.giugno2019;

import javafx.scene.shape.Circle;

public class CircleTile extends Tile{


    public CircleTile(Stack stack) {
        super(stack);
        figura = new Circle(Tile.RADIUS);
        figura.setFill(color);
        figura.setStroke(stroke);
        this.getChildren().addAll(figura,testo);
    }
}
