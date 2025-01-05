package it.unitn.prog2.lacchin.settembre2019;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Figura {

    Shape figura;
    Casella app;
    static final Color GIALLO = Color.YELLOW;
    static final double RADIUS = 30.0;
    static final Color BORDO = Color.RED;
    EventHandler <MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            EventTarget target = mouseEvent.getTarget();

            if (target instanceof Shape) {
                app.cancella.fire();
            }
        }
    };


    public Figura (Casella app) {
        //dobbiamo fare una funzione che mi prenda a caso una figura!

        this.app = app;



    }

    public Shape getFigura() {
        return figura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.getClass().getName().equals(((Figura)o).getClass().getName());
    }

}
