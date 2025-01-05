package it.unitn.prog2.lacchin.giugno2022;

import it.unitn.prog2.lacchin.giugno2022.bandiere.*;

import java.util.Comparator;

public class Stato{

    String nome;
    String capitale;
    Bandiera bandiera;

    public Stato (String nome, String capitale, Bandiera bandiera) {
        this.nome = nome;
        this.capitale = capitale;
        this.bandiera = bandiera;


    }

    public Stato (String capitale, Bandiera bandiera) {
        this.capitale = capitale;
        this.bandiera = bandiera;
    }


}
