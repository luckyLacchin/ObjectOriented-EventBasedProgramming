package it.unitn.prog2.lacchin.settembre2021;

import javafx.scene.image.Image;

public class Accessorio extends Prodotto{

    boolean luce;

    Accessorio(String nome, Image image, int prezzo, String descrizione, boolean luce) {
        super(nome, image, prezzo, descrizione);
        this.luce = luce;
    }
}
