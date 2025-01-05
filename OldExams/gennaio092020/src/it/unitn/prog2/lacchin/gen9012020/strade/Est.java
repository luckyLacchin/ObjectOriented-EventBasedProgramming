package it.unitn.prog2.lacchin.gen9012020.strade;

import it.unitn.prog2.lacchin.gen9012020.RoadGame;
import javafx.geometry.Pos;

public class Est extends Strada{

    public Est (int i, int j, RoadGame game) {
        super(i,j,game);
        direzione = "sud";
        bp.setAlignment(circle, Pos.CENTER);
        bp.setRight(circle);
        this.getChildren().add(bp);
    }
}
