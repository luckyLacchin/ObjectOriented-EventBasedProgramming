package it.unitn.prog2.lacchin.giugno2022;

import java.util.Comparator;

public class OrdPerStato implements Comparator<Stato> {
    @Override
    public int compare(Stato o1, Stato o2) {
        return o1.nome.compareTo(o2.nome);
    }
}
