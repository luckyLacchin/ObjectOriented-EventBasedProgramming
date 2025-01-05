package it.unitn.prog2.lacchin.picco_giugno2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class luckyClick extends Application {

    Text punteggio;
    Text tentativi;
    int numeroTentativi;
    int punti;
    @Override
    public void start(Stage primaryStage) {


        numeroTentativi = 100;
        punti = 0;
        VBox root = new VBox();
        punteggio = new Text("Punteggio = 0");
        punteggio.setFont(new Font(20));
        tentativi = new Text("Tentativi = 10 ");
        tentativi.setFont(new Font(20));
        Griglia griglia = new Griglia(this);


        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(punteggio,tentativi,griglia);


        Scene scene = new Scene(root, 500, 570);
        primaryStage.setTitle("Lucky Click");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}