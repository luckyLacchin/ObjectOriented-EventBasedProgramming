package it.unitn.prog2.lacchin.settembre2021;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Vetrina extends Stage {

    HBox root;
    Scene scene;
    Shop shop;

    Vetrina (Shop shop) {

        root = new HBox();
        scene = new Scene(root,600,200);
        this.shop = shop;
        this.setTitle("Vetrina");
        this.setScene(scene);

        this.setX(300);
        this.setY(100);

        this.show();

        this.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                shop.primaryStage.requestFocus();
                shop.fire(e.getCharacter());
            }
        });
    }

    public void riempiVetrina (ArrayList <Prodotto> lista) {

        root.getChildren().clear();
        for (int i = 0; i < 3; i++) {
            root.getChildren().add(new layoutVetrina(lista.get(i),shop));
        }
    }
}
