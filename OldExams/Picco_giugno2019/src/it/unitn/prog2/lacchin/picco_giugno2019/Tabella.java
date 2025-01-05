package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Tabella extends VBox {

    ArrayList<Persona> lista;
    public Tabella (ArrayList<Persona> lista) {
        super();
        this.lista = lista;
        this.setAlignment(Pos.CENTER_RIGHT);
        riempiTabella();
    }

    public void riempiTabella () {
        Text tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10;
        for (Persona persona : lista) {
            persona.calcoloTariffa();
            HBox hb = new HBox();
            tx1 = new Text(persona.cognome+ " ");
            tx2 = new Text(persona.nome+ " ");
            tx3 = new Text(persona.codiceFiscale+ " ");
            tx4 = new Text(persona.annoDiNascita+ " ");
            tx1.setFont(new Font(12));
            tx2.setFont(new Font(12));
            tx3.setFont(new Font(12));
            tx4.setFont(new Font(12));
            hb.getChildren().addAll(tx1,tx2,tx3,tx4);
            if (persona.getClass().getName().equals("it.unitn.prog2.lacchin.picco_giugno2019.StudenteSolo")) {
                tx5 = new Text(((StudenteSolo)persona).uni + " ");
                tx6 = new Text (((StudenteSolo)persona).corso+ " ");
                tx7 = new Text("|"+ " ");
                tx8 = new Text("tariffa : " + persona.tariffa+ " ");
                tx5.setFont(new Font(12));
                tx6.setFont(new Font(12));
                tx7.setFont(new Font(12));
                tx8.setFont(new Font(12));
                hb.getChildren().addAll(tx5,tx6,tx7,tx8);
            }
            else if (persona.getClass().getName().equals("it.unitn.prog2.lacchin.picco_giugno2019.AtletaStudente")) {
                tx5 = new Text(((AtletaStudente)persona).uni+ " ");
                tx6 = new Text (((AtletaStudente)persona).corso+ " ");
                tx7 = new Text(((AtletaStudente)persona).disciplina+ " ");
                tx8 = new Text(((AtletaStudente)persona).rilevanza+ " ");
                tx9 = new Text("|"+ " ");
                tx10 = new Text("tariffa : " + persona.tariffa+ " ");
                tx5.setFont(new Font(12));
                tx6.setFont(new Font(12));
                tx7.setFont(new Font(12));
                tx8.setFont(new Font(12));
                tx9.setFont(new Font(12));
                tx10.setFont(new Font(12));
                hb.getChildren().addAll(tx5,tx6,tx7,tx8,tx9,tx10);
            }
            else if (persona.getClass().getName().equals("it.unitn.prog2.lacchin.picco_giugno2019.AtletaSolo")) {
                tx5 = new Text(((AtletaSolo)persona).disciplina+ " ");
                tx6 = new Text(((AtletaSolo)persona).rilevanza+ " ");
                tx7 = new Text("|"+ " ");
                tx8 = new Text("tariffa : " + persona.tariffa+ " ");
                tx5.setFont(new Font(12));
                tx6.setFont(new Font(12));
                tx7.setFont(new Font(12));
                tx8.setFont(new Font(12));
                hb.getChildren().addAll(tx5,tx6,tx7,tx8);
            }
            else if (persona.getClass().getName().equals("it.unitn.prog2.lacchin.picco_giugno2019.Persona")) {
                tx5 = new Text("|"+ " ");
                tx6 = new Text("tariffa : " + persona.tariffa+ " ");
                tx5.setFont(new Font(12));
                tx6.setFont(new Font(12));
                hb.getChildren().addAll(tx5,tx6);
            }
            this.getChildren().add(hb);
        }
    }
}
