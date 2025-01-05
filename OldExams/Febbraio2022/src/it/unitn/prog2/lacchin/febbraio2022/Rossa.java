package it.unitn.prog2.lacchin.febbraio2022;

import javafx.scene.paint.Color;

public class Rossa extends Figura{

    public Rossa () {
        this.getFigura().setFill(Color.RED);
        switch ((int) (Math.random() * 3)) {
            case 0 -> this.lettera = "A";
            case 1 -> this.lettera = "B";
            case 2 -> this.lettera = "C";
            default -> System.out.println("E' stato inserito un valore non valido.");
        }
    }
}
