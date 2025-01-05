package it.unitn.prog2.lacchin.picco_luglio2020;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class LayoutPiastrella extends StackPane {

    static final double LATO = 130;
    Rectangle rectangle;
    Shape interno;

    public LayoutPiastrella (Piastrella piastrella) {
        rectangle = new Rectangle(LATO,LATO);
        rectangle.setFill(piastrella.base);
        this.getChildren().add(rectangle);
        rectangle.setId("bordo");
        if (piastrella instanceof Bicolore) {
            interno = ((Bicolore) piastrella).interno;
            interno.setFill(((Bicolore) piastrella).coloreInterno);
            this.getChildren().add(interno);
            interno.setId("interno");
        }
        EventHandler<MouseEvent> mouseHandler = mouseEvent -> {

            if (piastrella.sceltaColore && mouseEvent.getTarget() instanceof Shape) {
                Shape target = (Shape) mouseEvent.getTarget();
                if (target.getId().equals("bordo"))
                    target.setFill(piastrella.colori.get((++piastrella.indexColore) % (piastrella.colori.size())));
                else if (target.getId().equals("interno"))
                    target.setFill(piastrella.colori.get((++((Bicolore)piastrella).indexColoreInterno) % (piastrella.colori.size())));
            }
        };
        addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);
    }
}
