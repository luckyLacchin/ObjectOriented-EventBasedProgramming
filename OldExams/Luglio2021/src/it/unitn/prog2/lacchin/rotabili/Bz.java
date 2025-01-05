package it.unitn.prog2.lacchin.rotabili;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bz extends Rotabile {

    public static int inizioMarcatura = 400;
    public Bz () {
        super ();
        Image image = new Image ("it/unitn/prog2/lacchin/rotabili/Bz.bmp",200,20,true,true);
        this.setImage(image);

    }
    @Override
    public String toString () {
        return "Bz";
    }
}
