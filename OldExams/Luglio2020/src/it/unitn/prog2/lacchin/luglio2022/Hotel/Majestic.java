package it.unitn.prog2.lacchin.luglio2022.Hotel;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Majestic extends Albergo {

    public Majestic () {
        nome = "Majestic";
        prezzo = 65;
        valutazione = 8.8;
        stelle = 3;
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/Majestic.jpg",500,500,true,true);
        iw = new ImageView(image);
        stelline = new ArrayList<>();
        for (int i = 0; i < this.stelle; i++) {
            stelline.add(new Stella());
        }
    }
}
