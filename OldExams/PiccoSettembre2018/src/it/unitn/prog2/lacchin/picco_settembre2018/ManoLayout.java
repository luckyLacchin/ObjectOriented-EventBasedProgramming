package it.unitn.prog2.lacchin.picco_settembre2018;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ManoLayout extends HBox {

    public ManoLayout (ArrayList <Card> mano) {

        for (Card card : mano) {
            Cella temp = new Cella(card.seme,card.valore,card);
            this.getChildren().add(temp);
        }
        this.setAlignment(Pos.CENTER);
    }
}
