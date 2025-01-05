package it.unitn.disi.prog2.pratofiorito;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PratoFiorito extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        GridPane schacchiera = new GridPane();
        HBox label = new HBox();
        Text title = new Text("Gioca");
        label.setAlignment(Pos.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        label.getChildren().add(title);
        schacchiera.setAlignment(Pos.CENTER);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Tile btn = new Tile();
                btn.setMinSize(70,70);
                double val = Math.random ();
                if (val < 0.9)
                    btn.setBomba (false);
                else
                    btn.setBomba(true);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int bombe = 0;
                        if (btn.getBomba()) {
                            //in questo caso è una bomba
                            Alert alert = new Alert (Alert.AlertType.INFORMATION);
                            alert.setTitle("ESITO");
                            alert.setTitle("HAI PERSO");
                            alert.setContentText("Hai preso una bomba");
                            primaryStage.close();
                            alert.showAndWait();

                        }
                        else {
                            bombe = 0;
                            Tile result = null;
                            ObservableList<Node> childrens = schacchiera.getChildren();
                            for (int riga = schacchiera.getRowIndex(btn)-1; riga <= schacchiera.getRowIndex(btn)+1;riga++) {
                                for (int colonna = schacchiera.getColumnIndex(btn)-1; colonna <= schacchiera.getColumnIndex(btn)+1;colonna++) {
                                    if (riga >= 0 && riga < 9 && colonna >= 0 && colonna < 9) {
                                        for (Node node : childrens) {
                                            if(schacchiera.getRowIndex(node) == riga && schacchiera.getColumnIndex(node) == colonna) {
                                                if (!(node instanceof Tile)) {
                                                    System.out.println("Errore, presenza di un nodo non valido");
                                                }else {
                                                    result = (Tile) node;
                                                    if (result.getBomba()) {
                                                        ++bombe;
                                                    }
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                            btn.setText (""+bombe+"");
                        }
                        btn.setDisable(true);

                    }
                });
                schacchiera.add(btn,i,j);

            }
        }
        root.setCenter(schacchiera);
        root.setTop(label);
        Scene scene = new Scene(root, 750, 750);
        primaryStage.setTitle("Prato Fiorito");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}

