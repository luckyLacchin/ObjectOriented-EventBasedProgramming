package it.unitn.prog2.lacchin.luglio2021;

import it.unitn.prog2.lacchin.rotabili.*;

import java.util.ArrayList;
import java.util.Collection;

public class Aurora extends Treno{



    public Aurora () {
        super();
        ArrayList<Rotabile> rotabili = new ArrayList<Rotabile>();
        rotabili.add((new Loco()));
        rotabili.add (new Az());
        rotabili.add (new Az());
        rotabili.add (new Bz());
        rotabili.add (new Bz());
        this.costruisci(this,rotabili,"Aurora");
    }
}
