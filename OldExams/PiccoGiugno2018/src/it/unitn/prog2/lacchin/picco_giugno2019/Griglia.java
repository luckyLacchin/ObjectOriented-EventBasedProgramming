package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

public class Griglia extends GridPane {

    ArrayList <Cella> celle;
    Cella [] [] matrice;
    luckyClick lucky;
    ArrayList <Bomba> bombe;

    public Griglia (luckyClick lucky) {
        super();
        this.lucky = lucky;
        celle = new ArrayList<>();
        matrice = new Cella[10][10];
        bombe = new ArrayList<>();
        riempiGriglia();
    }

    public void riempiGriglia () {

        int index = 0;
        for (int i = 0; i  < 10; i++) {
            celle.add(new Moltiplicatore(this));
        }

        for (int i = 0; i < 10; i++) {
            celle.add(new Divisore(this));
        }

        for (int i = 0; i < 5; i++) {
            celle.add(new Bomba(this));
        }

        for (int i = 0; i < 75; i++) {
            celle.add(new Base(this));
        }

        Collections.shuffle(celle);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                celle.get(index).setI(i);
                celle.get(index).setJ(j);
                matrice[i][j] = celle.get(index++);
                this.add(matrice[i][j],j,i);
            }
        }
    }
}


//POTEVO ANCHE TOGLIERE IL COSTRUTTORE DI CELLE CON I E J!