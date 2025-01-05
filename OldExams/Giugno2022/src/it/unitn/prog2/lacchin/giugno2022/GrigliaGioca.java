package it.unitn.prog2.lacchin.giugno2022;

import it.unitn.prog2.lacchin.giugno2022.bandiere.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.Iterator;

public class GrigliaGioca extends GridPane {

    //potevo anche mettere static l'array di stati ma così è più carino
    GiocaStage app;
    TextFieldNonEditable [] testi;
    Bandiera [] bandiere;
    public GrigliaGioca (GiocaStage app) {
        super();
        this.app = app;
        riempiPrimaColonna();
        riempiSecondaColonna();
    }

    public void riempiPrimaColonna () {
        Iterator<Stato> x = app.estratti.iterator();
        bandiere = new Bandiera[3];
        for (int i = 0; i  < app.estratti.size(); i++) {
            bandiere [i] = x.next().bandiera;
            this.add(bandiere[i],0,i);
        }
    }

    public void riempiSecondaColonna () {
        Collections.sort(app.estratti,new OrdPerCapitale());
        testi = new TextFieldNonEditable[3];
        for (int i = 0; i  < app.estratti.size(); i++) {
            TextFieldNonEditable text = new TextFieldNonEditable(app);
            testi[i] = text;
            this.add(text,1,i);

        }
    }



}
