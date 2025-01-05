package it.unitn.prog2.lacchin.gen9012020;

import it.unitn.prog2.lacchin.gen9012020.strade.*;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Griglia extends GridPane {

    Griglia app;
    RoadGame game;
    public Griglia (RoadGame game) {
        super();
        this.setWidth(500);
        this.setHeight(500);
        this.app = this;
        this.game = game;
        riempiGriglia();

    }

    public void riempiGriglia () {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.add(new Prato(i,j,game),j,i);
            }
        }
    }


}
