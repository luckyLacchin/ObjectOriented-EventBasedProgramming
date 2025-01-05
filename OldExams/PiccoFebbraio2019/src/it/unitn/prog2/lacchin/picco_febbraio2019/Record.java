package it.unitn.prog2.lacchin.picco_febbraio2019;

import java.util.Objects;

public abstract class Record implements Comparable <Record> {

    String field1;
    String field2;
    Integer field3;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return field1.equals(record.field1) && field2.equals(record.field2) && field3.equals(record.field3);
    }

    @Override
    public int compareTo(Record o) {
        return this.field2.compareTo(o.field2);
    }

}
