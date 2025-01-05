package it.unitn.prog2.lacchin.picco_settembre2018;

import java.util.ArrayList;
import java.util.Collections;

public class Mano extends ArrayList <Card> {


    ArrayList <Card> deck;
    String nome;
    public Mano (String nome, ArrayList <Card> deck) {
        super();
        this.deck = deck;
        this.nome = nome;
        creaMano ();
        Collections.sort(this);
    }

    public void creaMano () {

        ArrayList <Card> cloneDeck = (ArrayList<Card>) deck.clone();

        for (int i = 0; i < 4; i++) {
            Card card = cloneDeck.get(i);
            this.add(card);
            deck.remove(card);
        }
    }
    @Override
    public String toString () {

        String res = nome + ": ";
        for (Card temp : this) {
            res += temp.toString() +  ", ";
        }
        return res;
    }


}
