package it.unitn.prog2.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck extends ArrayList<Card> {

    public enum Seeds {
        C {
            @Override
            public String toString() {

                return "C";
            }
        },
        Q {
            @Override
            public String toString() {

                return "Q";
            }
        },
        F {
            @Override
            public String toString() {

                return "F";
            }
        },
        P {
            @Override
            public String toString() {

                return "P";
            }
        }
    };
    public enum Values {A
            {
                @Override
                public String toString() {

                    return "A";
                }
            },
        _2
                {
                    @Override
                    public String toString() {

                        return "2";
                    }
                },
        _3{
            @Override
            public String toString() {

                return "3";
            }
        },
        _4{
            @Override
            public String toString() {

                return "4";
            }
        },
        _5{
            @Override
            public String toString() {

                return "5";
            }
        },
        _6{
            @Override
            public String toString() {

                return "6";
            }
        },
        _7{
            @Override
            public String toString() {

                return "7";
            }
        },
        _8{
            @Override
            public String toString() {

                return "8";
            }
        },
        _9{
            @Override
            public String toString() {

                return "9";
            }
        },
        _10{
            @Override
            public String toString() {

                return "10";
            }
        },J,Q,K}
    public Deck () {
        super();
    }
    public void setDeck () {
        for (Seeds seed : Seeds.values()) {
            for (Values value: Values.values()) {
                Card temp = new Card (seed,value);
                this.add(temp);
                this.add(temp);
            }
        }

    }

    public void shuffleDeck () {
        Collections.shuffle(this);
    }
    public void printDeck () {
        for (Card temp: this) {
            System.out.println(temp);
        }
    }
    public void printDeckN (int n) {
        Iterator <Card> iter = this.iterator();
        while (n != 0) {
            System.out.println (iter.next());
            n -= 1;
        }
    }
    public boolean eDoppia (int n) {
        boolean res = false;
        for (int i = 0; i < n; i++) {
            Card temp = this.get(i);
            for (int j = i+1; j < n; j++) {
                if (temp.equals(this.get(j))) {
                    res = true;
                }
            }
        }
        return res;
    }
    public Card eDoppiaCard (int n) {
        Card res = null;
        for (int i = 0; i < n; i++) {
            Card temp = this.get(i);
            for (int j = i+1; j < n; j++) {
                if (temp.equals(this.get(j))) {
                    res = this.get(i);
                }
            }
        }
        return res;
    }
}
