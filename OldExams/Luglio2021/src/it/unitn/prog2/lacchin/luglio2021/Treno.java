package it.unitn.prog2.lacchin.luglio2021;

import it.unitn.prog2.lacchin.rotabili.*;
import javafx.css.Style;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Treno extends HBox {

    ArrayList<Rotabile> rotabili = null;
    public Nome nome = null;
    public Treno () {
        super ();
    }
    public Treno (Nome nome) {
        super();
        this.nome = nome;
    }
    public Treno (String n) {
        super();
        this.nome = new Nome(n);
    }
    public Treno (ArrayList<Rotabile> rotabili, Nome nome) {
        Iterator<Rotabile> i = rotabili.iterator();
        while (i.hasNext()) {
            this.getChildren().add(i.next());
        }
        this.nome = nome;
        this.rotabili = rotabili;
    }
    public Treno (ArrayList<Rotabile> rotabili) {
        Iterator<Rotabile> i = rotabili.iterator();
        while (i.hasNext()) {
            this.getChildren().add(i.next());
        }
        this.rotabili = rotabili;
    }
    public Treno (ArrayList<Rotabile> rotabili, String nome) {
        Iterator<Rotabile> i = rotabili.iterator();
        while (i.hasNext()) {
            this.getChildren().add(i.next());
        }
        this.nome = new Nome (nome);
        this.rotabili = rotabili;
    }
    public void costruisci (Treno treno, ArrayList<Rotabile> rotabili, String nome) {
        Iterator<Rotabile> i = rotabili.iterator();
        while (i.hasNext()) {
            treno.getChildren().add(i.next());
        }
        treno.nome = new Nome (nome);
        this.rotabili = rotabili;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treno treno = (Treno) o;
        return Objects.equals(rotabili, treno.rotabili) && Objects.equals(nome, treno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rotabili, nome);
    }

    public ArrayList<Rotabile> getRotabili() {
        return rotabili;
    }

    public Nome getNome() {
        return nome;
    }

    public void stampaTreno () {

        System.out.print(""+this.getNome().getNome()+": ");
        for (Rotabile r : rotabili) {
            Class classe = r.getClass();
            //ystem.out.println(classe);
            switch (classe.getName()) {
                case "it.unitn.prog2.lacchin.rotabili.Az":
                    System.out.print(r + "-"+(((Az)r).inizioMarcatura++)+": ");
                    break;
                case "it.unitn.prog2.lacchin.rotabili.Bz":
                    System.out.print(r + "-"+(((Bz)r).inizioMarcatura++)+": ");
                    break;
                case "it.unitn.prog2.lacchin.rotabili.Dz":
                    System.out.print(r + "-"+(((Dz)r).inizioMarcatura++)+": ");
                    break;
                case "it.unitn.prog2.lacchin.rotabili.Loco":
                    System.out.print(r + "-"+(((Loco)r).inizioMarcatura++)+": ");
                    break;
                case "it.unitn.prog2.lacchin.rotabili.Wrz":
                    System.out.print(r + "-"+(((Wrz)r).inizioMarcatura++)+": ");
                    break;
                default:
                    System.out.println("E' stata inserita una classe non valida");
            }
        }
        System.out.println();
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }
}
