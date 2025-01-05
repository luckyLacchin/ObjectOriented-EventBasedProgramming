package it.unitn.prog2.febbraio2020.scrittori;

import it.unitn.prog2.febbraio2020.Artista;

import java.util.Objects;

public class Scrittore extends Artista {

    public Scrittore () {
        super();
    }

    public String getIncipit() {
        return incipit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Scrittore scrittore = (Scrittore) o;
        return Objects.equals(incipit, scrittore.incipit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), incipit);
    }
}
