package it.unitn.prog2.deck;

import java.util.Objects;

public class Card {
    private Deck.Seeds seed;
    private Deck.Values value;
    public Card (Deck.Seeds seed, Deck.Values value) {
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
        return ""+this.seed+""+this.value;
    }
}
