package it.unitn.prog2.lacchin.luglio2022.Appartamenti;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PietraBianca extends Appartamento {
    public PietraBianca () {
        nome = "PietraBianca";
        prezzo = 40;
        valutazione = 9.5;
        persone = 4;
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/PietraBianca.jpg",500,500,true,true);
        iw = new ImageView(image);
    }
}
