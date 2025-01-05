package it.unitn.prog2.lacchin.rotabili;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Az extends Rotabile {

    public static int inizioMarcatura = 200;
    public Az () {
        super ();
        Image image = new Image ("it/unitn/prog2/lacchin/rotabili/Az.bmp",200,20,true,true);
        this.setImage(image);

    }

    @Override
    public String toString () {
        return "Az";
    }

}
