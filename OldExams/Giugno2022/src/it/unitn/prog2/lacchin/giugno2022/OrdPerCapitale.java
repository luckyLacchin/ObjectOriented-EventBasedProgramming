package it.unitn.prog2.lacchin.giugno2022;

import java.util.Comparator;

public class OrdPerCapitale implements Comparator<Stato> {
    @Override
    public int compare(Stato o1, Stato o2) {
        return o1.capitale.compareTo(o2.capitale);
    }
}
