package it.unitn.prog2.lacchin.giugno2022;

import it.unitn.prog2.lacchin.giugno2022.bandiere.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Iterator;

public class Griglia extends GridPane {

    Main app = null;

    public Griglia (Main app) {
        super();
        this.app = app;
        riempiPrimaColonna();
        riempiSecondaColonna();
        riempiTerzaColonna();
    }


    public void riempiPrimaColonna () {

        Iterator<Stato> x = app.stati.iterator();

        for (int i = 0; i  < app.stati.size(); i++) {
            this.add(x.next().bandiera,0,i);
        }
    }
    public void riempiSecondaColonna () {

        Iterator<Stato> x = app.stati.iterator();

        for (int i = 0; i  < app.stati.size(); i++) {
            this.add(new Text(x.next().nome),1,i);
        }
    }
    public void riempiTerzaColonna () {

        Iterator<Stato> x = app.stati.iterator();

        for (int i = 0; i  < app.stati.size(); i++) {
            this.add(new Text(x.next().capitale),2,i);
        }
    }
}
