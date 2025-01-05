package it.unitn.prog2.lacchin.drawcard;

import java.util.Objects;

public class Card implements Comparable{
    private Deck.Seeds seed;
    private Deck.Values value;
    public Card(Deck.Seeds seed, Deck.Values value) {
        this.seed = seed;
        this.value = value;
    }

    public Deck.Seeds getSeed() {
        return seed;
    }

    public Deck.Values getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return seed == card.seed && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seed, value);
    }
    @Override
    public String toString () {
        return "["+this.value+" "+this.seed+"]";
    }

    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) return 0;
        if (this.seed.getValueSeed()==((Card) o).seed.getValueSeed()) {
            if (this.value.getValues() < ((Card) o).value.getValues())
                return -1;
            else
                return 1;
        }
        if (this.seed.getValueSeed() < ((Card) o).seed.getValueSeed())
            return -1;
        if (this.seed.getValueSeed() > ((Card) o).seed.getValueSeed())
            return +1;

        return 0;
    }
}
