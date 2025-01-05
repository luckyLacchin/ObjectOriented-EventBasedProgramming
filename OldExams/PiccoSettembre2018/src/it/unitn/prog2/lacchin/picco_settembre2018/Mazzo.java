package it.unitn.prog2.lacchin.picco_settembre2018;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo extends ArrayList<Card> {

    String [] semi = {"C", "Q", "F", "P"};
    String [] valore = {"1","2","3","4"};
    Card blackJack;

    public Mazzo () {
        creaMazzo ();
        blackJack =  new Card("J","0");
        this.add(blackJack);

    }

    public void creaMazzo () {

        for (String s : valore) {
            for (String z : semi) {
                this.add(new Card(z,s));
            }
        }

    }

    public void mescola () {
        Collections.shuffle(this);
    }

    public void ordina () {

        Collections.sort(this);

    }

    @Override
    public String toString () {
        String res = "";
        for (Object temp : this) {
            Card carta = (Card) temp;
            res += carta.toString() +  ", ";
        }
        return res;
    }


}
