package it.unitn.disi.prog2.grigliafigure;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class Main extends Application {
    private int P = -1;
    private int S = -1;
    @Override
    public void start(Stage primaryStage) {
        EventHandler <MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println (mouseEvent.getSource().toString());
                if (mouseEvent.getSource() instanceof Figura) {
                    ((Figura)mouseEvent.getSource()).change();
                }

            }
        };
        GridPane root = new GridPane();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                root.add(new Figura(clickHandler,i,j),i,j); // i sono le colonne e j sono le righe, per questo mi viene inverso! Va bene sistemare solo il listener e dopo mi va tutto anche se intendo x e y al contrario rispetto al gridPane
            }
        }
        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.YELLOW);
        primaryStage.setTitle("GIOCO");
        primaryStage.setScene(scene);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (Character.isDigit(keyEvent.getCharacter().charAt(0))) {
                    if (Integer.parseInt(keyEvent.getCharacter())+1 >= 1 && Integer.parseInt(keyEvent.getCharacter())+1 <= 8) {
                        if (P == -1) {
                            P = Integer.parseInt(keyEvent.getCharacter());
                            System.out.println("P="+P);
                        }
                        else if (S == -1) {
                            S = Integer.parseInt(keyEvent.getCharacter());
                            System.out.println("S="+S);
                        }
                    }
                }
                if (P != -1 && S != -1) {
                    ObservableList<Node> figure =  root.getChildren();
                    for (Node temp : figure) {
                        if(temp instanceof Figura && ((((Figura)temp).getX())+1==S) && ((((Figura)temp).getY())+1==P)) {
                            //((Figura)temp).fireEvent(new MouseEvent());
                            ((Figura)temp).change();
                        }
                    }
                    P = -1;
                    S = -1;
                }
                if (keyEvent.getCharacter().equals("c")) {
                    P = -1;
                    S = -1;
                    System.out.println("P="+P);
                    System.out.println("S="+S);
                }
                if (keyEvent.getCharacter().equals("r")) {
                    P = -1;
                    S = -1;
                    ObservableList<Node> figure =  root.getChildren();
                    for (Node temp : figure) {
                        if(temp instanceof Figura) {
                            ((Figura)temp).getOggetto().setFill(Color.WHITE);
                        }
                    }
                }
            }
        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}