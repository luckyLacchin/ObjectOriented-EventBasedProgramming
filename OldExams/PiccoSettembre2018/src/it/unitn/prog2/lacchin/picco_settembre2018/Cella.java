package it.unitn.prog2.lacchin.picco_settembre2018;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Cella extends StackPane {

    Text carta;
    String seme;
    String valore;
    Rectangle rectangle;
    Card card;
    final static Color AZZURRO = Color.AQUA;
    final static Color STROKE = Color.BLACK;
    final static double LATO = 50.0;

    public Cella (String seme, String valore, Card card) {

        this.seme = seme;
        this.valore = valore;
        this.card = card;
        carta = new Text();
        rectangle = new Rectangle(LATO,LATO);
        rectangle.setFill(AZZURRO);
        rectangle.setStroke(STROKE);
        carta.setText(this.valore + this.seme);
        this.getChildren().addAll(rectangle,carta);
    }
}
