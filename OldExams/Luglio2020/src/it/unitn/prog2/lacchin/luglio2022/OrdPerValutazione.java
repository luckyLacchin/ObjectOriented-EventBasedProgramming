package it.unitn.prog2.lacchin.luglio2022;

import java.util.Comparator;

public class OrdPerValutazione implements Comparator<Alloggio> {
    @Override
    public int compare(Alloggio o1, Alloggio o2) {
        if (o1.valutazione == o2.valutazione)
            return 0;
        else if (o1.valutazione > o2.valutazione)
            return 1;
        else
            return -1;
    }
}
