package it.unitn.prog2.febbraio2020.pittori;

import it.unitn.prog2.febbraio2020.*;
import it.unitn.prog2.febbraio2020.Artista;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Pittore extends Artista {


    Image image = null;
    public Pittore () {
        super();

    }

    public ImageView getIw() {
        return iw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pittore pittore = (Pittore) o;
        return Objects.equals(iw, pittore.iw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), iw);
    }


}
