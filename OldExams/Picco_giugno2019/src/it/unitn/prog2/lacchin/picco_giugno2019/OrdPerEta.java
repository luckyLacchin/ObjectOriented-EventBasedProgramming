package it.unitn.prog2.lacchin.picco_giugno2019;

import java.util.Comparator;

public class OrdPerEta implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        Integer anno1 = o1.anno;
        Integer anno2 = o2.anno;
        return anno1.compareTo(anno2);
    }
}
