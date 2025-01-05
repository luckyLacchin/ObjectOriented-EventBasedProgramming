package it.unitn.prog2.lacchin.drawcard;

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
        };
        public int getValueSeed () {
            int res = -1;
            switch (this) {
                case C:
                    res = 0;
                    break;
                case Q:
                    res =  1;
                    break;
                case F:
                    res = 2;
                    break;
                case P:
                    res = 3;
                    break;
            }
            return res;
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
        },J,Q,K;
        public int getValues () {
            int res = -1;
            switch (this) {
                case A:
                    res = 1;
                    break;
                case _2:
                    res =  2;
                    break;
                case _3:
                    res = 3;
                    break;
                case _4:
                    res = 4;
                    break;
                case _5:
                    res = 5;
                    break;
                case _6:
                    res =  6;
                    break;
                case _7:
                    res = 7;
                    break;
                case _8:
                    res = 9;
                    break;
                case _9:
                    res =  9;
                    break;
                case _10:
                    res = 10;
                    break;
                case J:
                    res = 11;
                    break;
                case Q:
                    res =  12;
                    break;
                case K:
                    res = 13;
                    break;
            }
            return res;
        }



    }
    public Deck() {

        super();
        for (Seeds seed : Seeds.values()) {
            for (Values value: Values.values()) {
                Card temp = new Card (seed,value);
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

}
