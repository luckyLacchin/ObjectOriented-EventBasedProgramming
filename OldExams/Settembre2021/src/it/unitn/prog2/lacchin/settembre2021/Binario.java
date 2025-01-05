package it.unitn.prog2.lacchin.settembre2021;

import javafx.scene.image.Image;

public class Binario extends Prodotto{

    int lunghezza,angolo;

    Binario(String nome, Image image, int prezzo, String descrizione, int lunghezza, int angolo) {

        super(nome, image, prezzo, descrizione);
        this.lunghezza = lunghezza;
        this.angolo = angolo;
    }
}
