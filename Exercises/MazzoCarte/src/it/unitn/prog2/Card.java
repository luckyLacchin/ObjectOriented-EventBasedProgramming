package it.unitn.prog2;

public class Card {
    CardDeck.Values value;
    CardDeck.Seeds seed;
    public Card (CardDeck.Values value, CardDeck.Seeds seed) {
        this.value = value;
        this.seed = seed;
    }

    public CardDeck.Seeds getSeed() {
        return seed;
    }

    public CardDeck.Values getValue() {
        return value;
    }

    public CardDeck.Seeds setSeed(CardDeck.Seeds seed) {
        return this.seed = seed;
    }

    public void setValue(CardDeck.Values value) {
        this.value = value;
    }
    @Override
    public String toString () {
        System.out.println();
        return (this.seed+";"+ this.value);
    }
}
