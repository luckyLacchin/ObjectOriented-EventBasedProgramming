package it.unitn.disi.prog2.grigliafigure;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Objects;
import java.util.Random;

public class Figura extends StackPane{
    private Shape oggetto;
    private int x,y;
    EventHandler <MouseEvent> clickHandler;
    public Figura (EventHandler <MouseEvent> clickHandler,int x, int y) {
        super();
        this.clickHandler = clickHandler;
        this.x = x;
        this.y = y;
        Random r = new Random ();

        switch (r.nextInt(3)) {
            case 0 -> oggetto = new Circle(30);
            case 1 -> oggetto = new Rectangle(60, 60);
            case 2 -> oggetto = new Polygon(0.0, 0.0, 0.0, 60.0, Math.sqrt(3) / 2 * 60.0, 30.0);
            default -> {
            }
        }
        oggetto.setFill(Color.WHITE);
        oggetto.setStroke(Color.BLACK);
        this.getChildren().add(oggetto);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, this.clickHandler);
    }

    public void change() {

        if (oggetto.getFill().equals(Color.WHITE)) {
            if (((this.x + this.y) % 2) != 0)
                oggetto.setFill(Color.RED);
            else
                oggetto.setFill(Color.GREEN);
        }
        else
            oggetto.setFill(Color.WHITE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figura figura = (Figura) o;

        if (this.oggetto.getClass()!= figura.oggetto.getClass()) return false;
        return oggetto.getFill().equals((figura.oggetto.getFill()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(oggetto);
    }

    public Shape getOggetto() { //devo fare così perchè l'oggetto Shape è private, quindi per darlo al main devo dare un getter!
        /* Abbiamo messo la limitazione di Shape private in modo tale che possiamo solo vedere com'è e non modificarlo, cosa
        che potremmo fare se lo mettessimo public!
         */
        return oggetto;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
