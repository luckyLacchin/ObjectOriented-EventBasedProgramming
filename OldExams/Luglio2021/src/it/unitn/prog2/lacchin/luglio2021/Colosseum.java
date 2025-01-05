package it.unitn.prog2.lacchin.luglio2021;

import it.unitn.prog2.lacchin.rotabili.*;


import java.util.ArrayList;

public class Colosseum extends Treno{

    public Colosseum () {
        super();
        ArrayList<Rotabile> rotabili = new ArrayList<Rotabile>();
        rotabili.add((new Loco()));
        rotabili.add (new Az());
        rotabili.add (new Bz());
        rotabili.add (new Bz());
        rotabili.add (new Dz());
        rotabili.add (new Wrz());
        this.costruisci(this,rotabili,"Colosseum");
    }
}
