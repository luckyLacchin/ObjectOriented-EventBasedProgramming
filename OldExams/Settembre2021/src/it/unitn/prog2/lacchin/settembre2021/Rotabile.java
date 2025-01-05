package it.unitn.prog2.lacchin.settembre2021;

import javafx.scene.image.Image;

public class Rotabile extends Prodotto{

    int assiMotori;
    Rotabile(String nome, Image image, int prezzo, String descrizione, int assiMotori) {
        super(nome, image, prezzo, descrizione);

        this.assiMotori = assiMotori;
    }
}
