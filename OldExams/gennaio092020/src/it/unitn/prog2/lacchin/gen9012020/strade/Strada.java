package it.unitn.prog2.lacchin.gen9012020.strade;

import it.unitn.prog2.lacchin.gen9012020.Cella;
import it.unitn.prog2.lacchin.gen9012020.RoadGame;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Strada extends Cella {

    static final int RADIUS = 10;
    static final Color STROKE = Color.YELLOW;
    Circle circle;
    String direzione;

    public Strada (int i, int j, RoadGame game) {
        super(i,j,game);
        bp = new BorderPane();
        circle = new Circle();
        bp.setStyle("-fx-background-color: #666666;");
        circle.setRadius(RADIUS);
        circle.setStroke(Color.YELLOW);
        setMargin(bp,new Insets(0.5,0.5,0.5,0.5));
        bp.setPrefWidth(Cella.LATO);
        bp.setPrefHeight(Cella.LATO);


    }
}
