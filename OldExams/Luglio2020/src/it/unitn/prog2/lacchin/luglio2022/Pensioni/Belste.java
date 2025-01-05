package it.unitn.prog2.lacchin.luglio2022.Pensioni;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Belste extends Pensione {

    public Belste () {
        nome = "Belste";
        prezzo = 35;
        valutazione = 6.2;
        extra = "SOLO_COLAZIONE";
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/Belste.jpg",500,500,true,true);
        iw = new ImageView(image);
    }
}
