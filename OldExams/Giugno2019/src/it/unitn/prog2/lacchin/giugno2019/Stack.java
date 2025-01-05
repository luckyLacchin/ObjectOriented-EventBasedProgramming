package it.unitn.prog2.lacchin.giugno2019;

import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Stack extends VBox {


    int n;
    ArrayList<Tile> lista;
    ArrayList<Tile> equivalenti;
    Gioco main;
    public Stack (int N, Gioco main) {
        super();
        this.n  = N;
        this.main = main;
        lista = new ArrayList<>();
        equivalenti = new ArrayList<>();
        riempiStack();
    }

    public void riempiStack () {
        Tile random;
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                random = new SquareTile(this);
            }
            else {
                random = new CircleTile(this);
            }
            lista.add(random);
            if (!controllo(random)) {
                lista.remove(random);
            }
        }
        Collections.shuffle(lista);
        this.getChildren().addAll(lista);
    }

    /**
     * Funzione che serve per vedere se nello stack sono già presenti Tile equivalenti.
     * @return
     */
    public boolean controllo (Tile random) {

        boolean res = true;
        for (Tile tile : lista) {
            if (random.equivalenti(tile) && !random.equals(tile))
                res = false;
        }
        return res;
    }

    public Tile randomTile () {

        Tile creato;
        switch ((int) (Math.random() * 2)) {
            case 0 -> creato = new CircleTile(this);
            case 1 -> creato = new SquareTile(this);
            default -> {
                creato = null;
                System.out.println("Qualcosa è andato storto! ");
            }
        }
        return creato;
    }

    public void riordina () {
        Collections.sort (lista);
        this.getChildren().clear();
        this.getChildren().addAll(lista);
    }

    public Tile cercaEquivalente (Tile source) {

        for (Tile tile : lista) {
            if (source.equivalenti(tile) && !source.equals(tile)) {
                return tile;
            }
        }
        return null;
    }
}
