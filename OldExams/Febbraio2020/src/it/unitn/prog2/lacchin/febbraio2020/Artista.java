package it.unitn.prog2.lacchin.febbraio2020;

import javafx.scene.image.ImageView;

import java.util.Objects;

public class Artista implements Comparable{

    public String nome = null;
    public String cognome = null;
    public ImageView iw = null;
    public String incipit = null;

    public Artista () {

    }

    @Override
    public int compareTo(Object o){
        if (!(o instanceof Artista))
            System.exit(1);
        return this.cognome.compareTo(((Artista)o).cognome);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Artista)) return false;
        Artista artista = (Artista) o;
        return nome.equals(artista.nome) && cognome.equals(artista.cognome);//Objects.equals(nome, artista.nome) && Objects.equals(cognome, artista.cognome);
    }
    /*
    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome);
    }

     */
}
