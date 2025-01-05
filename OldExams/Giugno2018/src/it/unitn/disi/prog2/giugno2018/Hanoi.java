package it.unitn.disi.prog2.giugno2018;


import it.unitn.disi.prog2.giugno2018.dischi.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Hanoi extends Application {

    Text from;
    Text to;
    Palo p1,p2,p3;
    Palo partenza, destinazione;
    Hanoi main;
    Disco discoA,discoB,discoC,discoD;
    Button close;
    StagePopUp stage;
    @Override
    public void start(Stage primaryStage) {

        main = this;
        BorderPane root = new BorderPane();
        from = new Text("from");
        to = new Text("to");

        close = new Button("Close");
        close.setId("close");
        close.setDisable(true);
        Button reset = new Button("Reset");
        reset.setId ("reset");
        Button move = new Button("Move");
        move.setId("move");
        Button clear = new Button("Clear");
        clear.setId("clear");




        HBox pali = new HBox();
        pali.setAlignment(Pos.TOP_CENTER);
        pali.setBackground(new Background(new BackgroundFill(Color.GREY,CornerRadii.EMPTY,Insets.EMPTY)));
        pali.setSpacing(50.0);
        p1 = new Palo(this);
        p1.setId("p1");
        p1.setVbox();
        p2 = new Palo(this);
        p2.setId("p2");
        p3 = new Palo(this);
        p3.setId("p3");
        pali.getChildren().addAll(p1,p2,p3);


        discoA = new DiscoA();
        discoB = new DiscoB();
        discoC = new DiscoC();
        discoD = new DiscoD();
        p1.arrayDischi.add(discoD);
        p1.arrayDischi.add(discoC);
        p1.arrayDischi.add(discoB);
        p1.arrayDischi.add(discoA);
        for (int i = 3; i >= 0; i--) {
            p1.dischi.getChildren().add(p1.arrayDischi.get(i));
        }

        HBox top = new HBox();

        top.getChildren().addAll(from,to,clear);
        top.setAlignment(Pos.CENTER);
        top.setSpacing(30.0);

        BorderPane.setAlignment(top,Pos.TOP_CENTER);
        BorderPane.setAlignment(move, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(close,Pos.CENTER_LEFT);
        BorderPane.setAlignment(reset,Pos.CENTER_RIGHT);
        BorderPane.setAlignment(pali,Pos.CENTER);


        root.setTop(top);
        root.setBottom(move);
        root.setRight(close);
        root.setLeft(reset);
        root.setCenter(pali);

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.destinazione = null;
                main.partenza = null;
                main.from.setText("from ");
                main.to.setText("to ");
            }
        });

        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Disco daSpostare = main.partenza.arrayDischi.get(main.partenza.arrayDischi.size()-1);
                if (main.partenza == null || main.destinazione == null) {
                    System.out.println("Pali di partenza e di arrivo non definiti.");
                    stage = new StagePopUp("Pali di partenza e di arrivo non definiti.");
                    stage.show();
                    close.setDisable(false);

                }
                else {
                    if (main.destinazione.dischi == null) {
                        main.destinazione.setVbox();
                        main.destinazione.arrayDischi.add(daSpostare);
                        main.partenza.arrayDischi.remove(daSpostare);
                        main.partenza.dischi.getChildren().remove(daSpostare);
                        main.destinazione.dischi.getChildren().add(daSpostare);

                    }
                    else {
                        if (main.destinazione.arrayDischi.size() > 0) {
                            if (daSpostare.getDimensione() > (main.destinazione.arrayDischi.get(0).getDimensione())) {
                                System.out.println("Impossibile appoggiare un disco su uno più piccolo.");
                                stage = new StagePopUp("Impossibile appoggiare un disco su uno più piccolo.");
                                stage.show();
                                close.setDisable(false);
                            }
                            else {
                                main.destinazione.arrayDischi.add(daSpostare);
                                main.partenza.arrayDischi.remove(daSpostare);
                                main.partenza.dischi.getChildren().remove(daSpostare);
                                main.destinazione.dischi.getChildren().clear();
                                for (int i = main.destinazione.arrayDischi.size()-1; i >= 0; i--) {
                                    main.destinazione.dischi.getChildren().add(main.destinazione.arrayDischi.get(i));
                                }
                            }
                        }
                        else {
                            main.destinazione.arrayDischi.add(daSpostare);
                            main.partenza.arrayDischi.remove(daSpostare);
                            main.partenza.dischi.getChildren().remove(daSpostare);
                            main.destinazione.dischi.getChildren().clear();
                            for (int i = main.destinazione.arrayDischi.size()-1; i >= 0; i--) {
                                main.destinazione.dischi.getChildren().add(main.destinazione.arrayDischi.get(i));
                            }
                        }
                    }

                }
            }
        });

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                main.destinazione = null;
                main.partenza = null;
                main.from.setText("from ");
                main.to.setText("to ");
                p1 = null;
                p2 = null;
                p3 = null;
                p1 = new Palo(main);
                p2 = new Palo(main);
                p3 = new Palo(main);

                p1.setId("p1");
                p1.setVbox();
                p2.setId("p2");
                p3.setId("p3");
                p1.arrayDischi.add(discoD);
                p1.arrayDischi.add(discoC);
                p1.arrayDischi.add(discoB);
                p1.arrayDischi.add(discoA);

                for (int i = 3; i >= 0; i--) {
                    p1.dischi.getChildren().add(p1.arrayDischi.get(i));
                }
                pali.getChildren().clear();
                pali.getChildren().addAll(p1,p2,p3);
            }
        });

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                close.setDisable(true);

            }
        });

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Tower of Hanoi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}