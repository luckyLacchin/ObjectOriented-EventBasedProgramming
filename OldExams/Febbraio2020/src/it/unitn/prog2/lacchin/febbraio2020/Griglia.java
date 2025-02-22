package it.unitn.prog2.lacchin.febbraio2020;

import it.unitn.prog2.lacchin.febbraio2020.pittori.*;
import it.unitn.prog2.lacchin.febbraio2020.scrittori.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Griglia extends GridPane {


    ArrayList <Artista> artisti = null;
    ArrayList<Artista> estratti = null;
    ArrayList <Cella> selezionati = null;
    public Griglia () {
        super();
        artisti = new ArrayList<>();
        estratti = new ArrayList<>();
        selezionati = new ArrayList<>();
        riempiArtisti();
        riempiGriglia();
        //System.out.println(estratti);
        primaColonna();
        secondaColonna();
        terzaColonna();
    }

    public void riempiArtisti () {

        this.artisti.add(new Manzoni());
        this.artisti.add(new Alighieri());
        this.artisti.add(new Pavese());
        this.artisti.add(new Caravaggio());
        this.artisti.add(new Michelangelo());
        this.artisti.add(new Boccioni());
        Collections.shuffle(artisti);
    }

    public void riempiGriglia () {
        ArrayList <Artista> copiaArtisti = ((ArrayList<Artista>) artisti.clone());
        while (estratti.size()<=2){
            Artista temp = copiaArtisti.get((int)(Math.random()*(copiaArtisti.size()-1)));
            estratti.add(temp);
            copiaArtisti.remove(temp);
        }
    }



    public void primaColonna () {
        Artista casuale = null;
        int index = 0;
        ArrayList <Artista> copiaEstratti = ((ArrayList<Artista>) estratti.clone());
        while (copiaEstratti.size()>=1) {
            Cella c;

            casuale = copiaEstratti.get((int)(Math.random()*(copiaEstratti.size()-1)));
            copiaEstratti.remove(casuale);
            if(casuale instanceof Pittore) {

                c = new Cella(((Pittore)casuale).getIw(),0,this);
                this.add(c,0,index);
            }
            else {
                c = new Cella(((Scrittore)casuale).getIncipit(),0,this);
                //System.out.println(casuale);
                this.add(c,0,index);
            }
            System.out.println("c = " + c);
            //System.out.println("getChildren = " + this.getChildren());
            ++index;
        }

    }



    public void secondaColonna () {
        Artista casuale = null;
        int index = 0;
        ArrayList <Artista> copiaEstratti = ((ArrayList<Artista>) estratti.clone());
        Collections.sort(copiaEstratti);
        while (copiaEstratti.size() >= 1) {
            casuale = copiaEstratti.get(0);
            copiaEstratti.remove(casuale);
            this.add(new Cella(casuale.cognome,1,this),1,index);
            ++index;
        }
    }

    public void terzaColonna () {
        Artista casuale = null;
        int index = 0;
        ArrayList <Artista> copiaEstratti = ((ArrayList<Artista>) estratti.clone());
        while (copiaEstratti.size() >= 1) {
            casuale = copiaEstratti.get((int)(Math.random()*(copiaEstratti.size()-1)));
            copiaEstratti.remove(casuale);
            this.add(new Cella(casuale.nome,2,this),2,index);
            ++index;
        }
    }

    public boolean controlAnswer () {
        Artista answer = new Artista();
        boolean corretta = true;
        for (Cella c : selezionati) {
            for (Cella s:selezionati) {
                if(c != s && c.equals(s)) {
                    System.out.println("Selezionare una casella per colonna!");
                    corretta = false;
                }
            }
        }
        if(corretta) {
            corretta = false;
            for(Cella c:selezionati) {
                if(c.column==1) {
                    answer.cognome = c.testo.getText();
                }
                else if (c.column == 2) {
                    answer.nome = c.testo.getText();
                }
            }
            System.out.println(answer.nome + " " + answer.cognome);
            Iterator<Artista> x = estratti.iterator();
            while (x.hasNext()) {
                if(answer.equals(x.next())) {
                    corretta = true;
                }
            }
        }
        if(corretta) {
            corretta = false;
            for(Cella c : selezionati) {
                if(c.column == 0) {
                    if(c.iw != null) { // vuol dire che ho selezionato un'immagine
                        Pittore as = new Pittore();
                        answer.iw = c.iw;
                        as.iw = answer.iw;
                        as.nome = answer.nome;
                        as.cognome = answer.cognome;
                        Iterator <Artista> x = estratti.iterator();
                        while (x.hasNext()) {
                            Artista temp = x.next();
                            if(temp instanceof Pittore) {
                                if(temp.equals(as))
                                    corretta = true;
                            }
                        }
                    }
                    else {
                        answer.incipit = c.testo.getText();
                        Iterator <Artista> x = estratti.iterator();
                        Scrittore as = new Scrittore();
                        as.nome = answer.nome;
                        as.cognome = answer.cognome;
                        as.incipit = answer.incipit;
                        System.out.println(answer.nome + " " + answer.cognome+ " " + answer.incipit);
                        while (x.hasNext()) {
                            Artista temp = x.next();
                            if(temp instanceof Scrittore) {
                                if (temp.equals(as)) {
                                    corretta = true;
                                }
                            }

                        }
                    }
                }
            }
        }
        //adesso guardiamo la prima casella!
        return corretta;
    }
}