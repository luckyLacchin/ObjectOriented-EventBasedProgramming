package it.unitn.prog2.lacchin.picco_luglio2020;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Bicolore extends Piastrella{

    Shape interno;
    Color coloreInterno;
    int indexColoreInterno = 1;
    public Bicolore(String codice, String materiale, double value, double dim, boolean sceltaColore, Shape interno) {
        super(codice, materiale, value, dim, sceltaColore);
        this.interno = interno;
        coloreInterno = colori.get(1);
    }
}
