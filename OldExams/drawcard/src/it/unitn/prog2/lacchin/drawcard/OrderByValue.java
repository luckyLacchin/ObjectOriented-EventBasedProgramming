package it.unitn.prog2.lacchin.drawcard;

import java.util.Comparator;

public class OrderByValue implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        Card c1 = (Card) o1;
        Card c2 = (Card) o2;
        if (c1.equals(c2)) return 0;
        if (c1.getValue().getValues()==c2.getValue().getValues()) {
            return 0;
            /*if (c1.getSeed().getValueSeed() < c2.getSeed().getValueSeed())
                return -1;
            else
                return 1;

             */
        }
        if (c1.getValue().getValues()<c2.getValue().getValues())
            return -1;
        if (c1.getValue().getValues()>c2.getValue().getValues())
            return +1;
        return 0;
    }
}
