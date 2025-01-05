package it.unitn.prog2.lacchin.picco_giugno2019;

import java.util.Comparator;

public class OrdPerNome implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.nome.compareTo(o2.nome);
    }
}
