package it.unitn.prog2.lacchin;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Cella extends StackPane implements Cloneable {

    Rectangle foreground;
    Rectangle background;
    Text testo;
    Griglia griglia;
    int lato;
    boolean scoperta;
    Cella cella;
    EventHandler <MouseEvent> mouseHandler;

    public Cella(Griglia griglia) {
        super();
        cella = this;
        this.griglia = griglia;
        scoperta = false;
        lato = griglia.LATO / griglia.play.N;

        foreground = new Rectangle(lato, lato);
        foreground.setFill(Color.YELLOW);
        foreground.setStroke(Color.BLACK);

        background = new Rectangle(lato, lato);
        background.setFill(Color.YELLOW);
        background.setStroke(Color.BLACK);

        testo = new Text();

        this.getChildren().addAll(background, testo, foreground);


        mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!scoperta) {
                    scoperta = true;
                    cella.getChildren().remove(foreground);
                    cella.scopri();
                } else {
                    scoperta = false;
                    cella.getChildren().add(foreground);
                    cella.nascondi();
                }
            }
        };

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseHandler);

    }

    abstract void scopri();

    abstract void nascondi();

    @Override
    public Cella clone() {
        Cella res;
        try {
            res = (Cella) super.clone();
            /*
            res.background = new Rectangle(lato, lato);
            res.background.setFill(Color.YELLOW);
            res.background.setStroke(Color.BLACK);

            res.testo = new Text();
            res.testo.setText(this.testo.getText());

            res.getChildren().clear();
            res.getChildren().addAll(res.background,res.testo);

             */

            return res;
        } catch (CloneNotSupportedException e) {
            System.err.println("Implementation error");
            System.exit(1);
        }
        return null; //qui non arriva mai }

    }
}
