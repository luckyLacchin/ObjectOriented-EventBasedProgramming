package it.unitn.prog2.lacchin.rotabili;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dz extends Rotabile {

    public static int inizioMarcatura = 100;
    public Dz () {
        super ();
        Image image = new Image ("it/unitn/prog2/lacchin/rotabili/Dz.bmp",200,20,true,true);
        this.setImage(image);


    }
    @Override
    public String toString () {
        return "Dz";
    }
}
