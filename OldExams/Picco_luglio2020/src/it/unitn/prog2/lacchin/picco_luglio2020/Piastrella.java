package it.unitn.prog2.lacchin.picco_luglio2020;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public abstract class Piastrella {

    String codice, materiale,costo,dimensione,sceltaString;
    double dim,value;
    boolean sceltaColore;
    Color base;
    int indexColore = 0;

    final ArrayList<Color> colori;


    public Piastrella (String codice, String materiale, double value, double dim,boolean sceltaColore) {

        this.codice = codice;
        this.materiale = materiale;
        this.value = value;
        this.dim = dim;
        this.sceltaColore = sceltaColore;
        this.costo = String.valueOf(this.value);
        this.dimensione = String.valueOf(this.dim);
        colori = new ArrayList<>();
        colori.add(Color.BROWN);
        colori.add(Color.WHEAT);
        colori.add(Color.TEAL);
        colori.add(Color.DARKBLUE);
        colori.add(Color.OLIVE);
        colori.add(Color.GOLD);



        if (sceltaColore)
            sceltaString = "SI";
        else
            sceltaString = "NO";
        this.base = this.colori.get(0);

    }
}
