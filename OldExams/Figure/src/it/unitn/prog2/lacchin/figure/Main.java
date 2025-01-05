package it.unitn.prog2.lacchin.figure;

import javafx.application.Application;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        ArrayList <Figura> arrayFigure = new ArrayList<>();
        Text res = new Text();
        HBox info = new HBox();
        info.getChildren().add(res);
        info.setAlignment(Pos.CENTER);
        res.setText("");
        res.setTextAlignment(TextAlignment.CENTER);
        root.setTop(info);
        Button gioca = new Button ("Gioca!");
        HBox figure = new HBox();
        figure.setAlignment(Pos.CENTER);
        figure.setSpacing(10);
        gioca.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Figura fig = new Figura();
                figure.getChildren().add(fig.figura);
                arrayFigure.add(fig);
                if(figure.getChildren().size() == 2) {
                    gioca.setDisable(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMAZIONE");
                    alert.setHeaderText("ESITO:");
                    if (arrayFigure.get(0).equals(arrayFigure.get(1))) {
                        alert.setContentText("HAI VINTO");
                        res.setText("Hai vinto!");
                    }
                    else {
                        alert.setContentText("HAI PERSO");
                        res.setText("Hai perso!");
                    }
                    alert.showAndWait();
                }

            }
        });
        root.setCenter(figure);
        Button canc = new Button("Cancella");
        canc.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                res.setText("");
                arrayFigure.removeAll(arrayFigure);
                figure.getChildren().removeAll(figure.getChildren());
                gioca.setDisable(false);
        }
        });
        HBox bottoni = new HBox();
        bottoni.getChildren().addAll(gioca,canc);
        bottoni.setAlignment(Pos.CENTER);
        root.setBottom(bottoni);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Gioco");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}