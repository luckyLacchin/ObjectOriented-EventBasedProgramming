package it.unitn.prog2.lacchin.luglio2021;

import it.unitn.prog2.lacchin.rotabili.*;
import it.unitn.prog2.lacchin.rotabili.Rotabile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;


public class OfficinaDiComposizione extends Stage {

    Main app;
    Treno treno = null;
    ArrayList<Rotabile> componenti = null;
    Nome nomen = null;
    public BorderPane root = null;
    VBox below = null;
    public OfficinaDiComposizione (Main app) {
        super();
        this.app = app;
        treno = new Treno();
        nomen = new Nome();
        root = new BorderPane();
        componenti = new ArrayList<>();
        HBox aggiungi = new HBox();
        Button loco = new Button("Aggiungi Loco");
        Button az = new Button("Aggiungi Az");
        Button bz = new Button("Aggiungi Bz");
        Button dz = new Button("Aggiungi Dz");
        Button wrz = new Button("Aggiungi Wrz");

        //potevo settare anche gli Id dei vari bottoni e fare un solo evenhandler, ma con copia incolla ho fatto più veloce.
        loco.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                treno.getChildren().add(new Loco());
            }
        });
        az.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                treno.getChildren().add(new Az());

            }
        });
        bz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                treno.getChildren().add(new Bz());

            }
        });
        dz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                treno.getChildren().add(new Dz());

            }
        });
        wrz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                treno.getChildren().add(new Wrz());

            }
        });
        aggiungi.getChildren().addAll(loco,az,bz,dz,wrz);
        root.setTop(aggiungi);
        VBox center = new VBox();
        Text nomedelTreno = new Text("Nome del treno: ");
        HBox hb = new HBox();
        TextField n = new TextField();
        Button applica = new Button("Applica: ");
        applica.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                nomen.setText(n.getText());
                VBox below2 = new VBox();
                below2.getChildren().addAll(nomen,treno);
                below = below2;
                root.setBottom(below);
            }
        });
        hb.getChildren().addAll(n,applica);
        Button esercizio = new Button("metti in Esercizio: ");
        /*esercizio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                treno.setNome(nomen);
                app.treni.add(treno);
                treno = new Treno();
                System.out.println(app.treni);
                System.out.println(below);
                System.out.println(center);
                VBox tuttiTreni2 = new VBox();
                Iterator<Treno> i = app.treni.iterator();
                while (i.hasNext()) {
                    Componente c = new Componente(i.next(),app);
                    tuttiTreni2.getChildren().add(c);
                }
                app.tuttiTreni = tuttiTreni2;
                app.root.setCenter(app.tuttiTreni);
                System.out.println(treno);
                nomen = new Nome();
                below = new VBox();
                below.getChildren().addAll(nomen,treno);
                root.setBottom(below);
                n.clear();
                //non so perché mi dà errore in runtime anche se io uso due treni diversi per andare a formare un nuovo treno
                //ma mi esce l'indirizzo sembre dello stesso in continuazione...
                //perché poi devo fare un altro vbox e facendo getChildren.removeAll() non
                //faccio nulla e rimangono i nodi?!??!

            }
        });
        //devo rifare questa funzione! (riguardarlo a tutorato adesso ti metti a fare un altro esame!)
         */
        center.getChildren().addAll(nomedelTreno,hb,esercizio);
        root.setCenter(center);
        below = new VBox();
        below.getChildren().addAll(nomen,treno);
        root.setBottom(below);
    }
}
