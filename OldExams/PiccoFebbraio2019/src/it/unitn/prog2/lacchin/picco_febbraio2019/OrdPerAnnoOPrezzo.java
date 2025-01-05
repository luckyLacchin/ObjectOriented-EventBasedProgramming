package it.unitn.prog2.lacchin.picco_febbraio2019;

import java.util.Comparator;

public class OrdPerAnnoOPrezzo implements Comparator <Record>{
    @Override
    public int compare(Record o1, Record o2) {
        return o1.field3.compareTo(o2.field3);
    }
}
