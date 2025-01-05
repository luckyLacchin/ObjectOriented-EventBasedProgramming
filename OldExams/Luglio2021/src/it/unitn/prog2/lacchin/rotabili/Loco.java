package it.unitn.prog2.lacchin.rotabili;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Loco extends Rotabile {

    public static int inizioMarcatura = 1;
    public Loco () {
        super ();
        Image image = new Image ("it/unitn/prog2/lacchin/rotabili/Loco.bmp",200,20,true,true);
        this.setImage(image);
        inizioMarcatura = 1;
    }
    @Override
    public String toString () {
        return "Loco";
    }
}
