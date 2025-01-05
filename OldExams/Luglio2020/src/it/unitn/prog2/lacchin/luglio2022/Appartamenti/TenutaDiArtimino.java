package it.unitn.prog2.lacchin.luglio2022.Appartamenti;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TenutaDiArtimino extends Appartamento {
    public TenutaDiArtimino () {
        nome = "TenutaDiArtimino";
        prezzo = 60;
        valutazione = 5.5;
        persone = 6;
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/TenutaDiArtimino.jpg",500,500,true,true);
        iw = new ImageView(image);
    }
}
