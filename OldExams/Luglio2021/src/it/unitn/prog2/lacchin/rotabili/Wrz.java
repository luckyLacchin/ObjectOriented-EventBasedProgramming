package it.unitn.prog2.lacchin.rotabili;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wrz extends Rotabile {

    public static int inizioMarcatura = 300;
    public Wrz () {
        super ();
        Image image = new Image ("it/unitn/prog2/lacchin/rotabili/WRz.bmp",200,20,true,true);
        this.setImage(image);

    }
    @Override
    public String toString () {
        return "Wrz";
    }
}
