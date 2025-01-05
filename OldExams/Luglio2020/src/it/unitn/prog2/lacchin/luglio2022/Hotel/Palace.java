package it.unitn.prog2.lacchin.luglio2022.Hotel;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Palace extends Albergo {

    public Palace () {
        super();
        nome = "Palace";
        prezzo = 200;
        valutazione = 8.3;
        stelle = 5;
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/Palace.jpg",500,500,true,true);
        iw = new ImageView(image);
        stelline = new ArrayList<>();
        for (int i = 0; i < this.stelle; i++) {
            stelline.add(new Stella());
        }
    }
}
