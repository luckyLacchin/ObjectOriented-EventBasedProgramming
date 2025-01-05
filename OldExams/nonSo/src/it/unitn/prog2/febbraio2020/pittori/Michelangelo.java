package it.unitn.prog2.febbraio2020.pittori;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Michelangelo extends Pittore{

    public Michelangelo () {
        super();
        nome = "Michelangelo";
        cognome = "Buonarotti";
        image = new Image("it/unitn/prog2/febbraio2020/img/Adamo.jpg",130,130,true,true);
        iw = new ImageView(image);
    }
}
