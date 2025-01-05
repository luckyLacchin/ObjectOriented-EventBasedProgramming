package it.unitn.prog2.lacchin.luglio2021;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Iterator;

public class Componente extends VBox {

    Main app = null;
    public Componente (Treno treno, Main app) {
        super();
        this.app = app;
        this.getChildren().addAll(treno.nome,treno);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                app.treni.remove(treno);
                app.tuttiTreni.getChildren().removeAll();
                System.out.println(app.treni);
                VBox tuttiTreni2 = new VBox();
                for (Treno treno : (app.treni)) {
                    Componente c = new Componente(treno,app);
                    tuttiTreni2.getChildren().add(c);
                }
                app.tuttiTreni = tuttiTreni2;
                app.root.setCenter(app.tuttiTreni); // chiedere perché devi ripristinare tutto tu e non si aggiorna da solo! e non serve togliere i nodi
                //da vbox e dopo rimetterli usando sempre lo stesso!?
            }


        });

    }

}
