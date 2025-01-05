package it.unitn.prog2.lacchin.luglio2022;

import java.util.Comparator;

public class OrdPerPrezzo implements Comparator<Alloggio> {
    @Override
    public int compare(Alloggio o1, Alloggio o2) {
        if (o1.prezzo == o2.prezzo)
            return 0;
        else if (o1.prezzo > o2.prezzo)
            return 1;
        else
            return -1;
    }
}
