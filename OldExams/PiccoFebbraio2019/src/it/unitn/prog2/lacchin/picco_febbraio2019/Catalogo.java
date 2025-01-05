package it.unitn.prog2.lacchin.picco_febbraio2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Catalogo extends Application {

    ArrayList <Record> persone;
    ArrayList <Record> automobili;
    Tabella listaPersone;
    Tabella listaAutomobili;
    Input input; //usiamo solo una variabile per entrambi i stage!
    Catalogo questo;

    @Override
    public void start(Stage primaryStage) {

        questo = this;
        HBox root = new HBox();

        persone = new ArrayList<>();
        automobili = new ArrayList<>();

        BorderPane left = new BorderPane();
        BorderPane right = new BorderPane();

        listaPersone = new Tabella();
        listaAutomobili = new Tabella();

        Button mescolaPersone = new Button("Mescola");
        Button mescolaAutomobili = new Button("Mescola");
        Button ordinaPersone = new Button ("Ordina");
        Button ordinaAutomobili = new Button("Ordina");
        Button contaPersone = new Button("Conta");
        Button contaAutomobili = new Button("Conta");
        Button ordinaPerAnno = new Button("Ordina per anno");
        Button ordinaPerPrezzo = new Button("Ordina per prezzo");
        Button newPersona = new Button("New Person");
        Button newAuto = new Button("New Auto");


        mescolaPersone.setId ("mescolaPersone");
        mescolaAutomobili.setId ("mescolaAutomobili");
        ordinaPersone.setId("ordinaPersone");
        ordinaAutomobili.setId("ordinaAutomobili");
        contaPersone.setId("contaPersone");
        contaAutomobili.setId("contaAutomobili");
        ordinaPerAnno.setId("ordinaPerAnno");
        ordinaPerPrezzo.setId("ordinaPerPrezzo");
        newPersona.setId("newPersona");
        newAuto.setId("newAuto");


        EventHandler <ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Button source = (Button) actionEvent.getSource();
                switch (source.getId()) {
                    case "newPersona":
                        input = new InputPersona(questo);
                        input.show();
                        break;
                    case "newAuto":
                        input = new InputAuto(questo);
                        input.show();
                        break;
                    case "contaPersone":
                        System.out.println("Numero di persone = " + persone.size());
                        break;
                    case "contaAutomobili":
                        System.out.println("Numero di automobili = " + automobili.size());
                        break;
                    case "mescolaPersone":
                        Collections.shuffle(persone);
                        listaPersone.testi.getChildren().clear();
                        listaPersone.riempi(persone);
                        break;
                    case "mescolaAutomobili":
                        Collections.shuffle(automobili);
                        listaAutomobili.testi.getChildren().clear();
                        listaAutomobili.riempi(automobili);
                        break;
                    case "ordinaPersone":
                        Collections.sort(persone);
                        listaPersone.testi.getChildren().clear();
                        listaPersone.riempi(persone);
                        break;
                    case "ordinaAutomobili":
                        Collections.sort(automobili);
                        listaAutomobili.testi.getChildren().clear();
                        listaAutomobili.riempi(automobili);
                        break;
                    case "ordinaPerAnno":
                        Collections.sort(persone, new OrdPerAnnoOPrezzo());
                        listaPersone.testi.getChildren().clear();
                        listaPersone.riempi(persone);
                        break;
                    case "ordinaPerPrezzo":
                        Collections.sort(automobili, new OrdPerAnnoOPrezzo());
                        listaAutomobili.testi.getChildren().clear();
                        listaAutomobili.riempi(automobili);
                        break;
                    default:
                        System.out.println("Qualcosa è andato storto!");
                }
            }
        };


        newPersona.addEventHandler(ActionEvent.ACTION,eventHandler);
        newAuto.addEventHandler(ActionEvent.ACTION,eventHandler);
        mescolaPersone.addEventHandler(ActionEvent.ACTION,eventHandler);
        mescolaAutomobili.addEventHandler(ActionEvent.ACTION,eventHandler);
        ordinaPersone.addEventHandler(ActionEvent.ACTION,eventHandler);
        ordinaAutomobili.addEventHandler(ActionEvent.ACTION,eventHandler);
        contaPersone.addEventHandler(ActionEvent.ACTION,eventHandler);
        contaAutomobili.addEventHandler(ActionEvent.ACTION,eventHandler);
        ordinaPerAnno.addEventHandler(ActionEvent.ACTION,eventHandler);
        ordinaPerPrezzo.addEventHandler(ActionEvent.ACTION,eventHandler);


        VBox buttonsPersone = new VBox();
        VBox buttonsAutomobili = new VBox();

        buttonsPersone.getChildren().addAll(mescolaPersone,ordinaPersone,contaPersone,ordinaPerAnno);
        buttonsAutomobili.getChildren().addAll(mescolaAutomobili,ordinaAutomobili,contaAutomobili,ordinaPerPrezzo);

        buttonsPersone.setAlignment(Pos.CENTER_RIGHT);
        buttonsAutomobili.setAlignment(Pos.CENTER_LEFT);
        BorderPane.setAlignment(buttonsPersone,Pos.CENTER_RIGHT);
        BorderPane.setAlignment(buttonsAutomobili,Pos.CENTER_RIGHT);

        BorderPane.setAlignment(newPersona,Pos.BOTTOM_RIGHT);
        BorderPane.setAlignment(newAuto,Pos.BOTTOM_LEFT);

        left.setTop(listaPersone);
        left.setCenter(buttonsPersone);
        left.setBottom(newPersona);

        right.setTop(listaAutomobili);
        right.setCenter(buttonsAutomobili);
        right.setBottom(newAuto);

        root.getChildren().addAll(left,right);

        root.setSpacing(2.5);



        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("Gabriele Lacchin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}