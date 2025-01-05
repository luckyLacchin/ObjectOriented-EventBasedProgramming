package it.unitn.prog2.lacchin.picco_settembre2018;

import java.util.Objects;

public class Card implements Comparable{

    String seme;
    String valore;
    int n;

    public Card (String seme, String valore) {
        this.valore = valore;
        this.seme = seme;
        n = Integer.parseInt(this.valore);
    }

    @Override
    public String toString () {
        return valore + "-" + seme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return valore.equals(((Card)o).valore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valore);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Card)) System.exit(1);
        if (n < ((Card) o).n) return -1;
        else if (n == ((Card) o).n) {
            return seme.compareTo(((Card)o).seme);
        }
            return 1;
    }
}
