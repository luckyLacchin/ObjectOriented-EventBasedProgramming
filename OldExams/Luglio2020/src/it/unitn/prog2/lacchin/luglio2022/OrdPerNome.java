package it.unitn.prog2.lacchin.luglio2022;

import java.util.Comparator;

public class OrdPerNome implements Comparator<Alloggio> {
    @Override
    public int compare(Alloggio o1, Alloggio o2) {
        return o1.nome.compareTo(o2.nome);
    }
}
