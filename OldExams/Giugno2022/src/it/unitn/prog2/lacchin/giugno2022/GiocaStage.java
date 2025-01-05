package it.unitn.prog2.lacchin.giugno2022;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class GiocaStage extends Stage {

    Main app;
    ArrayList<Stato> estratti;
    VBox bottom;
    public GiocaStage (Main app) {
        super();
        this.app = app;
        scegliEstratti ();

        BorderPane root = new BorderPane();

        GrigliaGioca grigliaGioca = new GrigliaGioca(this);

        bottom = new VBox();
        mettiText();

        Button controlla = new Button("Controlla");

        controlla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean corretto = true;
                for (int i = 0; i < 3; i++) {
                    if(grigliaGioca.testi[i].equals("")) {
                        System.out.println("Inserire una risposta in tutti i textField");
                        corretto = false;
                    }
                }
                if(corretto) {
                    Stato [] risposte = new Stato[3];
                    for (int i = 0; i < 3; i++) {
                        risposte[i] = new Stato(grigliaGioca.testi[i].getText(),grigliaGioca.bandiere[i]);
                    }

                    for (int i = 0; i < 3 && corretto; i++) {
                        corretto = false;
                        for (Stato temp : estratti) {
                            if(temp.capitale.equals(risposte[i].capitale) && temp.bandiera.equals(risposte[i].bandiera)) {
                                corretto = true;
                            }
                        }
                    }
                }
                if(corretto) {
                    System.out.println("HAI VINTO!");
                }
                else
                    System.out.println("HAI PERSO!");
            }
        });


        controlla.setAlignment(Pos.CENTER);
        HBox bottone = new HBox();
        bottone.setAlignment(Pos.CENTER);
        bottone.getChildren().add(controlla);
        bottom.getChildren().add(bottone);

        root.setCenter(grigliaGioca);
        root.setBottom(bottom);


        Scene scene = new Scene(root, 220, 200);
        this.setTitle("Gioca!");
        this.setScene(scene);
        this.show();
    }

    public void scegliEstratti () {

        estratti = new ArrayList<>();
        ArrayList <Stato> statiClone = (ArrayList<Stato>) app.stati.clone();
        for (int i = 0; i < 3; i++) {
            int index = (int)(Math.random()*statiClone.size());
            estratti.add(statiClone.get(index));
            statiClone.remove(index);

        }
    }

    public void mettiText () {

        for (int i = 0; i < estratti.size(); i++) {
            Text text = new Text(i + " : " + estratti.get(i).capitale);
            bottom.getChildren().add(text);
        }
    }
}
