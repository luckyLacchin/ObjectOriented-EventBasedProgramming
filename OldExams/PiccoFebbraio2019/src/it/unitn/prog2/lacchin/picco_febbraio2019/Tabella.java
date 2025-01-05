package it.unitn.prog2.lacchin.picco_febbraio2019;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Tabella extends StackPane {

    static final double WIDTH = 350.0;
    static final double HEIGHT = 200.0;
    static final Color WHITE = Color.WHITE;


    Rectangle rectangle;
    VBox testi;
    public Tabella () {

        rectangle = new Rectangle(WIDTH,HEIGHT);
        rectangle.setFill(WHITE);
        rectangle.setStroke(Color.GREY);
        testi = new VBox();

        this.getChildren().addAll(rectangle,testi);

    }

    public void riempi (ArrayList <Record> lista) {

        for (Record record : lista) {
            HBox hb = new HBox();
            Text t1 = new Text(record.field1);
            Text t2 = new Text(record.field2);
            Text t3 = new Text(String.valueOf(record.field3));
            hb.setAlignment(Pos.TOP_LEFT);
            hb.setSpacing(2);
            hb.getChildren().addAll(t1,t2,t3);
            testi.getChildren().add(hb);
        }
    }
}
