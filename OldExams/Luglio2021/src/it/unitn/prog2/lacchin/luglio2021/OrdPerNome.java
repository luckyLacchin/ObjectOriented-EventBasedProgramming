package it.unitn.prog2.lacchin.luglio2021;

import java.util.Comparator;

public class OrdPerNome implements Comparator<Treno> {

    @Override
    public int compare(Treno o1, Treno o2) {
        return (o1.getNome().getNome().compareTo(o2.getNome().getNome()));
    }
}
