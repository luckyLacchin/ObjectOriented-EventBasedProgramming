package it.unitn.prog2.lacchin.luglio2021;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main extends Application {
    public ArrayList <Treno> treni = null;
    public VBox tuttiTreni = null;
    BorderPane root = null;
    @Override
    public void start(Stage primaryStage) {

        Main thisApp = this;
        root = new BorderPane();
        tuttiTreni = new VBox();
        treni = new ArrayList<>();
        treni.add(new Aurora());
        treni.add(new Colosseum());
        treni.add(new Mediolanum());
        Iterator <Treno> i = treni.iterator();
        while (i.hasNext()) {
            Componente c = new Componente(i.next(),thisApp);
            tuttiTreni.getChildren().add(c);
        }
        root.setCenter(tuttiTreni);
        HBox bottoni = new HBox();
        Button ordLunghezza = new Button("ordina per lunghezza");
        Button ordNome = new Button("ordina per nome");
        Button stampa = new Button("stampa");
        bottoni.getChildren().addAll(ordLunghezza,ordNome,stampa);
        root.setBottom(bottoni);
        ordLunghezza.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                tuttiTreni.getChildren().clear();
                Collections.sort(treni,new OrdPerLunghezza());
                Iterator <Treno> i = treni.iterator();
                while (i.hasNext()) {
                    Componente c = new Componente(i.next(),thisApp);
                    tuttiTreni.getChildren().add(c);
                }

            }
        });
        ordNome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tuttiTreni.getChildren().clear();
                Collections.sort(treni,new OrdPerNome());
                Iterator <Treno> i = treni.iterator();
                while (i.hasNext()) {
                    Componente c = new Componente(i.next(),thisApp);
                    tuttiTreni.getChildren().add(c);
                }

            }
        });
        stampa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                for (Treno treno : treni) {
                    treno.stampaTreno();
                }
            }
        });
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCharacter().equals("N")) {
                    ordNome.fire();
                }
                else if (e.getCharacter().equals("L")) {
                    ordLunghezza.fire();
                }
            }
        });
        Scene scene = new Scene(root, 1100, 375);
        primaryStage.setTitle("Treni in esercizio LACCHIN GABRIELE");
        primaryStage.setScene(scene);
        primaryStage.show();

        OfficinaDiComposizione officina = new OfficinaDiComposizione(thisApp);
        Scene scene2 = new Scene (officina.root,1100,170);
        officina.setScene(scene2);
        officina.show();

        //dovevo usare rotabile come treeset o sortset perché voleva che fosse
        //ordinato il treno secondo la marcatura!
    }
    public static void main(String[] args) {
        launch(args);
    }
}