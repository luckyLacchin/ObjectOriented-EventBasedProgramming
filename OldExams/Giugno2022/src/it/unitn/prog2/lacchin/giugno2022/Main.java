package it.unitn.prog2.lacchin.giugno2022;

import it.unitn.prog2.lacchin.giugno2022.bandiere.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    TuttoStage ts = null;
    GiocaStage gs = null;
    ArrayList<Stato> stati = null;
    Main app = null;
    @Override
    public void start(Stage primaryStage) {

        app = this;
        stati = new ArrayList<>();
        riempiStati();


        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        Button gioca = new Button("Gioca");
        gioca.setId("gioca");
        Button mostraTutto = new Button("Mostra Tutto");
        mostraTutto.setId("MostraTutto");



        EventHandler <ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button source = (Button) actionEvent.getSource();

                switch (source.getId()) {
                    case "gioca":
                        if(ts != null) {
                            ts.close();
                        }
                        gs = new GiocaStage(app);
                        gs.show();
                        break;
                    case "MostraTutto":
                        if(gs != null) {
                            gs.close();
                        }
                        ts = new TuttoStage(app);
                        ts.show();
                        break;
                    default:
                        System.out.println("E' successo qualcosa che non doveva succedere");

                }
            }
        };

        gioca.addEventHandler(ActionEvent.ACTION,eventHandler);
        mostraTutto.addEventHandler(ActionEvent.ACTION,eventHandler);



        root.getChildren().addAll(mostraTutto,gioca);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Gabriele Lacchin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void riempiStati() {
        stati = new ArrayList<>();
        stati.add(new Stato("Algeria","Algers", new DueFasceVert(Color.GREEN,Color.WHITE)));
        stati.add(new Stato("Armenia","Yerevan", new TreFasceOriz(Color.RED,Color.BLUE,Color.ORANGE)));
        stati.add(new Stato("Chad","N'Djamena", new TreFasceVert(Color.BLUE,Color.YELLOW,Color.RED)));
        stati.add(new Stato("Czech Republic","Prague", new Triangolo(Color.WHITE,Color.RED,Color.BLUE)));
        stati.add(new Stato("Djibouti","Djibouti", new Triangolo(Color.CYAN,Color.GREEN,Color.WHITE)));
        stati.add(new Stato("Gabon","Libreville", new TreFasceVert(Color.GREEN,Color.YELLOW,Color.BLUE)));
        stati.add(new Stato("Indonesia","Jakarta", new DueFasceOriz(Color.RED,Color.WHITE)));
        stati.add(new Stato("Lithuania","Vilnius", new TreFasceOriz(Color.YELLOW,Color.GREEN,Color.RED)));
        stati.add(new Stato("Malta","La Valletta", new DueFasceVert(Color.WHITE,Color.RED)));
        stati.add(new Stato("Ukraine","Kiev", new DueFasceOriz(Color.BLUE,Color.YELLOW)));

    }
    public static void main(String[] args) {
        launch(args);
    }
}