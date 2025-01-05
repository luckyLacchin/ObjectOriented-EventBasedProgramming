package it.unitn.prog2.lacchin.luglio2022.Hotel;

import it.unitn.prog2.lacchin.luglio2022.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class Artemide extends Albergo {


    public Artemide () {
        super();
        nome = "Artemide";
        prezzo = 60;
        valutazione = 8.5;
        stelle = 4; //dopo per fare le stelle mi sa che devo fare una classe stella che estende polygon e fare dopo un array di
        //stelle di dim = int stelle
        image = new Image("it/unitn/prog2/lacchin/luglio2022/img/Artemide.jpg",500,500,true,true);
        iw = new ImageView(image);
        stelline = new ArrayList<>();
        for (int i = 0; i < this.stelle; i++) {
            stelline.add(new Stella());
        }

    }
}
