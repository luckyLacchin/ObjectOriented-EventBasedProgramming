package it.unitn.prog2.lacchin.agosto2020;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Griglia extends GridPane {

    ArrayList <Cella> lista = null;
    ArrayList<Cella> coperte = null;
    ArrayList<Cella> scoperte = null;
    ArrayList<Cella> congelate = null;
    Stage app = null;
    Memory main = null;

    public Griglia (Stage app, Memory main) {
        super();
        this.main = main;
        lista = new ArrayList<>();
        coperte = new ArrayList<>();
        scoperte = new ArrayList<>();
        congelate = new ArrayList<>();
        this.app = app;

    }
    public void ripristino () {
        Iterator<Cella> x = this.lista.iterator();
        while (x.hasNext()) {
            Cella c = x.next();

            c.foreground.setFill(Cella.COLOR);
            c.getChildren().clear();
            if (!c.text.getText().equals("K.O.")) {
                if(this.congelate.contains(c))
                    c.addEventHandler(MouseEvent.MOUSE_CLICKED,c.mouseHandler);
                c.background.setFill(Cella.BORDO[0]);
                c.getChildren().addAll(c.celletta, c.background, c.figura, c.text, c.foreground);
            }
            else {
                //c.addEventHandler(MouseEvent.MOUSE_CLICKED,c.mouseHandler);
                c.getChildren().addAll(c.celletta, c.background, c.text, c.foreground);
            }
        }


    }

    public Griglia casuale () {

        Collections.shuffle(lista);
        Griglia newGriglia = new Griglia(this.app,this.main);
        ArrayList <Cella> cloneLista = ((ArrayList<Cella>) this.lista.clone());
        newGriglia.lista = cloneLista;
        newGriglia.coperte = cloneLista;
        //this.getChildren().clear();

        System.out.println(lista);
        Iterator <Cella> x = lista.iterator();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newGriglia.add(x.next(),j,i);
            }
        }
        //perché non mi mette la griglia in modo casuale?!?!
        return newGriglia;


    }
    public void populate () {
        int index = 0;
        int i = 0;
        int j = 0;
        while (index < 24) {
            //System.out.println("index = " + index);
            Cella cella = new Cella(index,this);
            this.add(cella, j++, i);
            if(j == 5) {
                ++i;
                j = 0;

            }
            Cella cella2 = new Cella(index,this);

            this.add(cella2, j++, i);
            if(j == 5) {
                ++i;
                j=0;

            }
            coperte.add(cella);
            coperte.add(cella2);
            lista.add(cella);
            lista.add(cella2);
            index += 2;
        }
        Cella ultima = new Cella(24,this);
        //System.out.println("SONO FUORI");
        this.add(ultima,4,4);
        coperte.add(ultima);
        lista.add(ultima);
    }

}
