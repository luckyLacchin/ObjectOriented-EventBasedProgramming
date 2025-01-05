package it.unitn.prog2.lacchin.gen9012020;

import it.unitn.prog2.lacchin.gen9012020.strade.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;

public class RoadGame extends Application {

    Button [] insiemeBottoni;
    Button premuto;
    Griglia griglia;
    boolean aggiungiAuto = false;
    Button aggiungi;
    Button muoviAuto;
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        griglia = new Griglia(this);
        HBox bottom = new HBox();
        GridPane bottoni = new GridPane();
        VBox right = new VBox();

        Button ovest = new Button("Strada OVEST");
        ovest.setId("ovest");
        Button est = new Button("Strada EST");
        est.setId("est");
        Button nord = new Button("Strada NORD");
        nord.setId("nord");
        Button sud = new Button("Strada SUD");
        sud.setId("sud");
        Button prato = new Button("Prato");
        prato.setId("prato");
        bottoni.add(ovest,0,1);
        bottoni.add(nord,1,0);
        bottoni.add(prato,1,1);
        bottoni.add(sud,1,2);
        bottoni.add(est,2,1);

        aggiungi = new Button("Aggiungi auto");
        aggiungi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aggiungiAuto = true;

            }
        });
        aggiungi.setId("Aggiungi auto");
        muoviAuto = new Button("Muovi auto");
        muoviAuto.setId("Muovi auto");
        muoviAuto.setDisable(true);
        muoviAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int row, column;
                boolean fatto = false;
                /*
                Iterator<Node> c = griglia.getChildren().iterator();
                while ((c.hasNext()) && !fatto) {
                    Cella temp = (Cella) c.next();
                    if (temp.haAuto) {
                        switch (premuto.getId()) {
                            case "ovest":
                                row = temp.i;
                                column = temp.j-1;
                                break;
                            case "est":
                                row = temp.i;
                                column = temp.j+1;
                                break;
                            case "sud":
                                row = temp.i + 1;
                                column = temp.j;
                                break;
                            case "nord":
                                row = temp.i-1;
                                column = temp.j;
                                break;
                            default:
                                row = -1;
                                column = -1;
                                System.out.println("Inserire un bottone direzionale");
                        }
                        System.out.println("column = " + column);
                        System.out.println("row = " + row);
                        if(column < 0 || column > 9 || row < 0 || row > 9) {
                            System.out.println("CRASH!");
                        }
                        else {
                            Cella t = (Cella) getElementAt(row,column);
                            if (t.getClass().getName().equals("it.unitn.prog2.lacchin.gen9012020.Prato")) {
                                System.out.println("CRASH!");
                            }
                            else {
                                temp.haAuto = false;
                                temp.getChildren().remove(temp.auto);
                                t.getChildren().add(t.auto);
                                t.haAuto = true;
                            }
                        }
                        fatto = true;
                    }

                }

                 */
                Iterator<Node> c = griglia.getChildren().iterator();
                while ((c.hasNext()) && !fatto) {
                    Cella temp = (Cella) c.next();
                    if (temp.auto != null) {
                        switch (premuto.getId()) {
                            case "ovest":
                                row = temp.i;
                                column = temp.j-1;
                                break;
                            case "est":
                                row = temp.i;
                                column = temp.j+1;
                                break;
                            case "sud":
                                row = temp.i + 1;
                                column = temp.j;
                                break;
                            case "nord":
                                row = temp.i-1;
                                column = temp.j;
                                break;
                            default:
                                row = -1;
                                column = -1;
                                System.out.println("Inserire un bottone direzionale");
                        }
                        System.out.println("column = " + column);
                        System.out.println("row = " + row);
                        if(column < 0 || column > 9 || row < 0 || row > 9) {
                            System.out.println("CRASH!");
                        }
                        else {
                            Cella t = (Cella) getElementAt(row,column);
                            if (t.getClass().getName().equals("it.unitn.prog2.lacchin.gen9012020.Prato")) {
                                System.out.println("CRASH!");
                            }
                            else {
                                temp.getChildren().remove(temp.auto);
                                t.getChildren().add(temp.auto);
                                t.auto = temp.auto;
                                temp.auto = null;

                            }
                        }
                        fatto = true;
                    }

                }
            }
        });

        Button reset = new Button("Reset");
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (Node c : griglia.getChildren()) {
                    Cella temp = (Cella) c;
                    if(temp.auto != null) {
                        temp.getChildren().remove(temp.auto);
                        temp.auto = null;
                        aggiungi.setDisable(false);
                        muoviAuto.setDisable(true);
                    }
                }
            }
        });
        reset.setId("Reset");
        right.setAlignment(Pos.CENTER);
        right.getChildren().addAll(aggiungi,muoviAuto,reset);

        bottom.setSpacing(20);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(bottoni,right);

        root.setCenter(griglia);
        root.setBottom(bottom);


        insiemeBottoni = new Button[5];
        insiemeBottoni [0] = ovest;
        insiemeBottoni [1] = nord;
        insiemeBottoni [2] = prato;
        insiemeBottoni [3] = sud;
        insiemeBottoni [4] = est;

        EventHandler<ActionEvent> direzioneEventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                EventTarget eventTarget = actionEvent.getTarget();

                if(eventTarget instanceof Button) {
                    premuto = (Button) eventTarget;
                    premuto.setDisable(true);
                    for (int i = 0; i < 5; i++) {
                        if(!insiemeBottoni[i].getId().equals(premuto.getId())) {
                            insiemeBottoni[i].setDisable(false);
                        }
                    }
                }
            }
        };

        ovest.addEventHandler(ActionEvent.ACTION,direzioneEventHandler);
        nord.addEventHandler(ActionEvent.ACTION,direzioneEventHandler);
        sud.addEventHandler(ActionEvent.ACTION,direzioneEventHandler);
        prato.addEventHandler(ActionEvent.ACTION,direzioneEventHandler);
        est.addEventHandler(ActionEvent.ACTION,direzioneEventHandler);

        EventHandler <KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch (e.getCharacter()) {
                    case "N":
                        nord.fire();
                        break;
                    case "S":
                        sud.fire();
                        break;
                    case "O":
                        ovest.fire();
                    case "E":
                        est.fire();
                        break;
                    case "P":
                        prato.fire();
                        break;
                    default:
                        System.out.println("Premere uno dei seguenti tasti: N,S,E,O,P");

                }
            }
        };

        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyHandler);
        Scene scene = new Scene(root, 520, 600);
        primaryStage.setTitle("Make a Road!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public Node getElementAt (int row, int column) {

        for (Node temp : griglia.getChildren()) {
            if(GridPane.getRowIndex(temp)==row && GridPane.getColumnIndex(temp)==column) {
                return temp;
            }
        }
        return null;


    }
}