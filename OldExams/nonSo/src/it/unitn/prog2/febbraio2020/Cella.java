package it.unitn.prog2.febbraio2020;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Objects;


public class Cella extends StackPane {

    static final int LATO = 150;
    static final Color[] COLORI = {Color.YELLOW,Color.AZURE};
    Rectangle background = null;
    ImageView iw = null;
    Text testo = null;
    int column;
    Griglia griglia = null;

    public Cella (int column, Griglia griglia) {
        this.griglia = griglia;
        this.column = column;
        background = new Rectangle();
        background.setFill(COLORI[0]);
        background.setHeight(LATO);
        background.setWidth(LATO);
        background.setStroke(Color.BLACK);
        testo = new Text();
        EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Cella source = (Cella) mouseEvent.getSource();
                griglia.selezionati.add(source);
                if(griglia.selezionati.size() == 3) {
                        griglia.controlAnswer();
                }
            }
        };
        addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);


    }
    public Cella (ImageView iw, int column, Griglia griglia) {
        this(column,griglia);
        this.iw = iw;
        this.getChildren().addAll(background,this.iw);
    }

    public Cella (String stringa, int column, Griglia griglia) {
        this(column,griglia);
        testo.setText(stringa);
        this.getChildren().addAll(background,testo);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cella cella = (Cella) o;
        return column == cella.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column);
    }
}
