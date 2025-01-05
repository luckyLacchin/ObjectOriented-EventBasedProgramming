package it.unitn.prog2.lacchin.luglio2021;

import it.unitn.prog2.lacchin.rotabili.Az;
import it.unitn.prog2.lacchin.rotabili.Bz;
import it.unitn.prog2.lacchin.rotabili.Loco;
import it.unitn.prog2.lacchin.rotabili.Rotabile;

import java.util.ArrayList;

public class Mediolanum extends Treno{

    public Mediolanum () {
        super();
        ArrayList<Rotabile> rotabili = new ArrayList<Rotabile>();
        rotabili.add((new Loco()));
        rotabili.add (new Az());
        rotabili.add (new Az());
        rotabili.add (new Az());
        this.costruisci(this,rotabili,"Mediolanum");
    }
}
