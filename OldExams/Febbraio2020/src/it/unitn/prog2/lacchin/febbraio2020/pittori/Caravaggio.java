package it.unitn.prog2.lacchin.febbraio2020.pittori;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Caravaggio extends Pittore{

    public Caravaggio() {
        super();
        nome = "Michelangelo";
        cognome = "Merisi";
        image = new Image("it/unitn/prog2/lacchin/febbraio2020/img/Fanciullo.jpg",130,130,true,true);
        iw = new ImageView(image);

    }
}
