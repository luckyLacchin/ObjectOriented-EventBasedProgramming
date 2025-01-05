package it.unitn.prog2.lacchin.luglio2022.Appartamenti;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SaporeDiSale extends Appartamento {
    public SaporeDiSale () {
        nome = "SaporeDiSale";
        prezzo = 80;
        valutazione = 7.9;
        persone = 8;
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/SaporeDiSale.jpg",500,500,true,true);
        iw = new ImageView(image);
    }
}
