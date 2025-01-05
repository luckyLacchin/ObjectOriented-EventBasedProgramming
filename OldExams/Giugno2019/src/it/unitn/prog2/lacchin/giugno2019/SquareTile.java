package it.unitn.prog2.lacchin.giugno2019;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SquareTile extends Tile{


    public SquareTile(Stack stack) {
        super(stack);
        figura = new Rectangle(Tile.RADIUS * 2,Tile.RADIUS * 2);
        figura.setFill(color);
        figura.setStroke(stroke);
        this.getChildren().addAll(figura,testo);
    }
}