package it.unitn.prog2.lacchin.picco_luglio2020;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Layout extends HBox {

    Text tx1,tx2,tx3,tx4,tx5;

    public Layout (Button prev, Button next, Piastrella piastrella) {
        super();

        VBox right = new VBox();
        right.setAlignment(Pos.CENTER);
        LayoutPiastrella layoutPiastrella = new LayoutPiastrella(piastrella);
        right.getChildren().add(layoutPiastrella);

        VBox left = new VBox();
        VBox up = new VBox();
        HBox bottoni = new HBox();

        tx1 = new Text("Codice: " + piastrella.codice);
        tx2 = new Text("materiale: " + piastrella.materiale);
        tx3 = new Text("costo: " + piastrella.costo);
        tx4 = new Text("dimensione: " + piastrella.dimensione);
        tx5 = new Text("scelta colore: "+ piastrella.sceltaString);
        up.setAlignment(Pos.CENTER_LEFT);
        up.getChildren().addAll(tx1,tx2,tx3,tx4,tx5);

        bottoni.getChildren().addAll(prev,next);
        bottoni.setAlignment(Pos.CENTER);

        left.setSpacing(15.0);
        left.setAlignment(Pos.CENTER);
        left.getChildren().addAll(up,bottoni);

        this.setSpacing (10.0);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(left,right);



    }
}
