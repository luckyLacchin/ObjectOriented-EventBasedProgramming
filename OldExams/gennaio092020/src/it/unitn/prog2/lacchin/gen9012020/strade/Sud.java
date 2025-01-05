package it.unitn.prog2.lacchin.gen9012020.strade;

import it.unitn.prog2.lacchin.gen9012020.RoadGame;
import javafx.geometry.Pos;

public class Sud extends Strada{


    public Sud (int i, int j, RoadGame game) {
        super(i,j,game);
        direzione = "sud";
        bp.setAlignment(circle, Pos.CENTER);
        bp.setBottom(circle);
        this.getChildren().add(bp);

    }
}
