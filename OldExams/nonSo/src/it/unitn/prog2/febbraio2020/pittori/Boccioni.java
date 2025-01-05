package it.unitn.prog2.febbraio2020.pittori;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boccioni extends Pittore{

    public Boccioni () {
        super();
        nome = "Umberto";
        cognome = "Boccioni";
        image = new Image("it/unitn/prog2/febbraio2020/img/Addii.jpg",130,130,true,true);
        iw = new ImageView(image);
    }
}
