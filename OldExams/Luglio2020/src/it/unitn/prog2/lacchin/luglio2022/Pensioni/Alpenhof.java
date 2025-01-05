package it.unitn.prog2.lacchin.luglio2022.Pensioni;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Alpenhof extends Pensione {

    public Alpenhof () {
        nome = "Alpenhof";
        prezzo = 60;
        valutazione = 8.5;
        extra = "MEZZA_PENSIONE";
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/Alpenhof.jpg",500,500,true,true);
        iw = new ImageView(image);
    }
}
