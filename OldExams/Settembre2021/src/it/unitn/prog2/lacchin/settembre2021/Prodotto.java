package it.unitn.prog2.lacchin.settembre2021;

import javafx.scene.image.Image;

abstract public class Prodotto {

    String nome,descrizione;
    Image image;
    int prezzo;
    //forse sarebbe più comodo mettere direttamente Imageview.

    Prodotto (String nome, Image image, int prezzo,String descrizione) {
        this.nome = nome;
        this.image = image;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }


}
