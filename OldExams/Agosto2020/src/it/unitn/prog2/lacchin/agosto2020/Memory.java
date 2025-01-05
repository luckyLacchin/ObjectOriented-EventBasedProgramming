package it.unitn.prog2.lacchin.agosto2020;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Memory extends Application {

    Text punteggio = null;
    int punti = 24;
    boolean finito = false;
    Griglia griglia = null;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        griglia = new Griglia(primaryStage,this);
        griglia.populate();

        HBox below = new HBox();
        Button reset = new Button("Random Reset");
        reset.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                griglia.ripristino();
                punti = 24;
                punteggio.setText(String.valueOf(punti));
                griglia.scoperte.clear();
                griglia.coperte.clear();
                griglia.congelate.clear();
                
                griglia = griglia.casuale();
                root.setCenter(griglia);
                reset.setDisable(true);


            }
        });
        punteggio = new Text ("24");
        below.setAlignment(Pos.CENTER);
        below.setSpacing(10.0);
        below.getChildren().addAll(reset,punteggio);

        root.setBottom(below);
        root.setCenter(griglia);


        Scene scene = new Scene(root, 510, 500);

        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCharacter().equals("R")) {
                    reset.fire();
                }
            }
        });
        primaryStage.setTitle("Gabriele Lacchin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}