package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Cella extends StackPane {

    static final double WIDTH = 50.0;
    static final Color YELLOW = Color.YELLOW;
    static final Color BLACK = Color.BLACK;

    int valore;
    int i;
    int j;
    Cella questa;
    Rectangle foreground;
    Rectangle background;
    Text text;
    EventHandler <MouseEvent> mouseEvent;
    Griglia griglia;
    boolean scoperto = false;

    public Cella (int i, int j, Griglia griglia) {

        this(griglia);
        this.i = i;
        this.j = j;
    }

    public Cella (Griglia griglia) {

        this.griglia = griglia;
        questa = this;
        foreground = new Rectangle(WIDTH,WIDTH);
        foreground.setStroke(BLACK);
        foreground.setFill(YELLOW);
        background = new Rectangle(WIDTH,WIDTH);
        background.setStroke(BLACK);
        text = new Text("");

        mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                questa.getChildren().remove(foreground);
                Cella source = (Cella) mouseEvent.getSource();
                source.scoperto = true;
                switch (source.getClass().getName()) {
                    case "it.unitn.prog2.lacchin.picco_giugno2019.Base":
                        ((Base)source).fire();
                        break;
                    case "it.unitn.prog2.lacchin.picco_giugno2019.Divisore":
                        ((Divisore)source).fire();
                        break;
                    case "it.unitn.prog2.lacchin.picco_giugno2019.Moltiplicatore":
                        ((Moltiplicatore)source).fire();
                        break;
                    case "it.unitn.prog2.lacchin.picco_giugno2019.Bomba" :
                        ((Bomba)source).fire();
                        break;
                    default:
                        System.out.println("Qualcosa e' andato storto!");

                }
                source.removeEventHandler(MouseEvent.MOUSE_CLICKED,this);


                griglia.lucky.numeroTentativi -= 1;
                if (griglia.lucky.numeroTentativi > 0)
                    griglia.lucky.tentativi.setText("Tentavi = " + griglia.lucky.numeroTentativi);
                else {
                    griglia.lucky.tentativi.setText("GAME OVER!");
                    for (Cella cella : griglia.celle) {
                        cella.removeEventHandler(MouseEvent.MOUSE_CLICKED,cella.mouseEvent);
                    }
                }
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent);

    }

    public abstract void fire ();


    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
