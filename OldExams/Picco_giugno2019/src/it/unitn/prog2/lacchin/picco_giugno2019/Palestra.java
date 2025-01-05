package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Palestra extends Application {

    ArrayList<Persona> archivio;
    ArrayList <Persona> studenti;
    ArrayList <Persona> atleti;
    ArrayList <Button> bottoniLeft;
    ArrayList <Button> bottoniRight;
    Tabella center;
    @Override
    public void start(Stage primaryStage) {

        archivio = new ArrayList<>();
        studenti = new ArrayList<>();
        atleti = new ArrayList<>();
        bottoniLeft = new ArrayList<>();
        bottoniRight = new ArrayList<>();
        riempiArchivio();

        BorderPane root = new BorderPane();

        HBox top = new HBox();
        HBox left = new HBox();
        HBox right = new HBox();

        Button tuttiButton = new Button("Tutti");
        tuttiButton.setId("tutti");
        tuttiButton.setDisable(true);
        Button studentiButton = new Button("Studenti");
        studentiButton.setId("studenti");
        Button atletiButton = new Button("Atleti");
        atletiButton.setId("atleti");
        Button perNome = new Button("per nome");
        perNome.setId("per nome");
        Button perEta = new Button("per eta");
        perEta.setId("per eta");
        Button exit = new Button("Exit");
        exit.setId("exit");


        bottoniLeft.add(tuttiButton);
        bottoniLeft.add(studentiButton);
        bottoniLeft.add(atletiButton);

        bottoniRight.add(perNome);
        bottoniRight.add(perEta);


        EventHandler <ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button target = (Button) actionEvent.getTarget();
                if (bottoniLeft.contains(target)) {
                    target.setDisable(true);
                    for (int i = 0; i < bottoniLeft.size(); i++) {
                        if (bottoniLeft.get(i) != target)
                            bottoniLeft.get(i).setDisable(false);
                    }
                }
                else if (bottoniRight.contains(target)) {
                    target.setDisable(true);
                    for (int i = 0; i < bottoniRight.size(); i++) {
                        if (bottoniRight.get(i) != target)
                            bottoniRight.get(i).setDisable(false);
                    }
                }


                switch (target.getId()) {
                    case "tutti":
                        center = new Tabella(archivio);
                        break;
                    case "studenti":
                        center = new Tabella(studenti);
                        break;
                    case "atleti":
                        center = new Tabella(atleti);
                        break;
                    case "per nome":
                        Collections.sort(center.lista,new OrdPerNome());
                        center.getChildren().clear();
                        center.riempiTabella();
                        break;
                    case "per eta":
                        Collections.sort(center.lista,new OrdPerEta());
                        center.getChildren().clear();
                        center.riempiTabella();
                        break;
                    default:
                        System.out.println("Qualcosa è andato storto!");
                }
                root.setCenter(center);
            }
        };

        tuttiButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        studentiButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        atletiButton.addEventHandler(ActionEvent.ACTION,buttonHandler);
        perEta.addEventHandler(ActionEvent.ACTION,buttonHandler);
        perNome.addEventHandler(ActionEvent.ACTION,buttonHandler);

        HBox.setMargin(tuttiButton,new Insets(5.0,5.0,5.0,5.0));
        HBox.setMargin(studentiButton,new Insets(5.0,5.0,5.0,5.0));
        HBox.setMargin(atletiButton,new Insets(5.0,5.0,5.0,5.0));
        HBox.setMargin(perNome,new Insets(5.0,5.0,5.0,5.0));
        HBox.setMargin(perEta,new Insets(5.0,5.0,5.0,5.0));


        left.getChildren().addAll(tuttiButton,studentiButton,atletiButton);
        //left.setSpacing(20.0);
        right.getChildren().addAll(perNome,perEta);
        left.setAlignment(Pos.TOP_LEFT);
        right.setAlignment(Pos.TOP_RIGHT);
        //right.setSpacing(20.0);
        top.setSpacing(150.0);
        top.getChildren().addAll(left,right);
        top.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        center = new Tabella(archivio);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });


        BorderPane.setAlignment(top,Pos.TOP_CENTER);
        root.setTop(top);
        BorderPane.setAlignment(center,Pos.CENTER_RIGHT);
        root.setCenter(center);
        BorderPane.setAlignment(exit,Pos.BOTTOM_RIGHT);
        root.setBottom(exit);

        Scene scene = new Scene(root, 500, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void riempiArchivio () {
        Persona persona;

        persona = new StudenteSolo("Bianchi","Anna",4,1990,"UNIPD","LM");
        archivio.add(persona);
        studenti.add(persona);

        persona = new StudenteSolo("Bianchi","Giovanni",3,1995,"UNITN","LT");
        archivio.add(persona);
        studenti.add(persona);


        persona = new AtletaStudente("Ferrari","Alberto",7,1993,"UNITN","LM","atletica","internazionale");
        archivio.add(persona);
        studenti.add(persona);
        atleti.add(persona);

        persona = new AtletaStudente("Ferrari","Vincenzo",8,1997,"UNITN","LT","atletica","nazionale");
        archivio.add(persona);
        studenti.add(persona);
        atleti.add(persona);

        persona = new Persona("Rossi","Carla",2,1990);
        archivio.add(persona);

        persona = new Persona("Rossi","Mario",1,1950);
        archivio.add(persona);


        persona = new AtletaSolo("Verdi","Alice",6,1967,"curling","internazionale");
        archivio.add(persona);
        atleti.add(persona);

        persona = new AtletaSolo("Verdi","Giacomo",5,1991,"nuoto","nazionale");
        archivio.add(persona);
        atleti.add(persona);


    }
}