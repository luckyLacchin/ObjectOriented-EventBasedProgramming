package it.unitn.prog2;
import java.util.*;

public class CardDeck extends ArrayList <Card>{
    public enum Seeds {
        C {
            @Override
            public String toString () {
                return "C";
        }
    },
        Q {
            @Override
            public String toString () {
                return "Q";
            }

        } //devo andare avanti a fare i toString!
        ,F,P};
    public enum Values {A,_2,_3,_4,_5,_6,_7,_8,_9,_10,_J,_Q,_K};
    public CardDeck() {
    }
    public void makeDeck () throws NullPointerException{
        for (Seeds c : Seeds.values()) {
            for (Values s : Values.values()) {
                this.add(new Card(s, c));
                this.add(new Card(s, c));

            }
        }


    }
    public void shuffle () {

    }


}
