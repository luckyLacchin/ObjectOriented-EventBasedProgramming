package it.unitn.prog2.lacchin.luglio2022;


import it.unitn.prog2.lacchin.luglio2022.Hotel.Stella;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public abstract class Albergo extends Alloggio{
    public int stelle;
    public ArrayList<Stella> stelline = null;
    public Albergo () {
        super();
    }
}
