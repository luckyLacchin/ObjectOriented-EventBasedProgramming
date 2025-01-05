package it.unitn.prog2.lacchin.grigliafigure;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Figura extends StackPane{
    Shape shape = null;
    int x=-1;
    int y=-1;
    Figura (int x, int y, EventHandler eventHandler) {
        super();
        int shapeIndex = (int) (Math.random() * 3);
        this.x = x;
        this.y = y;
        switch (shapeIndex) {
            case 0:
                shape = new Rectangle(70,70);
                break;
            case 1:
                shape = new Circle(35);
                break;
            case 2:
                shape = new Polygon();
                ((Polygon)shape).getPoints().setAll(
                        0.0, 0.0,
                        70.0, 0.0,
                        35.0, 70.0
                );
                break;
            default:
                break;
        }
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);
        shape.setFill(Color.WHITE);
        shape.setStroke(Color.BLACK);
        this.getChildren().add(shape);
        this.setAlignment(Pos.CENTER);
    }
    public void change () {
        if (((this.x + this.y)%2)==0 ) {
            if (this.shape.getFill().equals(Color.WHITE))
                this.shape.setFill(Color.GREEN);
            else
                this.shape.setFill(Color.WHITE);
        }
        else {
            if (this.shape.getFill().equals(Color.WHITE))
                this.shape.setFill(Color.RED);
            else
                this.shape.setFill(Color.WHITE);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }


    public Shape getShapee() {
        return this.shape;
    }

}
