package it.unitn.prog2.lacchin.settembre2021;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import jdk.jfr.Event;


public class layoutVetrina extends BorderPane {

    Text titolo,costo;
    ImageView iw;
    Shop shop;
    layoutVetrina (Prodotto prodotto, Shop shop) {

        titolo = new Text(prodotto.nome);
        costo = new Text(prodotto.prezzo + " Euro");
        titolo.setFill(Color.RED);
        costo.setFill(Color.BLUE);
        iw = new ImageView(prodotto.image);
        this.shop = shop;
        titolo.setFont(new Font(15));
        costo.setFont(new Font(15));
        titolo.setStyle("-fx-font-weight: bold");
        costo.setStyle("-fx-font-weight: bold");

        BorderPane.setAlignment(titolo, Pos.TOP_CENTER);
        BorderPane.setAlignment(iw,Pos.CENTER);
        BorderPane.setAlignment(costo,Pos.BOTTOM_CENTER);


        EventHandler <MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                shop.dettaglioStage.riempiDettaglio(prodotto);
            }
        };

        this.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseHandler);

        this.setTop(titolo);
        this.setCenter(iw);
        this.setBottom(costo);

    }
}
