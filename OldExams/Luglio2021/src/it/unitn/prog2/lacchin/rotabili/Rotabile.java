package it.unitn.prog2.lacchin.rotabili;

import javafx.scene.image.ImageView;

public class Rotabile extends ImageView {


    public Rotabile () {
        super();
    }

    @Override
    public String toString () {
        String res;
        Class classe = this.getClass();
        switch (classe.getName()) {
            case "Az":
                res =  ((Az)this).toString();
                break;
            case "Bz":
                res =  ((Bz)this).toString();
                break;
            case "Dz":
                res =  ((Dz)this).toString();
                break;
            case "Loco":
                res = ((Loco)this).toString();
                break;
            case "Wrz":
                res = ((Wrz)this).toString();
                break;
            default:
                res =  ("E' stata inserita una classe non valida");
                break;
        }
        return res;
    }
}
