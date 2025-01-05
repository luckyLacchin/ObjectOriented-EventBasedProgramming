package it.unitn.prog2.lacchin;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Play extends Application {
    int N = -1;
    Text punteggio;
    int punti = 0;
    Text vinte;
    int numeroVinte = 0;
    ComunicazioneStage comunicazioneStage;
    Griglia griglia;
    Stage primaryStage;
    /*facciamo che la griglia sia 500 per 500 quindi dopo la width e height
    della mia scena saranno 600,550.
     */
    @Override
    public void start(Stage primaryStage) {
        boolean corretto = false;
        do {
            String response=InputDialog.getResponse();
            if (response != null) {
                try {
                    N = Integer.parseInt(response);
                    if (N >= 3 && N <= 9)
                        corretto = true;
                } catch (NumberFormatException x) {
                    //corretto = false;
                }
            }
        }while(!corretto);
        BorderPane root = new BorderPane();

        griglia = new Griglia(this);

        this.primaryStage = primaryStage;

        BorderPane.setAlignment(griglia, Pos.CENTER_RIGHT);
        root.setCenter (griglia);

        HBox top = new HBox();

        Text tx1 = new Text("Punteggio ");
        punteggio = new Text("0");
        tx1.setFont(new Font(20));
        punteggio.setFont(new Font(20));
        punteggio.setFill(Color.BLUE);
        Text tx2 = new Text("Partite vinte ");
        vinte = new Text("0");
        tx2.setFont(new Font(20));
        vinte.setFont(new Font(20));
        top.setAlignment(Pos.CENTER);
        top.getChildren().addAll(tx1,punteggio,tx2,vinte);

        BorderPane.setAlignment(top,Pos.TOP_CENTER);
        root.setTop(top);

        Button reset = new Button("reset");
        reset.setId("reset");
        Button cheat = new Button("cheat");
        cheat.setId("cheat");


        EventHandler <ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button source = (Button) actionEvent.getSource();
                switch (source.getId()) {
                    case "reset":
                        ripristina();
                        break;
                    case "cheat":
                        griglia.mostra();
                        break;
                    default:
                        System.out.println("Qualcosa è andato storto");
                }

            }
        };

        reset.addEventHandler(ActionEvent.ACTION,buttonHandler);
        cheat.addEventHandler(ActionEvent.ACTION,buttonHandler);

        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(reset,cheat);
        BorderPane.setAlignment(bottom,Pos.BOTTOM_CENTER);
        root.setBottom(bottom);


        Scene scene = new Scene(root, 600, 560);
        primaryStage.setTitle("Play the Game!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gestisciPunti () {
        System.out.println(punti);
        punteggio.setText(String.valueOf(punti));
        if (punti < 10) {
            punteggio.setFill(Color.BLUE);
        }
        else if (punti > 10){
            punteggio.setFill(Color.RED);
        }
        else {
            punteggio.setFill(Color.GREEN);
            comunicazioneStage = new ComunicazioneStage(true,primaryStage);
            comunicazioneStage.show();

            griglia.play.numeroVinte++;
            griglia.play.vinte.setText(String.valueOf(griglia.play.numeroVinte));

            for (Cella cella : griglia.celle) {
                if (cella.scoperta) {
                    cella.getChildren().add(cella.foreground);
                    cella.scoperta = false;
                }
            }
            griglia.play.punti = 0;
            griglia.play.punteggio.setText(String.valueOf(griglia.play.punti));
        }
    }
    public void ripristina () {
        numeroVinte = 0;
        punti = 0;
        punteggio.setText(String.valueOf(punti));
        punteggio.setFill(Color.BLUE);
        vinte.setText(String.valueOf(numeroVinte));

        for (Cella cella : griglia.celle) {
            if (cella.scoperta) {
                cella.getChildren().add(cella.foreground);
                cella.scoperta = false;
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}