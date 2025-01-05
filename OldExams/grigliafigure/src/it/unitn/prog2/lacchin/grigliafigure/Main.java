package it.unitn.prog2.lacchin.grigliafigure;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    int i = -1;
    int j = -1;
    int index = 0;
    @Override
    public void start(Stage primaryStage) {

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Object target = mouseEvent.getSource();
                Object target2 = mouseEvent.getTarget();
                if (target2 instanceof Shape) {
                    ((Figura) target).change();
                }
            }
        };


        GridPane root = new GridPane();
        root.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                root.add(new Figura (i,j,eventHandler),i,j);
            }
        }
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {

                if (e.getCharacter().equals("c")) {
                    i = -1;
                    j = -1;
                    index = 0;

                }
                if (e.getCharacter().equals("r")) {
                    i = -1;
                    j = -1;
                    for (Node temp : root.getChildren()) {
                        Figura figure = (Figura) temp;
                        figure.getShapee().setFill(Color.WHITE);
                        index = 0;
                    }
                } else if (e.getCharacter().equals("1") || e.getCharacter().equals("2") || e.getCharacter().equals("3") ||
                e.getCharacter().equals("4") || e.getCharacter().equals("5") || e.getCharacter().equals("6") || e.getCharacter().equals("7") ||
                e.getCharacter().equals("8")) {
                    int n = Integer.parseInt(e.getCharacter());
                    if (n >= 1 && n <= 8) {
                        if (index == 0)
                            i = n;
                        else if (index == 1)
                            j = n;

                    }


                    if ((i != -1) && (j != -1)) {
                        System.out.println("i = " + i + " " + "j = " + j);
                        for (Node temp : root.getChildren()) {
                            if ((((Figura) temp).getX() == i - 1) && (((Figura) temp).getY() == j - 1)) {
                                ((Figura) temp).change();
                            }
                        }
                    }
                    ++index;
                    if (index == 2) {
                        System.out.println("i = " + i + " " + "j = " + j);
                        index = 0;
                        i = -1;
                        j = -1;
                    }
                }
            }
        });
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Esercitazione 6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}