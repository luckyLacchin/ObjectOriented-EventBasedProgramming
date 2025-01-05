package it.unitn.prog2.lacchin.luglio2022.Pensioni;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gruber extends Pensione {

    public Gruber () {
        nome = "Gruber";
        prezzo = 75;
        valutazione = 9.3;
        extra = "PENSIONE_COMPLETA";
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/Gruber.jpg",500,500,true,true);
        iw = new ImageView(image);
    }
}
