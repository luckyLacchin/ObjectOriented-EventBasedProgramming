package it.unitn.prog2.lacchin.luglio2021;

import java.util.Comparator;

public class OrdPerLunghezza implements Comparator<Treno> {

    @Override
    public int compare(Treno o1, Treno o2) {

        if (o1.equals(o2))
            return 0;
        if (o1.rotabili.size() > o2.rotabili.size())
            return 1;
        else
            return -1;
    }
}
