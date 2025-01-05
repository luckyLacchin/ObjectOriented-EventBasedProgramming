package esame0621.caselle;

import esame0621.Matrice;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class Casella extends Pane {
    public static final int TILE_HALF_HEIGHT=30;
    public static final int TILE_HEIGHT=TILE_HALF_HEIGHT*2;
    public static final int TILE_WIDTH=100;
    public static final int TILE_HALF_WIDTH=TILE_WIDTH/2;
    Rectangle box=new Rectangle();
    boolean isInPalette=false;
    Matrice matrice=null;

    public Casella() {
        box.setWidth(TILE_WIDTH);
        box.setHeight(TILE_HEIGHT);
        box.setStroke(Color.BLUE);
        this.getChildren().add(box);
        this.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (isInPalette) {
                    System.out.println(event.getSource().getClass().getName());
                    matrice.replaceCells(event.getSource().getClass().getName());
                    event.consume();
                }
            }
        });
    }

    public void setInPalette(Matrice m) {
        isInPalette = true;
        matrice=m;
    }
}